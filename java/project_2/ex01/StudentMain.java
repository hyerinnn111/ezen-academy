package ex01;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student();

        student1.studentName = "person1";
        student1.studentMajor = "comp sci";
        student1.studentMobile = "010-0000-0000";
        System.out.println(student1.studentName);
// 생성자 오버로딩에 대한 예시였습니다.
        Student student2 = new Student("123");
        Student student3 = new Student("123", "comp sci");
        Student student4 = new Student("123", "comp sci", "010-0000-0000");
    }
}



