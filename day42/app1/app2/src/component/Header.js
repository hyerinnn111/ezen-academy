import "./Header.css";
// 화살표 함수를 흔히 씁니다
// 호이스팅 현상없고 function이란 단어도 생각가능해서 간편하다
const Header = () => {
    return <div className="Header">
        <h2>오늘은🎀</h2>
        <h1>{new Date().toDateString()}</h1>
        </div>
}

export default Header;