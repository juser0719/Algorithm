# 주어진 조건으로 최소한의 개수 찾기
n , m = map(int,input().split())
money = []
for i in range(n):
  money.append(int(input()))

dp = [100001] * (m+1)
dp[0] = 0

for i in range (n):
  for j in range(money[i],m+1):
    if dp[j - money[i]] != 100001:
      dp[j] = min(dp[j],dp[j - i] +1 )

if dp[m] == 100001:
  print(-1)
else:
  print(dp[m])
