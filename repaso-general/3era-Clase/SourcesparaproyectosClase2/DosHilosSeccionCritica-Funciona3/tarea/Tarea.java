package tarea;

//Clase Abstracta, NO se va a instanciar. Es una clase padre, sus hijos serán T1 y T2
public abstract class Tarea implements Runnable{
    protected static int y1 = 0, y2 = 0;
    protected static int critical = 0;

    /** Atributos protected y static, osea que si se modifica por T1 o T2 se verá reflejado en todas las clases
        el cambio. Y protected quiere decir que solo T1 y T2 pueden acceder a ellos, y cualquier otra clase que herede de esta. */

    /** Al ser esta una clase abstracta SIN MÉTODOS no hay que implementar ningún método en las clases hijas. Pero implementa la interfaz Runnable,
        osea que vamos a tener que sobreescribir el método run() en las clases hijas.*/
}
