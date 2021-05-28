# 시계, 반시계 문제.
from itertools import permutations
import copy

def solution(n, weak, dist):
    W = len(weak)
    append_list = weak + [w+n for w in weak]
    friend = []
    
    # for i in range(W):
    #     append_list.append(n + weak[i])
        
    for i , start in enumerate(weak):
        for friend_comb in permutations(dist):
            cnt = 1
            pos = start
            
            for f in friend_comb:
                pos += f
                
                if pos < append_list[i + W -1] : 
                    cnt += 1
                    pos = [w for w in append_list[i+1:i+W] \
                           if w > pos][0]
                else:
                    friend.append(cnt)
                    break
                    
    
    if len(friend) == 0:
        return -1
    
    return min(friend)