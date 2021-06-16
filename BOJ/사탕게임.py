def check(arr,s_row,e_row,s_col,e_col): # 최대 연속 캔디 구하기
    n = len(arr)
    res = 1
    #행 체크
    for i in range(s_row , e_row + 1):
        cnt = 1
        for j in range(1, n):
            if arr[i][j-1] == arr[i][j] : 
                cnt +=1 
            else:
                cnt = 1
            if cnt > res:
                res = cnt
    
    # 열 체크
    for i in range(s_col,e_col+1):
        cnt = 1
        for j in range(1,n):
            if arr[j-1][i] == arr[j][i]:
                cnt +=1 
            else:
                cnt = 1
            if cnt> res:
                res = cnt
    return res

N = int(input())
candy = [list(input()) for _ in range(N)]
res = 0 

for i in range(N):
    for j in range(N):
        if j <  N-1 : # 오른쪽과 교환 범위 못넘게
            candy[i][j] , candy[i][j+1] = candy[i][j+1] , candy[i][j] # 오른쪽이랑 바꿔줌.
            can_num = check(candy,i,i,j,j+1)
            if can_num > res:
                res = can_num
            candy[i][j+1] , candy[i][j] = candy[i][j] , candy[i][j+1] # 원래대로

        if i < N -1 : # 아래쪽 교환 범위 못넘게
            candy[i][j], candy[i+1][j] = candy[i+1][j] , candy[i][j] # 아래랑 바꿔줌.
            can_num = check(candy,i,i+1,j,j)
            if can_num > res:
                res = can_num
            candy[i+1][j] , candy[i][j] = candy[i][j], candy[i+1][j] # 원위치

print(res)
