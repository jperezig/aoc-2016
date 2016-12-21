package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day1 {

  sealed trait Direction

  case object Right extends Direction

  case object Left extends Direction

  case object Up extends Direction

  case object Down extends Direction

  sealed trait MoveTo

  case object MoveToLeft extends MoveTo

  case object MoveToRight extends MoveTo


  case class Position(lookingAt: Direction, x: Int, y: Int)

  case class Movement(direction: MoveTo, length: Int)

  def read(input: String): Vector[String] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.next.split(",").map(_.trim).toVector


  object Movement {
    def apply(input: String): Movement = input.trim.charAt(0) match {
      case 'R' => Movement(MoveToRight, Integer.parseInt(input.trim.substring(1)))
      case 'L' => Movement(MoveToLeft, Integer.parseInt(input.trim.substring(1)))
    }
  }

}
