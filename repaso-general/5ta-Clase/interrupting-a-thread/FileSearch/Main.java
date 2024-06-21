import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        /**
         *  Cuando estabas haciendo este programa te entró la duda: Solo se está creando UN HILO, entonces, ¿hay concurrencia?
         *  La respuesta es si. Porque en realidad hay dos hilos, el Main (acá) y el que está buscando el archivo.
         *  Es una concurrencia zonza (?) pero al fin y al cabo es concurrencia.
         * */


        FileSearch buscador = new FileSearch("/home/benja/Documentos","log6.txt");
        Thread hilo = new Thread(buscador);

        hilo.start();
        //hilo.run();
        /**
         *  ¿Qué pasa si usamos hilo.run()?
         *  En este caso no estamos "comenzando" (start) ningún hilo nuevo. Sino que el hilo Main se encarga de todo.
         *  Por lo tanto pasa a ser una cosa secuencial. No hay concurrencia.
         * */

        try{
            // Lo tuve que pasar a milisegundos porque sino no se llegaba a ver la interrupción. Mejor dicho, nunca se interrumpía.
            Thread.sleep(10);
            //TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        hilo.interrupt();
        System.out.println("\nMain end");
    }
}
