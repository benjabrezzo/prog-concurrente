public class ParkingStats {

    private long numberCars;
    private long numberMotorcycles;

    /**
     * Dos objetos para la sincronización. Estos serán los locks.
     * ControlCars sincroniza el acceso al atributo numberCars, y controlMotorcycles sincroniza el acceso al atributo numberMotorcycles
     * */
    private final Object controlCars, controlMotorcycles;
    private ParkingCash cash;

    /**
     * Contructor of the class
     * */

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        controlCars = new Object();
        controlMotorcycles = new Object();
        this.cash = cash;
    }

    public void carComeIn(){
        synchronized (controlCars) {
            numberCars++;
        }
    }

    public void carGoOut(){
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motorcycleComeIn(){
        synchronized (controlMotorcycles) {
            numberMotorcycles++;
        }
    }

    public void motorcycleGoOut(){
        synchronized (controlMotorcycles) {
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        synchronized (controlCars) {
            return numberCars;
        }
    }

    public long getNumberMotorcycles() {
        synchronized (controlMotorcycles) {
            return numberMotorcycles;
        }
    }
}
