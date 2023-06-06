package BookMyShow;

import BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map <City, List<Movie>> locationWiseList;
    List<Movie> allMovies;

    public MovieController() {
        locationWiseList = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(City city, Movie movie) {
        allMovies.add(movie);

        List<Movie> movies = locationWiseList.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        locationWiseList.put(city, movies);
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public List<Movie> getMovieBasedOnCity(City city) {
        return locationWiseList.get(city);
    }

}
