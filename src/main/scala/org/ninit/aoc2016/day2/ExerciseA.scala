package org.ninit.aoc2016.day2

object ExerciseA extends App {

  case class Position(x: Int, y: Int) {
    require(x >= 0 && x < 3 && y >= 0 && y < 3)
    val Min = 0
    val Max = 2

    def moveTo(moveTo: MoveTo): Position = moveTo match {
      case Up => Position(x, Math.min(y + 1, Max))
      case Right => Position(Math.min(x + 1, Max), y)
      case Down => Position(x, Math.max(y - 1, Min))
      case Left => Position(Math.max(x - 1, Min), y)
    }

    def toNumber: Int = (x, y) match {
      case (0, 2) => 1
      case (1, 2) => 2
      case (2, 2) => 3
      case (0, 1) => 4
      case (1, 1) => 5
      case (2, 1) => 6
      case (0, 0) => 7
      case (1, 0) => 8
      case (2, 0) => 9
      case (_, _) => throw new IllegalArgumentException(s"Not valid position x:$x, y:$y")
    }
  }

  def run(input: String): Unit = {
    var initialPosition = Position(1, 1)
    read(input).foreach { v =>
      val l = v.foldLeft(initialPosition)((p, s) => p.moveTo(s))
      print(l.toNumber)
      initialPosition = l
    }
  }

  run("/day2")
}
