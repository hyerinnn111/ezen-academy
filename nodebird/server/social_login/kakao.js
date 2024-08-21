const passport = require("passport");
const KakaoStrategy = require("passport-kakao").Strategy;
const mysql = require("mysql2");
const crypto = require("crypto");

const { KAKAO_ID, KAKAO_SECRET, SERVER_URL } = process.env;

const connection = mysql.createConnection({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_DATABASE,
});

passport.use(
  new KakaoStrategy(
    {
      clientID: KAKAO_ID,
      clientSecret: KAKAO_SECRET,
      callbackURL: `http://localhost:8000/auth/kakao/callback`,
    },
    (accessToken, refreshToken, profile, done) => {
      let email = profile._json.kakao_account.email;
      const username = profile.username || profile.displayName || 'KakaoUser';

      if (!email) {
        email = `kakao_${profile.id}@no-email.com`;
      }


      function generateUserid() {
        do {
          randomDigits = Math.floor(10000 + Math.random() * 90000);
          userid = `${prefix}${randomDigits}`;
        } while (usedUserNumbers.has(userid)); // 중복된 userid가 있다면 다시 생성
      
        usedUserNumbers.add(userid); // Set에 추가
        return userid;
      }

      // 회원번호를 생성합니다. (6자리)
    const userid = generateUserid();

      const sql = "SELECT * FROM user WHERE email = ?";
      connection.query(sql, [email], (err, results) => {
        if (err) {
          return done(err);
        }
        if (results.length === 0) {
          const defaultPassword = "1234";
          const newUser = {
            userid: userid,
            username: username,
            email: email,
            password: defaultPassword,
            usertype: 1,
          };
          const insertSql = "INSERT INTO user (userid, username, email, password, usertype) VALUES (?, ?, ?, ?, ?)";
          connection.query(
            insertSql,
            [
              newUser.userid,
              newUser.username,
              newUser.email,
              newUser.password,
              newUser.usertype,
            ],
            (err, results) => {
              if (err) {
                return done(err);
              }
              return done(null, newUser);
            }
          );
        } else {
          return done(null, results[0]);
        }
      });
    }
  )
);

passport.serializeUser((user, done) => {
  done(null, user.userid);
});

passport.deserializeUser((userid, done) => {
  const sql = "SELECT * FROM user WHERE userid = ?";
  connection.query(sql, [userid], (err, results) => {
    if (err) {
      return done(err);
    }
    done(null, results[0]);
  });
});
