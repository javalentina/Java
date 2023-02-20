import java.util.List;
import java.util.Scanner;

public class ChatBot {
    private static List<HotelRoom> hotelRooms;
    private static Operation operation;

    public ChatBot(List<HotelRoom> hotelRooms, Operation operation) {
        this.hotelRooms = hotelRooms;
        this.operation = operation;
    }

    public static void chatBotHotel() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.println("Enter operation number:\n" +
                "1 - List all rooms\n" +
                "2 - Rent a room\n" +
                "3 - Cancel booking\n" +
                "4 - Find client booking\n" +
                "5 - List all bookings\n" +
                "6 - Quit");

        while (isRunning) {
            System.out.println("Choose your operation");
            int operationNumber = scanner.nextInt();

            switch (operationNumber) {
                case 1:
                    System.out.println(hotelRooms);
                    break;
                case 2: {
                    System.out.println("What Room Number would you like? Available are:");
                    System.out.println(operation.showAvailableRooms());

                    Integer roomNumber = scanner.nextInt();
                    System.out.println("You choose Room Number " + roomNumber + " .");

                    while (!operation.checkAvailable(roomNumber)) {
                        System.out.println("This Room is not Available, Choose another one among this:");
                        System.out.println(operation.showAvailableRooms());
                        roomNumber = scanner.nextInt();
                    }
                    System.out.println("Please Enter your Name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Thank you For Booking. Here is your Booking Details:");
                    operation.rentRoom(name, roomNumber);

                    break;
                }
                case 3: {
                    System.out.println("Booking Cancellation. Enter Your Booking Number please ");
                    Integer bookingNumber = scanner.nextInt();
                    operation.bookingCancel(bookingNumber);
                    System.out.println("Your Booking was Cancelled");
                    break;
                }
                case 4: {
                    System.out.println("Find Information about Client. Print the Name of Person: ");
                    scanner.nextLine();
                    String findName = scanner.nextLine();
                    System.out.println(operation.findClientBooking(findName));
                    break;
                }
                case 5: {
                    System.out.println("All Bookings ");
                    System.out.println(Operation.bookingList);
                    break;
                }
                case 6: {
                    isRunning=false;
                    System.out.println("Thank you! Hope to See you soon. ");
                    scanner.close();
                    break;
                }
                default:
                    System.out.println("No such operation. Try once Again.");

            }
        }
    }
}
