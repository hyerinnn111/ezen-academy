//자식 클래스가 부모클래스의 속성을 받아오는 상속의 개념입니다
// 자식 클래스가 부모클래스와 동일한 이름의 메서드를 구현하는 것을
// 메서드 오버라이딩이라 합니다

// 메서드 오버로딩도 있어요
// 메서드의 이름이 같은데 입력 항목이 다르면 알아서 해당 메서드를 부릅니다
class Animal2 {
    String name;
    void setName(String name) {
        this.name = name;
    }
}
class Dog1 extends Animal2{
    void sleep() {
        System.out.print(this.name + " 잠을 잡니다");
    }
}

class HouseDog extends Dog1 {
    void sleep() {
        System.out.print(this.name + " 집에서 겁나게 잠을 잡니다");
    }
    void sleep(int hour) {
        System.out.print(this.name + " 집에서 겁나게 " + hour + "_시간동안 겜하고놉니다" );
    }

}

// 원래 Dog객체는 암것도 없는데 Animal1에서 상속 받았다.
public class Inheritance_2 {
    public static void main(String[] args) {
        HouseDog housedog = new HouseDog();
        housedog.setName("jerry");
        housedog.sleep();
        housedog.sleep(3);
    }
}
