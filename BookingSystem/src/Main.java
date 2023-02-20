import java.util.ArrayList;
import java.util.List;

/*
 * Предположим мы разрабатываем некую систему для хранения и обработки данных  о бронирование номеров некого отеля.
 * Естественно, номера в гостинице делятся по категориям (например, Standart room, Superior, Sute).
 *  Естественно от категории могут завесить разные параметры, например цена за ночь.
 *  Наша систем должна хранить данные о брони.
 *  (Тк. работа с датами не была затронута, для хранения дат можно использовать, когда то написанный класс MyDate).
 *  Естественна любая бронь может быть оформлена, отменена или реализована, т.е. номер предоставлен.
 *  Естественно, система должна быстро предоставлять информацию о бронированиях того или иного клиента.
 *  Вам необходимо придумать и реализовать объектную модель и соответствующие методы.
 *
 * */
public class Main {
    public static void main(String[] args) {

        /*Hotels Numbers*/
        List<HotelRoom> hotelRooms = new ArrayList<>();
        hotelRooms.add(new HotelRoom(10, TypeOfRoom.SUPERIOR, AvailableOfRoom.FREE));
        hotelRooms.add(new HotelRoom(20, TypeOfRoom.STANDART, AvailableOfRoom.FREE));
        hotelRooms.add(new HotelRoom(30, TypeOfRoom.SUTE, AvailableOfRoom.FREE));
        hotelRooms.add(new HotelRoom(40, TypeOfRoom.SUPERIOR, AvailableOfRoom.FREE));
        hotelRooms.add(new HotelRoom(50, TypeOfRoom.STANDART, AvailableOfRoom.FREE));
        hotelRooms.add(new HotelRoom(60, TypeOfRoom.SUTE, AvailableOfRoom.RENT));

        Operation operation = new Operation(hotelRooms);
        ChatBot chatBot = new ChatBot(hotelRooms,operation);
        chatBot.chatBotHotel();
    }
}