#!/usr/bin/env python
# coding: utf-8

# In[18]:


n,k=map(int,input().split())
count=0

while n!=1:
    if n%k==0:
        n//=k
        count+=1
    elif n%k!=0:
        n-=1
        count+=1

print(count)

    


# # 정답

# In[ ]:


n,k = map(int,input().split())
result=0

while True:
    target=(n//k)*k
    result+=(n-target)
    n=target #무조건 마지막은 n이 0이된다.
    
    if n<k:
        break
        
    result +=1
    n//=k
    
result+= (n-1) #무조건 마지막 n이 0이므로 하나 더했던 것을 -1로 다시 빼준다.
print(result)


# 내 생각: 확실히 -1하는 부분을 한번에 구할 수 있으므로 횟수를 덜 할 수 있다.
