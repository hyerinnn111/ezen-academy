import { useState } from "react";
import "./App.css";

function App() {
  // testbody라는 이름의 해당 문자데이터를 업데이트하는
  // (sql에 추가하는) 함수 생성
  const [testbody, setTestbody] = useState("");
  // 화면 입력값이 변경될 때 호출되는 함수
  const handleChange = (e) => {
    setTestbody(e.target.value);
  };
  // 제출 버튼을 눌렸을 때 testbody에 담긴
  // 최종 문자데이터를 확정합니다
  const submitId = () => {
    const post = {
      test: testbody,
    };
    // 포트 3001을 타고 mysql에 들어가서 확정된 데이터를 보냅니다
    fetch("http://localhost:3001/idplz", {
      method: "post", //통신방법 지정
      headers: {
        "content-type": "application/json" // json형식으로 헤더 설정
      },
      body: JSON.stringify(post), // 데이터 객체를 json문자열로 변환하여 전송
    })
    .then((res) => res.json())
    .then((json) => {
      setTestbody(json.text)
    })
  };

  return (
    <div className="App">
      <input onChange={handleChange} name="testBody" />
      <button onClick={submitId}>제출하기</button>
      <h1>{testbody}</h1>
    </div>
  );
}

export default App;