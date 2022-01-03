#!/usr/bin/env python
# coding: utf-8

# 가로의 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있다. 태일이는 이 얇은 바닥을 1x2의덮개,2x1의 덮개, 2x2의 덮개를 이용해 채우고자 한다.
# 이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성하시오. 예를 들어 2x3크기의 바닥을 채우는 경우의 수는 5가지이다.

# In[16]:


n=int(input())


# In[17]:


#점화식 di=di-1+di-2*2
d=[0]*1001
d[1]=1
d[2]=3
for i in range(3,n+1):
    d[i]=d[i-1]+d[i-2]*2
    
print(d[n])
    


# In[ ]:




