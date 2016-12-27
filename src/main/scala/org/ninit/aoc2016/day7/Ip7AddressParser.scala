package org.ninit.aoc2016.day7

import scala.collection.mutable.ListBuffer
import scala.util.parsing.combinator.RegexParsers

object Ip7AddressParser extends RegexParsers {

  case class Ip7Address(values: List[Value], hypernet: List[Hypernet])

  case class Value(v: String)
  case class Hypernet(v: String)



  private def values: Parser[Value] = """[a-z]+""".r ^^ { Value(_) }

  private def hypernet: Parser[Hypernet] = "[" ~ values ~ "]" ^^ { p => Hypernet(p._1._2.v) }

  private def parse = ((values | hypernet) +) ^^ { l =>
    val values = new ListBuffer[Value]
    val hypernets = new ListBuffer[Hypernet]
    l.map {
      case h: Hypernet => hypernets += h
      case v: Value => values += v
    }
    Ip7Address(values.toList, hypernets.toList)
  }

  def apply(input: String) = {
    parseAll(parse, input) match {
      case Success(result, _) => result
      case failure: NoSuccess => scala.sys.error(failure.msg)
    }
  }
}