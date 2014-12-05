package controllers;

import models.Episode;
import models.TVShow;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.Transactional;
import play.mvc.*;

import java.util.LinkedList;
import java.util.List;

public class Application extends Controller {

    static GenericDAO dao = new GenericDAOImpl();

    @Transactional
    public static Result index() {
        List<TVShow> tvShows = dao.findAllByClassName(TVShow.class.getName());
        List<TVShow> watching = new LinkedList<TVShow>();
        List<TVShow> watched = new LinkedList<TVShow>();
        List<TVShow> unWatched = new LinkedList<TVShow>();
        for (TVShow show: tvShows) {
            if(!show.isFollowing()) {
                unWatched.add(show);
            } else if (show.isFollowing()) {
                watching.add(show);
            } else {
                watched.add(show);
            }
        }
        return ok(views.html.index.render(unWatched, watching, watched));
    }

    @Transactional
    public static Result watch(long id) {
        TVShow tvShow = dao.findByEntityId(TVShow.class, id);
        tvShow.setFollowing(true);
        dao.merge(tvShow);
        dao.flush();
        return redirect(routes.Application.index());
    }

    @Transactional
    public static Result watchEpisode(long id) {
        Episode episode = dao.findByEntityId(Episode.class, id);
        episode.setWatched(true);
        dao.merge(episode);
        dao.flush();
        return redirect(routes.Application.index());
    }

}
