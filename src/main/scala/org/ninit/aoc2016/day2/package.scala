package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day2 {

  sealed trait MoveTo

  case object Right extends MoveTo

  case object Left extends MoveTo

  case object Up extends MoveTo

  case object Down extends MoveTo

  case object None extends MoveTo

  object MoveTo {
    def apply(c: Char) = c match {
      case 'U' => Up
      case 'D' => Down
      case 'L' => Left
      case 'R' => Right
      case _ => throw new IllegalArgumentException(s"Unsupported movement $c")
    }
  }

  def read(input: String) =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.map(_.map(MoveTo(_)).toVector).toVector

}
