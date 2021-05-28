arr = list(map(int,input().split()))
n = len(arr)
dp = [i for i in arr]

def get_max ():
  temp = 0
  maxx = 0
  for i in range(n):
    temp += dp[i]
    if temp > maxx:
      maxx = temp
    elif temp < 0:
      temp = 0

  return maxx 

def get_max_minus():
  maxx = int(-1e9)
  for i in range (n):
    if maxx < dp[i]:
      maxx = dp[i]
      
  return maxx

res = get_max()

if res != 0:
  print(res)
else:
  print(get_max_minus())
