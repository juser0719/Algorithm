"""
문자열 S의 부분 문자열이란, 문자열의 연속된 일부를 의미한다.

예를 들어, "aek", "joo", "ekj"는 "baekjoon"의 부분 문자열이고, "bak", "p", "oone"는 부분 문자열이 아니다.

문자열 S와 P가 주어졌을 때, P가 S의 부분 문자열인지 아닌지 알아보자.
"""
def make_table():
    length = len(P)
    table = [0] * len(P)
    j = 0
    for i in range(1, length):
        while j > 0 and P[i] != P[j]:
            j = table[j - 1]
        if P[i] == P[j]:
            j += 1
            table[i] = j
    return table


def kmp():
    table = make_table()
    j = 0
    for i in range(len(S)):
        while j > 0 and S[i] != P[j]:
            j = table[j - 1]
        if S[i] == P[j]:
            if j == len(P) - 1:
                return True
            else:
                j += 1
    return False

S = input()
P = input()

print(1 if kmp() else 0)