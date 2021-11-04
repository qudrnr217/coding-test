#!/usr/bin/env python
# coding: utf-8

# n,k=map(int,input().split())
# a=list(map(int,input().split()))
# b=list(map(int,input().split()))
# 
# 
# 

# In[3]:


n,k=map(int,input().split())
a=[1,2,5,4,3]
b=[5,5,6,6,5]

for i in range(k):
    for j in range(n):
        if a[j]==min(a):
            mi=j
        if b[j]==max(b):
            ma=j
    a[mi], b[ma]=max(b), min(a)
print(a)
print(sum(a))


# In[6]:


n,k=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))

#a=[1,2,5,4,3]
#b=[5,5,6,6,5]
a.sort()
b.sort(reverse=True)
for i in range(k):
    if a[i]<b[i]:     
        a[i]=b[i]
    else:
        break

print(sum(a))
    


# In[ ]:





# In[ ]:




