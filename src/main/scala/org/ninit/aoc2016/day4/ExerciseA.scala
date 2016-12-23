package org.ninit.aoc2016.day4

object ExerciseA extends App{

  println(read("/day4").filter(_.isReal).map(_.number).sum)
}
