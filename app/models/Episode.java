package models;

import javax.persistence.*;

/**
 * Created by Leticia on 11/27/2014.
 */
@Entity(name = "Episode")
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int number;
    @Column
    private boolean watched;

    @ManyToOne(cascade = CascadeType.ALL)
    private Season season;


    public Episode(String name, int number, Season season) {
        this.name = name;
        this.number = number;
        this.season = season;
        this.watched = false;
    }

    public Episode() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeason(Season season) {
        this.season = season;
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

    public Long getId() {
        return id;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        season.setNextEpisode(this);
        this.watched = watched;
        season.setStatus();
    }

    public Season getSeason() {
        return season;
    }

}
