import task.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        //Se imprime por pantalla info de la prioridades:
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        // Se crean 10 hilos para ejecutar los 10 objetos de Calculator. Se crean dos arreglos para almacenar los
        // objetos Threads y sus estados.
        // Se setea el atributo prioridad de los hilos pares en máximo y los impares en mínimo

        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        // Se escribe en un archivo el estado de los hilos antes de lanzar su ejecución, luego se lanzan los hilos
        try (FileWriter file = new FileWriter("./data/log.txt"); PrintWriter pw = new PrintWriter(file);){

            //Escribimos el estado de los hilos
            for(int i = 0; i < 10; i++){
                pw.println("Main: Status of Thread "+ i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            // Iniciamos (start) los 10 hilos
            for(int i = 0; i <10; i++){
                threads[i].run();
            }

            boolean finish = false;
            while(!finish){
                for(int i = 0; i < 10; i++){
                    if(threads[i].getState() != status[i]){
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }

                finish = true;
                for(int i = 0; i< 10; i++){
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.threadId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : **************************************\n");
        pw.flush();
    }


}