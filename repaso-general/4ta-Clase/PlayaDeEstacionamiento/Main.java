public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);

        System.out.println("Parking Simulator");
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int numberSensor = 2 * availableProcessors;

        System.out.println("Number of sensors: " + numberSensor);

        Thread[] threads = new Thread[numberSensor];
        for(int i = 0; i < numberSensor; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for(int i = 0; i < numberSensor; i++) {
            try{
                threads[i].join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: "+stats.getNumberCars()+"\n");
        System.out.printf("Number of motorcycles: "+stats.getNumberMotorcycles()+"\n");
        cash.close();
    }
}
