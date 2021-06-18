# 동전의 개수가 최소가 되도록 각각의 동전은 몇 개라도 사용할 수 있다.
N , K = map(int, input().split())
coin  = [int(input()) for _ in range(N)]
coin.sort()
dp = [100001 for _ in range(K+1)]
dp[0] = 0

for i in coin:
    for j in range(i,K+1):
        dp[j] = min(dp[j],dp[j - i]+1)

print(dp[K] if dp[K] != 100001 else -1)