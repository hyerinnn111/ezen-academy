// 문자열 관련 내장기능 소개입니다
    public class String7 {
    public static void main(String[] args) {
        java.lang.String a = "hello";
        java.lang.String b = "java";
        String c = new String("hello");
// equals는 문자열2개를 비교하는 명령어입니다
//System.out.print(a.equals(b));
// a와 c의 내용은 같은데 c는 새로운 객체로 선언되어서 주소가 다르다
        System.out.print(a == c);
        System.out.print(a.equals(c));
// ==은 메모리 주소를 비교하고 equals는 데이터 내용을 비교한다
// 기본 데이터는 값이 같으면 메모리 주소가 같아서 문제가 없는데
// 새로운 객체를 생성하면 메모리주소가 달라진다
        String d = "hello java";
// indexOf는 특정문자열이 시작되는 위치를 리턴한다.
// 7번째부터 java가 시작되므로 0부터 수를 세니까 6이 출력된다
        System.out.print(d.indexOf("java"));
// contains는 문자열 안에 특정 문자열이 있는지 참 거짓으로 나타낸다
        System.out.print(d.contains("java"));
// substring(0,4)은 처음부터 4글자만을 뽑아낸다
        System.out.print(d.substring(0,4));

// 문자열 포매팅
// 문자열 데이터를 변수 처리해서 다른값을 포함할 수 있습니다
        System.out.print(String.format("사과를 %d개 먹었습니다", 4));

        System.out.print(String.format(
                "사과를 %d개 먹고 휴가를 %d일 다녀왔습니다", 4, 12));
        int number = 5;
        String day = "나흘";
        System.out.print(String.format(
                "사과를 %d개 먹고 휴가를 %s 다녀왔습니다", number, day));
// %d: 정수   %s:문자열  %f: 실수  %c: 문자 1글자
    }
}
