package moteur.objectifs;

import joueur.Joueur;
import moteur.Enums;
import moteur.Parcelle;
import moteur.Partie;
import moteur.Plateau;
import javafx.geometry.Point3D;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * La classe des objectifs parcelle
 */
public class ObjectifParcelle extends Objectif {

    private int type; //0 pour droit ; 1 pour courbé //2 pour triangle //3 pour 4 parcelles

    /**
     * Le constructeur
     * @param valeur
     * @param couleur
     * @param type
     */
    public ObjectifParcelle(int valeur, Enums.TypeParcelle couleur, int type) {
        super(valeur,couleur);
        this.type = type;
    }

    //////////////////////////////GETTER et SETTER//////////////////////////////

    public int getType() {
        return type;
    }

    public String toString() {
        switch (type) {
            case 0:
                return "3 parcelles alignées " + getCouleur();
            case 1:
                return "3 parcelles courbées " + getCouleur();
            case 2:
                return "3 parcelles en triangle " + getCouleur();
            case 3:
                return "4 parcelles " + getCouleur();
            default:
                return "motif incorrect";
        }
    }

    //////////////////////////////Méthodes//////////////////////////////

    /**
     * C'est la méthode qui renvois un True quand l'objectif est réalisé.
     * @param joueur
     * @return
     */
    @Override
    public boolean validation(Joueur joueur){
        Plateau plateau=Plateau.getInstance();
        ArrayList<Point3D> pointsPlateau = plateau.getKeylist();

        for(int i = 0; i < pointsPlateau.size(); i++) { //on parcours la map
            Point3D pointCourant = pointsPlateau.get(i);

            if(plateau.chercheMotifParcelle(pointCourant, getCouleur(), type)){
                return true;
            }
        }
        return false;
    }
}