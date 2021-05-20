#!/usr/bin/env python
# coding: utf-8

# In[2]:


n=int(input())
count=0

money=[500,100,50,10]
for i in money:
  count+=n//i
  n=n%i
print(count)

