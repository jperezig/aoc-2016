package org.ninit.aoc2016.day7

object ExerciseA extends App {

  private def containsPalindrome(entries: Iterator[String]): Boolean =
    entries.exists(isPalindrome)

  private def containsPalindrome(entries: List[String]): Boolean =
    entries.exists(s => containsPalindrome(s.sliding(4)))

  println(read("/day7").count { address =>
    !containsPalindrome(address.hypernet.map(_.v)) && containsPalindrome(address.values.map(_.v))
  })

}
