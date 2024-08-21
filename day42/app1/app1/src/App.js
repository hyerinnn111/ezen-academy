// 리액트 패키지 호출 후 사용하지 않는 요소의 제거
import './App.css';
import Viewer from "./component/Viewer"
import Controller from "./component/Controller";
import { useEffect, useState} from "react";

function App() {
  // useState기능은 반드시 해당 컴포넌트 함수안에 와야함
  const [count, setCount] = useState(0);

  const [text, setText] = useState("");
  // 숫자세는 함수 (증감의 변수처리)
  const handleSetCount = (value) => {
    setCount(count + value);
  }
  const handleChangeText= (e) => {
    setText(e.target.value);
  }

  useEffect(() => {
    console.log("점수 업데이트", count, text)
  }, [count, text])

  return (
    <div className="App">
      <h1> 간단한 점수계산</h1>
      <input value={text} onChange={handleChangeText} />
      <section>
        {/* Viewer 컴포넌트에 현재점수를 전달합니다 */}
      <Viewer count={count}/>
      </section>
      <section>
        {/* 숫자세는 함수전체를 보냅니다 */}
        <Controller handleSetCount={handleSetCount} />
        </section>
    </div>
  );
}

export default App;
