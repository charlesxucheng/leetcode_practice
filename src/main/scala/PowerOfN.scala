import scala.annotation.tailrec

object PowerOfN {
  def myPow(x: Double, n: Int): Double = {
    @tailrec
    def myPowRec(x: Double, n: Int, acc: Double): Double = {
      if (n == 0) return acc
      if (n % 2 == 0) myPowRec(x * x, n / 2, acc)
      else myPowRec(x * x, n / 2, acc * x)
    }

    if (n < 0) 1 / myPowRec(x, -n, 1.0)
    else myPowRec(x, n, 1.0)
  }
}
