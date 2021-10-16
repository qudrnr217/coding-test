#!/usr/bin/env python
# coding: utf-8

# NxN 크기의 시험관이 있습니다. 시험관은 1x1크기의 칸으로 나누어지며, 특정한 위치에는 바이러스가 존재할 수 있습니다. 바이러스의 종류는 1~K번까지 K가지가 있으며 모든 바이러스는 이 중 하나에 속합니다.
# 시험관에 존재하는 모든 바이러스는 1초마다 상,하,좌,우의 방향으로 증식하는데, 매초 번호가 낮은 종류의 바이러스로부터 먼저 증식합니다. 또한 증식 과정에서 특정한 칸에 이미 어떠한 바이러스가 있다면, 그곳에는 다른 바이러스가 들어갈 수 없습니다.
# 시험관의 크기와 바이러스의 위치 정보가 주어졌을 때, S초가 지난 후에 (X,Y)에 존재하는 바이러스의 종류를 출력하는 프로그램을 작성하세요. 만약 S초가 지난 후에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력합니다. 이떄 X와 Y는 각각 행과 열의 위치를 의미하며, 시험관의 가장 왼쪽위에 해당하는 곳은 (1,1)에 해당합니다. 예를 들어 다음과 같이 3x3크기의 시험관에 서로 다른 1번 2번 3번 바이러스가 각각(1,1),(1,3),(3,1)에 위치해 있을 때 2초가 지난 뒤에 (3,2)에 존재하는 바이러스의 종류를 계산해보겠습니다.
# 결과적으로 2초가 지난 뒤에 (3,2)에 존재하는 바이러스의 종류는 3번 바이러스입니다. 따라서 3을 출력하면 정답입니다.

# # 입력 조건
# 첫째 줄에 자연수 N,K가 주어지며, 각 자연수는 공백으로 구분합니다.
# (1<=N<=200, 1<=K<=1,000)<br>
# 둘째 줄부터 N개의 줄에 걸쳐서 시험관의 정보가 주어집니다. 각 행은 N개의 원소로 구성되며, 해당 위치에 존재하는 바이러스의 번호가 주어지며 공백으로 구분합니다. 단, 해당 위치에 바이러스가 존재하지 않는 경우 0이 주어집니다. 또한 모든 바이러스의 번호는 K이하의 자연수로만 주어집니다.<br>
# N+2번째 줄에는 S,X,Y가 주어지며 공백으로 구분합니다.(0<=S<=10,000, 1<=X,Y<=N)
# 
# # 출력 조건
# S초 뒤에 (X,Y)에 존재하는 바이러스의 종류를 출력합니다. 만약 S초뒤에 해당위치에 바이러스가 존재하지 않는다면 0을 출력합니다.

# # 입력 예시1
# 3 3<br>
# 1 0 2<br>
# 0 0 0<br>
# 3 0 0<br>
# 2 3 2<br>
# 
# # 출력 예시1
# 3
# 
# # 입력 예시2
# 3 3<br>
# 1 0 2<br>
# 0 0 0<br>
# 3 0 0<br>
# 1 2 2<br>
# 
# # 출력 예시2
# 0

# In[6]:


import copy
n,k=map(int,input().split())
arr=[[1,0,2],[0,0,0],[3,0,0]]

s,x,y=2,3,2


# In[7]:


#동서남북
dx=[1,-1,0,0]
dy=[0,0,1,-1]

#시간
cnt=0 
min_num=[]
def virus(a,b,c):
    for i in range(4):
        nx=a+dx[i]
        ny=b+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<k:
            if arr[nx][ny]==0:#옆이 0일 경우
                arr[nx][ny]=c
                min_num.append((nx,ny))
            #옆의 숫자가 같을경우
            elif arr[nx][ny]==c:
                continue
            #옆의 숫자가 다를 경우
            else:
                if arr[nx][ny]<c:
                    continue
            

for i in range(n):
    for j in range(k):
        if arr[i][j]!=0:
            virus(i,j,arr[i][j])
cnt+=1
while cnt<=s:
    for i in range(len(min_num)):
        a,b=min_num[i]
        virus(a,b,arr[a][b])
        
    cnt+=1

print(arr)   
if arr[x-1][y-1]==0:
    print(0)
else:
    print(arr[x-1][y-1])

#min_num=sorted(min_num,key=lambda x:x[0])
#print(min_num)


# In[4]:


import copy
#from collections from deque
import heapq
n,k=map(int,input().split())
arr=[[1,0,2],[0,0,0],[3,0,0]]

s,x,y=1,2,2


# In[5]:


# 동서남북
dx=[1,-1,0,0]
dy=[0,0,1,-1]
cnt=0
q=[]
visited=[[False]*k for _ in range(n)]
def virus(x,y,c):
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            
            if nx>=0 and nx<n and ny>=0 and ny<k:
                #옆에 0이 있을 경우
                if arr[nx][ny]==0:
                    arr[nx][ny]=c
                    
while cnt<s:
    for i in range(n):
        for j in range(k):
            if arr[i][j]!=0:
                if visited[i][j]==False:
                    heapq.heappush(q,(arr[i][j],i,j))
                    visited[i][j]=True

    while q:
        c,a,b=heapq.heappop(q)
        virus(a,b,c)
    cnt+=1


print(arr[x-1][y-1])


# In[ ]:




