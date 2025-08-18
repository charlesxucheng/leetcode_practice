class SqrtTest extends UnitSpec {
  "Sqrt" when {
    "given 0" should {
      "return 0" in {
        Sqrt.mySqrt(0) mustBe 0
      }
    }

    "given 1" should {
      "return 1" in {
        Sqrt.mySqrt(1) mustBe 1
      }
    }

    "given 2" should {
      "return 1" in {
        Sqrt.mySqrt(2) mustBe 1
      }
    }

    "given 4" should {
      "return 2" in {
        Sqrt.mySqrt(4) mustBe 2
      }
    }

    "given 6" should {
      "return 2" in {
        Sqrt.mySqrt(6) mustBe 2
      }
    }

    "given 8" should {
      "return 2" in {
        Sqrt.mySqrt(8) mustBe 2
      }
    }

    "given 2147395599" should {
      "return 46339" in {
        Sqrt.mySqrt(2147395599) mustBe 46339
      }
    }
  }
}
