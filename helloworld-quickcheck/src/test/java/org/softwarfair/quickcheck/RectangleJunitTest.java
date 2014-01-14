package org.softwarfair.quickcheck;

import org.junit.Assert;
import org.junit.Test;

public class RectangleJunitTest {

    @Test
    public void testAreaEmpty1() throws Exception {
        Rectangle cut = new Rectangle(0,0);
        Assert.assertEquals(0l, cut.area());
    }

    @Test
    public void testAreaEmpty2() throws Exception {
        Rectangle cut = new Rectangle(0,1);
        Assert.assertEquals(0l, cut.area());
    }

    @Test
    public void testAreaEmpty3() throws Exception {
        Rectangle cut = new Rectangle(1,0);
        Assert.assertEquals(0l, cut.area());
    }

    @Test
    public void testAreaCorrectOneXOne() throws Exception {
        Rectangle cut = new Rectangle(1,1);
        Assert.assertEquals(1l, cut.area());
    }

    @Test
    public void testAreaCorrectOneXTwo() throws Exception {
        Rectangle cut = new Rectangle(1,2);
        Assert.assertEquals(2l, cut.area());
    }

    @Test
    public void testAreaCorrectTwoXOne() throws Exception {
        Rectangle cut = new Rectangle(2,1);
        Assert.assertEquals(2l, cut.area());
    }

    @Test
    public void testAreaCorrectTwoXTwo() throws Exception {
        Rectangle cut = new Rectangle(2,2);
        Assert.assertEquals(4l, cut.area());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaNegatives1() throws Exception {
        Rectangle cut = new Rectangle(-1,-1);
        cut.area();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaNegatives2() throws Exception {
        Rectangle cut = new Rectangle(-1,-1);
        cut.area();
    }

    @Test
    public void testNonSquare1() throws Exception {
        Rectangle cut = new Rectangle(1,2);
        Assert.assertFalse(cut.isSquare());

    }

    @Test
    public void testNonSquare2() throws Exception {
        Rectangle cut = new Rectangle(2,1);
        Assert.assertFalse(cut.isSquare());

    }

    @Test
    public void testSquare() throws Exception {
        Rectangle cut = new Rectangle(3,3);
        Assert.assertTrue(cut.isSquare());

    }

}
