public class ParkingCash {
    private static final int costoVehiculo = 2;
    private long dineroRecaudado;

    public ParkingCash() {
        dineroRecaudado = 0;
    }

    public synchronized void vehiclePay(){
        dineroRecaudado += costoVehiculo;
    }

    public void close() {
        System.out.printf("Closing accounting");
        long totalAmount;
        synchronized (this) {
            totalAmount = dineroRecaudado;
            dineroRecaudado = 0;
        }
        System.out.printf("The total amount is: "+totalAmount);
    }
}
