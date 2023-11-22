package model;

public class CentraleReservation<T extends EntiteReservable> {
    private T[] entitesAReserver;
    private int nombreEntites;

    public CentraleReservation(T[] entitesAReserver) {
        this.entitesAReserver = entitesAReserver;
        this.nombreEntites = 0;
    }
    
    public int ajouterEntite(T entite) {
        entitesAReserver[nombreEntites] = entite;
        nombreEntites++;
        entite.setNumIdentification(nombreEntites);
        return nombreEntites;
    }
    
    public <U extends Formulaire> int[] donnerPossibilites(U formulaire) {
        int[] possibilites = new int[nombreEntites];

        for (int i = 0; i < nombreEntites; i++) {
            if (entitesAReserver[i].estLibre(formulaire)) {
                possibilites[i] = entitesAReserver[i].getNumIdentification();
            } else {
                possibilites[i] = 0;
            }
        }
        return possibilites;
    }
    
    public <U extends Formulaire> Reservation reserver(int numeroEntite, U formulaire) {
        if (numeroEntite > 0 && numeroEntite <= nombreEntites) {
            T entiteAReserver = entitesAReserver[numeroEntite - 1];
            formulaire.setIdentificationEntite(numeroEntite);
            return entiteAReserver.reserver(formulaire);
        }
        return null;
    }
}