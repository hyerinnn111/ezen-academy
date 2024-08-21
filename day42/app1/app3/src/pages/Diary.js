import { useParams } from "react-router-dom";

const Diary = () => {
    const { id } = useParams();
    
    return <div> { id }diary 입니다</div>
}

export default Diary;