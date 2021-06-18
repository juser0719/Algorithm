# k원이 되는 경우의 수를 구하시오. 각각의 동전 무한개. (dp)

N , K = map(int,input().split())
coin  = [int(input()) for _ in range(N)]
dp = [0 for _ in range (K+1)] # dp[i] = i원이 되는 경우의 수.
dp[0] = 1 # 동전을 1개만 쓸 때의 경우의 수를 고려하기 위해 선언.

for i in coin : # 코인 순회
    for j in range(i,K+1): #dp를 순회하며 
        if j - i >= 0:
            dp[j] += dp[j-i]

print(dp[K])
