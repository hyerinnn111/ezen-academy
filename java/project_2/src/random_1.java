public class random_1 {
    public static void main(String[] args) {
        // 특정 범위의 무작위 수를 만들어야 할때
        // 고객id번호 등을 만들 때 사용
        // Math.random() : 0에서 1사이의 무작위 실수 만듬
        System.out.println(Math.random());
// 0에서 9이하의 정수를 무작위로 만들 때
        System.out.println((int)(Math.random() * 10));
    // 1에서 10이하의 정수를 무작위로 만들 때
        System.out.println((int)(Math.random() * 10)+1);
        // 형변환 예제
        int integer1 = 10;
        double double1 = 1.23456;
        // 자동형변환 (좁은곳에서 넓은 곳으로)
        double double2 = integer1;

        // 강제 형변환 (넓은 곳에서 좁은 곳으로)
        int int3 = (int) double1;
        // int int4 = double1; 강제 형변환의 조건을 만족하지 않으면 에러
    }
}
