// "Hello world!"
// 를 출력하는 코드입니다. 그런데 깁니다...
// 자바는 객체지향언어로 모든 파일엔 클래스가 존재합니다.
// 파일이름은 대표클래스 이름과 동일해야합니다.
// 클래스에 public이 붙으면 클래스 이름과 파일이름이 같아야 합니다
// public이 붙은 클래스가 대표 클래스이구나...아실 수 있습니다
public class Main {
    // 클래스 안의 main이 메서드(클래스안 함수)이다.
    // public은 누구나 이 메서드에 접근할 수 있다
    // static이 있으면 인스턴스(객체) 없이 실행됨
    // void는 리턴값이 없음을 의미
    // String[] 문자데이터가 배열로 이루어져 있음을 알림
    public static void main(String[] args) {
        // main이란 이름의 메서드 블럭 안에 명령문이 있다.
        // System.out.println 표준 출력문
        System.out.println("Hello world!");
    }
}