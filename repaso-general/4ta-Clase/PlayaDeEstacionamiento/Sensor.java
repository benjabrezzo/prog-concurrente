import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable {

    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            // Entran dos autos
            stats.carComeIn();
            stats.carComeIn();
            // Espera 50 milisegundo
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Entra una moto
            stats.motorcycleComeIn();
            // Espera otros 50 milisegundo
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Se van la moto y los dos autos
            stats.carGoOut();
            stats.carGoOut();
            stats.motorcycleGoOut();
        }
    }
}
