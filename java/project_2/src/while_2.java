public class while_2 {
    public static void main(String[] args) {
        // while로 1부터 10까지 합계를 출력
        // while문은 무한루프의 소지가 있으니 사용에 유의하여 주시기 바랍니다
        int i = 1, sum =0;
        while(i <=10) {
            sum += i;
            //i++; //이거 안써주면 i값이 증가하지 않아 무한히 1을 더합니다
            System.out.print(sum);
        }

    }
}
