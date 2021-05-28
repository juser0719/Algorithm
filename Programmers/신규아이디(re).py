import re
# 소문자 변환
def lev1(id_):
    return id_.lower()
# 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
def lev2(id_):
    return re.sub('[^a-z\d\-\_\.]','',id_)
# 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
def lev3(id_):
    return re.sub('[.]+','.',id_)
# 마침표(.)가 처음이나 끝에 위치한다면 제거
def lev4(id_):
    return re.sub('^\.|\.$', '', id_)
# 빈 문자열이라면, new_id에 "a"를 대입
def lev5(id_):
    if len(id_) == 0:
        return 'a'
    return id_
# 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
def lev6(id_):
    if len(id_) > 15:
        return lev4(id_[0:15])
    return id_
# 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복
def lev7(id_):
    while len(id_) < 3:
        id_ += id_[-1]
    return id_

def solution(new_id):
    new_id = lev1(new_id)
    new_id = lev2(new_id)
    new_id = lev3(new_id)
    new_id = lev4(new_id)
    new_id = lev5(new_id)
    new_id = lev6(new_id)
    new_id = lev7(new_id)
    
    answer = new_id
    return answer