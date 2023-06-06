package BookMyShow;

import BookMyShow.Enums.City;
import BookMyShow.Enums.SeatType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String args[]) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialise();

        bookMyShow.createBooking(City.Kanpur, "AVENGERS");
        bookMyShow.createBooking(City.Kanpur, "BAHUBALI");

    }

    private void createBooking(City city, String movieName) {
        List<Movie> movies = movieController.getMovieBasedOnCity(city);

        if (movies.isEmpty()) {
            System.out.println("This movie is not available in the given city!!");
            return;
        }

        Movie movie = null;

        for(Movie movie1 : movies) {
            if (movie1.getMovieName().equals(movieName)) {
                movie = movie1;
                break;
            }
        }

        if (movie == null) {
            System.out.println("This movie is not available in the given city!!");
            return;
        }

        Map<Theatre, List<Show>> shows = theatreController.getAllShows(city, movie);
        Show show = shows.entrySet().iterator().next().getValue().get(0);

        int seatNo = 30;
        List<Integer> bookedSeats = show.getBookedSeats();

        if(!bookedSeats.contains(seatNo)) {
            bookedSeats.add(seatNo);

            Booking booking = new Booking();
            List<Seat> mybookedSeats = new ArrayList<>();
            for (Seat seat : show.getScreen().getSeatList()) {
                if(seat.getSeatId() == seatNo) {
                    mybookedSeats.add(seat);
                }
            }

            Payment payment = new Payment();
            payment.paymentId = 1;

            booking.setBookedSeats(mybookedSeats);
            booking.setShow(show);
            booking.setPayment(payment);

            System.out.println("Booking successfully completed");

            printTicket(booking, seatNo);
        }
        else {
            System.out.println("Seat is already booked!! Try Again");
        }
    }

    private void printTicket(Booking booking, int seatNo) {
        System.out.println("========== TICKET ==========");
        System.out.println("Movie Name: " + booking.getShow().getMovie().getMovieName());
        System.out.println("Show Id: " + booking.getShow().getShowId());
        System.out.println("Show StartTime: " + booking.getShow().getStartTime());
        System.out.println("Seat Number: " + seatNo);
        System.out.println("Payment Id: " + booking.getPayment().paymentId);
    }

    private void initialise() {
        createMovies();
        createTheaters();
    }

    private void createTheaters() {
        Movie movie1 = movieController.getAllMovies().get(0);
        Movie movie2 = movieController.getAllMovies().get(1);

        Theatre theatre1 = new Theatre();
        theatre1.setTheatreId(1);
        theatre1.setCity(City.Kanpur);
        theatre1.setScreenList(createScreens());
        List<Show> showList = new ArrayList<>();
        Show show1 = createShow(1, theatre1.getScreenList().get(0), movie1, 8);
        Show show2 = createShow(2, theatre1.getScreenList().get(0), movie1, 12);
        showList.add(show1);
        showList.add(show2);
        theatre1.setShowList(showList);

        Theatre theatre2 = new Theatre();
        theatre2.setTheatreId(1);
        theatre2.setCity(City.Delhi);
        theatre2.setScreenList(createScreens());
        showList = new ArrayList<>();
        show1 = createShow(1, theatre2.getScreenList().get(0), movie2, 10);
        show2 = createShow(2, theatre2.getScreenList().get(0), movie2, 14);
        showList.add(show1);
        showList.add(show2);
        theatre2.setShowList(showList);

        theatreController.addTheatre(City.Kanpur, theatre1);
        theatreController.addTheatre(City.Delhi, theatre2);
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeatList(createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShow(int showId, Screen screen, Movie movie, double startTime) {
        Show show = new Show();

        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(startTime);

        return show;
    }

    private List<Seat> createSeats() {
        List<Seat> seatList = new ArrayList<>();

        for (int i=1; i<=40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.GOLD);
            seatList.add(seat);
        }

        for (int i=41; i<=80; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.PLATINUM);
            seatList.add(seat);
        }

        for (int i=81; i<=100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.SILVER);
            seatList.add(seat);
        }

        return seatList;
    }

    private void createMovies () {
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieLength(120);
        movie.setMovieName("AVENGERS");

        Movie movie2 = new Movie();
        movie2.setMovieId(2);
        movie2.setMovieLength(212);
        movie2.setMovieName("BAHUBALI");

        movieController.addMovie(City.Kanpur, movie2);
        movieController.addMovie(City.Delhi, movie);

    }
}
