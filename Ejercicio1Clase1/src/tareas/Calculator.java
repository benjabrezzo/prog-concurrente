package tareas;

public class Calculator implements Runnable{
    private int number;

    // (4) Esta clase implementa la interfaz 'Runnable', lo que significa que puede ser ejecutada por un hilo al mismo tiempo que se ejecuta la clase Main.
    // Ahora como está hecho el programa no pasa nada más en Main más que instanciar el objeto de Tarea, pero si pasara algo más ocurriria al mismo tiempo que
    // lo que está ocurriendo acá gracias a la interfaz Runnable.
    // ACLARACIÓN: El objeto de Calculator se instancia por el hilo principal que es donde ocurre t0do lo de Main, lo que se esta ejecutando en un hilo
    // secundario (gracias a Runnable) es el método run() de aca abajo.

    public Calculator(int number){
        super();
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }
}
