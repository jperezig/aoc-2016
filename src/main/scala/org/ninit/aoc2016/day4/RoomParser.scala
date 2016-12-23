package org.ninit.aoc2016.day4

import scala.util.parsing.combinator.RegexParsers

case class RoomCode(letters: String, number: Int, checksum: String) {

  def isReal: Boolean = {
    val popularLetters =
      letters.replaceAll("-", "").groupBy(identity).map(v => (v._1, v._2.length)).toVector.
        sortBy(e => (-e._2, e._1)).map(_._1).mkString
    popularLetters.startsWith(checksum)
  }

  def decrypt: RoomCode = {
    val v = letters.split("-").map(_.map { c =>
      (((c.toInt - 'a'.toInt + number) % 26) + 'a'.toInt).toChar
    }).mkString(" ")
    RoomCode(v, number, checksum)
  }
}

object RoomParser extends RegexParsers {

  private def word: Parser[String] = """(([a-z]+)-)+""".r ^^ { _.toString }

  private def checksum: Parser[String] = """[a-z]+""".r ^^ { _.toString }

  private def number: Parser[Int] = """[0-9]+""".r ^^ {Integer.valueOf(_).toInt}

  private def roomCode: Parser[RoomCode] = word ~  number ~ "[" ~ checksum ~ "]" ^^ {
    case w ~ n ~ _ ~ c ~ _ => RoomCode(w, n, c)
  }

  def apply(input: String): RoomCode = {
    parseAll(roomCode, input) match {
      case Success(result, _) => result
      case failure: NoSuccess => scala.sys.error(failure.msg)
    }
  }
}