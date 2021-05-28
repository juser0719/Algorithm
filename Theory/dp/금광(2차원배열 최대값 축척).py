# 2차원 배열에서 조건에 따라 이동하며 최대 or 최소값 도출
answer = []
T  = int(input())
for tc in range (T):
  # n = 열 , m = 행
  n , m = map(int,input().split())
  arr = list(map(int, input().split()))
  dp = []
  start = 0
  for i in range(n):
    dp.append(arr[start : start + m])
    start += m
  
  for j in range(1, m):
    for i in range(n):
    # 왼쪽 위에서 오는 경우
      if i == 0:
        left_up = 0
      else:
        left_up = dp[i - 1][j - 1]
    # 왼쪽 아래에서 오는 경우
      if i == n - 1:
        left_down = 0
      else:
        left_down = dp[i + 1][j - 1]
    # 왼쪽에서 오는 경우
      left = dp[i][j - 1]
      dp[i][j] = dp[i][j] + max(left_up, left_down, left)

    result = 0
  for i in range(n):
    result = max(result, dp[i][m - 1])
  answer.append(result)


print(answer)