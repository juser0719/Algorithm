def decrease(N):
    cnt = 0
    num = 1
    while True:
        str_num = str(num)
        flg = True

        if len(str_num) == 1:
            pass
        else:
            for i in range (1,len(str_num)):
                if int(str_num[i]) < int(str_num[i-1]): # 감소하는 수인가?
                    continue
                else: # 아니면 감소하지 않는 위치가 감소하도록 수정합니다.
                    start = str_num[:i-1]
                    mid = str(int(str_num[i-1]) + 1)
                    end = '0' + str_num[i+1:]
                    num = int(start+mid+end)
                    flg = False
                    print("start: "+start+" mid: "+mid+" end: "+ end)
                    break
                    
        
        if flg: # 감소하는 수이면 현재 수 + 1 살펴보고 , 갯수에 추가
            cnt +=1
            if cnt == N: # 만약 원하는 갯수에 만족하면 num 리턴.
                return num
            num += 1 # 부족하면 다음 넘버 체크


N = int(input())
if N == 0 : 
    print(0)
elif N >= 1023:
    print(-1)
else:
    print(decrease(N))