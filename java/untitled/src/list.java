import java.util.ArrayList;

public class list {
    public static void main(String[] args) {
        // 리스트 자료형입니다
        // 배열과 유사한데 요소의 개수가 사전에 정해지지 않습니다
        // 제네릭스 - 자료형을 지정하는 방식입니다
        // 제네릭스를 안쓰면 들어오는 데이터마다 데이터 타입을 지정해야합니다
        ArrayList<String> pitches = new ArrayList<>();
        pitches.add("100");
        pitches.add("110");
        pitches.add("120");
        //인덱스를 통해 원하는 값을 접근하며 get메서드를 쓴다
//        System.out.print(pitches.get(0));
        // 리스트의 개수 입니다
        System.out.print(pitches.size());
        System.out.print(pitches);



    }
}
