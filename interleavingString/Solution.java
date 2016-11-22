
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Position>> isInterleave(String s1, String s2, String s3) {
	List<List<Position>> result = getPathFrom(s1, s2, s3, new Position(-1, -1));
	return result;
    }

    private List<List<Position>> getPathFrom(String s1, String s2, String s3, Position curr) {
	List<List<Position>> paths = new ArrayList<>();
	if (curr.x1 == s1.length()-1 && curr.x2 == s2.length()-1) {
	    List<Position> temp = new ArrayList<>();
	    temp.add(curr);
	    paths.add(temp);
	}
	else {
	    List<Position> next = getNext(s1.length(), s2.length(), curr);
	    for (Position pos : next) {
		if (getChar(s1, s2, curr, pos) == s3.charAt(pos.x1+pos.x2+1)) {
		    List<List<Position>> nextPath = getPathFrom(s1, s2, s3, pos);
		    for (List<Position> list : nextPath) {
			List<Position> cpy = new ArrayList<>(list);
			cpy.add(0, curr);
			paths.add(cpy);
		    }
		}
	    }
	}
	return paths;
    }

    private char getChar(String s1, String s2, Position curr, Position next) {
	if (curr.x1 == next.x1)
	    return s2.charAt(next.x2);
	if (curr.x2 == next.x2)
	    return s1.charAt(next.x1);
	return 'a';
    }
    
    private List<Position> getNext(int len1, int len2, Position curr) {
	List<Position> next = new ArrayList<>();
	if (curr.x1 < len1-1)
	    next.add(new Position(curr.x1+1, curr.x2));
	if (curr.x2 < len2-1)
	    next.add(new Position(curr.x1, curr.x2+1));
	return next;
    }

    public static void main(String[] args) {
	String s1 = "aabcc", s2 = "dbbca";
	String s3 = "aadbbcbcac";
	// String s3 = "aadbbbaccc";
	
	Solution soln = new Solution();
	List<List<Position>> result = soln.isInterleave(s1, s2, s3);
	if (!result.isEmpty()) {
	    System.out.println("All possible paths are:");
	    for (List<Position> list : result) {
		for (int i = 0; i < list.size()-1; i++)
		    System.out.print(list.get(i)+"->");
		System.out.println(list.get(list.size()-1));
	    }
	}
	else
	    System.out.println("There is no such path!");
    }
}
