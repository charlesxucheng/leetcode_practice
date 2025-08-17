class ParenthesisGenerationTest extends UnitSpec {
  "Parenthesis generation" should {
    "return the expected result" in {
      val testData = Table(
        ("n", "expected"),
        (0, List()),
        (1, List("()")),
        (2, List("()()", "(())")),
        (3, List("((()))", "(()())", "(())()", "()(())", "()()()"))
      )
      forAll(testData) { (n, expected) =>
        ParenthesisGeneration.generateParenthesis(
          n
        ) must contain theSameElementsAs expected
      }
    }
  }

}
