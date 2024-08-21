import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function LoginPage() {
  const [email, setemail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const [loginStatus, setloginStatus] = useState("");

  // 서버 주소
  const Server_URL = process.env.REACT_APP_Server_Side_Address;
  const Kakao_JS_KEY = process.env.REACT_APP_KAKAO_JS_KEY;

  useEffect(() => {
    // Kakao SDK 초기화
    if (!window.Kakao.isInitialized()) {
      window.Kakao.init(Kakao_JS_KEY);
      console.log('Kakao SDK initialized with key:', Kakao_JS_KEY);
    }
  }, [Kakao_JS_KEY]);

  const LoginPageJs = () => {
    console.log("LoginPageJs 함수 호출됨");

    axios
      .post(`http://localhost:8000/login`, {
        email: email,
        password: password,
        usertype: "1", // 고정된 사용자 유형 (예를 들어, 일반 사용자)
      })
      .then((response) => {
        console.log("서버 응답:", response);
        if (response.data.success) {
          const { usertype, userid, username } = response.data.data[0];
          const userData = {
            userid: userid,
            username: username,
            usertype: usertype,
          };
          sessionStorage.setItem("loggedIn", true);
          sessionStorage.setItem("userData", JSON.stringify(userData));
          sessionStorage.setItem("usertype", usertype);
          navigate("/");
          window.location.reload();
        } else {
          console.log("로그인 실패:", response.data);
          setloginStatus("로그인 실패: " + response.data.message);
        }
      });
  };

// Inside handleKakaoLogin function
const handleKakaoLogin = async () => {
  window.Kakao.Auth.login({
    success: async (authObj) => {
      console.log("Kakao login success:", authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: async (response) => {
          console.log(response);
          const kakaoAccount = response.kakao_account;
          const email = kakaoAccount.email || `kakao_${response.id}@no-email.com`;
          const username = kakaoAccount.profile.nickname || 'KakaoUser';
          const usertype = "1"; // Assuming the default usertype is "personal"
          const userid = response.id.toString().substring(0, 6); // Extract the first 6 digits of response.id

          const userData = {
            userid: userid,
            username: username,
            usertype: usertype,
          };

          try {
            const response = await axios.post("http://localhost:8000/kakao-login", {
              userid,
              username,
              email,
              usertype,
            });

            console.log("Kakao login response:", response.data);

            // Update login status
            setloginStatus("Kakao 로그인 성공");

            // Set session storage
            sessionStorage.setItem("loggedIn", true);
            sessionStorage.setItem("userData", JSON.stringify(userData));
            sessionStorage.setItem("usertype", usertype);

            // Redirect or do any other necessary action
            navigate("/"); // Redirect to home page
            window.location.reload();
          } catch (error) {
            console.error("서버 에러:", error);
            setloginStatus("서버 에러: " + error.message);
          }
        },
        fail: (error) => {
          console.log(error);
          setloginStatus("Kakao 로그인 실패");
        },
      });
    },
    fail: (err) => {
      console.log("Kakao login failed:", err);
      setloginStatus("Kakao 로그인 실패");
    },
  });
};


  return (
    <div>
      <div>
        <h1>로 그 인</h1>
        <div>
          <form>
            <div>
              가입된 이메일과 비밀번호를 입력해주세요. <br />
              계정을 만드십시오.
            </div>
            <div>
              <input
                type="text"
                placeholder=" 이메일"
                value={email}
                onChange={(e) => setemail(e.target.value)}
              />
              <br />
              <input
                type="password"
                placeholder=" 비밀번호"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              {loginStatus && (
                <div>{loginStatus}</div>
              )}
              <br />
            </div>

            <hr />
            <div>
              <button
                onClick={(e) => {
                  e.preventDefault();
                  LoginPageJs();
                }}
              >
                로그인
              </button>
              <button
                onClick={() => navigate("/Register/personal")}
              >
                회원가입
              </button>
              <button
                type="button"
                onClick={handleKakaoLogin}
                style={{ backgroundColor: '#FFEB00', border: 'none', padding: '10px', borderRadius: '5px' }}
              >
                카카오로 로그인
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
