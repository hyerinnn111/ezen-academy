// import {useReducer} from "react";

// function reducer(state, action) {
//     switch (action.type) {
//         case "INCREASE":
//             return state + action.data; // setCount(count+1) 표현
//         case "DECREASE":
//             return state -action.data; // setCount(count-1) 표현
//             case "DECREASE":
//         case "INIT":
//             return 0;
//         case "HUNDRED":
//             return 100;
//         default: 
//             return state;
//     }
// }

// function Test2() {
//     const [count, dispatch] = useReducer(reducer, 0)
//     return (
//             <div>
//               <h1>{count}</h1>
//               <button onClick={() => dispatch({type: "INCREASE", date:1}) }>++</button>
//               <button onClick={() => dispatch({type: "DECREASE", date:1}) }>--</button>
//               <button onClick={() => dispatch({type: "INIT"}) }>리셋</button>
//               <button onClick={() => dispatch({type: "HUNDRED"}) }>100gogo</button>
//             </div>
//           )
        
//         }
//         export default Test2;





import { useState } from "react"

function Test2() {
  const [count, setCount] = useState(0)

const onIncrease = () => {
  setCount(count+1)
}
const onDecrease = () => {
  setCount(count-1)
}
// 0으로 리셋하려면?
const resetCount = () => {
    setCount(0)
}
  return (
    <div>
      <h1>{count}</h1>
      <button onClick={onIncrease}>++</button>
      <button onClick={onDecrease}>--</button>
      <button onClick={resetCount}>리셋</button>
    </div>
  )

}
export default Test2;