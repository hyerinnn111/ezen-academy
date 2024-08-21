public class while_3 {
    public static void main(String[] args) {
        // random() 을 이용해서 1~6이 나오는 주사위를 만들고
        // while을 써서 주사위를 계속 던지는데 6이 나오면 코드를 종료하게 해주세요
        boolean run = true;
        while (run) {
            int num = (int)(Math.random() * 6) + 1;
            System.out.println("num = " + num);
            if (num == 6) {
                run = false;
            }
        }
    }
}
