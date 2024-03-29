package tareas;

// Tarea va a ser una clase ABSTRACTA osea que va a implmentar de forma parcial el comportamiento definido por la interfaz Runnable
// T1 y T2 extienden esta clase Tarea, ellos se van a encargar de implementar el método run()

public abstract class Tarea implements Runnable{
    protected static int y1 = 0, y2 = 0;
    protected static int critical = 0;
    protected static int cantidad = 0;
}

// protected quiere decir que las variables pueden ser accedidas por las clases dentro del mismo paquete (en este caso el paquete tareas) y por
// las subclases (independientemente del paquete donde se encuentren).

// static indica que las variables son compartidas por todas las instancias de la clase, y pueden ser accedidas utilizando el nombre de la clase
// en lugar de una instancia específica de la clase. Osea que la variable existe en un ámbito estático y su valor es el mismo para todas
// las instancias de la clase.
