package org.ninit.aoc2016

import org.ninit.aoc2016.day7.Ip7AddressParser.Ip7Address

import scala.io.{Codec, Source}

package object day7 {

  def isPalindrome(s: String): Boolean = s == s.reverse && s.charAt(0) != s.charAt(1)

  def read(input: String): Vector[Ip7Address] =
    Source.fromInputStream(getClass.getResourceAsStream(input), Codec.UTF8.name).
      getLines.map(Ip7AddressParser(_)).toVector
}
