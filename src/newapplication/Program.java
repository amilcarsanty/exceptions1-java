package newapplication;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import newmodel.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// List<Reservation> listReservations = new ArrayList<>();

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.print("Reservation: " + reservation.toString());

				System.out.println("\n");
				System.out.println("Enter data to update the reservation: ");
				System.out.print("Check-in date (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Check-out date (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());

				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
					System.out.println("Error in reservation: " + error);
				}
				else {
					System.out.print("Reservation: " + reservation);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
