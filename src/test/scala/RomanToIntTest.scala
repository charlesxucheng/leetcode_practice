class RomanToIntTest extends UnitSpec {

  "romanToInt" should {
    "convert single roman numerals to integers" in {
      val testData = Table(
        ("roman", "expected"),
        ("I", 1),
        ("V", 5),
        ("X", 10),
        ("L", 50),
        ("C", 100),
        ("D", 500),
        ("M", 1000)
      )

      forAll(testData) { (roman, expected) =>
        RomanToInt.romanToInt(roman) mustBe expected
      }
    }

    "convert multiple roman numerals with no subtractions required to integers" in {
      val testData = Table(
        ("roman", "expected"),
        ("II", 2),
        ("VII", 7),
        ("XI", 11),
        ("LXXX", 80),
        ("XXXXXX", 60),
        ("MMX", 2010)
      )

      forAll(testData) { (roman, expected) =>
        RomanToInt.romanToInt(roman) mustBe expected
      }
    }

    "convert special 2-symbol roman numerals that form one unit to integers" in {
      val testData = Table(
        ("roman", "expected"),
        ("IV", 4),
        ("IX", 9),
        ("XL", 40),
        ("XC", 90),
        ("CM", 900)
      )

      forAll(testData) { (roman, expected) =>
        RomanToInt.romanToInt(roman) mustBe expected
      }
    }

    "convert mixed roman numerals to integers" in {
      val testData = Table(
        ("roman", "expected"),
        ("IXXC", 99),
        ("MDCLXVI", 1666),
        ("VIII", 8),
        ("MCMXCIX", 1999),
        ("MMMCMXCIX", 3999),
        ("MDCCCLXXXIV", 1884)
      )

      forAll(testData) { (roman, expected) =>
        RomanToInt.romanToInt(roman) mustBe expected
      }
    }
  }
}
