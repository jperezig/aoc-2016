package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day6 {

  def read(input: String): Vector[String] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).getLines.toVector
}
