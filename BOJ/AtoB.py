A , B = map(int,input().split())
res = 1

while True :
    if A == B :
        break
    elif ( B%2 != 0 and B % 10 != 1 ) or (B < A):
        res = -1
        break
    else:
        if B % 10 == 1:
            res += 1
            B = B //10
        else:
            res += 1
            B = B//2

print(res)