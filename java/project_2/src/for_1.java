public class for_1 {
    public static void main(String[] args) {
        // one, two, three 문자열을 순차적으로 출력하는 법
        String[] numbers = {"one", "two", "three"};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
// 학생 5명의 성적이 90,25,67,45,80 점이다
// 60점이 넘으면 해당학생은 합격이고 이하면 불합격이다
int[] marks = {90,25,67,45,80} ;
        for (int i = 0; i < marks.length; i++) {
            if(marks[i] >60) {
                System.out.println( (i+1) + "번째 학생은 합격입니다");
            }
            else {
                System.out.println( (i+1) + "번째 학생은 불합격입니다");
            }
        }
// 구구단 출력 예제
        for(int i = 2; i < 10; i++ ) {
            for(int j = 1; j < 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println(""); //줄바꾸기
        }
        // i 는 for문 내에서 선언된 "지역변수"라서
        // for문 밖에서는 사용불가
        // System.out.println(i);
    }
}
