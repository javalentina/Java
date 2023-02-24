import java.util.Date;

public class Booking {
    private Client client;
    private HotelRoom room;
    private Integer bookingNumber;
    private BookingStatus bookingStatus;
    private Date bookingBegin;
    private Date bookingEnd;
    private static int counter = 1;

    public Client getClient() {
        return client;
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Booking(Client client, HotelRoom room, BookingStatus bookingStatus,Date bookingBegin, Date bookingEnd) {
        this.client = client;
        this.room = room;
        this.bookingStatus = bookingStatus;
        this.bookingNumber = counter;
        this.bookingBegin= bookingBegin;
        this.bookingEnd= bookingEnd;
        counter++;
    }


    @Override
    public String toString() {
        return "Booking number: " + bookingNumber + ". Client: " + client +", Status: " +bookingStatus+ ", " + room  ;
    }
}
