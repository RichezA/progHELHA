package IntroThreads;

public class Exo1_4Threads {

    long j = 0;
    public Exo1_4Threads() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < 10000000; i++) {
                    Exo1_4Threads.this.incJ();
                }
            }
        };
        Thread thread1 = new Thread(() -> {
            Thread thread1_1 = new Thread(runnable);
            thread1_1.start();
            runnable.run();
            try {
                thread1_1.join();
            } catch (InterruptedException e) {
            }
        });
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        runnable.run();

        thread1.join();
        thread2.join();

        System.out.println("J : " + j);
    }

    synchronized private void incJ() {
        j++;
    }

    public static void main(String[] args) throws InterruptedException {
        new Exo1_4Threads();
    }
}
