package tyovuorolistanmuodostaminen;

public class Job {
    int id;
    String day;
    int week;
    char identifier;
    int duration;
    String start;
    String end;

    // Oletetaan, että konstruktorissa tulee aina tarvittava data
    public Job(String line) {
        String s[] = line.split("\t");
        this.id = Integer.parseInt(s[0]);
        this.day = s[1].substring(0,2);
        this.week = Integer.parseInt(s[1].substring(2,3));
        this.identifier = s[2].toCharArray()[0];
        this.duration = Integer.parseInt(s[3]);
        this.start = s[4];
        this.end = s[5];
    }
}
