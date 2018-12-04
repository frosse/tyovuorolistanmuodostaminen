package tyovuorolistanmuodostaminen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

    // Helpotetaan tietorakenteen luomista
    final String[] days = { "ma", "ti", "ke", "to", "pe", "la", "su" };

    // Työvuorojen lista
    JobList joblist;

    // Työntekijät
    ArrayList<Worker> workers;

    // Varsinainen tietorakenne
    // Arraylist = viikot
    // Hashmap = päivät
    // HashSet = työntekijät
    ArrayList<HashMap<String, HashSet<Worker>>> allData = new ArrayList<>();

    boolean print = false;

    public void setWorkingHours() {

        for (int i = 0; i < 3; i++) {
            HashMap<String, HashSet<Worker>> dataSet = new HashMap<>();
            for (String s : days) {
                dataSet.put(s, new HashSet<Worker>());
            }
            allData.add(dataSet);
        }
    }

    public void findSolution() throws IOException {
        joblist = new JobList();
        workers = new ArrayList<>();

        // Sekoitetaan työt, jotta saadaan vaihtelua iteraatioihin
        Collections.shuffle(joblist.jobs);
        for(Job job: joblist.jobs) {

            boolean found = false;
            while( !found ) {
                // Järjestetään työntekijät tapahtuu työajan mukaan
                Collections.sort(workers);
                for (Worker worker : workers) {
                    if(!worker.isWorkTimeCapped(job.duration) && !worker.isHolidaysOverLimit()) {

                        if ( allData.get ( job.week-1 ).get ( job.day ).add ( worker ) ) {

                            worker.addWorkTime ( job.duration );
                            found = true;
                            break;
                        }
                    }
                }
                if(!found) {workers.add(new Worker()); }
            }
        }

        if ( print || workers.size() < 77) { printWorkers(); }

        System.out.println("Workers needed: "+ workers.size());
        System.out.println("");
    }

    public void printWorkers() {
        for (Worker w : workers) {
            System.out.println(w);
        }
    }

    public void printIfErrors() {
        for (Worker w : workers) {
            if (w.workTime > 7020 || w.workDays > 16) {
                System.out.println(w);
            }
        }
    }

    public void setPrint(boolean print) {
        this.print = print;
    }
}
