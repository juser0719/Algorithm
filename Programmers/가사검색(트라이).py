from collections import defaultdict

class Node(object):
    def __init__(self,key,passnumber = None, inEnd = None):
        self.key = key
        self.passnumber = defaultdict(int)
        self.isEnd = False
        self.children = {}


class Trie(object):
    def __init__(self):
        self.head = Node(None)
        
    #새로운 단어 추가.
    def insert(self,string):
        curr_node = self.head
        curr_node.passnumber[len(string)] += 1
        # 단어의 문자로 Tree 구조를 만들어줌.
        for char in string:
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)
            curr_node = curr_node.children[char]
            curr_node.passnumber[len(string)] += 1
        # 다 끝나면 브레이크 포인트 작성
        curr_node.isEnd = True
    
    def search(self,query):
        curr_node = self.head # 트리의 가장 위
        for q in query:
            if q == "?":
                break
            if q in curr_node.children:
                curr_node = curr_node.children[q]
            else:
                return 0
        return curr_node.passnumber[len(query)]

def solution(words, queries):
    answer = []
    trie = Trie()
    r_trie = Trie()
    r_words = [w[::-1] for w in words]
    dic = {}
    
    for word in words:
        trie.insert(word)
    for word in r_words:
        r_trie.insert(word)
    for query in queries:
        if query in dic:
            answer.append(dic[query])
            continue
        if query.endswith("?"):
            res = trie.search(query)
            answer.append(res)
            dic["query"] = res
        else:
            res = r_trie.search(query[::-1])
            answer.append(res)
            dic["query"] = res
    
    return answer