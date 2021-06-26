"""
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.

최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
"""
def find_parent(arr,x):
    if arr[x] != x:
        arr[x] = find_parent(arr,arr[x])
    return arr[x]

def union_parent(arr,x,y):
    x = find_parent(arr,x)
    y = find_parent(arr,y)
    if x<y :
        arr[y] = x
    else:
        arr[x] = y

V , E = map(int,input().split())
res = 0
edges = []

for _ in range(E):
    e = map(int,input().split())
    edges.append((e[0],e[1],e[2]))

edges.sort(key= lambda x : x[2])
parent = [i for i in range(V+1)]

for edge in edges:
    s,e,cost = edge

    if find_parent(parent,s) != find_parent(parent,e):
        union_parent(parent,s,e)
        res += cost
print(res)
