#!/usr/bin/env python
# coding: utf-8

# In[8]:


m,n = map(int,input().split())
result=0
maximum=-1
for i in range(m):
    array=list(map(int,input().split()))
    result=min(array)
    if maximum<result:
        maximum=result
print(maximum)


# In[ ]:




