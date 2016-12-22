package org.ninit.aoc2016.day2

sealed trait Position {
  def moveTo(moveTo: MoveTo): Position
}

case object One extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Down => Three
    case _ => One
  }
}

case object Two extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Right => Three
    case Down => Six
    case _ => Two
  }
}

case object Three extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => One
    case Left => Two
    case Right => Four
    case Down => Seven
    case None => Three
  }
}

case object Four extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Left => Three
    case Down => Eight
    case _ => Four
  }
}

case object Five extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Right => Six
    case _ => Five
  }
}

case object Six extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Two
    case Left => Five
    case Right => Seven
    case Down => A
    case None => Six
  }
}

case object Seven extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Three
    case Left => Six
    case Right => Eight
    case Down => B
    case None => Seven
  }
}

case object Eight extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Four
    case Left => Seven
    case Right => Nine
    case Down => C
    case None => Eight
  }
}

case object Nine extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Left => Eight
    case _ => Nine
  }
}

case object A extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Six
    case Right => B
    case _ => A
  }
}

case object B extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Seven
    case Left => A
    case Right => C
    case Down => D
    case None => B
  }
}

case object C extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => Eight
    case Left => B
    case _ => C
  }
}

case object D extends Position {
  override def moveTo(moveTo: MoveTo): Position = moveTo match {
    case Up => B
    case _ => D
  }
}


object ExerciseB extends App {
  def run(input: String): Unit = {
    var initialPosition = Five.moveTo(None)
    read(input).foreach { v =>
      val l = v.foldLeft(initialPosition)((p, s) => p.moveTo(s))
      print(l)
      initialPosition = l
    }
  }


  run("/day2")
}
