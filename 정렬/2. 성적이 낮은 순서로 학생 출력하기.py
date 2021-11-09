#!/usr/bin/env python
# coding: utf-8

# In[45]:


n=int(input())
arr=[]
for i in range(2):
    data=input().split()
    arr.append((data[0],int(data[1])))
    
arr.sort(key=lambda x: x[1])
for i in arr:
    print(i[0])


# In[48]:


n = int(input())
data = [list(input().split()) for _ in range(n)]


# In[53]:


data.sort(key=lambda x:int(x[1]))
for i in range(n):
    print(data[i][0], end =' ')

