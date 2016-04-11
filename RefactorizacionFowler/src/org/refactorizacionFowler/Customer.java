package org.refactorizacionFowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String customerName;
	private Vector<Rental> rented = new Vector<>();

	public Customer(String name) {
		customerName = name;
	};

	public void addRental(Rental arg) {
		rented.addElement(arg);
	}

	public String getName() {
		return customerName;
	}

	public String statement() {
		Enumeration<Rental> rentals = rented.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned "
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	public String htmlStatement() {
		Enumeration<Rental> rentals = rented.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();

			// show figures for each rental
			result += each.getMovie().getTitle() + ": "
					+ String.valueOf(each.getCharge()) + "<BR>\n";
		}
		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge())
				+ "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = rented.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = rented.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
}
