#!/usr/bin/env python
# coding: utf-8

# # 문제

# N*M 크기의 얼믕 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다. 구멍이 뚫려 있는 부분끼리 상,하,좌,우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다. 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오. 다음의 4x5얼음 틀 예시에서는 아이스크림이 총 3개 생성이된다.
# 

# In[1]:


n, m=map(int,input().split())
arr=[list(map(int,input()) for _ in range(n)]
count=0
print(arr)


# In[2]:


def dfs(i,j):
    if i<0 or i>n-1 or j<0 or j>m-1:
        return -1
    else:
        if arr[i][j]==0:
            arr[i][j]=1
            dfs(i,j+1)#동
            dfs(i,j-1)#서
            dfs(i+1,j)#남
            dfs(i-1,j)#북
            return 1
            
        
for i in range(n):
    for j in range(m):
        if(dfs(i,j)==1):
            count+=1
           
                
        
print(count)


# In[ ]:




