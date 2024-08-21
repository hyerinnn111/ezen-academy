package ex06;
// 인터페이스 적용방법
// interface라고 써주고 이거는 class라고할 필요는 없다
interface Predator {

}

class Animal {
    String name;
    void setName(String name) {
        this.name = name;
    }
}
class Tiger extends Animal implements Predator{

}
class Lion extends Animal implements Predator{

}
class Crocodile extends Animal {

}
class ZooKeeper {
    // 만약 tiger랑 lion이 단순 인풋 데이터면 오버로딩이 안되고 에러가 날 것이다
    // 그런데 객체를 인풋으로 받는 메서드는 객체 종속적이기 때문에
    // 다른 객체는 다른 형태의 인풋값이라고 생각해서 오버로딩 기능이 정상작동한다
    // 객체 종속적인 속성이 지닌다.
    // 메서드 오버로딩이 지금 되는 이유는 객체는 사용자 정의 자료형 즉 고유한 자료형이니까
    void feed(Tiger tiger) {
        System.out.print("사과먹자");
    }
    void feed(Lion lion) {
        System.out.print("바나나먹자");
    }
    void feed(Crocodile crocodile) {
        System.out.print("딸기먹자");
    }
}

public class Interface {
    // 인터페이스입니다. 객체를 인풋으로 받는 메서드가
    // 인풋 객체에 독립적으로 실행될 수 있는 기능

}
