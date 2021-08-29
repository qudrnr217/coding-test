#!/usr/bin/env python
# coding: utf-8

# In[123]:





# In[125]:


n=input()
al=int(ord(n[0]))-96
num=int(n[1])
arr=[al,num]
count=0
method=[(-2,-1),(-2,1),(2,-1),(2,1),(-1,-2),(1,-2),(-1,2),(1,-2)]
#method=[[-2,-1],[-2,1],[2,-1],[2,1],[-1,-2],[1,-2] ,[-1,2],[1,-2]]
for i in method:
    n_num=num+i[0]
    n_al=al+i[1]
    count+=1
    if(n_num<1 or n_al<0 or n_num>8 or n_al>8):
        count-=1

print(count)


# In[ ]:





# In[ ]:




