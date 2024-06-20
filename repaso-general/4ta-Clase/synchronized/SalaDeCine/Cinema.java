public class Cinema {
    /** Estas dos varaibles almacenan los lugares disponibles del cine */
    private long vacanciesCinema1;
    private long vacanciesCinema2;


    /** Dos objetos para la sincrionización. */
    private final Object controlCinema1, controlCinema2;

    public Cinema(){
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    public boolean sellTicket1(int number) {
        synchronized (controlCinema1) {
            if(number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTicket2(int number) {
        synchronized (controlCinema2) {
            if(number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTicket1(int number) {
        synchronized (controlCinema1) {
            if(number < vacanciesCinema1) {
                vacanciesCinema1 += number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTicket2(int number) {
        synchronized (controlCinema2) {
            if(number < vacanciesCinema2) {
                vacanciesCinema2 += number;
                return true;
            } else {
                return false;
            }
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }

}
