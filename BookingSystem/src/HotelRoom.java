import java.math.BigDecimal;

public class HotelRoom {
    private int number;
    private TypeOfRoom type;
    private AvailableOfRoom availableOfRoom;
    private BigDecimal price;

    public HotelRoom(int number, TypeOfRoom type, AvailableOfRoom availableOfRoom) {
        this.number = number;
        this.type = type;
        this.availableOfRoom = availableOfRoom;
    }

    public int getNumber() {
        return number;
    }

    public TypeOfRoom getType() {
        return type;
    }

    public AvailableOfRoom getAvailableOfRoom() {
        return availableOfRoom;
    }

    public void setAvailableOfRoom(AvailableOfRoom availableOfRoom) {
        this.availableOfRoom = availableOfRoom;
    }

    @Override
    public String toString() {
        return  String.format("Room Number: %d, type= %s , availableOfRoom= %s ,price= %s \n",number ,type ,availableOfRoom,type.getPrice());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelRoom hotelRoom)) return false;

        if (number != hotelRoom.number) return false;
        if (type != hotelRoom.type) return false;
        return availableOfRoom == hotelRoom.availableOfRoom;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (availableOfRoom != null ? availableOfRoom.hashCode() : 0);
        return result;
    }
}
