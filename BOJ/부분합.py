"""
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 

이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
"""
N , S = map(int,input().split())
li = list(map(int,input().split()))
res = []
ed = 0
summ = 0

for st in range(N):
  while summ < S and ed < N:
    summ += li[ed]
    ed += 1
  
  if summ >= S:
    res.append(abs(ed-st))
  summ -= li[st]

if len(res) == 0 :
  print(0)
else:
  print(min(res))
