package controllers;

import models.TVShow;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

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
            if(show.getStatus() == 0) {
                unWatched.add(show);
            } else if (show.getStatus() == 1) {
                watching.add(show);
            } else {
                watched.add(show);
            }
        }
        return ok(views.html.index.render(unWatched, watching, watched));
    }

}
