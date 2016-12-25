package org.ninit.aoc2016.day6

object ExerciseA extends App {

  private def count(input: String, size: Int): String = {
    val data = read(input)
    List.range(0, size - 1).map { index =>
      data.map(_.charAt(index)).groupBy(identity).map(e => e._1 -> e._2.length).toVector.sortWith(_._2 > _._2)(0)._1
    }.mkString
  }

  println(count("/day6.test", 7))
}
