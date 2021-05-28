# 도달할 수 있는 노드 개수, 최단 거리 중 가장 먼 노드와의 거리 찾기
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드의 개수, 간선의 개수, 시작 노드를 입력받기
n, m, start = map(int, input().split())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n + 1)]
# 최단 거리 테이블을 모두 무한으로 초기화
dis = [INF] * (n + 1)

for _ in range(m):
  x,y,z = map(int,input().split())
  graph[x].append((y,z))

def dijkstra(start):
  q = []
  heapq.heappush(q,(0,start)) # 시작 노드 최단 거리 = 0
  dis[start] = True # 방문 처리
  while q :
    now_dis,now = heapq.heappop() # 최단거리 가장 짧은 노드 꺼냄.
    if dis[now] < now_dis : 
      continue
    
    for i in graph[now]: # 인접한 노드 확인
      cost = now_dis + i[1] # 현재 노드 거쳐 다른 인접 노드 접근 거리 확인
      if cost < dis[i[0]] :
        dis[i[0]] = cost
        heapq.heappush(q,(cost,i[0]))

dijkstra(start)

cnt = 0 #도달할 수 있는 노드 개수
max_dis = 0 # 가장 먼 노드와의 최단 거리

for d in dis:
  if d != 1e9:
    cnt += 1
    max_dis = max(max_dis,d)

print(cnt -1, max_dis)

