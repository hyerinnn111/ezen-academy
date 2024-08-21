package ex04;
// private을 선언하면 외부에서 변수 접근이 불가능하다.
// 그래서 해당 클래스 안에 변수의 열람과 편집이 가능한 메서드를 만들어야.
// 이러한 은닉된 변수를 읽는 기능이 getter, 편집하는 기능이 setter입니다
public class Book {
    private String bookTitle;
    private String bookAuthor;

    public void setBookTitle(String bookTitle) { // bookTitle setter
        this.bookTitle = bookTitle;
    }
    public String getBookTitle() { // bookTitle getter
        return bookTitle;
    }
}