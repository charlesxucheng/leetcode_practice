case class MyTreeNode(
    value: Int,
    left: Option[MyTreeNode],
    right: Option[MyTreeNode]
)

class TreeNode(
    _value: Int = 0,
    _left: TreeNode = null,
    _right: TreeNode = null
) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
