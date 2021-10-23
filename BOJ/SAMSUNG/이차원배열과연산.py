def cal(matrix, dir):  # 배열A의 연산
    new_matrix, length = [], 0  # 연산 후 반환할 행렬 / 최대 길이의 행(또는 열)

    for row in matrix:
        num_cnt, new_row = [], []
        # (숫자, 개수)를 담을 배열 / 연산 후의 행(또는 열)을 담을 배열

        for num in set(row):
            # 각 숫자에 대해서 개수를 파악
            if num == 0:
                continue  # 0일 경우 continue
            cnt = row.count(num)
            num_cnt.append((num, cnt))

        num_cnt = sorted(num_cnt, key=lambda x: (x[1], x[0]))  # 정렬

        for num, cnt in num_cnt:
            new_row += [num, cnt]

        new_matrix.append(new_row)
        length = max(length, len(new_row))

    for row in new_matrix:  # 가장 긴 행(또는 열)의 크기에 맞춰 0 추가
        row += [0] * (length - len(row))

        if len(row) > 100:
            row = row[:100]  # 크기가 100이 넘어가면 슬라이싱

    return list(zip(*new_matrix)) if dir == 'C' else new_matrix


N, M, K = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(3)]
res = 0

while True:
    if res > 100:
        res = -1
        break
    if -1 < N-1 < len(matrix) and -1 < M-1 < len(matrix[0]) and matrix[N-1][M-1] == K:
        break
    if len(matrix) >= len(matrix[0]):
        matrix = cal(matrix, 'R')
    else:
        matrix = cal(list(zip(*matrix)), 'C')
    res += 1


print(res)
