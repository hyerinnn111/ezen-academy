// 사용자에게 인풋값을 받아서 작업하는 기능 소개
import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        // Scanner 객체를 소개합니다
        // Scanner는 사용자 정의 자료형입니다
        Scanner scanner = new Scanner(System.in);
        // 유저에게 숫자 입력해달라고 알려줌
        System.out.print("숫자를 입력하세요");
        // 유저가 입력한 값을 num1변수에 저장
        int num1 = scanner.nextInt();
        System.out.print(num1);

        System.out.print("이름를 입력하세요");
        String name = scanner.next();
        System.out.print(name);

        // 예제: 정수2개를 각각 스캐너로 num3, num4에 입력받아서
        // 입력값의 합을 출력하세요
        System.out.print("첫번째 숫자");
        int num3 = scanner.nextInt();
        System.out.print("두번째 숫자");
        int num4 = scanner.nextInt();
        int sum = num3 + num4;
        System.out.print("합계" + sum);

    }
}
