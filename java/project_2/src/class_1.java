class calculator1 {
    // 메인 클래스인 class_1와 별개로 계산기 클래스를 만들어서 덧셈메서드를 포함시킴
    // 초기변수를 0으로 정하고
    static int result = 0;
    // add라는 메서드에 인풋을 넣으면 인풋값을 더해주는 기능
    // 자바에서 메서드는 클래스없이 홀로서기 불가능
    static int add(int num) {
        result += num;
        return result;
    }
}

class calculator2 {
    // 메인 클래스인 class_1와 별개로 계산기 클래스를 만들어서 덧셈메서드를 포함시킴
    // 초기변수를 0으로 정하고
    static int result = 0;
    // add라는 메서드에 인풋을 넣으면 인풋값을 더해주는 기능
    // 자바에서 메서드는 클래스없이 홀로서기 불가능
    static int add(int num) {
        result += num;
        return result;
    }
}
// 자바에서 다른 클래스를 자유롭게 부를 수 있다
// 만약에 서로다른 두 쌍의 덧셈 결과물이 필요하다면???
// 1. 객체없이 해결하는 법: 결과 세트 수만큼 클래스 만들기
public class class_1 {
    public static void main(String[] args) {
        // 만들어 둔 calculator클래스 add 메서드를 호출하여 인풋값을 주고 파일 실행시 메서드 실행
        System.out.println(calculator1.add(3));
        System.out.println(calculator1.add(4));
        System.out.println(calculator2.add(1));
        System.out.println(calculator2.add(9));
    }
}
