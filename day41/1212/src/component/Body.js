import "./Body.css";

const Body = ({name777, location, foodList}) => {
// const Body = (props) => {
// props라 쓰면서 전체 데이터셋을 다 가져올 필요 없이
// 받을 때 데이터를 선택해서 받을 수 있습니다

// props로 전달된 데이터가 여러개인 경우
// props의 구성요소를 나열하여 사용하실 수 있습니다
// 구조분해할당 방식 (객체를 분해해서 원하는 데이터 얻기)
// const {name9999, location} = props;
   
    return ( 
    <div className="body">
        <h1>바디 태그입니다</h1>
        <p>{name777}과정은 {location}에 있습니다</p>
        <p>{foodList.length}개 메뉴가 있네요</p>
        <p>저는 {foodList[0]}를 먹겠습니다</p>
        </div>
        )
    }
    // 기본값을 설정하는 방법. foodList라는 데이터는
    // 기본값이 비어있다로 나타내서 코딩 중간에 데이터 부재로
    // 어려움을 겪지 않도록 할 수 있다
        Body.defaultProps = {
            foodList: [],
        }
export default Body;