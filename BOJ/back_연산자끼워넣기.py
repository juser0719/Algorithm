"""
N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 

연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.

N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
"""

N = int(input())
num = list(map(int,input().split()))
op  = list(map(int,input().split()))

max_ = -1e9
min_ = 1e9

def dfs(depth,total,p,m,mul,div):
    global max_ , min_
    if depth == N :
        max_ = max(total, max_)
        min_ = min(total, min_)
        return
    
    if p :
        dfs(depth+1,total+ num[depth], p -1 , m, mul , div)
    if m :
        dfs(depth+1,total - num[depth], p  , m-1, mul , div)
    if mul:
        dfs(depth+1,total* num[depth], p , m, mul -1 , div)
    if div:
        dfs(depth+1,int(total/num[depth]), p , m, mul , div -1)

dfs(1,num[0],op[0],op[1],op[2],op[3])

print(max_)
print(min_)