public class array {
    // 클래스내부 메서드가 반드시 존재해야 합니다
    // 맞게 코드입력해도 실행이 안됩니다
    // 배열은 배열의 길이가 사전에 정해져야 합니다
    public static void main(String[] args) {
        // 배열 - 한 변수에 여러데이터 삽입가능
        int[] odds = {1,3,5,7,9};
        String[] weeks = {"월", "화", "수", "목"};
        // 값 입력 후 인덱스 작업으로 값 출력 가능
        System.out.print(odds[1]);
        // 배열값을 사전에 지정하지 않아도 됩니다
        String[] weekend = new String[3];
        weekend[0] = "금요일";
        weekend[1] = "토요일";
        weekend[2] = "일요일";
        System.out.print(weekend[1]);
    }
}
