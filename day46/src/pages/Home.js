import Header from "../component/Header" 
import Button from "../component/Button"
import Editor from "../component/Editor" 
import React, {useState, useContext, useEffect} from "react"
import {DiaryStateContext} from "../App"
import {getMonthRangeByDate} from "../util"
import DiaryList from "../component/DiaryList"

const Home = () => {
    const data = useContext(DiaryStateContext)
    // new Date() 날짜 객체는 데이터의 형태가 날짜임을 알려준다
    // 현재 시간을 받고 싶다면 new Date.getTime() 이런식으로 뒤에 명령어가 필요하다
    const [pivotDate, setPivotDate] = useState(new Date());
    // 일기 게시글 데이터 필터링
    const [filteredData, setFilteredData] = useState( [] );
    const headerTitle = `${pivotDate.getFullYear()}년 
                            ${pivotDate.getMonth() +1}월`

useEffect( () => {
    if (data.length >=1) {
        const {beginTimeStamp, endTimeStamp} = getMonthRangeByDate(pivotDate)
        setFilteredData(
            data.filter( (it) => beginTimeStamp <= it.date && 
            it.date <= endTimeStamp))
    }
    else {
        setFilteredData([]) 
    }
}, [data, pivotDate] )



const onIncreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() + 1))
}

const onDecreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() - 1))
}

    return (<div>
        <Header 
        title={headerTitle}

        leftChild={
            <Button
        text="<" onClick={ onDecreaseMonth  } />}

        rightChild={
            <Button
        text=">" onClick={ onIncreaseMonth  } />}
        />
        {/* <Editor onSubmit={() => { alert("제출하셨군여")}}/> */}
        <DiaryList data={filteredData} />
        </div>)
}

export default Home;