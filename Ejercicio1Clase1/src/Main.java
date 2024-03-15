import tareas.Tarea;

public class Main {
    //Por ahora este condicion no se usa
    static boolean condicion = true;

    //
    public static void main(String[] args) {

        // (1) Se crea una nueva instancia de la clase Tarea, que a su vez crea un objeto Calculator y lo ejecuta en un nuevo hilo
        new Tarea();
    }
}

/* Hilo principal (main): Este hilo se ejecuta cuando inicias tu programa.
   En el método main, se crea una instancia de la clase Tarea y se ejecuta su constructor.
   Dentro del constructor de Tarea, se crea un nuevo objeto Calculator y se inicia un nuevo hilo para ejecutar la tarea definida por este objeto.*/

/* Hilo secundario (creado para el objeto Calculator): Cuando creas una instancia de Thread y le pasas una instancia de Calculator, se crea un nuevo hilo
   que ejecuta la tarea definida por el método run() de Calculator. En este caso, la tarea es imprimir una serie de cálculos de multiplicación en la consola.*/