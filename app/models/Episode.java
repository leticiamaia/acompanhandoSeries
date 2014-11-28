package models;

import javax.persistence.*;

/**
 * Created by Leticia on 11/27/2014.
 */
@Entity(name = "Episode")
public class Episode {
    @Id
    @SequenceGenerator(name = "EPISODE_SEQUENCE", sequenceName = "EPISODE_SEQUENCE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private int number;
    public enum State {
        UNWATCHED,
        WATCHING,
        FINISHED,
    }

    public Episode(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Episode() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
