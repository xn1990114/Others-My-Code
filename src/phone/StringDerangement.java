package phone;
import java.util.*;

public class StringDerangement {
	public List<String> calDerangement(String s){
		List<String> result=new ArrayList<String>();
		int[] count=new int[256];
		Map<Character,Set<Integer>> indexes=new HashMap<Character,Set<Integer>>();
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			count[ch]++;
			if(!indexes.containsKey(ch)){
				indexes.put(ch, new HashSet<Integer>());
			}
			indexes.get(ch).add(i);
		}
		build(count,indexes,s.length(),"",result);
		return result;
	}
	public void build(int[] count,Map<Character,Set<Integer>> indexes,int targetLen,String curr,List<String> result){
		if(curr.length()==targetLen){
			result.add(curr);
			return;
		}
		for(int i=0;i<256;i++){
			if(count[i]==0){
				continue;
			}
			count[i]--;
			if(!indexes.get((char)i).contains(curr.length())){
				build(count,indexes,targetLen,curr+(char)(i),result);
			}
			count[i]++;
		}
	}
}
