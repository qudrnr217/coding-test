#!/usr/bin/env python
# coding: utf-8

# 친구들로부터 천재 프로그래머로 불리는 "프로도"는 음악을 하는 친구로부터 자신이 좋아하는 노래 가사에 사용된 단어들 중에 특정 키워드가 몇 개 포함되어 있는지 궁금하니 프로그램으로 개발해 달라는 제안을 받았습니다.<br>
# 그 제안 사항 중, 키워드는 와일드카드 문자 중 하나인 "?"가 포함된 패턴 형태의 문자열을 뜻합니다. 와일드카드 문자인 "?"는 글자 하나를 의미하며, 어떤 문자에도 매치된다고 가정합니다. 예를 들어 "fro??"는 "frodo", "front", "forst"등에 매치되지만 "frame", "frozen"에는 매치되지 않습니다.<br>
# 가사에 사용된 모든 단어들이 담긴 배열 words와 찾고자 하는 키워드가 담긴 배열 queries가 주어 질 때, 각 키워드별로 매치된 단어가 몇 개인지 순서대로 배열에 담아 반환하도록 solution 함수를 완성해주세요.

# # 가사 단어 제한사항
# words의 길이는 2이상 100,000이하입니다.<br>
# 각 가사 단어의 길이는 1이상 10,000 이하로 빈 문자열인 경우는 없습니다.<br>
# 전체 가사 단어 길이의 합은 2이상 1,000,000 이하입니다.<br>
# 가사에 동일 단어가 여러 번 나올 경우 중복을 제거하고 words에는 하나로만 제공됩니다.<br>
# 각 가사 단어는 오직 알파벳 소문자로만 구성되어 있으며, 특수문자나 숫자는 포함되지 않는 것으로 가정합니다.<br>
# 
# # 검색 키워드 제한사항
# queries의 길이는 2이상 100,000이하입니다.<br>
# 각 검색 키워드의 길이는 1이상 10,000 이하로 빈 문자열인 경우는 없습니다<br>
# 전체 검색 키워드 길이의 합은 2이상 1,000,000이하입니다.<br>
# 검색 키워드는 중복될 수도 있습니다.<br>
# 각 검색 키워드는 오직 알파벳 소문자와 와일드카드 문자인"?"로만 구성되어 있으며, 특수문자나 숫자는 포함하지 않는 것으로 가정합니다.<br>
# 검색키워드는 와일드카드 문자인 "?"하나 이상 포함돼 있으며, "?"는 각 검색키워드의 접두사 아니면 접미사 중 하나로만 주어집니다.<br>
# -예를 들어 "??odo", "fro??","?????"는 가능한 키워드입니다.<br>
# 반면에 'frodo(?가 없음)', 'fr?do(?가 중간에)', '?개??(?가 양쪽에)는 불가능한 키워드입니다.<br>

# In[16]:


words=["frodo","front","frost","frozen","frame","kakao"]
queries=["fro??","????o","fr???","fro???","pro?"]
# length=[]
result=[]

#?뺀 길이 구하기
def c_length(query):
    cnt=0
    for i in range(len(query)):
        if query[i]=='?':
            continue
        else:
            cnt+=1
    
    return cnt

    
            

for query in queries:
    c_sum=0
    for i in range(len(words)):
        a=c_length(query)
        cnt=0
        for j in range(len(query)):
            if len(query)==len(words[i]):
                if query[j]==words[i][j]:
                    cnt+=1
                elif query[j]=='?'and words[i][j]!='?':
                    continue
                else:
                    break
        if cnt==a:
            c_sum+=1
            
    result.append(c_sum)


print(result)


# # 정답

# In[39]:


from bisect import bisect_left, bisect_right
words=["frodo","front","frost","frozen","frame","kakao"]
queries=["fro??","????o","fr???","fro???","pro?"]
array=[[] for _ in range(10001)]
reversed_array=[[] for _ in range(10001)]


def count_by_range(a,left_value,right_value):
    right_index=bisect_right(a,right_value)
    left_index=bisect_left(a,left_value)
    print('right_value=',a,right_value)
    print('left_value',a,left_value)
    print(right_index,left_index)
    
    return right_index-left_index


def solution(words,queries):
    answer=[]
    for word in words: #모든 단어를 접미사 와일드카드 배열, 접두사 와일드카드 배열에 각각 삽입
        array[len(word)].append(word) #단어를 삽입
        reversed_array[len(word)].append(word[::-1]) #단어를 뒤집어서 삽입
    
#     print(reversed_array)
    
    for i in range(10001):
        array[i].sort()
        reversed_array[i].sort()
        
    for q in queries: #쿼리를 하나씩 확인하며 처리
        if q[0] != '?': #접미사에 와일드카드가 붙은 경우
            res=count_by_range(array[len(q)],q.replace('?','a'), q.replace('?','z')) #3
        else:
            res=count_by_range(reversed_array[len(q)],q[::-1].replace('?','a'),q[::-1].replace('?','z')) #3

        # 검색된 단어의 개수를 저장
        answer.append(res)
    return answer
        
solution(words,queries)


# In[ ]:




