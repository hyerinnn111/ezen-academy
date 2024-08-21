
import './App.css';
import Viewer from "./component/Viewer";

function App() {
  const test11 = {
    a: 111,
    b: 222,
  }

  return (
    <div className="App">
      <h2>간단한 숫자 카운트 앱</h2>
      <h3>{test11}</h3>
      <section>
        <Viewer />
      </section>
    </div>
  );
}

export default App;
