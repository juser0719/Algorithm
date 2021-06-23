from collections import deque

def bfs(n,k):
    if n == k :
        return 0,1
    if n > k :
        return n-k, 1
    q = deque([N])
    ways = [0]*100001
    visited = [int('inf')] * 10001

N , K = map(int,input().split())
time , cnt = bfs(N,K)
print(time,cnt)