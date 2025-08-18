object Sqrt {
  def mySqrt(x: Int): Int = {
    if (x == 0 || x == 1) return x
    var left = 0
    var right = x
    var mid = 0
    while (left <= right) {
      mid = left + (right - left) / 2
      val result = x / mid
      if (result < mid) right = mid - 1
      else if (result > mid) left = mid + 1
      else return mid
    }
    if (x / mid < mid) mid - 1 else mid
  }
}
