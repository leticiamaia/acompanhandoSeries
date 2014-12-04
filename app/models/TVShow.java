package models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leticia on 11/27/2014.
 */

@Entity(name = "TVShow")
public class TVShow {
   @Id
   @GeneratedValue
    private Long id;

    @Column
    private String name;

    @JoinColumn(name="SEASON")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Season> seasons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column
    private int status;

    public TVShow(String name) {
        this.name = name;
        seasons = new LinkedList<Season>();
        status = 0;
    }


    public TVShow() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }
}
