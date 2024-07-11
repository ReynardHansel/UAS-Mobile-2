// Thread class
class SimpleThread extends Thread {

    private String thread_name;

    SimpleThread(String thread_name) {
        this.thread_name = thread_name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            //* Biar si code nya jadi synchronous
            synchronized (this) {
                System.out.println(thread_name + " iteration: " + i);
            }

            try {
                //* Sleep utk simulasi thread yg sedang jalan
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Something wrong, si thread nya kena interruption (di Simple Thread)");
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class no2_thread {
    public static void main(String[] args) {
        SimpleThread contoh_thread_1 = new SimpleThread("Thread 1");
        SimpleThread contoh_thread_2 = new SimpleThread("Thread 2");

        contoh_thread_1.start();
        contoh_thread_2.start();
    }
}