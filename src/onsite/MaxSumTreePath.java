package onsite;

import java.util.*;

/*Company: AQR
 * 给一个tree和一个target sum，要求输出所有的任意相连的path,这条path的和是target sum。
 * Path可以拐弯的，比如左边的一串+当前根节点+右边的一串。就是很灵活，不一定是root到leaf。
 * find paths in a tree summing to a target value。
 */
public class MaxSumTreePath {
	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> findPath(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		buildPath(root, target, result);
		return result;
	}

	public Map<Integer, List<List<Integer>>> buildPath(TreeNode curr, int target, List<List<Integer>> result) {
		Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		if (curr == null) {
			return map;
		}
		if(!map.containsKey(curr.val)){
			map.put(curr.val, new ArrayList<List<Integer>>());
		}
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(curr.val);
		map.get(curr.val).add(temp);
		if (curr.val == target) {
			result.add(temp);
		}
		Map<Integer, List<List<Integer>>> l = buildPath(curr.left, target, result);
		Map<Integer, List<List<Integer>>> r = buildPath(curr.right, target, result);
		for (int left : l.keySet()) {
			if (r.containsKey(target - curr.val - left)) {
				for (List<Integer> llist : l.get(left)) {
					for (List<Integer> rlist : r.get(target - curr.val - left)) {
						List<Integer> toadd1 = new ArrayList<Integer>(llist);
						List<Integer> toadd2 = new ArrayList<Integer>(rlist);
						Collections.reverse(toadd2);
						toadd1.add(curr.val);
						toadd1.addAll(toadd2);
						result.add(toadd1);
					}
				}
			}
		}
		for (int left : l.keySet()) {
			int num = left + curr.val;
			if (num == target) {
				for (List<Integer> list : l.get(left)) {
					List<Integer> toadd = new ArrayList<Integer>(list);
					toadd.add(curr.val);
					result.add(toadd);
				}
			}
			if (!map.containsKey(num)) {
				map.put(num, new ArrayList<List<Integer>>());
			}
			for (List<Integer> list : l.get(left)) {
				List<Integer> toadd = new ArrayList<Integer>(list);
				toadd.add(curr.val);
				map.get(num).add(toadd);
			}
		}
		for (int right : r.keySet()) {
			int num = right + curr.val;
			if (num == target) {
				for (List<Integer> list : r.get(right)) {
					List<Integer> toadd = new ArrayList<Integer>(list);
					toadd.add(curr.val);
					Collections.reverse(toadd);
					result.add(toadd);
				}
			}
			if (!map.containsKey(num)) {
				map.put(num, new ArrayList<List<Integer>>());
			}
			for (List<Integer> list : r.get(right)) {
				List<Integer> toadd = new ArrayList<Integer>(list);
				toadd.add(curr.val);
				map.get(num).add(toadd);
			}
		}
		return map;
	}

	public void display(List<List<Integer>> list) {
		for (List<Integer> l : list) {
			for (int num : l) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
