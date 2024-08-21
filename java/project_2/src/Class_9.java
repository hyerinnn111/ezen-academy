// 객체를 인풋으로 하는 메서드
public class Class_9 {
    class Updater {
        void update(int count) {
            count++;
        }
    }
    class Counter {
        int count = 0;
    }

    public class Class_9 {
        public static void main(String[] args) {
            Counter mycount = new Counter();
            System.out.println(mycount.count);
            Updater myupdate = new Updater();
            System.out.println(mycount.count);
        }
    }
}
