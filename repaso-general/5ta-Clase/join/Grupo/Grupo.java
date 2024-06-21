public class Grupo implements Runnable{

    String mensaje;

    public Grupo(String nombre){
        mensaje = "Hola, somos el grupo "+ nombre +" y este es nuestro mensaje número: ";
    }

    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            String msj = mensaje+i;
            System.out.println(msj);
        }
    }

}
