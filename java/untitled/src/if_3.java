import java.util.Scanner;

public class if_3 {
    public static void main(String[] args) {
        // 유저에게 점수하나를 입력 받아서 (이전 정답 참조)
        // 90점 이상이면 a
        // 80점 이상이면 b
        // 70점 이상이면 c
        // 60점 이상이면 d
        // 60점 미만이면 f를 출력해 주세요
                Scanner scanner = new Scanner(System.in);
                System.out.print("점수를 입력하세요");
                int score2 = scanner.nextInt();
                if (score2 >= 90) {
                    System.out.print("a입니다");
                }
                 else if (score2 >= 80) {
                        System.out.print("b입니다");
                    }
                else if (score2 >= 70) {
                    System.out.print("c입니다");
                }
                else if (score2 >= 60) {
                    System.out.print("d입니다");
                }
                else {
                    System.out.print("f입니다");
                }
            }
        }
