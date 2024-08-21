import "./TodoEditor.css";
import { useState, useRef } from "react";

const TodoEditor = ({onCreate}) => {
    // 사용자 입력태그에 입력한 데이터를 저장할 state입니다
    const [content, setContent] = useState("")
    
    const inputRef = useRef()
    // setContent기능을 통해 입력받은 값을 업데이트 합니다
    const onChangeContent = (e) => {
        setContent(e.target.value);
    }

    const onSubmit = () => {
        // 입력태그에 글자 없으면 입력태그를 그대로 두고 빠져나옴
        if(!content) {
            inputRef.current.focus()
            return;
        }
        onCreate(content);
        // 입력한 값이 들어가면 기존의 입력값은 클리어합니다
        setContent("")
    }

    return (
        <div className="TodoEditor">
            <h4>새로운 할일 작성하기🤍</h4>
            <div className="editor_wrapper">
                <input 
                ref={inputRef}
                value={content}
                onChange={onChangeContent}
                placeholder="새로운 할일.."/>
                <button onClick={onSubmit}>추가</button>
            </div>
        </div>
    )
}

export default TodoEditor;