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
            System.out.printf(Thread.currentThread().getName()+" : "+file.getAbsolutePath());
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

}
