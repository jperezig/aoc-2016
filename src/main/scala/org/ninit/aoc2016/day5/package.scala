package org.ninit.aoc2016

import java.security.MessageDigest

package object day5 {

  private val digest = MessageDigest.getInstance("MD5")

  def md5(input: String) = digest.digest(input.getBytes).map("%02x".format(_)).mkString
}
