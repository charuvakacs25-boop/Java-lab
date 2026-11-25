import java.util.Scanner;

class SeatAlreadyBookedException extends Exception {
    SeatAlreadyBookedException(String msg) {
        super(msg);
    }
}

class Reservation {
    boolean[] seats = new boolean[5];

    void reserveSeat(int seatNo)
            throws SeatAlreadyBookedException {

        if (seatNo < 1 || seatNo > 5) {
            throw new IllegalArgumentException("Invalid seat number!");
        }

        if (seats[seatNo - 1]) {
            throw new SeatAlreadyBookedException(
                "Seat is already booked!");
        }

        seats[seatNo - 1] = true;
        System.out.println("Seat " + seatNo + " reserved successfully!");
    }
}

public class RailwayReservation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Reservation r = new Reservation();

        try {
            while (true) {
                System.out.print("Enter seat number (1-5): ");
                int seatNo = sc.nextInt();

                r.reserveSeat(seatNo);

                System.out.print("Book another seat? (1-Yes, 0-No): ");
                int choice = sc.nextInt();

                if (choice == 0)
                    break;
            }
        }

        catch (SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect input! Enter a number.");
        }

        finally {
            System.out.println("Transaction completed.");
            sc.close();
        }
    }
}

