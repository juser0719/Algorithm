"""
N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.

백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.

각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
"""

N = int(input())
T , P = [], []
dp = [0] * (N+1) 
# I 번째 날까지의 최대 금액

for _ in range(N):
    t,p = map(int,input().split())
    T.append(t)
    P.append(p)

max_ = 0
# 최대 금액
for i in range(N):
    # 가능 날짜 돌아가며 순회

    max_ = max(max_,dp[i])

    if i + T[i] > N:
        # 만약 (현재날 + 소요 시간) 이 N 보다 크면 무시함.
        continue

    dp[i+T[i]] = max(max_ + P[i] , dp[i+T[i]])
    # i+T[i]날의 최대금액 = I날 상담 했을때 or 안했을 때 
    # = (현재까지 수익 + 이번 상담수익) or (오늘 상담 끝나는 시점의 수익)

print(max(dp))
