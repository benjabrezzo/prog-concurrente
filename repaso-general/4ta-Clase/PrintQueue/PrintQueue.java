import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Lock queueLock;

    public PrintQueue() {
        queueLock = new ReentrantLock();
    }

    /** Cuando fairMode es True garantiza que los hilos obtendrán el bloqueo en el orden que lo solicitaron (FIFO - First In First Out)
     *  esto es útil para evitar la inanición (starvation) de hilos.
     *  Cuando es False, el bloqueo no es justo y puede ser adquirido por cualquier hilo de manera no determinística.*/

    public PrintQueue(boolean fairMode) {
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object document) {
        queueLock.lock();
        try{
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintingQueue: Printing a Job durring "+(duration / 1000) + " seconds\n");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
