package org.ninit.aoc2016.day7

import org.ninit.aoc2016.day7.Ip7AddressParser.Ip7Address

object ExerciseB extends App {

  private def extractReversedPalindrome(entries: List[String]): List[String] =
    entries.flatMap(a => a.sliding(3).filter(isPalindrome).map(reversePalindrome))

  private def reversePalindrome(string: String): String = {
    s"${string.charAt(1)}${string.charAt(0)}${string.charAt(1)}"
  }

  private def inHypernet(s: String, address: Ip7Address): Boolean =
    address.hypernet.map(_.v).exists(_.contains(s))

  println(read("/day7").count { address =>
    extractReversedPalindrome(address.values.map(_.v)).exists(inHypernet(_, address))
  })

}
