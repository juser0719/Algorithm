def calc(num, ops, idx):
    cal = ops.pop(idx)
    if cal == '*':
        num[idx] *= num.pop(idx+1)
    elif cal == '+':
        num[idx] += num.pop(idx+1)
    elif cal == '-':
        num[idx] -= num.pop(idx+1)


N = int(input())
res = int(-1e9)
arr = input()
cnt = 0  # 괄호친 연산자 수.
num = []
ops = []
st = [(num, ops, 0)]

for a in arr:
    if a in ["+", "-", "*"]:
        ops.append(a)
    else:
        num.append(int(a))

while st:
    nums, op, cnt = st.pop()
    # 숫자들, 연산자들, 괄호친 연산자 수.
    if cnt >= len(op):
        # 만약 연산자 갯수만큼 다 괄호를 쳤다면.
        while op:
            calc(nums, op, 0)
            # nums에 있는 숫자들 모두 연산.

        if res < nums[0]:
            # 최소 nums[0]은 존재.
            res = nums[0]
    else:
        st.append((nums, op, cnt+1))
        # 괄호를 칠거임 = cnt+1
        new_nums = nums[:]
        new_ops = op[:]
        calc(new_nums, new_ops, cnt)
        st.append((new_nums, new_ops, cnt+1))

print(res)
