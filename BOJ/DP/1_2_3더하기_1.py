"""
정수 n이 주어졌을 때, 

n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오. (중복 허용)

4 = 7가지.
"""
def count_num(num):
    if num == 1:
        return 1
    elif num == 2:
        return 2
    elif num == 3: 
        return 4
    else:
        return count_num(num-1) + count_num(num-2) + count_num(num-3)
        


T = int(input())
answer = []
for _ in range(T):
    t = int(input())
    answer.append(count_num(t))

for cnt in answer:
    print(cnt)