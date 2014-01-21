package org.softwarfair.quickcheck;

import net.java.quickcheck.Generator;
import net.java.quickcheck.QuickCheck;
import net.java.quickcheck.characteristic.AbstractCharacteristic;
import net.java.quickcheck.generator.CombinedGenerators;
import net.java.quickcheck.generator.PrimitiveGenerators;
import net.java.quickcheck.generator.iterable.Iterables;
import org.testng.Assert;
import org.testng.annotations.Test;

class RandomRectangleGenerator implements net.java.quickcheck.Generator<Rectangle>{
    Generator<Integer> x = PrimitiveGenerators.positiveIntegers();
    Generator<Integer> y = PrimitiveGenerators.positiveIntegers();

    @Override public Rectangle next() {
        return new Rectangle(x.next(), y.next());
    }
}

class SquareRectangleGenerator implements net.java.quickcheck.Generator<Rectangle>{
    Generator<Integer> side = PrimitiveGenerators.positiveIntegers();

    @Override public Rectangle next() {
        Integer next = side.next();
        return new Rectangle(next, next);
    }
}

class NonSquareRectangleGenerator implements net.java.quickcheck.Generator<Rectangle>{
    Generator<Integer> side = CombinedGenerators.uniqueValues(PrimitiveGenerators.positiveIntegers());

    @Override public Rectangle next() {
        return new Rectangle(side.next(), side.next());
    }
}

public class RectangleQuickCheckGeneratorTest {


    @Test
    public void classic() {
        QuickCheck.forAll(new RandomRectangleGenerator(), new AbstractCharacteristic<Rectangle>() {
            @Override
            protected void doSpecify(Rectangle any) throws Throwable {
                Assert.assertEquals(any.area(), any.getHeight()*any.getWidth());
            }
        });
    }
    @Test
    public void testArea() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new RandomRectangleGenerator())) {
            Assert.assertEquals(rectangle.getHeight() * rectangle.getWidth(), rectangle.area());
        }
    }

    @Test
    public void testIsSquare() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new SquareRectangleGenerator())) {
            Assert.assertTrue(rectangle.isSquare());
        }
    }

    @Test
    public void testIsNotSquare() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new NonSquareRectangleGenerator())) {
            Assert.assertFalse(rectangle.isSquare());
        }
    }

    @Test
    public void testAreaAdded2() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new RandomRectangleGenerator())) {
            int n = 2;
            long area = (rectangle.getHeight()+n)*(rectangle.getWidth()+n);
            rectangle.add(n);
            Assert.assertEquals(area, rectangle.area());
        }
    }

    @Test
    public void testAreaAddedN() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new RandomRectangleGenerator())) {
            int max = Integer.MAX_VALUE / Math.max(rectangle.getHeight(), rectangle.getWidth());
            Integer n = PrimitiveGenerators.positiveIntegers(max).next();
            long area = (rectangle.getHeight()+n)*(rectangle.getWidth()+n);
            rectangle.add(n);
            Assert.assertEquals(area, rectangle.area());
        }
    }

    @Test
    public void testHypotenuseAdded() throws Exception {
        for (Rectangle rectangle : Iterables.toIterable(new SquareRectangleGenerator())) {
            int max = Integer.MAX_VALUE - Math.max(rectangle.getHeight(), rectangle.getWidth());
            Integer n = PrimitiveGenerators.positiveIntegers(max).next();
            Rectangle square = new Rectangle(n, n);
            double expected = square.hypotenuse() + rectangle.hypotenuse();
            rectangle.add(n);

            Assert.assertEquals(rectangle.hypotenuse(), expected, 10);
        }
    }
}