package ex02;

// 다른폴더에 있는 클래스도 import구문으로 위치를 명시함으로써 자유롭게 쓸 수 있다.
// 자바스크립트처럼 "../ex01/Student" 폴더 상대경로를 쓰지않고 src메인 기준 절대위치를 가리킴
import ex01.Student;

public class StudentMain {
    public static void main(String[] args) {
        // 서로다른 위치에 있는 클래스 사용법
        Student student1 = new Student();
        ex02.Student student2 = new ex02.Student(studentName:"ppp", studentMajor:"kkk", student)
        System.out.println(student2.studentName);;
    }
}
