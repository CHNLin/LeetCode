public class minDiffInBST {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        private int[] res = new int[110];
        private int count = 0;
        public void serch_Tree(TreeNode t){
            if(t == null){
                return;
            }else{
                serch_Tree(t.left);
                res[count] = t.val;
                count++;
                serch_Tree(t.right);
            }
        }


        public int MY_minDiffInBST(TreeNode root) {
            //搜索树即中序遍历
            serch_Tree(root);
            int temp = 999999;
            for(int i = 0; i < count-1; i++){
                if(res[i+1] - res[i] < temp){
                    temp = res[i+1] - res[i];
                }
            }
            return temp;
        }
    }
}
