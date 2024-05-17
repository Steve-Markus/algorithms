public class ConvertSortedArrayToBinarySearchTree {

  public static void main(String[] args) {
    // read input
    int[] nums = {-10, -3, 0, 5, 9};
    TreeNode root = sortedArrayToBST(nums);
    printTree(root);
  }

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static TreeNode sortedArrayToBST(int[] nums) {
    return createBst(nums, 0, nums.length - 1);
  }

  private static TreeNode createBst(int[] nums, int l, int r) {
    if (l > r) {
      return null; // base case
    }

    int mid = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = createBst(nums, l, mid - 1);
    root.right = createBst(nums, mid + 1, r);

    return root;
  }

  private static void printTree(TreeNode root) {
    System.out.println(root.val);
    if (root.left != null) {
      printTree(root.left);
    }
    if (root.right != null) {
      printTree(root.right);
    }
  }
}
