package org.ninit.aoc2016

import scala.io.{Codec, Source}

package object day3 {

  case class Triangle(s1: Int, s2: Int, s3: Int) {

    def isPossible: Boolean =
      s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1
  }

  object Triangle {
    def apply(s1: String, s2: String, s3: String): Triangle =
      Triangle(Integer.valueOf(s1), Integer.valueOf(s2), Integer.valueOf(s3))

    def apply(sides: Array[String]): Triangle = {
      require(sides.length == 3)
      Triangle(sides(0), sides(1), sides(2))
    }
  }

  def createTriangles(rows: Vector[String]) = {
    val elements = rows.map(_.trim.split(" +"))
    Vector(
      Triangle(elements(0)(0), elements(1)(0), elements(2)(0)),
      Triangle(elements(0)(1), elements(1)(1), elements(2)(1)),
      Triangle(elements(0)(2), elements(1)(2), elements(2)(2))

    )
  }

  def readByRows(input: String): Vector[Triangle] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.map(line => Triangle(line.trim.split(" +"))).toVector


  def readByColumns(input: String): Vector[Triangle] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.grouped(3).map(l => createTriangles(l.toVector)).toVector.flatten

}
