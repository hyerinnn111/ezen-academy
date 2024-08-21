import java.util.Scanner;

public class if2 {
    public static void main(String[] args) {
//    유저에게 숫자를 입력 받아서 60점 이상이면 "합격"
//    60점 미만이면 "불합격" 메세지를 출력해 주세요
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수를 입력하세요");
        int score2 = scanner.nextInt();
        if (score2 >= 60) {
            System.out.print("합격입니다");
        }
        else {
            System.out.print("불합격입니다");
        }
    }
}
