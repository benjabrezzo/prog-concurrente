import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable{

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++){
            Date d = new Date();
            System.out.printf("\n"+d);
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e){
                System.out.printf("\nThe FileClock has been interrupted");
                //return;
            }
        }
    }
}


/**
 *  Si no usamos el return en la línea 15, se lanzará la excepción (automáticamente porque estamos interrumpiendo un
 *  hilo en estado de DORMIDO) pero el for continuará, entonces mostrará el mensaje de interrumpido y continuará ejecutando
 *  el for.
 *  No es buena práctica "catchear" y no hacer nada. Hacer algo sería poner el return.
 *
 *  IMPORTANTE: Relación de try-catch + sleep() dentro del catch con el gráfico que muestra los estados de los hilos
 *  1. Cuando se hace el sleep() dentro del try el hilo pasa al estado de sleeping.
 *  2. Cuando se hace el interrupt() el hilo (que estaba dormido) pasa al estado Ready-to-Run.
 *  3. Cuando la JVM lo decida pasa al estado de Runnig y ejecutará lo que está en el catch.
 *
 * */
