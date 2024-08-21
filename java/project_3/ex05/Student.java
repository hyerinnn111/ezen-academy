package ex05;
public class Student {
    // 객체변수 4개를 선언했습니다. 각 변수에 해당하는 getter, setter기능을 만드시고
    // StudentMain 클래스를 생성 하셔서 각 변수에 접근 및 변수선언을 해보세요
    // 모든 변수를 매개변수로 하는 생성자도 만들어 보세요
    private String studentName;
    private String studentNumber;
    private String studentMajor;
    private String studentMobile;
    // 각 필드의 getter/setter 메서드
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getStudentMajor() {
        return studentMajor;
    }
    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }
    public String getStudentMobile() {
        return studentMobile;
    }
    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Student() { //기본생성자는 이런식으로 생깁니다

    }
    public Student
            (String studentName, String studentNumber,
             String studentMajor, String studentMobile) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
        this.studentMobile = studentMobile;
    }
    // getter의 느낌으로 출력 메서드를 준비한다
    public void print() {
        System.out.print(studentName + studentNumber + studentMajor);
    }
}