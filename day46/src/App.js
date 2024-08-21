import { Routes, Route } from "react-router-dom"; // 1. Link 기능 호출
import React, {
  useReducer,
  useRef,
  useEffect,
  useState,
  createContext,
} from "react"; 
import "./App.css";
import Home from "./pages/Home";
import New from "./pages/New";
import Diary from "./pages/Diary";
import Edit from "./pages/Edit";

function reducer(state, action) {
  switch (action.type) {
    case "INIT": {
      return action.data;
    }
    case "CREATE": {
      // create케이스인 경우, 현재데이터 state앞에 action.data이름의
      // 사용자에게 받아놓은 새 일기 데이터를 붙인다는 말임
      return [action.data, ...state];
    }
    case "UPDATE": {
      return state.map((it) =>
        String(it.id) === String(action.data.id) ? { ...action.data } : it
      );
    }
    case "DELETE": {
      return state.filter((it) => String(it.id) !== String(action.targetId));
    }
    default: {
      return state;
    }
  }
}
// 테스트 데이터 3건 작성 - 배열안에 객체구조
const mockData = [
  {
    id: "mock1",
    date: new Date().getTime()-1,
    content: "mock1",
    emotionId: 1,
  },
  {
    id: "mock2",
    date: new Date().getTime()-2,
    content: "mock2",
    emotionId: 2,
  },
  {
    id: "mock3",
    date: new Date().getTime()-3,
    content: "mock3",
    emotionId: 3,
  },
];

// 일기 데이터 전달
// 방법1
// export const DiaryStateContext = createContext();
// 방법2
export const DiaryStateContext = React.createContext();
// 일기 데이터 변경하는 onDelete, onCreate등 컴포넌트 전달
export const DiaryDispatchContext = React.createContext();

function App() {
  const [isDataLoaded, setIsDataLoaded] = useState(false);
  const [data, dispatch] = useReducer(reducer, []); 
  const idRef = useRef(0); 

  useEffect(() => {
    dispatch({
      type: "INIT",
      data: mockData,
    });
    setIsDataLoaded(true);
  }, []);

  // 사용자가 입력한 데이터를 받아서 저장합니다
  const onCreate = (date, content, emotionId) => {
    dispatch({
      type: "CREATE",
      data: {
        id: idRef.current,
        date: new Date(date).getTime(),
        content,
        emotionId,
      },
    });
    idRef.current = idRef.current + 1;
  };

  const onUpdate = (targetId, date, content, emotionId) => {
    dispatch({
      type: "UPDATE",
      data: {
        id: targetId,
        date: new Date(date).getTime(),
        content,
        emotionId,
      },
    });
  };

  const onDelete = (targetId) => {
    dispatch({
      type: "DELETE",
      targetId,
    });
  };

  if (!isDataLoaded) {
    return <div>데이터를 불러오는 중입니다</div>;
  } else {
    return (
      <DiaryStateContext.Provider value={data}>
        {/* 무슨 컴포넌트를 전달할지 지정 */}
        <DiaryDispatchContext.Provider 
        value = { {
          onCreate,
          onUpdate,
          onDelete, }}>

          <div className="App">
            {/* Routes는 자기가 감싸는 Route컴포넌트 중에 페이지역할 컴포넌트를 별도관리함
      pages폴더를 생성
      그래서 url 주소를 가지는 화면 컴포넌트는 pages폴더로갑니다 */}
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/new" element={<New />} />
              <Route path="/diary/:id" element={<Diary />} />
              <Route path="/edit/:id" element={<Edit />} />
            </Routes>
          </div>

        </DiaryDispatchContext.Provider>
      </DiaryStateContext.Provider>
    );
  }
}

export default App;
