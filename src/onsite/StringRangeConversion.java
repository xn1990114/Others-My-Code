package onsite;
/*
 * company: ve-ri-tas
 * 给一个string(只可能含有26个字母)和一个vector<string>，要求依次完成vector内string代表的指令，
 * 指令格式为"a b s"，其中a和b是int，代表需要modify的string的index range [a,b]，s是char，
 * 可能是'L'或'R'，如果是L则将index range内的每一个字母向左变换（a变为z，b变为a，等等）。
 * 例如string是abc，则若vector[0]是0 0 L，那么完成第一个指令后string变为zbc。
 * 
 */
public class StringRangeConversion {
	public String convertString(String s,String[][] ops){
		int[] changes=new int[s.length()+1];
		for(int i=0;i<ops.length;i++){
			int start=Integer.parseInt(ops[i][0]);
			int end=Integer.parseInt(ops[i][1]);
			String last=ops[i][2];
			int dir=last.equals("L")?-1:1;
			changes[start]=changes[start]+dir;
			changes[end+1]=changes[end+1]-dir;
		}
		StringBuilder sb=new StringBuilder();
		int currChange=0;
		for(int i=0;i<s.length();i++){
			currChange=currChange+changes[i];
			char ch=(char)((s.charAt(i)-'a'+26+currChange)%26+'a');
			sb.append(ch);
		}
		return sb.toString();
	}
}
