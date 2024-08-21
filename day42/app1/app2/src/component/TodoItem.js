import "./TodoItem.css"

const TodoItem = ( { id, content, isDone, createDate, onDelete}) => {

    // 받은 onDelete함수를 마우스 클릭 시 실행할 함수로 감싸서 정의
    const onClickDelete = () => {
        onDelete(id)
    }
    return (
        <div className="TodoItem">
            <div className="checkbox_col">
                <input checked={isDone} type="checkbox" />
            </div>
            <div className="title_col">{content}</div>
            <div className="date_col">
                {new Date(createDate).toLocaleDateString}</div>
            <div className="btn_col">
                <button onClick={onClickDelete}>삭제</button>
            </div>
        </div>
    )
}

export default TodoItem;