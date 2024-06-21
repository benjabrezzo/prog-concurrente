import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Cada hilo representará un grupo:
        Thread teapots = new Thread(new Grupo("Teapots"));
        Thread venThread = new Thread(new Grupo("venThread"));
        Thread giA = new Thread(new Grupo("giA"));

        teapots.start();
        //teapots.join();

        /**
         *  La ejecución posterior al primer join() no va a continuar hasta que el hilo teapots termine.
         *  Ese es el funcionamiento básico de join().
         * */


        venThread.start();
        //venThread.join();

        giA.start();
        //giA.join();

        teapots.join();
        venThread.join();
        giA.join();

        System.out.printf("Main: Se finalizó la impresión de mensajes "+new Date()+"\n");
    }
}
