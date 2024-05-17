public class Calculator implements Runnable{

    @Override
    public void run(){
        long current = 1L;
        long max = 1000L;
        long numPrimes = 0L;

        System.out.printf("Thread "+Thread.currentThread().getName()+": START\n");
        while(current <= max){
            if(isPrime(current)){
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread "+Thread.currentThread().getName()+": END. Number of Primes: "+numPrimes+"\n");
    }

    private boolean isPrime(long number){
        if(number <= 2){
            return true;
        }
        for(long i = 2; i < number; i++){
            if((number % i) == 0){
                return false;
            }
        }
        return true;
    }
}
