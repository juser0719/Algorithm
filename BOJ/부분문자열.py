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