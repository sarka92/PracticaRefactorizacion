package refactorizacionFowler;

public class Rental {
	Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	int getFrequentRenterPoints() {
		return _movie.getTotalFrequentRenterPoints(_daysRented);
	}

	double getCharge() {
		return _movie._price.getTotalCharge(_daysRented);
	}
}
