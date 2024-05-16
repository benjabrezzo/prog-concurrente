public class Main{
    public static void main(String[] args) {
        // Para medir el tiempo de ejecución del programa utilizo la clase System:
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
            try{
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            //calculator.multiplicar();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }
}

/* Lo que ocurre en main es que se van a crear 10 objetos de la clase Calculadora y 10 objetos de la clase hilo. A cada hilo
*  se le pasa como argumento un objeto de la clase calculadora (pues esta implementa la interfaz Runnable).
*  Lo que se ejecutará el run() dentro de la clase de calculadora que lo que hace es imprimir el nombre del hilo y multiplicar el número que se pasó
*  como argumento por los valores de 1 hasta 10.
*  Es decir, se van a crear 10 calculadores, esto definido por el i del for. Osea que a la primera calculadora creada se le va a pasar el número 1,
*  a la segunda el número 2 y así hasta la última (osea la décima) con el número 10.
*  Luego la primera calculadora (que se le paso el valor de i = 1) imprimira el nommbre del hilo más 1*1, luego 1*2 y así hasta 1*10.
*  La última calculadora (osea la décima) imprimirá el nombre del hilo y 10*1, luego 10*2 y así hasta 10*10.
* */

/**
 * El programa CON concurrencia tarda aproximadamente 18ms*/
/**El programa SIN concurrencia tarda aproximadamente 13ms*/