import java.util.Scanner;

public class array_2 {
    public static void main(String[] args) {
//크기가 3인 정수형 배열을 선언하고
//스캐너로 정수값을 입력받은 후에 배열데이터의 합계와 평균을 계산
        Scanner scanner = new Scanner(System.in);
        // 배열 선언시, 배열의 크기가 반드시 지정 되어야 한다
        int[] number1 = new int[3];
//        System.out.println("첫째 숫자는요?");
//        // 배열이니까 인덱스 꼭 포함하기
//        number1[0] = scanner.nextInt();
//        System.out.println("둘째 숫자는요?");
//        // 배열이니까 인덱스 꼭 포함하기
//        number1[1] = scanner.nextInt();
//        System.out.println("셋째 숫자는요?");
//        // 배열이니까 인덱스 꼭 포함하기
//        number1[2] = scanner.nextInt();
//        int sum = number1[0] + number1[1] + number1[2];

        int sum = 0;
        for (int i = 0; i <number1.length; i++) {
            System.out.println((i+1) + "번째 값을 입력하세요");
            number1[i] = scanner.nextInt();
            sum += number1[i];
        }

        System.out.println(sum);
        System.out.println(sum/number1.length);
    }
}
