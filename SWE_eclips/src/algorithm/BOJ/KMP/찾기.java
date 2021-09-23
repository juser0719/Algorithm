package algorithm.BOJ.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 찾기 {
	
	static int cnt = 0;
	static ArrayList<Integer> pos = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		KMP(T,P);
		System.out.printf("%d\n",cnt);
		for(int i : pos)
		{
			System.out.println(i);
		}
		
	}
	
	static int[] makeTable(char[] pattern) {
		int p_size = pattern.length;
		int[] table = new int[p_size];
		int j =0;
		
		for(int i = 1; i < p_size; i++) 
		{
			while(j>0 && pattern[i] != pattern[j]) 
			{
				j = table[j-1];
			}
			if(pattern[i] == pattern[j])
				table[i] = ++j;
		}
		return table;
	}
	
	static void KMP (char[] parent, char[] pattern) {
		int[] table = makeTable(pattern);
		int parentSize = parent.length;
		int patternSize= pattern.length;
		int j  = 0;
		for(int i = 0; i < parentSize; i++)
		{
			while(j > 0 && parent[i] != pattern[j]) 
			{
				j = table[j-1];
			}
			if(parent[i] == pattern[j]) 
			{
				if( j == patternSize -1)
				{
					cnt++;
					pos.add( i - patternSize +2);
//					System.out.printf("%d 에서 찾았습니다.\n", i - patternSize +2);
					j = table[j];
				} else 
					j++;
			}
		}
	}
}
