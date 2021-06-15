def solution(begin, target, words):
    answer = [begin]
    cnt = 0
    
    if target not in words :
        return 0
    while len(words) != 0 :
        for i in answer:
            temp = []
            for word in words :
                word_cnt = 0
                for j in range(0,len(i)):
                    if i[j] != word[j] :
                        word_cnt +=1
                    if word_cnt > 1:
                        break;
                if word_cnt == 1:
                    temp.append(word)
                    words.remove(word)
        cnt +=1
        if target in temp :
            return cnt
        else :
            answer = temp

    
    return answer