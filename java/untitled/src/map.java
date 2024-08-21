import java.util.HashMap;
// 자바스크립트 객체 json 데이터형식과 같습니다
// key & value로 구성된 데이터형식입니다. hash라고도 합니다
// 리스트나 배열처럼 순차적으로 값을 찾지않고 key를 이용해 한번에 찾습니다
public class map {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");
        // key값을 입력하여 값을 출력합니다
        System.out.print(map.get("people"));
        // containsKey는 key값의 유무를 확인해 줍니다
        System.out.print(map.containsKey("people"));
        // 모든 key값을 출력
        System.out.print(map.keySet());
    }
}
