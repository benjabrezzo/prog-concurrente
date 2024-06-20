import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        FileSearch buscador = new FileSearch("","");
        Thread hilo = new Thread(buscador);

        hilo.start();

        try{
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        hilo.interrupt();
    }
}
