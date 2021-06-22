#!/usr/bin/env python
# coding: utf-8

# # 나의 답

# In[22]:


n=int(input())
count=0
for i in range(n+1): #시
    if '3' in str(i):
        count+=3600
        continue
    for j in range(60): #분
        if '3' in str(j):
            count+=60
            continue
        for k in range(60): #초
            if '3' not in str(i) or '3' not in str(j):
                if '3' in str(k):
                    count+=1
            
print(count)


# 답을 조금 보고 풀긴했다. 하지만 if '3' in str(i):를 쓸 수 있다는 파이썬의 강점을 알게 됨. 그리고 시간을 줄이기 위해 경우의 수를 따져서 코딩을 해봄.

# # 실제 정답

# In[23]:


h=int(input())

count=0
for i in range(h+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i)+str(j)+str(k):
                count+=1
                
print(count)        

