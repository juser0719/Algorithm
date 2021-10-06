import sys
n, d, k, c = map(int, sys.stdin.readline().split())
# 벨트위 초밥들 n , 초밥 가짓수 d , 연속해서 먹는 k , 쿠폰번호 c
onBelt = []
eat = {}
eat[c] = 1

res = 0

for i in range(n):
    onBelt.append(int(input()))

onBelt.extend(onBelt)
# append는 그자체를 원소로 넣고, extend는 1번 iterable한 원소들을 넣음.

# 처음 0에서 k 까지 먹기.
for i in range(k):
    if onBelt[i] in eat:
        eat[onBelt[i]] += 1
    else:
        eat[onBelt[i]] = 1

# print(onBelt)
# print(eat)
st = 0
ed = k

while ed < 2*n:
    res = max(res, len(eat))
    # 1. 왼쪽 제거.
    eat[onBelt[st]] -= 1
    if eat[onBelt[st]] == 0:
        # 만약 삭제된 왼쪽 초밥의 종류가 0이라면,
        del eat[onBelt[st]]

    # 2. 오른쪽 추가.
    if onBelt[ed] in eat:
        eat[onBelt[ed]] += 1
    else:
        eat[onBelt[ed]] = 1

    st += 1
    ed += 1

print(res)
