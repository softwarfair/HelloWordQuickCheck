Examples 
========

There are examples of how to use different frameworks to test using QuickCheck. 

This examples are the base for http://softwarfair.wordpress.com/2014/01/22/quickcheck-en-la-jvm/

As you will probably guess you can directly import the project in Idea, working from version 13

jUnit QuickCheck
================


There are simple tests that you can find at [src/test/org/softwarfair/quickcheck/RectangleJunitQuickCheckTest.java](src/test/org/softwarfair/quickcheck/RectangleJunitQuickCheckTest.java)

In order to test it you can simply execute 

    mvn test -Dtest=RectangleJunitQuickCheckTest

java QuickCheck
===============
This case you can find the test under [src/test/org/softwarfair/quickcheck/RectangleQuickCheckGeneratorTest.java](src/test/org/softwarfair/quickcheck/RectangleQuickCheckGeneratorTest.java)

Again to execute them you can simply execute 

    mvn test -Dtest=RectangleQuickCheckGeneratorTest

ScalaCheck
==========

Tests are located at [src/test/org/softwarfair/quickcheck/RectangleSpec.scala](src/test/org/softwarfair/quickcheck/RectangleSpec.scala) 

In order to execute is not working (but should) as a normal maven project and you have to execute the following: 

    mvn scala:run -Dlauncher=test
    

 

   
