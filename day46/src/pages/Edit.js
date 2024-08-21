// URL주소로 일기 데이터 가져오기
import {useParams, useNavigate} from "react-router-dom"
import useDiary from "../hooks/useDiary"
import Button from "../component/Button"
import Header from "../component/Header"
import {DiaryDispatchContext} from "../App"
import { useContext} from "react"
import Editor from "../component/Editor"

const Edit = () => {
    const { id } = useParams()
    const data = useDiary(id)
    const navigate = useNavigate()
    const {onDelete, onUpdate} = useContext(DiaryDispatchContext)

    const onSubmit = (data) => {
        if (window.confirm("진짜 수정할까요??")) {
            const {date, content, emotionId} = data
            onUpdate(id, date, content, emotionId)
            navigate("/", {replace: true})
        }
    }

    const goBack = () => {
        navigate(-1)
    }
    const onClickDelete = () => {
        if (window.confirm("진짜 지울까요??")) {
            onDelete(id)
        navigate("/", {replace: true})
    }
    }

    if (!data) {
        return <div>데이터를 불러오고 있습니다</div>
    } 
    else {    
    return (
    <div> 
        <Header
        title={"일기수정하기"}

        leftChild={ <Button
            text={"<뒤로가기"}
            onClick={goBack} /> }

            rightChild={ <Button
                color_type={"negative"}
                text={"삭제하기"}
                onClick={onClickDelete} /> }
            />
            <Editor initData={data} onSubmit={onSubmit}/>
    </div>)
    }
}

export default Edit;