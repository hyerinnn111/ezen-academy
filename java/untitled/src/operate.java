public class operate {
    public static void main(String[] args) {
        int num1 = 10, num2 = 5;
//        System.out.pringln(num1 + num2);
//        System.out.pringln(num1 - num2);
//        System.out.pringln(num1 % num2);
// 증감연산자 ( 반복문에서 값 1씩 올리는 기호 ++)
        // 증감연산자의 위치에 주의. ++가 뒤에 붙으면
        // 코드실행 당시엔 증가값이 반영되지 않는다
        int i = 0;
        System.out.println(i++);
        System.out.println(i);
        // ++가 앞에 붙으면 값 증가 먼저 시킨다
        System.out.println(++i);
        System.out.println(i);
        // 참 거짓을 선언하는 불 자료형입니다
        boolean isSusccess = true;
        boolean isTest = false;
        // 비교하여 참 거짓 조건을 만들 수 있습니다
        int base = 180;
        int height = 185;
        boolean isTall = height > base;
        if (isTall) {
            System.out.println("비교문은 참입니다");
        }
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(true || false);
        System.out.println(!isTall);


    }
}
