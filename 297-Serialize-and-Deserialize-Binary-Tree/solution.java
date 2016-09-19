/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	public String serialize(TreeNode root) {
		//idea is to use preorder traversal to trace the structure of the tree and even mark the null nodes with a 'n' to indicate termination of one certain path
		StringBuilder s = new StringBuilder();
		serialize(root, s);
		return s.substring(0,s.length()-1).toString();
	}

	public void serialize(TreeNode root, StringBuilder s){
		if(root==null){
			s.append("n,");
			return;
		}

		s.append(root.val+",");
		serialize(root.left, s);
		serialize(root.right, s);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] in = data.split(",");
		index = 0;
		return deserialize(in);
	}
	
	int index;
	public TreeNode deserialize(String[] in){
		if(index==in.length)
			return null;
		String curValue = in[index++];
		if(curValue.equals("n")){
			return null;
		}
		TreeNode cur = new TreeNode(Integer.parseInt(curValue));
		cur.left = deserialize(in);
		cur.right = deserialize(in);
		return cur;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));