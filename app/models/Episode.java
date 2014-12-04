package models;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Season season;

   /* @ManyToOne(cascade = CascadeType.ALL)
    private TVShow tvShow;*/

    public Episode(String name, int number, Season season, TVShow tvShow) {
        this.name = name;
        this.number = number;
        this.season = season;
       // this.tvShow = tvShow;
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
}
