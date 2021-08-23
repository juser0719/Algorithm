package algo;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {
	
	public static String[] subset , chars;
	public static int L,C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		chars = new String[C];
		for(int i = 0 ; i < C ;i++)
			chars[i] = sc.next();
		Arrays.sort(chars);
		permitation("",0);
	}
	
	public static void permitation(String sub , int cnt)
	{
		if(sub.length() == L)
		{
			int ja = 0;
			int mo = 0;
			for (char x : sub.toCharArray())
			{
				if(x == 'a'|| x=='e'||x=='i'||x=='o'||x=='u')
					mo+=1;
				else
					ja+=1;
			}
			if(ja>=2 && mo>=1)
				System.out.println(sub.toString());
			return;
		}
		if (chars.length <= cnt) return;

		permitation(sub+chars[cnt],cnt+1);
		permitation(sub,cnt+1);
		
	}
}
