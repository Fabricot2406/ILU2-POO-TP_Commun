package model;

public class EntiteReservable {
	private CalendrierAnnuel calendrierPersonnel;
	private int numIdentification;
	
	public int getNumIdentification() {
		return numIdentification;
	}
	
	public void setNumIdentification(int numIdentification) {
		this.numIdentification = numIdentification;
	}
	
	public <T extends Formulaire> boolean estLibre(T formulaire) {
		 return calendrierPersonnel.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public <T extends Formulaire> boolean compatible(T formulaire) {
		 return true; // A clarifier
	}
	
	public <T extends Formulaire> Reservation reserver(T formulaire) {
		 if (compatible(formulaire)) {
			 return new Reservation(); // Comment faire la bonne réservation dépendant du formulaire
		 }
		 return null;
	}
}
