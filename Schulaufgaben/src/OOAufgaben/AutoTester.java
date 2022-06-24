package OOAufgaben;

import org.junit.Assert;
import org.junit.Test;

public class AutoTester {

    @Test
    public void AutoTankt(){
        Auto auto = new Auto("FRI IC 508",11000.4,50.0,5.9,38.4);
        auto.tanken(40);
        Assert.assertEquals(50.0,auto.getKraftstoffmenge(),0.01);
    }

    @Test
    public void AutoKannStreckeFahren(){
        Auto auto = new Auto("FRI IC 508",11000.4,50.0,5.9,38.4);
        auto.fahren(200);
        Assert.assertEquals(11200.4,auto.getKilometerstand(),0.01);
    }
}
