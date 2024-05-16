public class Calculator implements Runnable{

    private int number;

    public Calculator(int number){
        super();
        this.number = number;
    }

    //Implementamos el método run(). Este método ejecutará las instrucciones de los threads que estamos creando.
    public void run(){

        for(int i = 0; i < 10; i++){
            System.out.printf(""+Thread.currentThread().getName()+": "+number+" * "+i+" = "+i*number+"\n");
        }
    }

    public void multiplicar(){
        for(int i = 0; i < 10; i++){
            System.out.println("El (falso) hilo-"+number+": "+number+" * "+i+" = "+number*i);
        }
    }


}