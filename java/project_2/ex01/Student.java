package ex01;
// 같은 폴더에서 자유롭게 외부 클래스를 호출할 수 있습니다
// 그래서, 폴더이름과 구조가 엄격히 유지됩니다
// package로 하위 폴더 이름이 관리되는데요,
// 이전부터 말씀드리지만 자바는 프로젝트 단위로 파일이 관리되기 때문에
// 개별 파일을 다른 프로젝트에 옮겨오는 것이 점점 까다로워 집니다.
public class Student {
    // 객체변수 선언
    String studentName;
    String studentMajor;
    String studentMobile;
    // 기본생성자: 클래스로 객체를 만들때, 반드시 실행되는 구문
    public Student() {
        System.out.println("기본생성자입니다");
    }
    public Student(String studentName) {
        System.out.println("studentName입니다");
        System.out.println(studentName);
    }
    public Student(String studentName, String studentMajor) {
        System.out.println("studentName, studentMajor입니다");
        System.out.println(studentName + " " + studentMajor);
    }
    public Student(String studentName, String studentMajor, String studentMobile) {
        System.out.println("studentName, studentMajor, studentMobile입니다");
        System.out.println(studentName + " " + studentMajor + " " + studentMobile);
    }
}