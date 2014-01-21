package org.softwarfair.quickcheck.scala

import org.scalacheck._
import org.scalacheck.Prop._
import org.specs.{Specification, ScalaCheck}
import org.softwarfair.quickcheck.Rectangle


/**
 * In this example, the arbitrary generator is kept in a separate object, but the generator and
 * arbitrary code are exactly the same as when using "pure" ScalaCheck
 */
object RectangleGenerator {
  // generator for the Rectangle case class
  val arbRectangleGen:Gen[Rectangle] = for {
    height <- Gen.choose(0,9999)
    width <- Gen.choose(0,9999)
  } yield(new Rectangle(width, height))

  // Arbitrary generator of rectangles
  implicit val arbRectangle: Arbitrary[Rectangle] = Arbitrary(arbRectangleGen)
}

object RectangleProperties extends Properties("Rectangle") {
  import RectangleGenerator._
  property("area") = forAll { (x:Int, y:Int) =>
    (x >= 0 && y >= 0) ==> {
      val rectangle = new Rectangle(math.abs(x),math.abs(y))
      rectangle.area == x*y
      }
  }

  property("area with generator") = forAll{ (rect:Rectangle) =>
    rect.area == rect.getHeight * rect.getWidth
  }
  
  property("hypotenouse of square + int == sum hypotenouses ") = forAll {
    (rect:Rectangle, side:Int) => {
      val square = new Rectangle(side, side).hypotenuse()
      val previousHypotenouse =  rect.hypotenuse()
      rect.add(side)
      square + previousHypotenouse  == rect.hypotenuse()
    } 
  }

}

/**
 * Used for running the tests from the command line, as there are no JUnit
 * compatible runners for ScalaCheck (could be done if ScalaCheck is used
 * from ScalaTest
 */
object Runner {
  import org.softwarfair.quickcheck._
  val rnd = new java.util.Random(100)
  val params = org.scalacheck.Test.Params(75, 500, 0, 20, rnd, 1)

  def apply() = {
    RectangleProperties.check(params)
  }

  def main(args: Array[String]) = apply()

}
