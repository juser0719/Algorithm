"""
정수 n이 주어졌을 때, 

n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오. (중복 불가)

4  = 3
"""
dp  = [[1,0,0],[1,1,0],[1,1,1]]
        
T = int(input())
answer = []
for _ in range(T):
    num = int(input())
    if num <= 3:
        print(sum(dp[num -1]))
        continue
    for i in range(3,num+1):
        cnt = []
        cnt.append(dp[i-1][0]) # (num-1)+  (1의 가짓수)
        cnt.append(dp[i-2][0] + dp[i-2][1]) # (num-2) + (2의 가짓수)
        cnt.append(dp[i-3][0] + dp[i-3][1] + dp[i-3][2]) # (num-3) + (3의 가짓수)

        dp.append(cnt)

    print(sum(dp[num-1]))

print(dp)