#!/usr/bin/env python
# coding: utf-8

# In[10]:


s='aabbaccc'

answer=99
#최대 압축은 반

for i in range(1,len(s)//2+1):
    count=1
    ret=""
    prev=s[:i]
    #차례대로 압축해본다.
    for j in range(i,len(s)+i,i):
        if prev==s[j:j+i]:
            count+=1
        else:
            if count != 1:
                ret=ret+str(count)+prev
            else:
                ret=ret+prev
            
            prev=s[j:j+i]
            count=1
    
    answer=min(answer,len(ret))
    
print(min(answer,len(s)))
            


# # 내 요약
# 압축할 때 prev처럼 비교해줄 str을 만들어서 비교해주는게 좋음!

# In[ ]:




