public class switch_2 {
    public static void main(String[] args) {
        // switch 구문은 문자열도 사용 가능
        // 정수 등으로 특정 케이스로 분리되어 if처럼 범위를 줄 수 없다.
        String city = "인천";
        switch (city) {
            case "서울":
                System.out.println("seoul");
                break;
            case "인천":
                System.out.println("incheon");
                break;
            case "강원도":
                System.out.println("gangwon");
                break;
            default:
                System.out.println("기타");
                break;
        }
    }
}
