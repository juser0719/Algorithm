def getWork(time,jobs,done):
    res = []
    for i in range(len(jobs)):
        if jobs[i][0] <= time and done[i] == 0:
            res.append(jobs[i])
    return res
def flg(done):
    for d in done:
        if d == 0:
            return True
    return False

def solution(jobs):
    answer = []
    done = [0] * len(jobs)
    work_path= []
    time = 0
    now  = 0

    # while(flg(done)):
    for test in range(5):
        
        if now == 0:
            # 일거리 탐색.
            # 현재 시간이전의 작업들 중 아직 하지 않은 것들의 분류별 가치 탐색.
            time+=1
            notYet = getWork(time,jobs,done)
            print(notYet)
            total_val = {}

            for j in range(len(notYet)):
                div = notYet[j][2]
                if div not in total_val:
                    total_val[div] = notYet[j][3]
                else:
                    total_val[div] += notYet[j][3]
            print(total_val)

            total_val = sorted(total_val.items(),key= lambda x :(x[1],x[0]))
            now = next(iter(total_val))[0]
            total_val = {}
            print(now)
            work_path.append(now)

        else:
            # 하는동안 들어온 일거리 중에 분류가 같은것들 까지 수행.
            for i in range(len(jobs)):
                
                if jobs[i][0] <= time and done[i] == 0 and jobs[i][2] == now:
                    print(jobs[i])
                    time += jobs[i][1]
                    done[i] = 1
            now = 0
            print(time)
            
            
    print(work_path)
    
    
    return answer



solution([[1, 5, 2, 3], [2, 2, 3, 2], [3, 1, 3, 3], [5, 2, 1, 5], [7, 1, 1, 1], [9, 1, 1, 1], [10, 2, 2, 9]])
