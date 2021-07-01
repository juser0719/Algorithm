"""
자연수 조합을 통하여 임의의 수 N 을 만들기 위한 경우의 수를 모두 구하는 프로그램을 작성하시오.
"""
def decompose():
    global st
    while True :
        print(st)
        temp = st.pop()
        if temp != 1 : 
        # a-1, 1 을 스택에 넣음
            st.append(temp -1)
            st.append(1)
        else:
        # 나온 값이 1 인 경우. 
            sum_ = 2
            while len(st)!= 0 and st[-1] == 1 :
                # 1이 아닌 수가 나올때까지 pop()
                st.pop()
                sum_ += 1
                # pop 한 갯수 저장
            if len(st) == 0 :
                break
            pivot = st.pop() -1
            # pivot 은 1이 아님. 그래서 pivot -1을 스택에 저장.
            st.append(pivot)
            
            while sum_ > pivot :
                st.append(pivot)
                sum_ -= pivot
                # pivot-1 보다 작게 쪼개서 넣음.

            st.append(sum_)
            # 지금까지 sum을 다시 스택에 넣음.


N = int(input())
st = [N]
decompose()


