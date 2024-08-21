package src;

class Animal3 {
    String name;
    void setName(String name) {
        this.name = name;
    }
}
class Dog11 extends Animal3{
    void sleep() {
        System.out.print(this.name + " 잠을 잡니다");
    }
}

class HouseDog1 extends Dog11 {
    // 생성자 메서드명과 클래스명을 동일하게 정하고
    // return과 void없이 입력값을 받게 하는 것이 생성자의 규칙이다
    HouseDog1(String name) {
        this.setName(name);
    }
    void sleep() {
        System.out.print(this.name + " 집에서 겁나게 잠을 잡니다");
    }
    void sleep(int hour) {
        System.out.print(this.name + " 집에서 겁나게 " + hour + "_시간동안 겜하고놉니다" );
    }

}

// 객체변수에 값을 지정하고 객체를 생성할 수 있게 설정하려면????
// 필수 데이터를 지정해야만 객체가 형성될 수 있도록 강제하는 것이 생성자이다
public class Constructor_1 {
    public static void main(String[] args) {
        HouseDog1 housedog = new HouseDog1("momo");
        System.out.print(housedog.name);
    }
}
