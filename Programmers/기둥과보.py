# 브루트 포스 조건

def check(result):
    for x,y,build_kind in result:
        if build_kind == 0:
            #기둥
            if y!= 0 and [x,y-1,0] not in result and [x,y,1] not in result and [x-1,y,1] not in result:
                return False
        else:
            #보
            if [x,y-1,0] not in result and [x+1,y-1,0] not in result and not ([x+1,y,1] in result and [x-1,y,1] in result):
                return False
    return True

def solution(n, build_frame):
    # 기둥 , 삭제 = 0 , 보  , 설치 = 1  
    answer = []
    for build_data in build_frame:
        
        x, y, build_kind, build =  build_data    
        if build :
            answer.append([x,y,build_kind])  
            if check(answer) == False:
                answer.remove([x,y,build_kind])
                
        elif [x,y,build_kind] in answer:
            answer.remove([x,y,build_kind])
            if check(answer) == False:
                answer.append([x,y,build_kind])
    
    answer = sorted(answer,key = lambda x : [x[0],x[1],x[2]])     
    return answer