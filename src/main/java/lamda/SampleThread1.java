package main.java.lamda;

public class SampleThread1 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.println("another Thread")


        );

        t1.start();


        System.out.println("Main Thread");


    }
}
