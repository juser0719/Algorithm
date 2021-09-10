package algorithm.BOJ.BF;

import java.util.Scanner;

public class 회문 {
	
	public static int isPallen(String s) {
		int size = s.length(), res = 0;
		int st = 0;
		int ed = size-1;
		
		while(st<=ed) {
			char st_c = s.charAt(st);
			char ed_c = s.charAt(ed);

			if(st_c == ed_c) {
				st++;
				ed--;
			}
			else{
				// 1 2
				int l = st;
				int e = ed;
				l++;
				res++;
				boolean left = true;
				boolean right= true;
				while(l<=e) {
					if(s.charAt(l) == s.charAt(e)) {
						l++;
						e--;
					}
					else {
						left = false;
						break;
					}
				}
				
				l = st;
				e = ed;
				e--;
				while(l<=e) {
					if(s.charAt(l) == s.charAt(e)) {
						l++;
						e--;
					}
					else {
						right = false;
						break;
					}
				}
				if(!left && !right) {
					res++; // 2
				}
				return res; 
				
			}
			
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb=  new StringBuilder();
		for(int tc = 1; tc<= T ; tc++) 
		{
			String str = sc.next();
			int state = isPallen(str);
			sb.append(state+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
