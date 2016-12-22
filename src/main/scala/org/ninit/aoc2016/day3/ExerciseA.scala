package org.ninit.aoc2016.day3

object ExerciseA extends App {

  println(readByRows("/day3").count(_.isPossible))
}
