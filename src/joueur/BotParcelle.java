package joueur;

import moteur.Enums;
import moteur.Enums.TypeParcelle;
import moteur.Parcelle;
import moteur.Partie;
import moteur.Plateau;
import javafx.geometry.Point3D;
import moteur.Enums.CouleurBot;
import moteur.objectifs.Objectif;
import moteur.objectifs.ObjectifPanda;
import moteur.objectifs.ObjectifParcelle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * La classe du bot Jardinier
 */
public class BotParcelle extends Bot{

    int choixchange;
    /**
     * Le constructeur
     * @param couleur
     */
    public BotParcelle(CouleurBot couleur){
        super(couleur);
        choixchange=0;
    }

    private void switchchoix(){
        choixchange=(choixchange+1)%4;
    }


    //////////////////////////////Méthodes//////////////////////////////

    /**
     * @param possibilites
     * @return
     */
    @Override
    public Enums.Action choixTypeAction(ArrayList<Enums.Action> possibilites){
        if(possibilites.contains(Enums.Action.PIOCHEROBJECTIFPARCELLE)){
            return Enums.Action.PIOCHEROBJECTIFPARCELLE;
        }
        if(possibilites.contains(Enums.Action.PIOCHEROBJECTIFPANDA)){
            return Enums.Action.PIOCHEROBJECTIFPANDA;
        }
        if(possibilites.contains(Enums.Action.PIOCHEROBJECTIFJARDINIER)){
            return Enums.Action.PIOCHEROBJECTIFJARDINIER;
        }
        if(possibilites.contains(Enums.Action.PIOCHERPARCELLE)){
            return Enums.Action.PIOCHERPARCELLE;
        }
        if(possibilites.contains(Enums.Action.POSERIRRIGATION)&& choixchange==0){
            switchchoix();
            return Enums.Action.POSERIRRIGATION;
        }
        if(possibilites.contains(Enums.Action.DEPLACERPANDA)&& choixchange>0){
            switchchoix();
            return Enums.Action.DEPLACERPANDA;
        }
        if(possibilites.contains(Enums.Action.DEPLACERJARDINIER)){
            return Enums.Action.DEPLACERJARDINIER;
        }
        return null;
    }

    /**
     * @param possibilites
     * @param parcelle
     * @return
     */
    @Override
    public Point3D choixCoordonnePoseParcelle(ArrayList<Point3D> possibilites,Parcelle parcelle) {
        Plateau plateau=Plateau.getInstance();
        //Objectif objParcelle=choixObjectifPrioritaire();
        for(int sizeMax=6;sizeMax>0;sizeMax--){
            for (Point3D coordonne : possibilites){
                if(plateau.getParcelleVoisineMemeCouleur(coordonne,parcelle).size()==sizeMax){
                    return coordonne;
                }
            }
        }
        return super.choixCoordonnePoseParcelle(possibilites,parcelle);
    }

    /**
     * @param possibilites
     * @return
     */
    @Override
    public Point3D choixDeplacementPanda(ArrayList<Point3D> possibilites) {
        Plateau plateau=Plateau.getInstance();
        for (int maxBambou=4;maxBambou>0;maxBambou--){
            for (Point3D coordonne : possibilites){
                if(Plateau.getInstance().getParcelle(coordonne).getNbBambou()>=maxBambou){
                    return coordonne;
                }
            }
        }
        return super.choixDeplacementPanda(possibilites);
    }

    /**
     * @param possibilites
     * @return
     */
    public Parcelle choixParcellePioche(ArrayList<Parcelle> possibilites){
        if(this.getListObjectifs().isEmpty()) return super.choixParcellePioche(possibilites);
        Objectif objParcelle = choixObjectifPrioritaire();
        for(Parcelle parcelle:possibilites){
            if(objParcelle.getCouleur()==parcelle.getType()){
                return parcelle;
            }
        }
        return super.choixParcellePioche(possibilites);
    }

    /**
     * @return
     */
    @Override
    public Objectif choixObjectifPrioritaire() {
        for(Objectif objectif:getListObjectifs()){
            if(objectif instanceof ObjectifParcelle){
                return objectif;
            }
        }
        return super.choixObjectifPrioritaire();
    }

}
