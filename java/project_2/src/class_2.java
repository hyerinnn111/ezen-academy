class Calculator {
    // 객체변수 = 인스턴스 변수 = 멤버변수 = 속성
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }

    int sub(int num) {
        result -= num;
        return result;
    }
}
// 그러면 객체를 도입한 해법은 무엇인가????
// 이름 지을 때 객체의 첫글자는 대문자입니다
// 아까는 객체의 도입이 없어서 클래스를 소문자로 네이밍 하였습니다만
// 객체를 도입하게 되어 위 클래스 이름을 대문자로 수정하였습니다
// 객체를 도입할 때 static을 냅두면 다른 객체의 값도 전부 가지고 있기 때문에
// 독립적인 계산 결과가 나오지 않습니다
// 객체는 그래서 프로그램의 단위라고 말하는구나
public class class_2 {
    public static void main(String[] args) {
        // 계산기 객체를 생성합니다
        // cal1은 Calculator의 인스턴스다
        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();

        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));
        System.out.println(cal2.add(1));
        System.out.println(cal2.add(9));
    }
}
