import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // Se muestra la información de prioridad de los hilos
        System.out.printf("Mímina Prioridad: "+Thread.MIN_PRIORITY+"\n");
        System.out.printf("Prioridad Normal: "+Thread.NORM_PRIORITY+"\n");
        System.out.printf("Máxima Prioridad: "+Thread.MAX_PRIORITY+"\n");

        /** Se crearan 2 arreglos para almacenar los objetos Threads y sus estados*/
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];

        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(new Calculator());
            if(i == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Hilo numero " + i);
        }

        /** Se van a escribir en un archivo el estado de los hilos antes de lanzar su ejecución.*/
        try(FileWriter file = new FileWriter("./log.txt");
            PrintWriter pw = new PrintWriter(file);) {
            for(int i = 0; i < 10; i++){
                pw.println("Main : Status of Thread "+ i + " : "+threads[i].getState());
                status[i] = threads[i].getState();
            }
            pw.println();
            // Start the ten threads
            for(int i = 0; i < 10; i++){
                threads[i].start();
            }

            /** Esperamos a que terminen los 10 hilos. Guardamos el estado de los hilos y solo lo escribmos
             * al log si cambió.*/
            boolean finish = false;
            while(!finish){
                for(int i = 0; i < 10; i++){
                    if(threads[i].getState() != status[i]){
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for(int i = 0; i < 10; i++){
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /** Private methods*/
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main : Id "+thread.getId()+" - "+thread.getName()+"\n");
        pw.printf("Main : Priotity "+thread.getPriority()+"\n");
        pw.printf("Main : Old State "+state+"\n");
        pw.printf("Main : New State "+thread.getState()+"\n");
        pw.println();
    }
}
