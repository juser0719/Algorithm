h , w = map(int,input().split())
wall = list(map(int,input().split()))

stack = []
answer = 0

for i in range(len(wall)):
  # 변곡점을 만나는 경우
  while stack and wall[i] > wall[stack[-1]]:
    # 스택에서 빼냄
    top = stack.pop()

    if not len(stack):
      break

    # 이전과의 차이만큼 물 높이 처리
    distance = i - stack[-1] - 1
    waters = min(wall[i], wall[stack[-1]]) - wall[top]

    answer += distance * waters

  stack.append(i)


print(answer)