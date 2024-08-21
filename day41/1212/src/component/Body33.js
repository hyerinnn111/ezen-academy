import { useState } from "react";
import "./Body.css";

function Body33() {
    const [score, setScore] = useState(0);

    const onIncrease = () => {
        setScore(score +1);
    }
    

    return (
        <div className="body">
            <h2>{score}</h2>
            <button onClick={onIncrease}>누르면 1씩 커짐^^</button>
            
        </div>
    );
}

export default Body33;