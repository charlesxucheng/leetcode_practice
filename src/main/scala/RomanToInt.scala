import scala.annotation.tailrec

object RomanToInt {
  def romanToInt(s: String): Int =
    romanToIntRec(s.toList.map(c => Roman.valueOf(c.toString)), None, 0)

  @tailrec
  private def romanToIntRec(
      s: List[Roman],
      lastSpecialSymbol: Option[Roman],
      accValue: Int
  ): Int = {
    s match {
      case Nil =>
        val total = accValue + lastSpecialSymbol.map(_.value).getOrElse(0)
        total
      case head :: tail =>
        if (lastSpecialSymbol.isEmpty) {
          if (head == Roman.I || head == Roman.X || head == Roman.C) {
            romanToIntRec(tail, Some(head), accValue)
          } else romanToIntRec(tail, None, accValue + head.value)
        } else {
          val lastSymbol = lastSpecialSymbol.get
          if (calculateCombinationValue(lastSymbol, head) > 0)
            romanToIntRec(
              tail,
              None,
              accValue + calculateCombinationValue(lastSymbol, head)
            )
          else
            romanToIntRec(tail, Some(head), accValue + lastSymbol.value)
        }
    }
  }

  private def calculateCombinationValue(s1: Roman, s2: Roman): Int = {
    if (s1 == Roman.I && s2 == Roman.V) 4
    else if (s1 == Roman.I && s2 == Roman.X) 9
    else if (s1 == Roman.X && s2 == Roman.L) 40
    else if (s1 == Roman.X && s2 == Roman.C) 90
    else if (s1 == Roman.C && s2 == Roman.D) 400
    else if (s1 == Roman.C && s2 == Roman.M) 900
    else 0
  }

  private enum Roman(val value: Int) {
    case I extends Roman(1)
    case V extends Roman(5)
    case X extends Roman(10)
    case L extends Roman(50)
    case C extends Roman(100)
    case D extends Roman(500)
    case M extends Roman(1000)
  }
}
