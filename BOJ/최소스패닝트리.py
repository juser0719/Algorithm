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
