package algo;

import java.util.Scanner;


class Node {
	int num;
	int left , right;
	String val;
	
	public Node(int num, int left, int right, String val) {
		super();
		this.num = num;
		this.left = left;
		this.right = right;
		this.val = val;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	
}

public class 사칙연산 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T ; tc++)
		{
			int N = sc.nextInt();
			
			for(int i = 0 ; i < N; i ++)
			{
				int num = sc.nextInt();
				String val = sc.next();
				int left= sc.nextInt();
				int right=sc.nextInt();
				
			}
			
		}
	}
}
