package models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leticia on 11/27/2014.
 */
@Entity(name = "Season")
public class Season {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int number;

    @ManyToOne(cascade = CascadeType.ALL)
    private TVShow tvShow;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="EPISODES")
    private List<Episode> espisodes;

    public Season(int number, TVShow tvShow) {
        this.number = number;
        this.tvShow = tvShow;
        espisodes = new LinkedList<Episode>();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
    }

    public void addEpisode(Episode episode) {
        espisodes.add(episode);
    }

}
