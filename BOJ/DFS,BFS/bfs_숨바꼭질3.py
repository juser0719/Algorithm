from collections import deque

def bfs(n,k):
    if n > k :
        return n-k

    q = deque([N])
    visited = [float('inf')] * 100001
    # visited[j] : j 까지 오는 최소 time 저장.

    flg = False
    visited[n] = 0
    while q and flg == False :
        size = len(q)
        
        for _ in range(size):
            now = q.popleft()
            

            if ( 0<=now*2 <= 100000) and visited[now] < visited[now*2]:
            # 당장 n*2 가는 경우 생각
                visited[now*2] = visited[now]
                if i == k:
                    flg = True
                if flg == False:
                    q.append(now * 2) 
                    
            # 다음에 +1,-1 갈 수 있는 후보군
            for i in [now -1,now +1 ]:
                if (0 <= i <= 100000) and visited[now] + 1 < visited[i] :
                # 수빈이의 이동(N) 범위 정해주기 && i 도착 최소 시간보다 작거나 같아야함.
                    
                    visited[i] = visited[now] + 1
                    # i 까지 가는 시간 = 지금까지의 시간(t) + 다음에 갈거니까(1) 

                    if i == k :
                    # 목표에 닿냐?
                        flg = True

                    if flg == False :
                    # 더가야함 = 지금 위치 넣어둠 = 마치 평행 세계
                        q.append(i) 
                
    

    return visited[k]


N , K = map(int,input().split())
time = bfs(N,K)

print(time)
