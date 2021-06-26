"""
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 

우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 

A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.
"""
import sys
import heapq
INF = sys.maxsize
input = sys.stdin.readline

def dijkstra(start_cost,start_node):
    dist = [ INF for _ in range(n+1)]
    dist[start_node] = 0
    q = [(start_cost,start_node)]

    while q:
        
        p = heapq.heappop(q)
        cur_cost, cur_node = p[0], p[1]
        for next_cost, next_node in graph[cur_node]:
            if dist[next_node] > cur_cost + next_cost:
                dist[next_node] = cur_cost + next_cost
                heapq.heappush(q, (dist[next_node],next_node))
    return dist

# 도시 개수 n, 버스 개수 m
n = int(input().rstrip())
m = int(input().rstrip())

graph = [ [] for _ in range(n+1) ]

for _ in range(m):
    start,end,cost = map(int,input().rstrip().rsplit())
    graph[start].append((cost,end))

want1, want2 = map(int,input().rstrip().rsplit())
answer = dijkstra(0,want1)
print(answer[want2])