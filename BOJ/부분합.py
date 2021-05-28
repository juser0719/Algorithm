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
