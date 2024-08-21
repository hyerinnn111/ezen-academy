import emotion1 from "./img/emotion1.png";
import emotion2 from "./img/emotion2.png";
import emotion3 from "./img/emotion3.png";
import emotion4 from "./img/emotion4.png";
import emotion5 from "./img/emotion5.png";

export const getEmotionImgById = (emotionId) => {
    const targetEmotionId = String(emotionId);
    switch ( targetEmotionId) {
        case "1":
            return emotion1;
        case "2":
            return emotion2;
        case "3":
            return emotion3;
        case "4":
            return emotion4;
        case "5":
            return emotion5;
                default:
                    return null;

    }
};
// 상태 id 값에 따른 위 이모티콘 그림함수를 사용할 데이터셋
export const emotionList = [
    {
        id: 1,
        name: "아주 좋음",
        img: getEmotionImgById(1),
      }, 
      {
        id: 2,
        name: "살짝 좋음",
        img: getEmotionImgById(2),
      }, 
      {
        id: 3,
        name: "보통",
        img: getEmotionImgById(3),
      }, 
      {
        id: 4,
        name: "살짝 나쁨",
        img: getEmotionImgById(4),
      }, 
      {
        id: 5,
        name: "아주 나쁨",
        img: getEmotionImgById(5),
      },
    ]
    
    




// 날짜 객체를 받으면 (1/1000 초 단위의 큰 수) 
// 우리가 알아볼 수 있게 변환해서 표시하는 함수
export const getFormattedDate = (targetDate) => {
    // let으로 선언해야 변수값의 재할당이 가능함
    let year = targetDate.getFullYear();
    let month = targetDate.getMonth() +1;
    let date = targetDate.getDate();
    if (month < 10) {
        month = `0${month}`
    }
    if (date < 10) {
        date = `0${date}`
    }
    return `${year}-${month}-${date}`

}