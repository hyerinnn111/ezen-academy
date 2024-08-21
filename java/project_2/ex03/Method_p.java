package ex03;

public class Method_p {
    // 매개변수와 리턴값 둘다 없음
    public void method1() {
        System.out.println("method1");
    }
    // 매개변수있음, 리턴값 없음
    public void method1(String param1) {
        System.out.println(param1 + "집에 가고 싶다");
    }

    // 매개변수 없음, 리턴값 있음
    public String method3() {
        System.out.println("부르셨나요??");
        String returnVal = "부르셨나요??";
        return returnVal;
    }
    // 매개변수 리턴값 모두 있음
    public String method4(String param1, int param2) {
        String returnVal = param1 + param2;
        return returnVal;
    }

}
