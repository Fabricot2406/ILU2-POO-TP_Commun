package model;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	
	public CalendrierAnnuel() {
		this.calendrier = new Mois[12];
		int[] moisJours = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] moisNoms = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "September", "Octobre", "Novembre", "Décembre"};
		for (int i = 0; i < 12; i++) {
			calendrier[i] = new Mois(moisNoms[i], moisJours[i]);
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserverJour(jour);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
	private class Mois {
		private String nom;
		private boolean [] jours;
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			for (int i = 0; i < nbJours; i++) {
				jours[i] = false;
			}
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour-1];
		}
		
		private void reserverJour(int jour) {
		    if (!estLibre(jour)) {
		        throw new IllegalStateException("Ce jour n'est pas libre !");
		    } else {
		    	jours[jour-1] = true;
		    }
		}
	}
}
