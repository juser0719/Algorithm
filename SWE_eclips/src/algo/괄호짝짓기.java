package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기 {
	
	private static char[] chars;
	private static char[] open = {'(','[','{','<'};

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc =1; tc <= 10 ; tc ++) 
		{
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			chars = s.toCharArray();
			
			Stack<Character> st = new Stack<>();
			st.push(chars[0]);
			int idx = 1;
			int res = 1;
			while(!st.isEmpty())
			{
				if(")]}>".contains(Character.toString(chars[idx]))) // 닫는 모션 나오면 지금 스택 팝해서 맞춰봄.
				{
					char last_ = st.peek();
					int  this_idx = ")]}>".indexOf(Character.toString(chars[idx]));

					if(last_ != open[this_idx]) // 적절한 짝이 아니면 break
					{
						res = 0;
						break;
					}else { // 적절한 짝이면 pop 
						st.pop();
					}
					
				} else { // 닫는거 아니면 스택에 추가 
					st.add(chars[idx]);
				}
				
				
				idx++;
				
				
			}
			
			System.out.printf("#%d %d\n",tc,res);
			
		}
		
		
		
	}
}
