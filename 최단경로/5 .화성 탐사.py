#!/usr/bin/env python
# coding: utf-8

# 당신은 화성 탐사 기계를 개발하는 프로그래머 입니다. 그런데 화성은 에너지 공급원을 찾기가 힘듭니다.<br>
# 그래서 에너지를 효율적으로 사용하고자 화성 탐사 기계가 출발 지점에서 목표 지점까지 이동할 때 항상 최적의 경로를 찾도록 개발해야 합니다.<br>
# 화성 탐사 기계가 존재하는 공간은 NxN크기의 2차원 공간이며, 각각의 칸을 지나기 위한 비용(에너지 소모량)이 존재합니다. 가장 왼쪽 위 칸인 [0][0] 위치에서 가장 오른쪽 아래 칸인[N-1][N-1]위치로 이동하는 최소 비용을 출력하는 프로그램을 작성하세요. 화성 탐사 기계는 특정한 위치에서 상하좌우 인접한 곳으로 1칸씩 이동할 수 있습니다.

# # 입력 조건
# 첫째 줄에 테스트 케이스의 수 T(1<=T<=10)가 주어집니다.<br>
# 매 테스트 케이스의 첫째 줄에는 탐사 공간의 크기를 의미하는 정수 N이 주어집니다.(0<=각 칸의 비용<=9)<br>
# 
# # 출력 조건
# 각 테스트 케이스마다 [0][0]의 위치에서 [N-1][N-1]의 위치로 이동하는 최소 비용을 한 줄에 하나씩 출력합니다.

# # 입력 예시
# 3<br>
# 3<br>
# 5 5 4<br>
# 3 9 1<br>
# 3 2 7<br>
# 5<br>
# 3 7 2 0 1<br>
# 2 8 0 9 1<br>
# 1 2 1 8 1<br>
# 9 8 9 2 0<br>
# 3 6 5 1 5<br>
# 7<br>
# 9 0 5 1 1 5 3<br>
# 4 1 2 1 6 5 3<br>
# 0 7 6 1 6 8 5<br>
# 1 1 7 8 3 2 3<br>
# 9 4 0 7 6 4 1<br>
# 5 8 3 2 4 8 3<br>
# 7 4 8 4 8 3 4<br>
# 
# # 출력 예시
# 20<br>
# 19<br>
# 36<br>

# In[20]:


import heapq
INF=int(1e2)
t=int(input())
n=int(input())
graph=[[]*n for _ in range(n)]
distance=[[INF]*n for _ in range(n)]
for i in range(n):
    graph[i]=list(map(int,input().split()))
    
print(graph)

#동서 남북
dx=[1,-1,0,0]
dy=[0,0,1,-1]


# In[22]:


def dijkstra(start,end,graph):
    q=[]
    heapq.heappush(q,(graph[0][0],start,end))
    distance[start][end]=graph[start][end]
    
    while q:
        dist,a,b=heapq.heappop(q)
        
        if distance[a][b]<dist:
            continue
    
        for k in range(4):
            nx=a+dx[k]
            ny=b+dy[k]
                
            if nx>=0 and nx<n and ny>=0 and ny<n:
                    cost=dist+graph[nx][ny]
                    if cost<distance[nx][ny]:
                        distance[nx][ny]=cost
                        heapq.heappush(q,(cost,nx,ny))
                        
dijkstra(0,0,graph)
print(distance)
print(distance[n-1][n-1])
                    


# In[ ]:




