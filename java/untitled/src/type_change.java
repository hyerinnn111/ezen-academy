public class type_change {
    public static void main(String[] args) {
        // 정수를 문자로, 그반대로도 데이터 타입변환 방법입니다
        // 정수 123을 문자열 "123" 으로 바꾸려한다면?
        // 정수앞에 빈 문자열을 더해주면 제일 쉽습니다
        // 순수 문자열 데이터니까 쌍따옴표 써야 합니다
        int n = 123;
        String num = "" + n;
        //System.out.print(num);
        // 아래 두 용법은 같은 결과를 만듭니다
        String num1 = String.valueOf(n);
        String num2 = Integer.toString(n);
//        System.out.print(num1);
//        System.out.print(num2);
        // 소수점이 포함된 문자열데이터를 숫자로 변환하려면??
        String num3 = "123.456";
        double d = Double.parseDouble(num3);
//        System.out.print(d);
        // 정수를 실수로 변환하려면??
        int n3 = 123;
        // 자동변환 원칙에 따라 아무일도 안해도 된다 ㅎㅎ
        double d1 = n3;
        //System.out.print(d1);
        // 실수를 정수로 변환하려면?
        double n4 = 123.123123;
        // 변환하려는데이터타입 n5 = (변환하려는데이터타입) n4;
        // 데이터타입 강제변환
        int n5 = (int) n4;
        System.out.print(n5);
        // 문자열 데이터를 정수로 한번에 바꾸려 들면
        // numberFormatException 발생
        String n7 = "123.456";
//        int n6 = Integer.parseInt(n7);
//        System.out.print(n6);
        // NumberFormatException(NumberFormatException.java:67)
        // 지금처럼 문법적 이슈는 드러나지 않는데 작동하지 않는다
        // 문자열은 실수로 바꾸고 나서 정수로 바꿔야함
        double n9 = Double.parseDouble(n7);
        int n10 = (int) n9;
        System.out.print(n10);
    }
}
