#!/usr/bin/env python
# coding: utf-8

# 선생님은 시험을 본 학생 N명의 성적을 분실하고, 성적을 비교한 결과의 일부만 가지고 있습니다. 학생 B명의 성적은 모두 다른데, 다음은 6명의 학생에 대하여 6번만 성적을 비교한 결과 입니다.
# 
# 1번학생의 성적<5번학생의 성적
# 3번학생의 성적<4번학생의 성적
# 4번학생의 성적<2번학생의 성적
# 4번학생의 성적<6번학생의 성적
# 5번학생의 성적<2번학생의 성적
# 5번학생의 성적<4번학생의 성적
# 
# A번 학생의 성적이 B번 학생보다 낮다면 화살표가 A->B를 가리키도록 할 때 위의 성적 결과를 다음 그림처럼 표현할 수 있습니다.
# 
# 이 그림으로 유추해서 순위를 정확히 알 수 있는 학생도 있고, 알 수 없는 학생도 있습니다. 예를 들어 1번학생은 5번학생보다 성적이 낮고, 5번학생은 4번학생보다 성적이 낮으므로 1번학생은 4번학생보다 성적이 낮습니다. 따라서 1번, 3번, 5번학생은 모두 4번 학생보다 성적이 낮다고 볼 수 있습니다. 그리고 4번학생은 2번학생과 6번학생보다 성적이 낮습니다. 정리하면 4번 학생보다 성적이 낮은 학생은 3명이고, 성적이 높은 학생은 2명이므로 4번 학생의 성적 순위를 정확히 알 수 있습니다. 하지만 예시에서 4번 학생을 제외한 다른 학생은 정확한 순위를 알 수 없습니다. 학생들의 성적을 비교한 결과가 주어질 때, 성적 순위를 정확히 알 수 있는 학생은 모두 몇명인지 계산하는 프로그램을 작성하세요.

# # 입력조건
# 첫째 줄에 학생들의 수 N(2<=N<=500)과 두 학생의 성적을 비교한 횟수 M(2<=M<=10,000)이 주어집니다.
# 다음 M개의 각 줄에는 두 학생의 성적을 비교한 결과를 나타내는 두 양의 정수 A와 B가 주어집니다. 이는 A번학생의 성적이 B번 학생보다 낮다는 것을 의미합니다.
# 
# # 출력조건
# 첫째 줄에 성적 순위를 정확히 알 수 있는 학생이 몇명인지 출력합니다.
# 
# # 입력예시
# 6 6<br>
# 1 5<br>
# 3 4<br>
# 4 2<br>
# 4 6<br>
# 5 2<br>
# 5 4<br>
# 
# # 출력예시
# 1

# In[16]:


n,m=map(int,input().split())
INF=int(1e2)
graph=[[INF]*(n+1) for _ in range(n+1)]
know=0
#자기 자신은 0으로 초기화
for i in range(1,n+1):
    for j in range(1,n+1):
        if i==j:
            graph[i][j]=0
            
            
#그래프 생성
for i in range(m):
    a,b=map(int,input().split())
    graph[a][b]=1
    
#플루이드 워셜
for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            graph[i][j]=min(graph[i][j],graph[i][k]+graph[k][j])
            
for i in range(1,n+1):
    count=0
    for j in range(1,n+1):
        if graph[i][j]!=INF or graph[j][i]!=INF:
            count+=1
    print(graph)
    if count==n:
        know+=1

print(know)
    
        
            


# In[19]:


import heapq
import numpy as np
n,m=map(int,input().split())
INF=int(1e2)
distance=[INF]*(n+1)

graph=[[] for _ in range(n+1)]

for i in range(n):
    a,b=map(int,input().split())
    graph[a].append((b,1))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    
    while q:
        dist, now = heapq.heappop(q)
        for i in graph[now]:
            cost=dist+1
            
            if distance[i[0]]>cost:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))


count=0            
# map=[]
for i in range(1,n+1):
    dijkstra(i)

print(distance)
        
# for i in range(1,n+1):
#     result=0
#     for j in range(1,n+1):
#         if distance[i][j]!=INF or distance[j][i]!=INF:
#             count+=1
            
#     if count==n:
#         result+=1
        
# print(result)
            
            
    


# In[4]:


6 6
1 5
3 4
4 2
4 6
5 2
5 4


# In[ ]:


[[100, 100, 100, 100, 100, 100, 100], 
 [100, 0, 2, 100, 2, 1, 3], 
 [100, 100, 0, 100, 100, 100, 100], 
 [100, 100, 2, 0, 1, 100, 2], 
 [100, 100, 1, 100, 0, 100, 1], 
 [100, 100, 1, 100, 1, 0, 2], 
 [100, 100, 100, 100, 100, 100, 0]]


# In[ ]:


[100, 100, 100, 100, 100, 100, 100],
[100, 1, 100, 100, 100, 1, 100],
[100, 100, 1, 100, 100, 100, 100],
[100, 100, 100, 1, 1, 100, 100],
[100, 100, 1, 100, 1, 100, 1],
[100, 100, 1, 100, 1, 1, 100], 
[100, 100, 100, 100, 100, 100, 1]]

