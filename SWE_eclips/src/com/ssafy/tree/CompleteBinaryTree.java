package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
	}
	
	public void add(char c) 
	{
		if(lastIndex == SIZE) // 꽉찬 상황.
			return;
		nodes[++lastIndex] = c;
	}
	
	public void bfs()
	{
		//탐색을 기다리는 노드들이 저장 되어야함. -> 인덱스가 탐색해야할 노드를 탐색할 수 있게 해주기 때문. = 
		Queue<Integer> q = new LinkedList<>(); 
		q.add(1); // 루트 노드부터 먼저 넣어줘야함.
		
		while(!q.isEmpty())
		{
			int current = q.poll(); // 현재노드의 위치값이 들어있음. 
			System.out.print(nodes[current] + " ");
			if(current *2 <= lastIndex)// 왼쪽 자식이 있다면 넣어줌.
				q.add(current*2);
			if(current*2 +1 <= lastIndex) // 오른쪽 자식이 있다면 넣어줌.
				q.add(current*2+1);
			System.out.println();
		}
	}
	
	public void bfs2()
	{
		//탐색을 기다리는 노드들이 저장 되어야함. -> 인덱스가 탐색해야할 노드를 탐색할 수 있게 해주기 때문. = 
		Queue<Integer> q = new LinkedList<>(); 
		q.add(1); // 루트 노드부터 먼저 넣어줘야함.
		
		int current = 0 , lev = 0 , size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			System.out.print("level "+lev+" : ");
			
			while(--size >=0)
			{
				current = q.poll(); // 현재노드의 위치값이 들어있음. 
				System.out.print(nodes[current] + " ");
				if(current *2 <= lastIndex)// 왼쪽 자식이 있다면 넣어줌.
					q.add(current*2);
				if(current*2 +1 <= lastIndex) // 오른쪽 자식이 있다면 넣어줌.
					q.add(current*2+1);
				
			}
			System.out.println();
			++lev;
		}
	}
	
	public void dfsByPreOrder() 
	{
		System.out.println("PreOrder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	public void dfsByPreOrder(int curr) 
	{
		System.out.print(nodes[curr] + " "); // 현재 노드 처리 
		if(curr *2 <= lastIndex) // 왼쪽 자식 노드 방문.
			dfsByPreOrder(curr*2);
		if(curr*2+1 <= lastIndex) // 오른쪽 자식 노드 방문.
			dfsByPreOrder(curr*2+1);
	}
}
