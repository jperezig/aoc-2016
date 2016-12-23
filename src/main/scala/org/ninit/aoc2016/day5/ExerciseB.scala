package org.ninit.aoc2016.day5

import scala.util.control.Breaks.{break, breakable}

object ExerciseB extends App {
  val inputCode = "reyedfim"

  var password = ("_" * 8).toCharArray
  breakable {
    for (index <- 0 to Int.MaxValue) {
      val m = md5(s"$inputCode$index")
      if (m.startsWith("00000")
        && m.charAt(5).isDigit
        && Integer.valueOf(m.charAt(5).toString) < 8
        && password(Integer.valueOf(m.charAt(5).toString)) == '_') {
        password(Integer.valueOf(m.charAt(5).toString)) = m.charAt(6)
        println(s"Found at index: $index. Password: '${password.mkString}'")
      }
      if (!password.mkString.contains("_")) break
    }
  }

  println(s"Finished. Pass:'${password.mkString}'")
}
