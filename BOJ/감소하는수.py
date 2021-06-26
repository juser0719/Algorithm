'''
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 
예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. 
N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
'''
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