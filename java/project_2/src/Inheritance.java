package src;

//자식 클래스가 부모클래스의 속성을 받아오는 상속의 개념입니다
class Animal1 {
    String name;
    void setName(String name) {
        this.name = name;
    }
}
class Dog extends Animal1{
    void sleep() {
        System.out.print(this.name + " 잠을 잡니다");
    }
}
// 원래 Dog객체는 암것도 없는데 Animal1에서 상속 받았다.
public class Inheritance {
    public static void main(String[] args) {
        // 클래스는 dog인데 자료형이 animal인 경우 (자식클래스의 부모 자료형 ^^)
        // 상속관계에서 성립하는 특수관계입니다.
        // 이 경우 자식클래스 메서드는 못씁니다.
        Animal1 dog2 = new Dog();
        // 반대의 경우는 컴파일 에러가 납니다.
        Dog dog3 = (Dog) new Animal1();
        Dog dog = new Dog();
        dog.setName("jerry");
        System.out.print(dog.name);
        dog.sleep();
    }
}