package org.refactorizacionFowler;

public abstract class Price {
	abstract int getPriceCode();

	abstract double getCharge(int daysRented);

	int getFrequentRenterPoints() {
		return 1;
	}
}
