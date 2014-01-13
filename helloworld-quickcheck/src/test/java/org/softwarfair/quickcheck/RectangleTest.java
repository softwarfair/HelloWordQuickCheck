package org.softwarfair.quickcheck;

import net.java.quickcheck.Generator;
import net.java.quickcheck.QuickCheck;
import net.java.quickcheck.characteristic.AbstractCharacteristic;
import net.java.quickcheck.generator.PrimitiveGenerators;
import net.java.quickcheck.generator.support.ExcludingGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {
    @Test
    public void testArea() throws Exception {
        for(int i = 1; i < 100; i++) {
            Integer x = PrimitiveGenerators.positiveIntegers().next();
            Integer y = PrimitiveGenerators.positiveIntegers().next();
            Rectangle out = new Rectangle(x, y);
            Assert.assertEquals(x*y, out.area());
        }
    }

    @Test
    public void testIsSquare() throws Exception {
        for(int i = 1; i < 100; i++) {
            Integer x = PrimitiveGenerators.positiveIntegers().next();
            Rectangle out = new Rectangle(x, x);
            Assert.assertTrue(out.isSquare());
        }
    }

    @Test
    public void testIsNotSquare() throws Exception {
        for(int i = 1; i < 100; i++) {
            Integer x = PrimitiveGenerators.positiveIntegers().next();

            Integer y = PrimitiveGenerators.positiveIntegers().next();
            while (x == y) {
                y = PrimitiveGenerators.positiveIntegers().next();
            }
            Rectangle out = new Rectangle(x, y);
            Assert.assertFalse(out.isSquare());
        }
    }

    @Test
    public void testIsSquareCharactestic() throws Exception {
        QuickCheck.forAllVerbose(100, PrimitiveGenerators.positiveIntegers(), new AbstractCharacteristic<Integer>() {
            @Override
            protected void doSpecify(Integer x) throws Throwable {
                Rectangle out = new Rectangle(x, x);
                Assert.assertTrue(out.isSquare());
            }
        });


    }
}