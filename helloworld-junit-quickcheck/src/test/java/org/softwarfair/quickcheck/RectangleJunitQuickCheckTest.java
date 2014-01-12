package org.softwarfair.quickcheck;

import com.pholser.junit.quickcheck.generator.InRange;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.ForAll;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;


@RunWith(Theories.class)
public class RectangleJunitQuickCheckTest {


    @Theory
    public void testArea(@ForAll int x, @ForAll int y) throws Exception {
        Assume.assumeTrue(x>=0 && y>=0);
        Rectangle out = new Rectangle(x,y);
        Assert.assertEquals(x*y, out.area());
    }

    @Theory
    public void testAreaFineGrained(@ForAll @InRange(minInt = 0, maxInt = 300) int x,
                                    @ForAll @InRange(minInt = 0, maxInt = 300) int y) throws Exception {
        Rectangle out = new Rectangle(x,y);
        Assert.assertEquals(x*y, out.area());
    }

    @Theory
    public void testNotIsSquare(@ForAll @InRange(minInt = 0) int x,
                                    @ForAll @InRange(minInt = 0) int y) throws Exception {
        Assume.assumeThat(x, is(not(y)));
        Rectangle out = new Rectangle(x,y);
        Assert.assertFalse(out.isSquare());

    }

    @Ignore
    @Theory
    public void testIsSquare(@ForAll @InRange(minInt = 0) int x,
                                @ForAll @InRange(minInt = 0) int y) throws Exception {
        Assume.assumeThat(x, is(y));
        Rectangle out = new Rectangle(x,y);
        Assert.assertTrue(out.isSquare());
    }

    @Theory
    public void testIsSquareTweaked(@ForAll @InRange(minInt = 0) int x) throws Exception {
        Rectangle out = new Rectangle(x,x);
        Assert.assertTrue(out.isSquare());
    }

}
