from collections import deque

N, K = map(int, input().split())
belt = deque(map(int, input().split()))
res = 0
robot = deque([0]*N)

while True:
    belt.rotate(1)
    robot.rotate(1)
    robot[-1] = 0

    if sum(robot):
        # 로봇이 존재하면, 이동.
        for i in range(N-2, -1, -1):
            # 끝-1에서 역으로 반복하며 자리 이동시켜줌.
            if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] >= 1:
                robot[i+1] = 1
                robot[i] = 0
                belt[i+1] -= 1
        robot[-1] = 0

    if robot[0] == 0 and belt[0] >= 1:
        # 처음에 로봇 놓음.
        robot[0] = 1
        belt[0] -= 1
    res += 1

    if belt.count(0) >= K:
        break

print(res)
