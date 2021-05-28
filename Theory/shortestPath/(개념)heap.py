import heapq
# 최소힙
def heapsort(iterable):
	h = []
    res = []
    for val in iterable:
    	heapq.heappush(h,val)
    for i in range (len(h)):
    	res.append(heapq.heappop(h))
    return res
# 최대힙
def heapsort(iterable):
	h = []
    res = []
    for val in iterable:
    	heapq.heappush(h,-val)
    for i in range (len(h)):
    	res.append(-heapq.heappop(h))
    return res