package OOAufgaben;

import org.junit.Assert;
import org.junit.Test;

public class RadioTester {

    @Test
    public void RadioIsCreatedOf(){
        Radio radio = new Radio(false,6,103.1);
        Assert.assertEquals(6,radio.getVolume());
        Assert.assertEquals(103.1,radio.getFrequency(),0.01);
        Assert.assertFalse(radio.Power());
    }
}
