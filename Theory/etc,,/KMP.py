# 문자열 매칭 알고리즘
## 단순 비교 알고리즘 보다 짧은 시간 복잡도를 지님.
### 접두사와 접미사의 개념으로 일치하는 경우에 점프를 수행해서 연산 줄여줌

def makeTable(pattern): # 실패 테이블
    patternSize = len(pattern)
    table = [0] * patternSize
    j = 0
    for i in range(1,patternSize):
        while j > 0 and pattern[i] != pattern[j] :
            j = table[j-1]
        if pattern[i] == pattern[j]:
            j += 1
            table[i] = j
    
    return table # 접두사 접미사 최대 길이 테이블

def KMP(parent,pattern):
    table = makeTable(pattern)
    parentSize = len(parent)
    patternSize = len(pattern)
    j = 0

    for i in range(parentSize):
        while j > 0 and parent[i] != pattern[j]:
            j = table[j-1]
        if parent[i] == pattern[j]:
            if j == patternSize -1:
                print("1")
                j = table[j]
                break
            else:
                j+=1
    print("0")

print(KMP("abacaabaabacaaba","abacaaba"))