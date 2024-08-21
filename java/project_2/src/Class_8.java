//public class Class_8 {
//    // 자바에서는 메서드가 인풋값으로 객체를 받을 수 있습니다
//    int a;
//    void varTest(Class_8 crazy) {
//        crazy.a++;
//    }
//
//    public static void main(String[] args) {
//       Class_8 sample = new Class_8();
//        sample.a = 1;
//        sample.varTest(sample);
//        System.out.print(sample.a);
//    }
//}

public class Class_8 {
    // 자바에서는 메서드가 인풋값으로 객체를 받을 수 있습니다
    // Class_8안에서 구성되었으므로 인풋필요없이 this로 처리 가능
    int a;
    void varTest() {
        this.a++;
    }

    public static void main(String[] args) {
        Class_8 sample = new Class_8();
        sample.a = 1;
        sample.varTest();
        System.out.print(sample.a);
    }
}