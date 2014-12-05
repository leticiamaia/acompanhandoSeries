package models;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.Play;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leticia on 12/1/2014.
 */
public class FileHandler {

    public static void read() {
        String csvFile = Play.application().getFile("/app/assets/seriesFinalFile.csv").getAbsolutePath();
        BufferedReader reader = null;
        String line = "";
        String splitBy = ",";
        try {
            reader = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            populateDatabase(reader, splitBy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void populateDatabase(BufferedReader reader, String splitBy) throws IOException {
        GenericDAO dao = new GenericDAOImpl();
        String line = reader.readLine();
        String[] args = line.split(splitBy);
        String tvShowName = args[0];
        int seasonNumber = Integer.parseInt(args[1]);
        int episodeNumber = Integer.parseInt(args[2]);
        String episodeName = args[3];
        TVShow show = new TVShow(tvShowName);
        Season season = new Season(seasonNumber, show);
        Episode episode = new Episode(episodeName,episodeNumber,season);
        season.addEpisode(episode);
        show.addSeason(season);

        while ((line = reader.readLine()) != null) {
            args = line.split(splitBy);
            tvShowName = args[0];
            seasonNumber = Integer.parseInt(args[1]);
            episodeNumber = Integer.parseInt(args[2]);
            if (args.length > 3) {
                episodeName = args[3];
            } else {
                episodeName = "";
            }

            if(tvShowName.equals(show.getName())) {
                if(seasonNumber == season.getNumber()) {
                    episode = new Episode(episodeName,episodeNumber,season);
                    season.addEpisode(episode);
                } else {
                    season = new Season(seasonNumber, show);
                    episode = new Episode(episodeName,episodeNumber,season);
                    season.addEpisode(episode);
                    show.addSeason(season);
                }
            } else {
                dao.persist(show);
                dao.flush();
                show = new TVShow(tvShowName);
                season = new Season(seasonNumber, show);
                episode = new Episode(episodeName,episodeNumber,season);
                season.addEpisode(episode);
                show.addSeason(season);
            }
        }
    }

}
