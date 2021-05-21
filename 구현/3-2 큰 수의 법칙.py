#!/usr/bin/env python
# coding: utf-8

# In[1]:


N,M,K=map(int,input().split())
num=list(map(int,input().split()))

result=0
count=0
num=sorted(num)

max_num=num[N-1]#가장 큰 원소
max_mnum=num[N-2]#그다음 큰 원소

for i in range(M):
  if count==K:
    result+=max_mnum
    count=0
  else:
    result+=max_num
    count+=1
  
print(result)


# # 정답

# 범위가 커진다면 내가 푼 문제는 문제가 생김 그래서 수학공식으로 해야함.

# In[6]:


N,M,K = map(int,input().split())
num = list(map(int,input().split()))

result=0
count=0
num.sort()
max_num=num[N-1]
max_mnum=num[N-2]

count= int(M/(K+1))*K
count+= M%(K+1)

result +=count * max_num
result +=(M-count) * max_mnum
print(result)

