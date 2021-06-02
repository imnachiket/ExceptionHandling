//lex_auth_012921592276475904109
//do not modify the above line

package exceptionassignment1;

public class BusBooking {

	private int bookingId;
	private String destination;
	private String tripPackage;
	private double totalAmount;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTripPackage() {
		return tripPackage;
	}

	public void setTripPackage(String tripPackage) {
		this.tripPackage = tripPackage;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BusBooking(int bookingId, String destination, String tripPackage) {

		this.bookingId = bookingId;
		this.destination = destination;
		this.tripPackage = tripPackage;
		this.totalAmount = 0;

	}

	public boolean validateCouponCode(String couponCode, int numberOfMembers) {

		if (couponCode.equals("BIGBUS") && numberOfMembers >= 10) {
			return true;
		} else if (couponCode.equals("MAGICBUS") && numberOfMembers >= 15) {
			return true;
		} else {

			try {
				throw new InvalidCouponCodeException("Invalid coupon code");
			} catch (InvalidCouponCodeException e) {
				System.out.println(e.getMessage());
			}

			return false;
		}
	}

	public String bookTrip(String couponCode, int numberOfMembers) {

		if (this.destination.equals("Washington DC") || this.destination.equals("Philadelphia")
				|| this.destination.equals("Orlando") || this.destination.equals("Boston")
				|| this.destination.equals("Atlanta")) {

			if (tripPackage.equals("Regular")) {
				this.totalAmount = 500;
			} else if (tripPackage.equals("Premium")) {
				this.totalAmount = 800;
			} else {
				try {
					throw new InvalidTripPackageException("Invalid package");
				} catch (InvalidTripPackageException e) {
					System.out.println(e.getMessage());
				}
			}

			if (validateCouponCode(couponCode, numberOfMembers) == true) {

				if (couponCode.equals("BIGBUS")) {
					this.totalAmount = this.totalAmount * numberOfMembers;
					return "Booking successful";
				} else {
					this.totalAmount = this.totalAmount * numberOfMembers;
					return "Booking successful";
				}

			} else {
				return "";
			}

			
		} else {
			try {
				throw new InvalidDestinationException("Invalid destination");
			} catch (InvalidDestinationException e) {
				System.out.println(e.getMessage());
			}
			return "";
		}

		/*
		 * if (validateCouponCode(couponCode, numberOfMembers) == true) {
		 * 
		 * if (couponCode.equals("BIGBUS")) { this.totalAmount =
		 * this.totalAmount * numberOfMembers; } else { this.totalAmount =
		 * this.totalAmount * numberOfMembers; }
		 * 
		 * return "Booking successful";
		 * 
		 * } else {
		 * 
		 * return ""; }
		 */
	}

}
