package takenoko.joueur;

import javafx.geometry.Point3D;
import takenoko.moteur.Enums;
import takenoko.moteur.Parcelle;
import takenoko.moteur.Partie;
import takenoko.moteur.Plateau;
import takenoko.moteur.objectifs.ObjectifJardinier;
import takenoko.moteur.objectifs.ObjectifPanda;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * La classe test du BotPanda
 */
public class BotPandaTest {

    Partie partie=new Partie();
    Plateau plateau =partie.getPlateau();
    Parcelle parcelleJaune = new Parcelle(Enums.TypeParcelle.JAUNE);
    Parcelle parcelleVerte = new Parcelle(Enums.TypeParcelle.VERTE);
    BotPanda botPanda = new BotPanda(Enums.CouleurBot.ROUGE);
    ObjectifPanda objectifPandaJaune = new ObjectifPanda(4, Enums.TypeParcelle.JAUNE,2);


    @Test
    public void choixDeplacementJardinierZeroParcelleCouleurVoulu() {
        plateau.resetPlateau();
        plateau.poser(parcelleVerte,new Point3D(0,1,-1));
        plateau.poser(parcelleVerte,new Point3D(1,0,-1));
        botPanda.addObjectif(new ObjectifPanda(6, Enums.TypeParcelle.JAUNE,4));

        ArrayList<Point3D> possibilites = partie.getJardinier().destinationsPossibles();
        Point3D pointAttendu = new Point3D(0,1,-1);

        assertEquals(botPanda.choixDeplacementJardinier(possibilites),pointAttendu);

    }

    @Test
    public void choixDeplacementJardinierUneParcelleCouleurVoulu(){
        plateau.resetPlateau();
        plateau.poser(parcelleVerte,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune,new Point3D(1,0,-1));
        botPanda.addObjectif(new ObjectifPanda(6, Enums.TypeParcelle.JAUNE,4));

        ArrayList<Point3D> possibilites = partie.getJardinier().destinationsPossibles();
        Point3D pointAttendu = new Point3D(1,0,-1);

        assertEquals(botPanda.choixDeplacementJardinier(possibilites),pointAttendu);
    }

    @Test
    public void choixDeplacementJardinierDeuxParcellesCouleurVoulu(){
        plateau.resetPlateau();
        Parcelle parcelleJaune2 = new Parcelle(Enums.TypeParcelle.JAUNE);
        plateau.poser(parcelleJaune,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune2,new Point3D(1,0,-1));
        plateau.poser(parcelleVerte,new Point3D(1,-1,0));
        botPanda.addObjectif(new ObjectifPanda(6, Enums.TypeParcelle.JAUNE,4));

        ArrayList<Point3D> possibilites = partie.getJardinier().destinationsPossibles();
        Point3D pointAttendu = new Point3D(0,1,-1);

        assertEquals(botPanda.choixDeplacementJardinier(possibilites),pointAttendu);

        parcelleJaune2.pousserBambou();

        assertEquals(botPanda.choixDeplacementJardinier(possibilites),pointAttendu);

    }

    @Test
    public void choixDeplacementPandaZeroParcelleCouleurVoulu() {
        plateau.resetPlateau();
        plateau.poser(parcelleVerte,new Point3D(0,1,-1));
        plateau.poser(parcelleVerte,new Point3D(1,0,-1));
        botPanda.addObjectif(new ObjectifPanda(6, Enums.TypeParcelle.JAUNE,4));

        ArrayList<Point3D> possibilites = partie.getPanda().destinationsPossibles();
        Point3D pointAttendu = new Point3D(0,1,-1);

        assertEquals(botPanda.choixDeplacementPanda(possibilites),pointAttendu);

    }

    @Test
    public void choixDeplacementPandaUneParcelleCouleurVoulu(){
        plateau.resetPlateau();
        plateau.poser(parcelleVerte,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune,new Point3D(1,0,-1));
        botPanda.addObjectif(new ObjectifPanda(6, Enums.TypeParcelle.JAUNE,4));

        ArrayList<Point3D> possibilites = partie.getPanda().destinationsPossibles();
        Point3D pointAttendu = new Point3D(1,0,-1);

        assertEquals(botPanda.choixDeplacementPanda(possibilites),pointAttendu);
    }

    @Test
    public void choixDeplacementPandaDeuxParcellesCouleurVoulu(){
        plateau.resetPlateau();
        Parcelle parcelleJaune2 = new Parcelle(Enums.TypeParcelle.JAUNE);
        plateau.poser(parcelleJaune,new Point3D(0,1,-1));
        plateau.poser(parcelleJaune2,new Point3D(1,0,-1));
        plateau.poser(parcelleVerte,new Point3D(1,-1,0));
        botPanda.addObjectif(objectifPandaJaune);

        ArrayList<Point3D> possibilites = partie.getPanda().destinationsPossibles();
        Point3D pointAttendu = new Point3D(0,1,-1);
        System.out.println(parcelleJaune.getNbBambou());
        assertEquals(botPanda.choixDeplacementPanda(possibilites),pointAttendu);

        parcelleJaune2.pousserBambou();

        pointAttendu = new Point3D(1,0,-1);
        assertEquals(botPanda.choixDeplacementPanda(possibilites),pointAttendu);
    }

    @Test
    public void choixParcellePiocheZeroParcelleVoulu(){
        botPanda.addObjectif(objectifPandaJaune);
        ArrayList<Parcelle> possibilites = new ArrayList<>();
        possibilites.add(parcelleVerte);
        possibilites.add(new Parcelle(Enums.TypeParcelle.VERTE));
        possibilites.add(new Parcelle(Enums.TypeParcelle.VERTE));
        assertEquals(botPanda.choixParcellePioche(possibilites), parcelleVerte);
    }

    @Test
    public void choixParcellePiocheUneParcelleVoulu(){
        botPanda.addObjectif(objectifPandaJaune);
        ArrayList<Parcelle> possibilites = new ArrayList<>();
        possibilites.add(parcelleVerte);
        possibilites.add(parcelleJaune);
        possibilites.add(new Parcelle(Enums.TypeParcelle.VERTE));
        assertEquals(botPanda.choixParcellePioche(possibilites), parcelleJaune);

    }

    @Test
    public void choixParcellePiocheDeuxParcellesVoulus(){
        botPanda.addObjectif(objectifPandaJaune);
        Parcelle parcelleJaune2 = new Parcelle(Enums.TypeParcelle.JAUNE);
        ArrayList<Parcelle> possibilites = new ArrayList<>();
        possibilites.add(parcelleVerte);
        possibilites.add(parcelleJaune);
        possibilites.add(parcelleJaune2);

        assertEquals(botPanda.choixParcellePioche(possibilites), parcelleJaune);
    }

    @Test
    public void choixObjectifPrioritaire(){
        ObjectifJardinier objectifJardinier = new ObjectifJardinier(6, Enums.TypeParcelle.JAUNE,4);
        botPanda.addObjectif(objectifJardinier);

        assertEquals(botPanda.choixObjectifPrioritaire(),objectifJardinier);

        botPanda.addObjectif(objectifPandaJaune);

        assertEquals(botPanda.choixObjectifPrioritaire(),objectifPandaJaune);

        ObjectifPanda ObjectifPandaRose = new ObjectifPanda(5, Enums.TypeParcelle.ROSE,2);
        botPanda.addObjectif(ObjectifPandaRose);

        assertEquals(botPanda.choixObjectifPrioritaire(),objectifPandaJaune);

    }
}