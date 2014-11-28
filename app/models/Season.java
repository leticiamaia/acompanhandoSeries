package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Leticia on 11/27/2014.
 */
@Entity(name = "Season")
public class Season {
    @Id
    @SequenceGenerator(name = "EPISODE_SEQUENCE", sequenceName = "EPISODE_SEQUENCE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private int number;
    private List<Episode> espisodes;
    public enum State {
        UNWATCHED,
        WATCHING,
        FINISHED,
    }

    public Season(int number, List<Episode> espisodes) {
        this.number = number;
        this.espisodes = espisodes;
    }

    public Season() {

    }

    public List<Episode> getEspisodes() {
        return espisodes;
    }

    public void setEspisodes(List<Episode> espisodes) {
        this.espisodes = espisodes;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
