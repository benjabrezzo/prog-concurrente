public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        /** El que se está poniendo a dormir es el hilo Main durante 10 segundos. */
        try{
            Thread.sleep(10000); //10000ms = 10s
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main Thread:\n");
        System.out.printf(Thread.currentThread().getName()+": Status of the Thread: "+Thread.currentThread().getState()+"\n");
        System.out.printf(Thread.currentThread().getName()+": isInterrupted(): "+Thread.currentThread().isInterrupted()+"\n");
        System.out.printf(Thread.currentThread().getName()+": isAlive(): "+Thread.currentThread().isAlive()+"\n");
        System.out.println();
        System.out.printf("PrimeGenerator Thread:\n");
        System.out.printf(task.getName()+": Status of the Thread: "+task.getState()+"\n");
        System.out.printf(task.getName()+": isInterrupted(): "+task.isInterrupted()+"\n");
        System.out.printf(task.getName()+": isAlive(): "+task.isAlive()+"\n");


        task.interrupt();
        try{
            Thread.sleep(10000); //10000ms = 10s
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("PrimeGenerator Thread:\n");
        System.out.printf(task.getName()+": Status of the Thread: "+task.getState()+"\n");
        System.out.printf(task.getName()+": isInterrupted(): "+task.isInterrupted()+"\n");
        System.out.printf(task.getName()+": isAlive(): "+task.isAlive()+"\n");


    }
}
