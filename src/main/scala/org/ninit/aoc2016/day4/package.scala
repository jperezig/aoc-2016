package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day4 {

  def read(input: String) = {
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.toVector.map(RoomParser(_))
  }

}
