// import React, { useState, useEffect } from "react";
// import { Link, useNavigate } from "react-router-dom";

// // Header 컴포넌트 정의. 이 컴포넌트는 prop으로 cartlength를 받습니다.
// function Header({ cartlength }) {
//   const [loggedIn, setLoggedIn] = useState(false); // 로그인 상태를 관리하는 state
//   const navigate = useNavigate(); // 페이지 이동을 위한 navigate 훅
//   const Server_URL = process.env.REACT_APP_Server_Side_Address; // 환경변수에서 서버 URL을 가져옴

//   // 페이지가 로드될 때 로그인 상태를 확인하고 상태를 업데이트
//   useEffect(() => {
//     const storedLoggedIn = sessionStorage.getItem("loggedIn");
//     if (storedLoggedIn) {
//       setLoggedIn(true); // 로그인 상태라면 loggedIn을 true로 설정
//     }
//   }, [setLoggedIn]);

//   // 로그아웃 시 세션 스토리지에서 로그인 상태 제거
//   const handleLogout = () => {
//     sessionStorage.removeItem("loggedIn");
//     sessionStorage.removeItem("usertype"); // usertype 항목 제거
//     sessionStorage.removeItem("userData"); // userData 항목 제거
//     setLoggedIn(false); // 로그인 상태를 false로 설정
//     navigate("/"); //로그아웃 후 메인 페이지로 이동
//     window.location.reload(); // 페이지를 새로 고침
//   };

//   return (
//     <div>
//       <div>
//         <div>
//           <Link to="/">
//             <img src={`${Server_URL}/logo.jpg`} />
//           </Link>
//         </div>
//         {loggedIn ? ( 
//           <ul>
//             <li onClick={handleLogout}>
//               로그아웃
//             </li>
//             <li>
//               {/* 장바구니 링크 */}
//               <Link to="/cart">
//                 장바구니{" "}
//                 {cartlength > 0 ? ( 
//                   <b>{cartlength}</b>
//                 ) : (
//                   <b></b>
//                 )}
//               </Link>
//             </li>
//             <li>
//               <Link to="/myOrderList">주문내역</Link>
//             </li>
//           </ul>
//         ) : (
//           // 로그아웃 상태일 때 로그인과 회원가입 버튼 표시
//           <ul>
//             <li>
//               <Link to="/Login">로그인</Link>
//             </li>
//             <li>
//               <Link to="/Register/personal">회원가입</Link>
//             </li>
//             <li>

//               <Link to="/Login">
//                 장바구니{" "}
//                 {cartlength > 0 ? ( 
//                   <b>{cartlength}</b>
//                 ) : (
//                   <b></b>
//                 )}
//               </Link>
//             </li>
//           </ul>
//         )}
//       </div>
//     </div>
//   );
// }

// export default Header;


import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";


