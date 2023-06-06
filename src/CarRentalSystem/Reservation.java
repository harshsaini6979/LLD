package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;

import javax.xml.stream.Location;
import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookedFrom;
    Date bookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    public Reservation(int reservationId) {
        this.reservationId = reservationId;
    }

    public void createReservation (User user, Vehicle vehicle, ReservationType reservationType) {
        this.user = user;
        this.vehicle = vehicle;
        this.reservationType = reservationType;
        reservationStatus = ReservationStatus.SCHEDULED;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
