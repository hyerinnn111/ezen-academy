public class Class_7 {
    // 메인 클래스 안에 값을 1 증가 시키는 메서드 선언{
    int varTest(int a) {
        a++;
        return a;
    }
    // 1. 메인 메서드에서 a라는 정수형 자료형 변수를 만들고 1을 부여함
    // 2. vatTest 메서드에 입력값을 a로 주고 호출했다
    // 3. a값을 출력했다
    // 기대와 달리 1증가 상관없이 그냥 1이 나왔다
    // 왜?? 메서드에서 사용한 매개변수는 메서드 안에서만 쓰이니까
    // 변수의 범위에 주의해 주세요. 애매하면 변수이름 다르게 코딩하기
    // 그럼 이전변수 1에서 메서드를 이용하여 2로 바꾸는 방법은 없을까??
    public static void main(String[] args) {
        int a = 1;
        Class_7 sample = new Class_7();
        a = sample.varTest(a);
        System.out.print(a);
    }
}
