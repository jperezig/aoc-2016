package org.ninit.aoc2016.day1


object ExerciseB extends App {

  private def updateDirection(direction: Direction, moveTo: MoveTo): Direction = direction match {
    case Up => if (moveTo == MoveToRight) Right else Left
    case Right => if (moveTo == MoveToRight) Down else Up
    case Down => if (moveTo == MoveToRight) Left else Right
    case Left => if (moveTo == MoveToRight) Up else Down
  }

  private def move(position: Position, moveTo: Movement): Vector[Position] = {
    val updatedLookingAt = moveTo.direction match {
      case MoveToRight => updateDirection(position.lookingAt, MoveToRight)
      case MoveToLeft => updateDirection(position.lookingAt, MoveToLeft)
    }

    updatedLookingAt match {
      case Up => Vector.range(1, moveTo.length + 1).map(l => Position(updatedLookingAt, position.x, position.y + l))
      case Right => Vector.range(1, moveTo.length + 1).map(l => Position(updatedLookingAt, position.x + l, position.y))
      case Down => Vector.range(1, moveTo.length + 1).map(l => Position(updatedLookingAt, position.x, position.y - l))
      case Left => Vector.range(1, moveTo.length + 1).map(l => Position(updatedLookingAt, position.x - l, position.y))
    }
  }

  private def distance(position: Position): Int = Math.abs(position.x) + Math.abs(position.y)

  private def run(input: String): Unit = {
    val viewPositions = scala.collection.mutable.Set[(Int, Int)]((0, 0))
    val position = read(input).foldLeft(Position(Up, 0, 0)) { (p, s) =>
      val steps = move(p, Movement(s))
      steps.foreach { pos =>
        if (!viewPositions.add((pos.x, pos.y))) println(s"$pos => ${distance(pos)}")
      }
      steps.last
    }
    print(distance(position))
  }

  run("/day1")

}
