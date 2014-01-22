Examples 
========

There are examples of how to use different frameworks to test using QuickCheck. 

jUnit QuickCheck
================

There are simple tests that you can find at src/test/org/softwarfair/quickcheck/RectangleJunitQuickCheckTest.java

In order to test it you can simply execute mvn test -Dtest=RectangleJunitQuickCheckTest

java QuickCheck
===============
This case you can find the test under src/test/org/softwarfair/quickcheck/RectangleQuickCheckGeneratorTest.java

Again to execute them you can simply execute mvn test -Dtest=RectangleQuickCheckGeneratorTest

ScalaCheck
==========

Tests are located at  src/test/org/softwarfair/quickcheck/RectangleSpec.scala

In order to execute is not working (but should) as a normal maven project and you have to execute the following: mvn scala:run -Dlauncher=test