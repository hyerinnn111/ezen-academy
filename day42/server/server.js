const express = require("express");
const app = express();
// 리액트의 기본 포트번호가 3000번이라서 3000아닌걸로 하면 됩니다
// 포트번호는 주소이므로 한 주소에 다른 서비스가 들어올 수 없습니다
const port = 3001;
// cors 패키지는 express 패키지에서 다른 출처 리소스에 대한 접근허용
const cors = require("cors");
// 서버의 요청과 응답사이 중간작업 수행 패키지입니다
// 요청의 본문 내용을 지정한 형태로 해석(parsing)해 줍니다
const bodyParser = require("body-parser");

// mysql 패키지를 부릅니다
const mysql = require("mysql2");
// mysql 로그인정보를 알려줍니다
var connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "1234",
  database: "parentsday", 
});
// mysql연결 명령어 입니다
connection.connect();

app.use(bodyParser.urlencoded({extended: false}))
app.use(bodyParser.json());
app.use(cors()); // 다른 출처 리소스에 대한 접근을 허용하겠습니다

app.get('/', (req, res) => {
    res.send('풀스택 코딩 중') //해당 메세지를 통해 잘되는지 간단히 체크
})

app.post("/idplz", (req, res) => {
    // 사용자의 요청 (req) 즉, 입력태그 값을 test라는 변수로 가져옵니다
    const test = req.body.test
// 데이터 삽입 쿼리입력
// 사용자에게 입력받은 test안의 글을 test_body 컬럼에 집어넣겠습니다
    connection.query("insert into test (test_body) values (?)", 
    [test], 
    function(err, rows, fields) {
        if(err) {
            console.log("실패입니다"); // 쿼리실행 실패시 실패메세지
        }
        else {
            console.log("성공입니다"); // 쿼리실행 성공시 성공메세지
        }
    })
})

app.listen(port, ()=> console.log(` ${port}에 연결되었습니다`))