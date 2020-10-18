package main.java.IP.concurrency;

public class Lazy {
    public static boolean initialized = false;
    public static Thread t = new Thread(() -> initialized = true);


    static {
        t.start();


    }




    public static void main(String[] args){
       System.out.println(initialized);

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
