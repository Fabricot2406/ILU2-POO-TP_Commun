package model;

public class FormulaireRestaurant extends Formulaire {
	private int numPersonnes;
	private int numService;
	
	public FormulaireRestaurant(int jour, int mois, int numPersonnes, int numService) {
		this.jour = jour;
		this.mois = mois;
		this.numPersonnes = numPersonnes;
		this.numService = numService;
	}

	public int getNombrePersonnes() {
		return numPersonnes;
	}

	public int getNumService() {
		return numService;
	}
}
