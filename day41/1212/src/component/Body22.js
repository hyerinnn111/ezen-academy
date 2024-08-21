import "./Body.css";
// 이벤트 핸들링은 어떻게 하는가?
// "버튼을 클릭하셨군요"라는 메세지를 띄우는 handleOnClick() 함수를 정의
// button 태그에 마우스 클릭 시 handleOnClick() 함수가 커지도록 함
function Body22() {
    // function handleOnClick() {
    //     alert("버튼을 클릭하셨군요")
    // }
    function handleOnClick33(e) {
        console.log(e.target.name)
    }
// a버튼과 b버튼을 각각 누르면 handleOnClick33함수가 실행되면서
// "a버튼이에요", "b버튼이에요" 라는 name 변수에 저장된 데이터가 console.log로 로그에 찍힙니다
    return (
        <div className="body">
            {/* <button onClick={handleOnClick}>클릭하세요</button> */}
            <button name="a버튼이에요" onClick={handleOnClick33}>a버튼을 클릭하세요</button>
            <button name="b버튼이에요" onClick={handleOnClick33}>b버튼을 클릭하세요</button>
        </div>
    )
}

export default Body22;