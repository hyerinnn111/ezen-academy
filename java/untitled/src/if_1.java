import java.util.ArrayList;

public class if_1 {
    public static void main(String[] args) {
        // 자바스크립트와 조건문 문법은 상당히 유사하다
        boolean money = true;
        int money2 = 2000;
        boolean creditcard = true;
        if (!(money2 > 3000 || creditcard)) {
            System.out.print("택시타자");
        }
        else {
            System.out.print("걸어가자");
        }
        // 숫자 비교말고 데이터 셋 안에 특정 데이터 유무로 참거짓 되는지???
        // pocket이란 리스트 변수를 선언한다. 변수안의 데이터는 문자열이다
        ArrayList<String> pocket = new ArrayList<>();
        // paper, money 문자열 데이터 추가함
        pocket.add("paper");
        pocket.add("money");
        // pocket 리스트 변수가 money를 포함한다면
        if (pocket.contains("money")) {
            System.out.print("모범타자");
        }
        else {
            System.out.print("인천시 따릉이");
        }
    }
}
