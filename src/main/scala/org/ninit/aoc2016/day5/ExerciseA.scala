package org.ninit.aoc2016.day5

import util.control.Breaks._

object ExerciseA extends App {

  val inputCode = "reyedfim"

  var password = ""
  breakable {
    for (index <- 0 to Int.MaxValue) {
      val m = md5(s"$inputCode$index")
      if (m.startsWith("00000")) {
        password = password.concat(m.charAt(5).toString)
        println(s"Found at index: $index. Password: '$password'")
      }
      if (password.length == 8) break
      if (index % 10000 == 0) println(s"Trying with index $index .....(Current password '$password')")
    }
  }

  println(s"Finished. Pass:'$password'")

}
