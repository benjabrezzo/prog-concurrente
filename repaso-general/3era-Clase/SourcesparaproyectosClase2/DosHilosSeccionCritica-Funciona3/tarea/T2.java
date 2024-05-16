package tarea;

public class T2 extends Tarea{

    public T2() {}

    @Override
    public void run(){
        while(true){
            Tarea.y2 = Tarea.y1 + 1;

            while((!(Tarea.y1 == 0) && !(Tarea.y2 <= Tarea.y1))){
                /** Este while se va a ejecutar si Tarea.y1 es DIFERENTE de 0 y si Tarea.y2 es MAYOR que Tarea.y1
                    Es opuesto al while en T1. */
                //System.out.println("En el while de T2");
            }

            Tarea.critical++;
            try{
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Tarea.critical--;
            Tarea.y2 = 0;

            if(Tarea.critical != 0){
                System.out.println("Valor CRITICAL desde T2  = " + (Tarea.critical));
                System.out.println("Valor Y1 desde T2 = " + (Tarea.y1));
                System.out.println("Valor Y2 desde T2 = " + (Tarea.y2));
            }

        }
    }

}
