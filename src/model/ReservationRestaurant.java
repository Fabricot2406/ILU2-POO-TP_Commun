package model;

public class ReservationRestaurant extends Reservation {
	private String numService;
	private int numTable;
	
	public ReservationRestaurant(int jour, int mois, int numService, int numTable) {
		this.jour = jour;
		this.mois = mois;
		if (numService == 1) {
			this.numService = "premier";
		} else if (numService == 2) {
			this.numService = "deuxième";
		}
		this.numTable = numTable;
	}

	@Override
	public String toString() {
		return "Le " + jour + "/" + mois + "\nTable " + numTable + " pour le " + numService + " service.";
	}
}
