from collections import deque

answer = 0

s = input()
q = deque()
for i in range( len(s)):
  if s[i] == '(' or s[i] == '[': # (, [ 스택 넣기
    q.append(s[i])
  else:
    if s[i] == ')': # 닫는 경우
      temp = 0 
      while len(q)!= 0:
        top = q.pop()
        if top == '(':
        #ex) 입력이 "()()" 인 경우 q에는 [2,2] 가 저장된다.
          if temp == 0 :
            q.append(2)
          else: # 괄호안에 이미 값이 무언가 있다면 그 값 곱해줌.
            q.append(2*temp)
          break # 맞은 경우 연산 끝났으면 루프 종료
        elif top == '[': # 잘못된 괄호
          print(0)
          exit(0)
        else: # 이미 다른 괄호 값이 있는 경우 
        # ex ) "(())"일때 q가 ["(",2] 일때 ")"를 만났을때 temp에 값 넣어줌
          temp += int(top)
    elif s[i] == ']':
      temp = 0
      while len(q)!= 0:
        top = q.pop()
        if top == '[':
          if temp == 0 :
            q.append(3)
          else:
            q.append(3*temp)
          break
        elif top == '(': # 잘못된 괄호
          print(0)
          exit(0)
        else: # 숫자인 경우
          temp += int(top)

for i in q:
  if i == '(' or i == '[':
    print(0)
    exit(0)
  else :
    answer += i
print(answer)
    
