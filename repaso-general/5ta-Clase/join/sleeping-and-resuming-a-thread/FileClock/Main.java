import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);

        thread.start();
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

/**
 * En el programa anterior (FileSearch) al ejecutar interrupt() el hilo finalizaba.
 * En este programa al ejecutar interrupt() el hilo no termina
 * */

