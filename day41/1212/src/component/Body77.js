import { useState } from "react";
import "./Body.css";

function Viewer ( {score}) {
    return (
    <div>
        {score % 2 === 0 ? <p>짝수</p> : <p>홀수</p>}
        </div>)
}

function Body77() {
    console.log("업데이트~")
    const [score, setScore] = useState(0);

    const onIncrease = () => {
        setScore(score +1);
    }
    const onDecrease = () => {
        setScore(score -1);
    }
    

    return (
        <div className="body">
            <h2>{score}</h2>
            <button onClick={onIncrease}>누르면 1씩 커짐^^</button>
            <button onClick={onDecrease}>누르면 1씩 작아짐^^</button>
            
        </div>
    );
}

export default Body77;