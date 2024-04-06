public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.println("Balance inicial de la cuenta: " + account.getBalance());
        companyThread.start();
        bankThread.start();

        try{
            companyThread.join(); //El método join() sirve para esperar a que termine la ejecución del hilo company en este caso. Es decir, le dice al hilo main que espere a que termine este hilo.
            bankThread.join(); //Acá lo mismo pero espera a que termine el hilo de Bank
            System.out.println("Balance final de la cuenta: " + account.getBalance());
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}