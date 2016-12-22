package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day3 {

  case class Triangle(s1: Int, s2: Int, s3: Int) {

    def isPossible: Boolean =
      s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1
  }

  object Triangle {
    def apply(sides: Array[String]): Triangle = {
      require(sides.length == 3)
      Triangle(Integer.valueOf(sides(0)), Integer.valueOf(sides(1)), Integer.valueOf(sides(2)))
    }
  }


  def read(input: String): Vector[Triangle] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.map(line => Triangle(line.trim.split(" +"))).toVector

}
