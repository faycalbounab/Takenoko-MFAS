package takenoko.moteur.objectifs;

import takenoko.joueur.Bot;
import takenoko.moteur.*;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * La classe test des objectifs Panda
 */
public class ObjectifPandaTest {
    Bot bot = new Bot(Enums.CouleurBot.ROUGE);

    @Test
    public void validationObjectifPanda() throws Exception {
        ObjectifPanda objectifpanda = new ObjectifPanda(5, Enums.TypeParcelle.ROSE,2);
        bot.addObjectif(objectifpanda);

        bot.getListBambou().add(new Bambou(Enums.TypeParcelle.ROSE));
        assertFalse(objectifpanda.validation(bot));

        bot.getListBambou().add(new Bambou(Enums.TypeParcelle.ROSE));
        assertTrue(objectifpanda.validation(bot));

        ArrayList<Bambou> listBambouCompare = new ArrayList<>();
        assertEquals(listBambouCompare,bot.getListBambou());

    }

}