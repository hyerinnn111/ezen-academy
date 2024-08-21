import java.util.Scanner;

public class switch_3 {
    public static void main(String[] args) {
        // switch와 scanner를 사용해서 사용자에게 사무가구를 입력받아서
        // 책상, 의자, 모니터, 마우스, 기타가구 케이스로 구분하도록 코드를 작성하세요
        Scanner scanner = new Scanner(System.in);
        System.out.println("가구종류를 입력하세요");
        String word = scanner.next();
        switch(word) {
            case "책상":
                System.out.println("책상");
                break;
            case "의자":
                System.out.println("의자");
                break;
            case "모니터":
                System.out.println("모니터");
                break;
            case "마우스":
                System.out.println("마우스");
                break;
            default:
                System.out.println("기타");
                break;
        }
    }
}
