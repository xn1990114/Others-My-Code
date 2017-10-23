package phone;
import java.util.*;
/*
 * Company: paypal
 * calculator with '+', '-', '*', "()"
 */
public class Calculator1 {
	public int calString(String s){
		Stack<Stack<Integer>> stack=new Stack<Stack<Integer>>();
		Stack<Character> signs=new Stack<Character>();
		char currSign='+';
		Stack<Integer> curr=new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				int start=i;
				while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
					i++;
				}
				int num=Integer.parseInt(s.substring(start,i+1));
				if(currSign=='*'){
					curr.push(curr.pop()*num);
				}
				else{
					curr.push((currSign=='-'?-1:1)*num);
				}
			}
			else if(s.charAt(i)=='('){
				stack.push(curr);
				if(i-1>=0&&(s.charAt(i-1)=='-'||s.charAt(i-1)=='*')){
					signs.push(s.charAt(i-1));
				}
				else{
					signs.push('+');
				}
				curr=new Stack<Integer>();
				currSign=' ';
			}
			else if(s.charAt(i)==')'){
				int num=calTotal(curr);
				curr=stack.pop();
				currSign=signs.pop();
				if(currSign=='*'){
					curr.push(curr.pop()*num);
				}
				else{
					curr.push((currSign=='-'?-1:1)*num);
				}
			}
			else{
				currSign=s.charAt(i);
			}
		}
		return calTotal(curr);
	}
	public int calTotal(Stack<Integer> curr){
		int res=0;
		while(!curr.isEmpty()){
			res=res+curr.pop();
		}
		return res;
	}
}
