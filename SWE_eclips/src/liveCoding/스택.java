package liveCoding;

import java.util.Stack;

public class 스택 {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		
		System.out.println(st.isEmpty()+"/" + st.size());
		st.push("전웅재");
		st.push("킹왕짱");
		st.push("skdltm");
		System.out.println(st.isEmpty()+"/" + st.size());
		st.pop();
		System.out.println(st.isEmpty()+"/" + st.size());
		
	}
}
