package tareas;

public class Tarea {

    public Tarea() {
        System.out.printf("Estoy en el constructor tarea en el hilo: %s\n", // Este system out va en el hilo principal (main)
                Thread.currentThread().getName());

        // (2) Se crea una instancia de Calculator con un valor de número específico, Calculator implementa la interfaz Runnable
        Calculator calc = new Calculator(4);
        // (3) Luego inicia un nuevo hilo (Thread) con el objeto de Calculator calc, es decir, con el objeto que implementa Runnable
        Thread h1 = new Thread(calc); // Hasta aca t0do en el hilo principal
     //   h1.start();
        h1.run();
    }

    // El método start() es parte de la clase Thread, se encarga de iniciar un nuevo hilo, reservar recursos del sistema y ejecutar el método run() en este nuevo hilo.

    // h1.run(): Este método simplemente llama al método run() en el mismo hilo desde el que se llama (el hilo principal). No inicia un nuevo hilo. Por lo tanto,
    // el método run() se ejecutará en el mismo hilo que llama al método. En este caso implementar la interfaz Runnable es al pedo. No es concurrencia.


}
