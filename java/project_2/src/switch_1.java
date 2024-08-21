public class switch_1 {
    public static void main(String[] args) {
        // 0, 1, 2 인 경우와 그 이외의 경우를 switch구문으로 분리
        // print, println 차이는 ln = line println이라고 쓰면 줄바꿈
        int num = 0;
        switch (num) {
            case 0:
                System.out.println("0입니다");
                break;
            case 1:
                System.out.println("1입니다");
                break;
            case 2:
                System.out.println("2입니다");
                break;
            default:
                System.out.println("별도 케이스입니다");
                break;
        }
        System.out.println("switch문 종료");
    }
}
