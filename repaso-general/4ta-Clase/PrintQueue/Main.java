public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue(false);

        //Creates the Threads
        Thread thread[] = new Thread[10];
        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        //Starts the Threads
        for(int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
