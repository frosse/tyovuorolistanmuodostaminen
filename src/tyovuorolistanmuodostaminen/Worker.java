package tyovuorolistanmuodostaminen;
/*
    Luokka mallintaan työntekijää
 */
public class Worker implements Comparable<Worker> {
    int workHourCap = 7020; // Työtuntien rajoitus kolmessa viikossa minuutteina eli 117 / 60 = 7020
    static int counter = 0;
    int id;
    int workTime;   // Työntekijän työaika minuutteina
    int workDays = 0;

    public Worker(){
        counter++;
        id = counter;
    }

    // Lisätään työaikaa ja samalla lisätään yksi työpäivä
    public void addWorkTime( int time ) {
        workTime += time;
        workDays++;
    }

    // Tarkistetaan onko työntekijällä jo "tarpeeksi" työpäiviä eli 21 - 5
    public boolean isHolidaysOverLimit(){
        return workDays >= 16;
    }

    public boolean isWorkTimeCapped( int duration ) {
        return workTime + duration >= workHourCap;
    }

    @Override
    public String toString() {
        return "Worker "+ id +" has "+ workTime/60 +"hours of work and "+ workDays  +" days of work";
    }

    @Override
    public int compareTo( Worker w ) {

        if ( this.workTime > w.workTime ) { return 1; }
        if ( this.workTime < w.workTime ) { return -1; }
        return 0;
    }
}
