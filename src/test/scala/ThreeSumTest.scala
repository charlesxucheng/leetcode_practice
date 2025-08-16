class ThreeSumTest extends UnitSpec {
  "Finding three sum" should {
    "return the expected result" in {
      val testData = Table(
        ("nums", "expected"),
        (Array(0, 0, 0), List(List(0, 0, 0))),
        (Array(-1, 0, 1, 2, -1, -4), List(List(-1, -1, 2), List(-1, 0, 1))),
        (Array(0, 1, 1), List()),
        (Array(1, 2, -2, -1), List()),
        (Array(1, -1, -1, 0), List(List(-1, 0, 1))),
        (Array(-2, 0, 1, 1, 2), List(List(-2, 0, 2), List(-2, 1, 1))),
        (Array(2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10), List(List(-10, 5, 5), List(-5, 0, 5), List(-4, 2, 2), List(-3, -2, 5), List(-3, 1, 2), List(-2, 0, 2)))
      )
      forAll(testData) { (nums, expected) =>
        ThreeSum.threeSum(nums) must contain theSameElementsAs expected
        ThreeSumSingleLoop.treeSum(nums) must contain theSameElementsAs expected
      }
    }
  }
}
