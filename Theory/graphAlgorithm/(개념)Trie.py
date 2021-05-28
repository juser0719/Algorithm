class Node (object) :
  def __init__ (self, key, data = None):
    self.key = key
    self.data = data
    self.children = {}
  

class Trie (object):
  def __init__(self):
    self.head = Node(None)
  #문자열 삽입
  def insert(self, string):
    curr_node = self.head 
    # 삽입할 string 각가의 문자에 대해 자식 node 만들며 내려감

    for char in string:
      # 자식 node 등 중 같은 문자가 없으면 node 새로 생성
      if char not in curr_node.children :
        curr_node.children[char] = Node(char)
      # 이제 존재하게 된다면 해당 노드로 이동
      curr_node = curr_node.children[char]
    
    #문자열 끝난 지점의 노드 data값에 해당 문자열을 입력
    curr_node.data = string

  def search(self, string):
    #가장 아래 노드부터 탐색 시작
    curr_node = self.head

    for char in string:
      # 자식 노드 중 해당 문자가 존재하면 그 노드로 이동
      if char in curr_node.children:
        curr_node = curr_node.children[char]
      # 없다면 False를 반환
      else:
        return False
    #탐색이 끝난 후 해당 노드에 data 가 존재하면 문자가 포함 되어있단 뜻임.
    if curr_node.data != None:
      return True