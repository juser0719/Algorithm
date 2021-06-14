def solution(distance, rocks, n):
    answer = 0
    rocks = sorted(rocks)
    #만들 수 있는 거리의 최소, 최대값 지정
    min_dis = 1
    max_dis = distance
    
    while min_dis <= max_dis:
        remove_cnt = 0 
        mid_dis = (max_dis+ min_dis) // 2
        
        prev = 0
        
        for rock in rocks:
            if (rock - prev) < mid_dis:
                remove_cnt += 1
            else :
                prev = rock
        
        # 마지막 돌과 도착지의 거리도 구해줘야함
        if (distance - prev) < mid_dis:
            remove_cnt +=1
        
        if (remove_cnt <= n):
            answer = max(answer, mid_dis)
            min_dis = mid_dis +1
        else :
            max_dis = mid_dis -1
        
    return answer