package ex04;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookTitle("책제목1");
        // System.out.print(book.bookTitle);
        // private 적용된 변수는 getter메서드를 실행시킨 후 확인 가능하다.
        String title = book.getBookTitle();
        System.out.print(title);
    }
}