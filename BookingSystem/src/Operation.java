import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operation {
    private List<HotelRoom> hotelRooms;
    private List<Client> clients;
    public static  List<Booking> bookingList = new ArrayList<Booking>();

    public Operation(List<HotelRoom> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public List<HotelRoom> showAvailableRooms() {
        List<HotelRoom> availableRooms = new ArrayList<>();
        for (HotelRoom hotelRoom : hotelRooms) {
            if (hotelRoom.getAvailableOfRoom().equals(AvailableOfRoom.FREE)) {
                availableRooms.add(hotelRoom);
            }
        }
        return availableRooms;
    }

    public void rentRoom(String name, Integer num, Date bookingBegin, Date bookingEnd) {

        Client client = new Client(name);

            for (HotelRoom hotelRoom : hotelRooms) {
                if (hotelRoom.getNumber() == num) {
                    Booking booking= new Booking(client, hotelRoom, BookingStatus.ACTIVE, bookingBegin, bookingEnd );
                    bookingList.add(booking);
                    hotelRoom.setAvailableOfRoom(AvailableOfRoom.RENT);
                    System.out.println(bookingList);
                }
            }
    }


    public boolean checkAvailable(Integer num) {

        boolean available = false;
        for (HotelRoom hotelRoom : hotelRooms) {
            if (hotelRoom.getNumber() == num) {
                if (hotelRoom.getAvailableOfRoom().equals(AvailableOfRoom.FREE)) {
                    available = true;
                }
            }
        }
        return available;
    }

    public void bookingCancel(Integer bookingNumber) {
        for (Booking booking : bookingList) {
            if (booking.getBookingNumber() == bookingNumber) {
                booking.setBookingStatus(BookingStatus.CANCELED);
            }
        }
    }

    public List<Booking> findClientBooking(String name) {
        List<Booking> clientBooking= new ArrayList<>();
            for (Booking booking : bookingList) {
                if (booking.getClient().getName().equalsIgnoreCase(name)) {
                    clientBooking.add(booking);
                }
            }
            if(clientBooking.isEmpty()){
                System.out.println("No such Person");
            }
        return clientBooking;

    }
}
