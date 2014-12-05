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

    @Column
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    private Episode nextEpisode;

    @ManyToOne(cascade = CascadeType.ALL)
    private TVShow tvShow;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="EPISODES")
    private List<Episode> episodes;

    public Season(int number, TVShow tvShow) {
        this.number = number;
        this.tvShow = tvShow;
        episodes = new LinkedList<Episode>();
        status = 0;
    }

    public Season() {
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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
        episodes.add(episode);
    }

    public void setStatus() {
        boolean areAllWatched = true;
        boolean isOneWatched = false;
        for(int i = 0; i < episodes.size(); i++) {
            if(episodes.get(i).isWatched()) {
                isOneWatched = true;
            }
            if(!episodes.get(i).isWatched()) {
                areAllWatched = false;
            }
        }
        if(areAllWatched) {
            status = 2;
        } else if(isOneWatched){
            status = 1;
        } else {
            status = 0;
        }
    }

    public int getStatus() {
        setStatus();
        return status;
    }

    public void setNextEpisode(Episode lastEpisode) {
        for(int i = 0; i < episodes.size()-1; i++) {
            if(lastEpisode.equals(episodes.get(i))) {
                nextEpisode = episodes.get(i+1);
            }
        }
    }

    public Episode getNextEpisode() {
        if (nextEpisode == null) {
            return episodes.get(0);
        } else {
            return nextEpisode;
        }
    }
}
