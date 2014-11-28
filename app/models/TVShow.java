package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Leticia on 11/27/2014.
 */

@Entity(name = "TVShow")
public class TVShow {
    @Id
    @SequenceGenerator(name = "TVShow_SEQUENCE", sequenceName = "TVShow_SEQUENCE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    private List<Season> seasons;

    public TVShow(String name, List<Season> seasons) {
        this.name = name;
        this.seasons = seasons;
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
}
