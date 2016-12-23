package org.ninit.aoc2016.day4

object ExerciseB extends App{

  println(read("/day4").filter(_.isReal).map(_.decrypt).filter(_.letters.contains("north")))

}
