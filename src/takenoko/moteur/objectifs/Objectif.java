package takenoko.moteur.objectifs;

import takenoko.moteur.Enums;
import takenoko.joueur.Joueur;

/**
 * La classe des objectifs
 */
public abstract class Objectif {

    private Enums.TypeParcelle couleur;
    private int valeur;

    private boolean valide;

    /**
     * Le constructeur
     * @param couleur
     * @param valeur
     */
    public Objectif(Enums.TypeParcelle couleur, int valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
        this.valide = false;
    }

    //////////////////////////////GETTER et SETTER//////////////////////////////

    public int getValeur() {
        return valeur;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Enums.TypeParcelle getCouleur() {
        return couleur;
    }

    public void setCouleur(Enums.TypeParcelle couleur) {
        this.couleur = couleur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    //////////////////////////////Méthodes//////////////////////////////


    /**
     * C'est la méthode qui renvois un True quand l'objectif est réalisé.
     * @param joueur
     * @return
     */
    public boolean validation(Joueur joueur){
        return valide;
    }
}

