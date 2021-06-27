"""
N개의 정수로 이루어진 수열 A1, A2, ..., AN에서, 가장 긴 증가하는 부분 수열(LIS)의 길이를 L이라고 하자. 

LIS는 하나 또는 그 이상 있을 수 있다. 모든 LIS를 사전 순으로 정렬했을 때, K번째 오는 수열을 구해보자.

두 LIS Ai1, Ai2, ..., AiL와 Aj1, Aj2, ..., AjL이 있을 때, ik ≠ jk를 만족하는 k가 하나라도 존재하면 다른 LIS이다.
"""
def f (p,k,s):
    global N
    if (p == N):
        return 1
    if p :
        res.append(Arr[p])
    for x in s:
        i = x[1]
        if Arr[p] < Arr[i] and dp[p] + 1 == dp[i] :
            if K < rec(i) :
                for 

N , K = map(int, input().split())
Arr = list(map(int,input().split()))
Arr.insert(0,float('-inf'))
dp  = [0] * len(Arr)
dp[0] = 1
L = 0
s = set()
res = []

for i in range(1,N+1):
    dp[i] = 1
    for j in range(0,i):
        if Arr[j] < Arr[i] :
            dp[i] = max(dp[i],dp[j]+1)
    L = max(L,dp[i])
    s.add({Arr[i],i})
N+=1
L+=1
s.add({Arr[N], N})
dp[N] , Arr[N] = L , float('-inf')

if f(0,K-1 ,s) :
