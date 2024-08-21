public class Class_5 {
    // 클래스 안에 sayHey라는 메서드를 만들어서
    // hihi라고 입력하면 메서드를 빠져나갑니다
    void sayHey(String nick) {
        if("hihi".equals(nick)) {
            return;
        }
        System.out.println("나는 " + nick + "이라고 말했습니다");
    }

    public static void main(String[] args) {
        Class_5 sample = new Class_5();
    }
}
