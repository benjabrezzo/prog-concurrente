import java.io.File;

public class FileSearch implements Runnable{
    /**
     * fileName es el nombre del archivo que se busca.
     * initPath es el directorio donde se iniciará la búsqueda.
     * */
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        super();
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run(){
        File file = new File(initPath);
        /**
         *  Chequea si el atributo fileName es un directorio. Si lo es llama al método directoryProcess().
         * */
        if(file.isDirectory()){
            try{
                directoryProcess(file);
            } catch (InterruptedException e){
                System.out.printf("La búsqueda ha sido interrumpida "+Thread.currentThread().getName());
            }
        }
    }


    /**
     * Este método se va a llamar desde el run() si y solo si el atributo initPath es un DIRECTORIO VÁLIDO.
     * directoryProcess(File file) lista todos las carpetas y archivos que hay en el directorio definido por initPath.
     * Hay recursión porque si nos encontramos con otra carpeta dentro del directorio de initPath volverá a llamarse a si
     * mismo para revisar los archivos dentro de esta carpeta.
     * */

    private void directoryProcess(File file) throws InterruptedException{
        //Se guardan todos los archivos (y carpetas) dentro de un arreglo.
        File[] list = file.listFiles();
        if(list != null){
            for(int i = 0; i < list.length; i++){
                if(list[i].isDirectory()){ //Si encuentra una carpeta se vuelve a llamar a si mismo para analizarla
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]); //SI NO es una carpeta analiza el archivo con el método fileProcess()
                }
            }
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }

    }

    /**
     * fileProcess(File file) recibe el archivo a "analizar". El análisis consiste en comparar el nombre del archivo con
     * el nombre del archivo buscado, el cual está definido en el atributo fileName.
     * */
    private void fileProcess(File file) throws InterruptedException{
        if(file.getName().equals(fileName)){
            System.out.printf(Thread.currentThread().getName()+" : "+file.getAbsolutePath()+"\n");
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

}

/**
 * IMPORTANTE (tal vez para el coloquio): En el programa PrimeGenerator extendíamos la clase Thread, la cual tiene
 * un método isInterrupted() para saber si el hilo fue interrumpido.
 * Pero en este programa NO ESTAMOS EXTENDIENDO THREAD. Estamos usando Runnable, por ende usamos el método
 * estático de la clase Thread: Thread.interrupted(), que se puede ver en el if de la línea 67.
 * Lo que hace es:
 * 1. Buscar que hilo se está ejecutando.
 * 2. Preguntar si está interrumpido.
 * El método isInterrupted() solo pregunta si está interrumpido, ya que se usa sobre el hilo que está trabajando (o estaba porque se interrumpio).
 * En conclusión, la diferencia es que el método estático hace solo un paso más, el de averiguar que hilo se está ejecutando.
 *
 * Tambien es IMPORTANTE DESTACAR: Que este programa interrumpe a un hilo que está ACTIVO. Mientras que en el próximo
 * programa (FileClock) se interrumpirá a un hilo que estará DORMIDO. Y cuando se interrumpe un hilo dormido se
 * LANZA UNA EXCEPCIÓN automáticamente. Acá (que está activo) tenemos que preguntar con el isInterrupted() y luego
 * lanzar la excepción manualmente.
 *
 * */