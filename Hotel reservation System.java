import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Standard"));
        rooms.add(new Room(105, "Deluxe"));

        int choice;
        do {
            System.out.println("\n🏨 HOTEL RESERVATION SYSTEM");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom(sc);
                    break;
                case 3:
                    cancelBooking(sc);
                    break;
                case 4:
                    viewAllRooms();
                    break;
                case 5:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void viewAvailableRooms() {
        System.out.println("\n🟢 Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " (" + room.type + ")");
            }
        }
    }

    static void bookRoom(Scanner sc) {
        System.out.print("Enter room number to book: ");
        int roomNum = sc.nextInt();
        for (Room room : rooms) {
            if (room.roomNumber == roomNum) {
                if (!room.isBooked) {
                    room.isBooked = true;
                    System.out.println("✅ Room " + roomNum + " booked successfully!");
                    return;
                } else {
                    System.out.println("❌ Room is already booked.");
                    return;
                }
            }
        }
        System.out.println("❌ Room not found.");
    }

    static void cancelBooking(Scanner sc) {
        System.out.print("Enter room number to cancel booking: ");
        int roomNum = sc.nextInt();
        for (Room room : rooms) {
            if (room.roomNumber == roomNum) {
                if (room.isBooked) {
                    room.isBooked = false;
                    System.out.println("✅ Booking cancelled for room " + roomNum);
                    return;
                } else {
                    System.out.println("❌ Room is not currently booked.");
                    return;
                }
            }
        }
        System.out.println("❌ Room not found.");
    }

    static void viewAllRooms() {
        System.out.println("\n🏷️ All Rooms Status:");
        for (Room room : rooms) {
            String status = room.isBooked ? "Booked" : "Available";
            System.out.println("Room " + room.roomNumber + " (" + room.type + ") - " + status);
        }
    }
}

// 👇 Room class comes AFTER the main class
class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }
}
