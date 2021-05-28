#라이브러리 사용하는 방법
from bisect import bisect_left , bisect_right
  # bisect_left(a,x) : 배열 a 에 x 를 삽입할 가장 왼쪽 인덱스
  # bisect_right(a,x) : 배열 a 에 x 를 삽입할 가장 오른쪽 인덱스 
def count_by_range (arr , left_range, right_range) :
  # 특정 범위안에 속하는 데이터 개수 구하기
  right_idx =  bisect_right(arr,right_range)
  left_idx  =  bisect_left(arr,left_range )

  return right_idx - left_idx




# 라이브러리 없이 구현하는 방법
def binay_search(arr,target,start,end) :
  # arr = 정렬된 해당 배열 , target = 목표 데이터 , start= 시작점, end = 끝점 

  if start > end:
    #탐색 범위에 데이터가 없다는 뜻
    return None
  mid = (start + end) // 2

  if arr[mid] == target :
    #찾고자 하는 값의 인덱스
    return mid
  elif target > arr[mid]:
    return binay_search(arr,target,mid+1,end)
  else:
    return binay_search(arr,target,start,mid-1)