def solution(tickets):
    answer = []
    T = dict()
    for t in tickets :
        if t[0] in T:
            T[t[0]].append(t[1])
        else:
            T[t[0]] = [t[1]]
            
    for i in T.keys():
        T[i].sort(reverse = True)
    print(T)
    st = ["ICN"]
    while st:
        top = st[-1]
        print(top)
        if top not in T or len(T[top]) == 0:
            answer.append(st.pop())
            print("answer",answer)
        else:
            print("T[top][-1] : ",T[top][-1])
            st.append(T[top][-1])
            T[top].pop()
    answer.reverse()
    return answer