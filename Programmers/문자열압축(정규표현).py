import re
# 정규 표현식의 활용
def solution(s):
    n = len(s)
    if n <= 2:
        return n
    res_cnt = []
    
    for i in range (1,n//2+1):
        # (): 그룹핑을 의미 매칭 결과를 각 그룹별로 분리 가능 , \w : word를 의미 , {i}: i개 있다면 , \g:전역 검색, <1>: 하나의 그룹으로 치고 공백을 뒤에 주겠다. 
        reList = re.sub('(\w{%i})' %i, '\g<1> ',s).split()
        cnt = 1
        res = []
        for j in range(len(reList)):
            if j < len(reList) -1 and reList[j] == reList[j+1]:
                cnt+= 1
            else:
                if cnt == 1:
                    res.append(reList[j])
                else:
                    res.append(str(cnt)+reList[j])
                    cnt = 1
        res_cnt.append(len(''.join(res)))
    return min(res_cnt)