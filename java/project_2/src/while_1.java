public class while_1 {
    public static void main(String[] args) {
        // 특정 조건에 도달할때까지 반복해서 수행
        int treehit = 0;
        while (treehit < 10) {
          treehit++;
          System.out.println("나무를" + treehit + "번 찍었습니다");
          if (treehit == 10) {
              System.out.print("나무가 쓰러집니다");
          }
        }
    }
}
