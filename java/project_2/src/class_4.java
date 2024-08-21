class Sample {
    int sum(int a, int b) { // a, b는 매개변수 (parameter)
        return a+b;
    }
    // 리턴값이 없는 메서드는 리턴 자료형에 void 라고 써줘야 한다
    void sub1(int a, int b) { // a, b는 매개변수 (parameter)
        System.out.print ("hello");
    }
    int sum222() {
        return 999;
    }
    String say() {
        return "hi";
    }
}
// 매개변수는 메서드에 입력값을 저장하는 변수
// 인수는 메서드 호출 시 전달하는 입력값

// 메서드는 4가지 종류가 있습니다
// 1. 입력값, 출력값이 모두 존재
// 2. 입력값있는데 출력은 없음
// 3. 입력값 없고 출력은 있음
// 4. 입력 출력값 다 없음
public class class_4 {
    public static void main(String[] args) {
        // 매개변수와 인수
        Sample sample = new Sample();
        int c =sample.sum(3,4); // 3,4를 인수라 한다
        System.out.print(c);
    }
}
