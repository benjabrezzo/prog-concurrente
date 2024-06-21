import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader, "Data Source Thread");

        NetworkConnectionsLoader ntLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ntLoader, "Network Connection Thread");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            //thread2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: "+new Date()+"\n");
    }
}
