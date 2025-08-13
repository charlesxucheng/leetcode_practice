object Fibonacci {
  def fib(n: Int): Int = {
    require(n >= 0 && n <= 30)
    var fib1 = 0
    var fib2 = 1
    var fib = 0
    if (n == 0 || n == 1) n
    else {
      for (i <- 2 to n) {
        fib = fib1 + fib2
        fib1 = fib2
        fib2 = fib
      }
      fib
    }
  }
}
