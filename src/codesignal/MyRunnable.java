package codesignal;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i+" ");
        }
    }
}

