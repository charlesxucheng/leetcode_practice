class PowerOfNTest extends UnitSpec {
    "Power of N" should {
        "return the expected result" in {
            val testData = Table(
              ("x", "n", "expected"),
              (1.0, -27325343, 1.0),
              (2.0, 10, 1024.0),
              (2.0, 3, 8.0),
              (2.0, -2, 0.25),
              (2.0, -3, 0.125),
              (0.0, 0, 1.0),
              (3.0, 0, 1.0),
              (253434.0, 0, 1.0),
              (2.0, -2147483648, 0.0),
            )
            forAll(testData) { (x, n, expected) =>
              PowerOfN.myPow(x, n) mustBe expected
            }
        }
    }

}
