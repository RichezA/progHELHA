package IntroThreads;

public class TestThread {
    long j = 0;

    public TestThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for(int i = 0; i < 1000000L; i++) {
                incJ();
                System.out.println("Dans le thread = " + j);
            }
            System.out.println("Après boucle 1");
        });
        thread.start();

        for(int i = 0; i < 1000000L; i++) {
            incJ();
            System.out.println("Dans le main : " + j);
        }
        System.out.println("Après boucle 2");
        thread.join();
        System.out.println("J : " + j);

    }

    synchronized private void incJ() {
        j++;
    }


    public static void main(String[] args) throws InterruptedException {
        new TestThread();
    }
}
