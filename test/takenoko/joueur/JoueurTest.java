package takenoko.joueur;

import takenoko.moteur.*;
import takenoko.moteur.objectifs.ObjectifJardinier;
import javafx.geometry.Point3D;
import takenoko.moteur.objectifs.ObjectifPanda;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * La classe test du Joueur
 */
public class JoueurTest {

    Partie partie=new Partie();
    Plateau plateau =partie.getPlateau();
    Parcelle parcelleJaune = new Parcelle(Enums.TypeParcelle.JAUNE);
    Joueur joueur = new Joueur(Enums.CouleurBot.ROUGE);
    Bambou bambouJaune = new Bambou(Enums.TypeParcelle.JAUNE);


    @Test
    public void verifierMesObjectifsJardinier(){
        ObjectifJardinier objectifJardinier = new ObjectifJardinier(6, Enums.TypeParcelle.JAUNE,4);
        joueur.addObjectif(objectifJardinier);

        plateau.poser(parcelleJaune,new Point3D(0,-1,1));
        for(int i = 0 ; i < 2 ; i++){
            plateau.getParcelle(new Point3D(0,-1,1)).pousserBambou();
        }

        joueur.verifierMesObjectif();
        assertEquals(0,joueur.getNombreObjectifsRemplis());

        plateau.getParcelle(new Point3D(0,-1,1)).pousserBambou();

        joueur.verifierMesObjectif();
        assertEquals(0,joueur.getNombreObjectifsRemplis());
    }

    @Test
    public void verifierMesObjectifsPanda(){
        ObjectifPanda objectifPanda = new ObjectifPanda(4, Enums.TypeParcelle.JAUNE,2);
        joueur.addObjectif(objectifPanda);
        joueur.getListBambou().add(new Bambou(Enums.TypeParcelle.JAUNE));

        joueur.verifierMesObjectif();
        assertEquals(0,joueur.getNombreObjectifsRemplis());

        joueur.getListBambou().add(new Bambou(Enums.TypeParcelle.JAUNE));

        joueur.verifierMesObjectif();
        assertEquals(0,joueur.getNombreObjectifsRemplis());
    }


    @Test
    public void joueurPoseUneParcelle(){
        plateau.resetPlateau();
        assertEquals(6,partie.getPlateau().emplacementsAutorise().size());
        assertEquals(1,partie.getPlateau().getKeylist().size());

        joueur.joueurPose(plateau,parcelleJaune,new Point3D(0,1,-1));

        assertEquals(5,partie.getPlateau().emplacementsAutorise().size());
        assertEquals(2,partie.getPlateau().getKeylist().size());
        assertEquals(partie.getPlateau().getKeylist().get(1),new Point3D(0,1,-1));
    }


    @Test
    public void joueurPoseDeuxParcelle(){
        plateau.resetPlateau();
        joueur.joueurPose(plateau, parcelleJaune,new Point3D(0,1,-1) );
        joueur.joueurPose(plateau,parcelleJaune,new Point3D(0,1,-1));
        assertEquals(partie.getPlateau().getKeylist().get(1),new Point3D(0,1,-1));
        assertEquals(partie.getPlateau().getKeylist().get(2),new Point3D(0,1,-1));
    }



    @Test
    public void joueurDeplaceJardinier(){
        partie.getJardinier().resetPersonnage();
        plateau.resetPlateau();
        plateau.poser(parcelleJaune,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune,new Point3D(1,0,-1));

        joueur.joueurDeplaceJardinier( partie.getJardinier(),new Point3D(0,1,-1) );

        assertEquals(new Point3D(0,1,-1),partie.getJardinier().getCoord());
    }


    @Test
    public void joueurDeplacePanda(){
        joueur.resetJoueur();
        plateau.poser(parcelleJaune,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune,new Point3D(1,0,-1));

        joueur.joueurDeplacePanda( partie.getPanda(),new Point3D(0,1,-1) );

        assertEquals(new Point3D(0,1,-1),partie.getPanda().getCoord());

        ArrayList<Bambou> listBambouAttendu = new ArrayList<>();
        listBambouAttendu.add(bambouJaune);
        for (int i = 0; i < joueur.getListBambou().size(); i++) {
            assertEquals(listBambouAttendu.get(i).getCouleur(),joueur.getListBambou().get(i).getCouleur());

        }

    }


    @Test
    public void listActionRestantePossible(){
        plateau.resetPlateau();
        joueur.resetJoueur();
        ArrayList<Enums.Action> listActionAttendu = new ArrayList<>();
        listActionAttendu.add(Enums.Action.PIOCHERPARCELLE);
        listActionAttendu.add(Enums.Action.PIOCHEROBJECTIFPANDA);
        listActionAttendu.add(Enums.Action.PIOCHEROBJECTIFJARDINIER);
        ArrayList<Enums.Action> listAction = joueur.listActionRestantePossible();
        assertEquals(listAction,listActionAttendu);

        plateau.poser(parcelleJaune,new Point3D(0,1,-1));

        listActionAttendu.add(Enums.Action.DEPLACERJARDINIER);
        listActionAttendu.add(Enums.Action.DEPLACERPANDA);

        ArrayList<Enums.Action> listAction2 = joueur.listActionRestantePossible();
        assertEquals(listAction2,listActionAttendu);
    }

    @Test
    public void supprimerBambou(){
        joueur.resetJoueur();
        joueur.getListBambou().add(new Bambou(Enums.TypeParcelle.JAUNE));
        joueur.getListBambou().add(new Bambou(Enums.TypeParcelle.JAUNE));
        assertEquals(joueur.getListBambou().size(), 2);
        joueur.supprBambou(Enums.TypeParcelle.JAUNE,2);
        assertEquals(joueur.getListBambou().size(), 0);

    }

    @Test
    public void piocherUneParcelle(){
        assertEquals(joueur.piocheUneParcelle(),null);
    }

    @Test
    public void joueurPose(){
        plateau.resetPlateau();
        assertEquals(plateau.getParcelle(new Point3D(1,0,-1)), null);
        joueur.joueurPose(plateau,parcelleJaune,new Point3D(1,0,-1));
        assertEquals(plateau.getParcelle(new Point3D(1,0,-1)), parcelleJaune);
    }




    @Test
    public void actionPiocheObjectifJardinier(){
        joueur.resetJoueur();
        assertEquals(joueur.getListObjectifs().size(), 2);
        joueur.actionPiocheObjectifJardinier();
        assertEquals(joueur.getListObjectifs().size(), 3);

    }

    @Test
    public void actionPiocheObjectifPanda(){
        joueur.resetJoueur();
        assertEquals(joueur.getListObjectifs().size(), 2);
        joueur.actionPiocheObjectifPanda();
        assertEquals(joueur.getListObjectifs().size(), 3);

    }


}
