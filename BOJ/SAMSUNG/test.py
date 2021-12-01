# 조합
def combinations(arr, r):
    for i in range(len(arr)):
        if r == 1:
            # 종료 조건.
            yield[arr[i]]
        else:
            for next in combinations(arr[i+1:], r-1):
                # 다음 원소부터 다시 시작.
                yield[arr[i]]+next


# 중복 조합
def combinataions_with_replacement(arr, r):
    for i in range(len(arr)):
        if r == 1:
            yield[arr[i]]
        else:
            for next in combinataions_with_replacement(arr[i:], r-1):
                yield [arr[i]]+next


# 순열
def permutation(arr, r):
    for i in range(len(arr)):
        if r == 1:
            yield [arr[i]]

        else:
            for next in permutation(arr[:i]+arr[i+1:], r-1):
                yield [arr[i]] + next

# 중복 순열


def permutation_with_replacement(arr, r):
    for i in range(len(arr)):
        if r == 1:
            yield[arr[i]]
        else:
            for next in permutation_with_replacement(arr, r-1):
                yield [arr[i]] + next


for i in combinataions_with_replacement([1, 2, 3, 4, 5], 3):
    print(i, end=" ")
