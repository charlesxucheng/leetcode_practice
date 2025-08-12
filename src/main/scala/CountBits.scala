object CountBits {
  def countBits(n: Int): Array[Int] = {
    val result = Array.fill(n + 1)(0)
    for (i <- 1 to n) {
      result(i) = result(i & (i - 1)) + 1
    }
    result
  }
}
