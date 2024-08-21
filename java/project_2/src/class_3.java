class Animal {
    String name;

    public void setName(String name777) {
        this.name = name777;
    }
}

public class class_3 {
    public static void main(String[] args) {
        // 객체 변수는 공유되지 않는다
        Animal cat = new Animal();
        cat.setName("mingky");
        Animal dog = new Animal();
        dog.setName("joy");
        System.out.println(cat.name);
        System.out.println(dog.name);
    }
}
