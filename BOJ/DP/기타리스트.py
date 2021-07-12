"""
현재 볼륨이 P이고 지금 i번째 곡을 연주하기 전이라면, i번 곡은 P+V[i]나 P-V[i] 로 연주해야 한다. 

하지만, 0보다 작은 값으로 볼륨을 바꾸거나, M보다 큰 값으로 볼륨을 바꿀 수 없다.

마지막 곡을 연주할 수 있는 볼륨 중 최댓값을 구하는 프로그램을 작성하시오.
"""

res = -1
N , S , M = map(int,input().split())
V = list(map(int, input().split()))

dp = [[0] *(M+1) for _ in range (N+1)]
dp[0][S] = 1

for i in range(N):
    for j in range (M+1):
        if dp[i][j] == 1:
            if j + V[i] <= M:
                dp[i+1][j+V[i]] = 1
            if j - V[i] >= 0:
                dp[i+1][j-V[i]] = 1

for i in range(M, -1,-1):
    if dp[N][i] == 1:
        res = i
        break
print(res)