import copy

# 2차원 배열의 90도 회전 브루트 포스

def rotated_90(key):
  return list(zip(*key[::-1]))

def test(x,y,m,key,board):
  try_board = copy.deepcopy(board)
  for i in range(m):
    for j in range(m):
      try_board[x+i][y+j] += key[i][j]
  return try_board

def check(board,m,n):
  for i in range(n):
    for j in range(n):
      if board[m+i][m+j] != 1:
        return False
  return True


def solution(key, lock):
    m , n = len(key) , len(lock)
    #m n m 이런 식으로 배치할 예정이라
    board = [[0]*(m*2 + n) for _ in range(m*2 + n)]
    
    for i in range(n):
        for j in range(n):
            board[m+i][m+j] = lock[i][j]
    
    rotated_key = key

    for _ in range(4):
      rotated_key = rotated_90(rotated_key)
      for i in range(1,m+n):
        for j in range(1, m+n):
          test_board = test(i,j,m,rotated_key, board)
          if check(test_board,m,n):
            return True


    return False



print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]],[[1, 1, 1], [1, 1, 0], [1, 0, 1]]))