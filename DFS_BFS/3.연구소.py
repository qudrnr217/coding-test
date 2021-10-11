#!/usr/bin/env python
# coding: utf-8

# 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었습니다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 합니다.
# 연구소는 크기가 NxM인 직사각형으로 나타낼 수 있으며, 직사각형은 1x1크기의 정사각혀응로 나누어져 있습니다. 연구소는 빈칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지합니다.
# 일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈칸으로 모두 퍼져나갈 수 있습니다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야합니다.
# 예를 들어, 다음과 같이 연구소가 생긴 경우를 살펴보겠습니다.
# 
# 2 0 0 0 1 1 0
# 
# 0 0 1 0 1 2 0
# 
# 0 1 1 0 1 0 0
# 
# 0 1 0 0 0 0 0
# 
# 0 0 0 0 0 1 1
# 
# 0 1 0 0 0 0 0
# 
# 0 1 0 0 0 0 0
# 
# 이떄, 0은 빈칸, 1은 벽, 2는 바이러스가 있는 곳입니다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈칸으로 퍼져 나갈 수 있습니다. 2행 1열, 1 2열, 4행 6열에 벽을 세운다면 지도의 모양은 다음과 같아집니다.
# 2 1 0 0 1 1 0
# 
# 1 0 1 0 1 2 0
# 
# 0 1 1 0 1 0 0
# 
# 0 1 0 0 0 1 0
# 
# 0 0 0 0 0 1 1
# 
# 0 1 0 0 0 0 0
# 
# 0 1 0 0 0 0 0
# 
# 바이러스가 퍼진 뒤의 모습은 다음과 같아집니다.
# 2 1 0 0 1 1 2
# 
# 1 0 1 0 1 2 2
# 
# 0 1 1 0 1 2 2
# 
# 0 1 0 0 0 1 2
# 
# 0 0 0 0 0 1 1
# 
# 0 1 0 0 0 0 0
# 
# 0 1 0 0 0 0 0
# 
# 벽을 3개 세운뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 할 때 위의 지도에서 안전 영역의 크기는 27입니다.
# 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역의 크기의 최댓값을 구하는 프로그램을 작성하세요.
# 

# # 입력 조건
# 첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어집니다. (3<=N, M<=8)
# 둘째 줄부터 N개의 줄에 지도의 모양이 주어집니다. 0은 빈칸, 1은 벽, 2는 바이러스가 있는 위치 입니다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수 입니다.
# 빈칸의 개수는 3개 이상입니다.
# 
# # 출력 조건
# 첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력합니다.

# In[63]:


from copy import deepcopy
n,m=map(int,input().split())

#arr=[list(map(int,input().split())) for i in range(m)]
arr=[[2, 0, 0, 0, 1, 1, 0], [0, 0, 1, 0, 1, 2, 0], [0, 1, 1, 0, 1, 0, 0], [0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 1], [0, 1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 0]]
#arr2=[[0]*m for _ in range(n)]
arr2=list()
#동서 남북
dx=[1, -1, 0, 0]
dy=[0, 0, 1, -1]
result=0

def virus(x,y,arr2):
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<m:
            if arr2[nx][ny]==0:
                arr2[nx][ny]=2
                virus(nx,ny,arr2)

def get_score(arr2):
    score=0
    for i in range(n):
        for j in range(m):
            if arr2[i][j]==0:
                score+=1
                
    return score
                
def dfs(count):
    global result
    if count==3:
        arr2=deepcopy(arr)
#         for i in range(n):
#             for j in range(m):
#                 arr2[i][j]==arr[i][j]
                
        for i in range(n):
            for j in range(m):
                if arr2[i][j]==2:
                    virus(i,j,arr2)
                    
        result=max(result,get_score(arr2))
        return
    
    for i in range(n):
        for j in range(m):
            if arr[i][j]==0:
                arr[i][j]=1
                count+=1
                dfs(count)
                arr[i][j]=0
                count-=1
                
dfs(0)
print(result)


# In[18]:


n,m=map(int,input().split())


# In[19]:


import copy 
from itertools import combinations as comb

result=0
#arr=[list(map(int,input().split())) for i in range(m)]
arr=[[2, 0, 0, 0, 1, 1, 0], [0, 0, 1, 0, 1, 2, 0], [0, 1, 1, 0, 1, 0, 0], [0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 1], [0, 1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 0],[1,1,1,1,1,1,1]]
s=[]
dx=[1, -1, 0, 0]
dy=[0, 0, 1, -1]
count=0
arr2=[]
arr3=[]
def count_zero(s):
    cnt=0
    for i in range(n):
        for j in range(m):
            if s[i][j]==0:
                 cnt+=1
    return cnt


#바이러스가 2로 전파
def virus(x,y,s):
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<m:
            if s[nx][ny]==0:
                s[nx][ny]=2
                virus(nx,ny,s)

#벽을 세워야하는 모든 경우의 수
def wall():
    global arr2
    global result
    for i in range(n): 
        for j in range(m): 
            if arr[i][j]==0:
                arr2.append((i,j))
    
    #print(arr2)
    arr3=comb(arr2,3)
    #print(list(arr3))
    
    for i in arr3:
        s=copy.deepcopy(arr)
        for j in range(3):
            a,b=i[j]
            s[a][b]=1
           
        for z in range(n):
            for x in range(m):
                if s[z][x]==2:
                    virus(z,x,s)
            
        result=max(result,count_zero(s))
        #print(result)
        
                
wall() 
print(result)


# In[ ]:




