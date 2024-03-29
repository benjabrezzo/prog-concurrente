package tareas;

public class T1 extends Tarea{
    public T1() {

    }

    @Override
    public void run() {
        while(true){
            Tarea.y1 = Tarea.y2 + 1;

            Tarea.cantidad += 1;

            while(!(Tarea.y2 == 0) && !(Tarea.y1 <= Tarea.y2)){
                // !(Tarea.y2 == 0) verifica si la variable y2 es diferente de 0.
                // !(Tarea.y1 <= Tarea.y2) verifica si y1 es mayor que y2

                //try {
                //    Thread.sleep(0);
                //} catch (InterruptedException e){
                //    e.printStackTrace();
                //}
            }

            Tarea.critical++;
            //try{
            //    Thread.sleep(0);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            Tarea.critical--;

            Tarea.y1 = 0;

            if(Tarea.critical != 0){
                System.out.println("--------Valor CRITICAL desde T1 = " + (Tarea.critical));
                System.out.println("--------Valor Y1 desde T1 = "+ (Tarea.y1));
                System.out.println("--------Valor Y2 desde T1 = "+ (Tarea.y2));
                System.out.println("Cantidad: "+(Tarea.cantidad));
            }

        }
    }
}