function Header({ cartlength }) {
  const [loggedIn, setLoggedIn] = useState(false);

// 1. 일정 시간이 지나면 자동 로그아웃 시키려면 남은 로그아웃 시간과 로그아웃 타이머를 관리해야 합니다.
// 시간 데이터 상태를 관리하는 useState기능을 활용하였습니다.
  const [logoutTimer, setLogoutTimer] = useState(null); // 로그아웃 타이머를 관리하는 state
  const [timeLeft, setTimeLeft] = useState(3600); // 남은 시간을 초 단위로 관리하는 state. 초기값은 1시간 입니다

  const navigate = useNavigate(); 
  const Server_URL = process.env.REACT_APP_Server_Side_Address; 



  // 2. 초기 시간을 배분하고 1시간이 지나면
  // setTimeout 내장 함수를 이용하여 기존에 있는 handleLogout로 유저를 로그아웃 시킵니다
  const resetLogoutTimer = () => {
    clearLogoutTimer();
    setTimeLeft(3600); // 타이머를 1시간으로 초기화
    const timer = setTimeout(handleLogout, 3600000); // 1시간 후에 handleLogout 호출
    setLogoutTimer(timer);
  };


  // 3. 로그인 상태일 시 1시간을 측정하기 위해, useState안의 setTimeLeft 데이터를 1초씩 감소시킨다
  // 시간이 모두 지나면 clearInterval을 통해서 setInterval로 시간을 측정하는 작업을 멈춘다
  useEffect(() => {
    if (loggedIn) {
      const intervalId = setInterval(() => {
        setTimeLeft((prevTime) => (prevTime > 0 ? prevTime - 1 : 0));
      }, 1000);
      return () => clearInterval(intervalId);
    }
  }, [loggedIn]);


  // 4. 그런데 유저가 쇼핑을 하는데 로그아웃을 시키면 안되니까 
  // 페이지가 로드될 때 마다 사용자의 활동을 감지하여
  // useEffect의 새로고침 기능을 통해서 유저의 활동이 있을 때 시간 데이터를 리셋해야 합니다
  useEffect(() => {
    const storedLoggedIn = sessionStorage.getItem("loggedIn");

    if (storedLoggedIn) {
      setLoggedIn(true); // 로그인 상태라면 loggedIn을 true로 설정

      // 로그인 상태를 감지할 때 로그아웃 타이머를 초기화 해야합니다
      resetLogoutTimer(); // 로그인 상태라면 로그아웃 타이머 초기화
    }

    // 5. 사용자 활동을 감지하여 로그아웃 타이머를 리셋
    // 키보드나 마우스의 움직임으로 사용자의 활동이 멈춘 상태인지를 확인합니다.
    const resetTimer = () => resetLogoutTimer();
    window.addEventListener("mousemove", resetTimer);
    window.addEventListener("keypress", resetTimer);

    // 6. 컴포넌트 언마운트 시 이벤트 리스너 제거
    // 프로그램 종료 시 키보드와 마우스 움직임 체크를 멈춥니다.
    return () => {
      window.removeEventListener("mousemove", resetTimer);
      window.removeEventListener("keypress", resetTimer);
      clearLogoutTimer();
    };
  }, [setLoggedIn]);


    // 7. 로그아웃 타이머 클리어 함수
    const clearLogoutTimer = () => {
      if (logoutTimer) {
        clearTimeout(logoutTimer);
      }
    };


    // 8. 유저가 알아볼 수 있는 시분초를 나타내는 함수입니다.
  const formatTime = (seconds) => {
    const h = Math.floor(seconds / 3600);
    const m = Math.floor((seconds % 3600) / 60);
    const s = seconds % 60;
    return `${h > 0 ? `${h}시간 ` : ""}${m}분 ${s}초`;
  };
  

  // 로그아웃 시 세션 스토리지에서 로그인 상태 제거
  const handleLogout = () => {
    sessionStorage.removeItem("loggedIn");
    sessionStorage.removeItem("usertype"); // usertype 항목 제거
    sessionStorage.removeItem("userData"); // userData 항목 제거
    setLoggedIn(false); // 로그인 상태를 false로 설정
    navigate("/"); //로그아웃 후 메인 페이지로 이동
    window.location.reload(); // 페이지를 새로 고침
  };






  return (
    <div>
      <div>
        <div>
          <Link to="/">
            <img src={`${Server_URL}/logo.jpg`} alt="Logo" />
          </Link>
        </div>
        {loggedIn ? (
          <ul>
            <li onClick={handleLogout}>로그아웃</li>
            <li>
              {/* 장바구니 링크 */}
              <Link to="/cart">
                장바구니{" "}
                {cartlength > 0 ? <b>{cartlength}</b> : <b></b>}
              </Link>
            </li>
            <li>
              <Link to="/myOrderList">주문내역</Link>
            </li>
            <li>
              {/* 남은 시간 표시 */}
              자동 로그아웃까지 남은 시간: {formatTime(timeLeft)}
            </li>
          </ul>
        ) : (
          // 로그아웃 상태일 때 로그인과 회원가입 버튼 표시
          <ul>
            <li>
              <Link to="/Login">로그인</Link>
            </li>
            <li>
              <Link to="/Register/personal">회원가입</Link>
            </li>
            <li>
              <Link to="/Login">
                장바구니{" "}
                {cartlength > 0 ? <b>{cartlength}</b> : <b></b>}
              </Link>
            </li>
          </ul>
        )}
      </div>
    </div>
  );
}

export default Header;