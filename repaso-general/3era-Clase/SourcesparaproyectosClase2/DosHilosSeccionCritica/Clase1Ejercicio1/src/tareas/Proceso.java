package tareas;

public class Proceso {

    T1 tarea1 = new T1();
    Thread t1 = new Thread(tarea1);
    t1.start();

    T2 tarea2 = new T2();
    Thread t2 = new Thread(tarea2);
    t2.start();

}
