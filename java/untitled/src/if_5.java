import java.util.Scanner;
public class if_5 {
    public static void main(String[] args) {
        // 서로다른 정수 3개를 입력받아서 가장 큰 정수를 출력해 주세요
        // 유저는 서로다른 정수값을 정확히 입력해 준다는 믿음을 가져도 됩니다
        Scanner scan = new Scanner(System.in);
        int num1 = 0, num2 = 0, num3 = 0;
        System.out.print("첫번째 숫자 입력");
        num1 = scan.nextInt();
        System.out.print("두번째 숫자 입력");
        num2 = scan.nextInt();
        System.out.print("세번째 숫자 입력");
        num3 = scan.nextInt();
        int max = 0;
        if (num1 > num2) {
            if(num1 > num3) {
                max = num1;
            }
            else {
                max = num3;
            }
        }
        else {
            if (num2 > num3) {
                max = num2;
            }
            else {
                max = num3;
            }
        }
        System.out.print("가장 큰 수는 " + max);
    }
}
