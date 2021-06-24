from collections import deque

def bfs(n,k):
    if n == k :
        return 0,1
    if n > k :
        return n-k, 1

    q = deque([N])
    ways = [0]*100001
    # ways[j] : j 까지 오는 최소 time 으로 올 수 있는 방법의 수. 
    visited = [float('inf')] * 100001
    # visited[j] : j 까지 오는 최소 time 저장.

    t , flg = 0 , False
    ways[n] , visited[n] = 1 , 0
    while q and flg == False :
        size = len(q)

        for _ in range(size):
            now = q.popleft()
            
            next= [now -1,now +1 , now *2]
            # 다음에 갈 수 있는 후보군
            for i in next :
                if (0 <= i <= 100000) and t +1 <= visited[i] :
                # 수빈이의 이동(N) 범위 정해주기 && i 도착 최소 시간보다 작거나 같아야함.
                    ways[i] += 1
                    # i 까지 가는 방법 + 1
                    visited[i] = t + 1
                    # i 까지 가는 시간 = 지금까지의 시간(t) + 다음에 갈거니까(1) 

                    if i == k :
                    # 목표에 닿냐?
                        flg = True

                    if flg == False :
                    # 더가야함 = 지금 위치 넣어둠 = 마치 평행 세계
                        q.append(i) 
        # 다음 시간으로...
        t += 1

    return visited[k], ways[k]


N , K = map(int,input().split())
time , cnt = bfs(N,K)

print(time)
print(cnt)