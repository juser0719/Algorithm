package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 계산기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1 ; tc<=10; tc ++)
		{
			int N = Integer.parseInt(br.readLine());
			String midfix = br.readLine();
			String postfix = "";
			
			Stack<Character> op = new Stack<Character>();
			Stack<Integer> num = new Stack<Integer>();
			// 중위에서 후위로. but +,* 한정.
			for(int i  =0 ; i < N ; i++)
			{
				char c = midfix.charAt(i);
				if( '0'<=c && c <= '9')
					postfix+=c;
				else 
				{
					if(c == '*') op.push(c); // 우선 순위가 더 높으니까 바로 붙여줌. 
					else // + 일경우  
					{
						while(!op.isEmpty() && (op.peek() =='*'|| op.peek() == '+')) // 낮은게 분명해서 기존에 넣어뒀던 * 먼저 하기 위해 후위연산에 붙여줌.
						{
							postfix +=op.pop();
						}
						op.push(c); // 그후 + 넣어줌.
					}
					
				}
			}
			while(!op.isEmpty()) postfix +=op.pop(); // 남은 연산자들 넣어줌.
			
//			System.out.println(postfix.toString());
			// 후위연산 계산.
			for(int i =0  ; i < N ; i++)
			{
				char c = postfix.charAt(i); 
				if( '0'<=c && c <= '9')
					num.add(c - '0');
				else 
				{
					int num1 = num.pop();
					int num2 = num.pop();
					if(c == '*') num.push(num1*num2);
					else num.push(num1+num2);
				}
			}
			
			System.out.printf("#%d %d\n",tc,num.pop());
		}
	}
	// 다른 연산자 넣을꺼면 여기서 우선순위 비교해주면 됨. 
	public static boolean check(char op1 , char op2)
	{
		int num1 = 0, num2 = 0;
		if(op1 == '*')
			num1 = 1;
		if(op2 == '*')
			num2 = 1;
		return num1>= num2;
	}
}
