N = int(input())
arr = list(map(int, input().split()))
main, sub_man = map(int, input().split())
cnt = 0

for i in range(N):
    if arr[i] > 0:
        arr[i] -= main
        cnt += 1

    if arr[i] > 0:
        cnt += int(arr[i]/sub_man)

        if arr[i] % sub_man != 0:
            # 나눴을때 나머지가 남으면 + 1 더해줌.
            cnt += 1

print(cnt)
