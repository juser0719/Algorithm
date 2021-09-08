package algorithm.BOJ.BF;

import java.util.Scanner;

public class 회문 {
	
	public static int isPallen(String s) {
		int size = s.length(), res = 0;
		int st = 0;
		int ed = size-1;
		while(st<ed) {
			char st_c = s.charAt(st);
			char ed_c = s.charAt(ed);

			if(st_c != ed_c) {
				int ns = st+1;
				int ne = ed-1;
				if(ns < ed && s.charAt(ns) == s.charAt(ed)) {
					st++;
					res= 1;
					continue;
				}
				if (st < ne && s.charAt(st) == s.charAt(ne)) {
					ed--;
					res = 1;
					continue;
				}
				res = 2;
				break;
				
			}
			
			st++;
			ed--;
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
			if(state == 0) {
				sb.append("0\n");
				continue;
			}else {
				if(state == 1)
				{
					sb.append("1\n");
					continue;
				}else
					sb.append("2\n");
					continue;
			}
		}
		
		System.out.println(sb.toString());
	}
}
