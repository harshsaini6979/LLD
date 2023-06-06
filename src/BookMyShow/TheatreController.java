package BookMyShow;

import BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> locationWiseTheatre;
    List<Theatre> allTheaters;

    public TheatreController() {
        locationWiseTheatre = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        List<Theatre> theatres = locationWiseTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        locationWiseTheatre.put(city, theatres);

        allTheaters.add(theatre);
    }

    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie) {
        Map<Theatre, List<Show>> locationWiseShows = new HashMap<>();

        List<Theatre> theatreList = locationWiseTheatre.get(city);

        for (Theatre theatre : theatreList) {
            List<Show> selectedShows = new ArrayList<>();
            List<Show> showList = theatre.getShowList();

            for (Show show : showList) {
                if (show.getMovie().movieId == movie.movieId) {
                    selectedShows.add(show);
                }
            }

            if (!selectedShows.isEmpty()) {
                locationWiseShows.put(theatre, selectedShows);
            }
        }

        return locationWiseShows;
    }
}
