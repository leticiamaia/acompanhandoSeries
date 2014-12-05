import models.Episode;
import models.Season;
import models.TVShow;
import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Leticia on 12/5/2014.
 */
public class ModelsTest {
    TVShow show;
    Season season;
    Episode episode;
    Episode episode1;
    Season season2;

    @Before
    public void setUp() {
        show = new TVShow("Show");
        season = new Season(1, show);
        episode = new Episode("Episode",1,season);
        episode1 = new Episode("Episode1",1,season);
        season2 = new Season(2, show);
        season.addEpisode(episode);
        season.addEpisode(episode1);
        show.addSeason(season);
        show.addSeason(season2);
    }

    @Test
    public void shouldWatchEpisode() {
        assertThat(season.getStatus()).isEqualTo(0);
        episode.setWatched(true);
        assertThat(episode.isWatched()).isEqualTo(true);
        //season -> watching
        assertThat(season.getStatus()).isEqualTo(1);;
    }

    @Test
    public void shouldWatchEntireSeason(){
        assertThat(season.getStatus()).isEqualTo(0);
        episode.setWatched(true);
        episode1.setWatched(true);
        assertThat(episode.isWatched()).isEqualTo(true);
        //season -> watched
        assertThat(season.getStatus()).isEqualTo(2);
    }

    @Test
    public void shouldCalculateNextEpisodeOfSeason() {
        assertThat(season.getNextEpisode()).isEqualTo(episode);
        season.setNextEpisode(episode);
        assertThat(season.getNextEpisode()).isEqualTo(episode1);
    }

}
