

public class eee {
    public static <string> void main(String[] args) {
        // 데이터가 담긴 변수를 선언해 봅시다.
        // 정수형 변수 선언 방식입니다.
        // 다 정수형인데 저장값의 범위가 다릅니다
        byte var1 = 127;
        char var2 = 120;  // 정수를 값에 해당하는 문자로 바꿔줍니다.
        int var3 = 220000000;
        long var4 = 150;
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);

        // 실수 자료형은 float 과 double이 있습니다
        // float은 소수점 7자리까지
        // double은 소수점 15자리까지 지원합니다.
        // float선언할 때 끝에 대문자 F 써서 double과 구분해줘야합니다.
        float xxx = 3.14235F;
        double yyy = 3.15555;

        // 문자열 데이터 타입은 char & String이 있다.
        // 주의할 점은 char는 정수와 문자열을 연결하는 유니코드와 연관이 생긴다.
        // char로 선언한 문자 데이터는 쌍따옴표 올 수 없다
        // 쌍따옴표 내부 데이터의 의미는 순수 문자열 데이터를 뜻하므로
        // 유니코드 컴파일을 막아버리기 때문
        // 반대로 String은 순수 문자열이니까 쌍따옴표로 쓰자
        // String에 홀따옴표를 쓰면 컴파일해야하는 데이터를 주는것이므로 에러난다
        char aaa = 'a';
        String c = "ㅠ";

        // 데이터 타입변환
        // 서로다른 데이터 타입이 만나면 타입 자동변환이 된다.
        // 타입 자동변환은 범위가 작은 타입에서 큰 타입으로 자동으로 됨
        byte bb = 99;
        int intvalue = bb;
    }
}
