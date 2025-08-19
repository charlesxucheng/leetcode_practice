object HammingWeight {
  def hammingWeight(n: Int): Int = {
    var count = 0
    var num = n
    while (num != 0) {
      num = num & (num - 1)
      count += 1
    }
    count
  }
}
