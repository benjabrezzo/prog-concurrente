package tarea;

public class T1 extends Tarea{
    public T1() {}

    @Override
    public void run() {
        while (true){
            Tarea.y1 = Tarea.y2 + 1;

            while((!(Tarea.y2 == 0) && !(Tarea.y1 <= Tarea.y2))) {
                /** Este while se va a ejecutar si Tarea.y2 es DISTINTO de 0 y si Tarea.y1 ES MAYOR que Tarea.y2 */
                //System.out.println("En el while de T1");
            }

            Tarea.critical++;
            Tarea.critical--;
            Tarea.y1 = 0;

            /** Thread.sleep(0) le indica al sistema que el hilo actual debería ceder voluntariamente su tiempo de CPU restante. */
            try{
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(Tarea.critical != 0){
                System.out.println("Valor CRITICAL desde T1 = " + (Tarea.critical));
                System.out.println(("Valor Y1 desde T1 = " + (Tarea.y1)));
                System.out.println(("Valor Y2 desde T1 = " + (Tarea.y2)));
            }

        }
    }
}
