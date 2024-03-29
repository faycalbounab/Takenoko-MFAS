package takenoko.joueur;

import takenoko.moteur.Enums;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe du bot Random
 */

public class BotRandom extends Bot{


    /**
     * Le constructeur
     * @param couleur
     */
    public BotRandom(Enums.CouleurBot couleur) {
        super(couleur);
    }


    //////////////////////////////Méthodes//////////////////////////////

    /**
     * Les differents choix du BotRandom
     * @param possibilites
     * @return
     */
    @Override
    public Enums.Action choixTypeAction(ArrayList<Enums.Action> possibilites) {
        int random = new Random().nextInt(2);
        if(possibilites.contains(Enums.Action.PIOCHEROBJECTIFJARDINIER)){
            return Enums.Action.PIOCHEROBJECTIFJARDINIER;
        }
        if(possibilites.contains(Enums.Action.PIOCHEROBJECTIFPANDA)){
            return Enums.Action.PIOCHEROBJECTIFPANDA;
        }
        if(possibilites.contains(Enums.Action.PIOCHERPARCELLE)&&random==0){
            return Enums.Action.PIOCHERPARCELLE;
        }
        if(possibilites.contains(Enums.Action.PIOCHERPARCELLE)){
            return Enums.Action.PIOCHERPARCELLE;
        }
        if(possibilites.contains(Enums.Action.DEPLACERJARDINIER)){
            return Enums.Action.DEPLACERJARDINIER;
        }
        if(possibilites.contains(Enums.Action.DEPLACERPANDA)){
            return Enums.Action.DEPLACERPANDA;
        }
        return null;
    }

}
