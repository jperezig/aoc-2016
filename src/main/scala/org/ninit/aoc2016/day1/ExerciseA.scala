package org.ninit.aoc2016.day1

object ExerciseA extends App {
  private def updateDirection(direction: Direction, moveTo: MoveTo): Direction = direction match {
    case Up => if (moveTo == MoveToRight) Right else Left
    case Right => if (moveTo == MoveToRight) Down else Up
    case Down => if (moveTo == MoveToRight) Left else Right
    case Left => if (moveTo == MoveToRight) Up else Down
  }

  private def move(position: Position, moveTo: Movement): Position = {
    val updatedLookingAt = moveTo.direction match {
      case MoveToRight => updateDirection(position.lookingAt, MoveToRight)
      case MoveToLeft => updateDirection(position.lookingAt, MoveToLeft)
    }

    updatedLookingAt match {
      case Up => Position(updatedLookingAt, position.x, position.y + moveTo.length)
      case Right => Position(updatedLookingAt, position.x + moveTo.length, position.y)
      case Down => Position(updatedLookingAt, position.x, position.y - moveTo.length)
      case Left => Position(updatedLookingAt, position.x - +moveTo.length, position.y)
    }
  }

  private def distance(position: Position): Int = Math.abs(position.x) + Math.abs(position.y)

  private def run(input: String): Unit = {
    val position = read(input).foldLeft(Position(Up, 0, 0)) { (p, s) =>
      move(p, Movement(s))
    }
    print(distance(position))
  }

  run("/day1")

}
