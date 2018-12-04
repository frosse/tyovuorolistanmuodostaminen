package tyovuorolistanmuodostaminen;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobList {

    ArrayList<Job> jobs = new ArrayList<>();


    // Luetaan tiedostosta joka rivi ArrayListiin
    // Käydään ArrayList läpi ja jokaisesta rivistä tehdään Job-luokan ilmentymä
    public JobList() throws IOException{

        Stream<String> stream = Files.lines(Paths.get("./src/tyovuorolistanmuodostaminen/Tyot.txt"));
        ArrayList<String> data = stream.collect(Collectors.toCollection( ArrayList::new));

        for ( String line:data ) {

            jobs.add( new Job( line ));
        }
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }
}
