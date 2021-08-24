package liveCoding;

public class DisjoinSet {
	static int N;
	static int[] parents;
	
	public static void make_set()
	// 모든 원소를 자신을 대표자로 만듦.
	{
		for(int i = 0 ; i < N ; i++)
			parents[i] = i;
	}
	
	public static int find (int a)
	//a 가 속한 집합의 대표자 찾기.
	{
		if(a == parents[a]) return a; // 자신이 대표자임.
//		return find(parents[a]); 일반적인 방법으로 부모찾아옴,
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로.. : path compression -> 연산 쉽게 해줌.
	}
	
	public static boolean union(int a, int b)
	// 두 원소를 하나의 집합으로합치기.
	{
		int a_root = find(a);
		int b_root = find(b);
		if(a_root == b_root) return false; // 이미 같은 집합이므로 합치지 않음.
		
		parents[b_root] = a_root;
		// a_root 밑으로 b_root set 이 모두 흡수됨.
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		parents = new int[N];
		
		// 1. make set
		make_set();
	}
}
