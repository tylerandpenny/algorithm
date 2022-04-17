package Exam.nonghang;

public class T1 implements Runnable {
    public static void main(String[] args) {
        new T1();
    }

    public T1() {
        T1 task = new T1();
        new Thread(task).start();
    }

    @Override
    public void run() {
        System.out.println("test");
    }
}
