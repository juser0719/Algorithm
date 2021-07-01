"""
자연수 조합을 통하여 임의의 수 N 을 만들기 위한 경우의 수를 모두 구하는 프로그램을 작성하시오.
"""
def decompose():
    global st
    while True :
        print(st)
        temp = st.pop()
        if temp != 1 :
            st.append(temp -1)
            st.append(1)
        else:
            sum_ = 2
            while len(st)!= 0 and st[-1] == 1 : 
                st.pop()
                sum_ += 1
            if len(st) == 0 :
                break
            pivot = st.pop() -1
            st.append(pivot)
            while sum_ > pivot :
                st.append(pivot)
                sum_ -= pivot
            st.append(sum_)



N = int(input())
st = [N]
decompose()


