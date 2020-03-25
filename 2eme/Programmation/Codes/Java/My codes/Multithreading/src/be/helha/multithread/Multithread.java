package be.helha.multithread;

public class Multithread {
    int j;
    Object o;
    public Multithread(){
        j = 0;
        o  = new Object();
    }

    private void Test() {
        Thread thread = new Thread((new Runnable()) {

            @Override
            public void run() {
                for(int i = 0; i < 1000000000; i++){
                    synchronized (Multithread.this) {
                        incJ();
                        System.out.println("Dans le thread: " + j);
                    }
                }
                System.out.println("Après boucle 1");
            }
        });
        //thread.setDaemon(true); // loop 1 ne se finit jamais, elle est kill dès que boucle 2 a fini
        thread.start();
        //synchronized (o){ // sert à rien à part pour dire de mettre un verrou pour faire une petit opération
        for(int i = 0; i < 1000000000; i++){
            synchronized (this){
                incJ();
                System.out.println("Dans le main: " + j);
            }
        }
        System.out.println("Après boucle 2");
        //}

        try {
            thread.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("j:" + j);
    }
    private void ThreadZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz(){
        Runnable runnable = () -> {
            for(int i = 0; i < 100000; i++){
                incJ();
            }
        };
        Thread thread2 = new Thread(()  -> {
            Thread thread3 = new Thread(runnable);
            thread3.start();
            runnable.run();
            try {
                thread3.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        });
            Thread thread1 = new Thread(runnable);
            thread1.start();
            thread2.start();
            runnable.run();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }System.out.println("J: " + j);

    }


    synchronized private void incJ() {
        j++;
    }

    public static void main(String[] args) {
        Multithread m =new Multithread();
        //m.Test();
        m.ThreadZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz();
    }

}
