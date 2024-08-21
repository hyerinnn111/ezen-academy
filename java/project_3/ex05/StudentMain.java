package ex05;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentName("ezen");
        Student student2 = new Student
                ("ezen2", "202311",
                        "comp sci", "010-1111");
        System.out.println(student2.getStudentMajor());
// 자바는 객체안의 데이터를 직접 확인하기 어렵습니다
        // 그냥 객체를 출력시도하면 클래스위치와 해시값이 보입니다 ex05.Student@119d7047
        System.out.println(student2);
        student2.print();
    }
}
// 데이터 저장 부분은 private 처리하면 외부접근을 차단한다
// 차단된 변수는 getter, setter 등으로 접근한다
// 자바에서 객체는 직접적으로 데이터 확인이 어렵다.
// 데이터 확인이 가능한 메서드를 준비하는게 일반적이다