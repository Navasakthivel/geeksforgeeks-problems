/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> leftView(Node root) {
        // code here
         backtrack(root,1,res);
        return res;
    }
    public void backtrack(Node root,int level,List<Integer> res)
        {
            if(root == null)
            {
                return;
            }
            if(res.size() < level)
            {
                res.add(root.data);
            }
            backtrack(root.left,level+1,res);
            backtrack(root.right,level+1,res);
        }
}