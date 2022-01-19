#!/usr/bin/env python
# coding: utf-8

# 동빈이는 숨바꼭질을 하면서 술래로부터 잡히지 않도록 숨을 곳을 찾고 있습니다.동빈이는 1~N까지의 헛간 중에서 하나를 골라 숨을 수 있으며, 술래는 항상 1번 헛간에서 출발합니다. 전체 맵에는 총 M개의 양방향 통로가 존재하며, 하나의 통로는 서로 다른 두 헛간을 연결합니다. 또한 전체맵은 항상 어떤 헛간에서 다른 어떤 헛간으로 도달이 가능한 형태로 주어집니다.<br>
# 동빈이는 1번 헛간으로부터 최단 거리가 가장 먼 헛간이 가장 안전하다고 판단하고 있습니다. 이때 최단 거리의 의미는 지나야하는 길의 최소 개수를 의미합니다. 동빈이가 숨을 헛간의 번호를 출력하는 프로그램을 작성하세요.<br>
# 
# # 입력 조건
# 첫째 주렝는 N과 M이 주어지며, 공백으로 구분합니다.<br>(2<=N<=20,000),(1<=M<=50,000)<br>
# 이후 M개의 줄에 걸쳐서 서로 연결된 두 헛간 A와 B의 번호가 공백으로 주어집니다.(1<=A, B<=N)<br>
# 
# # 출력 조건
# 첫 번째는 숨어야하는 헛간 번호를(만약 거리가 같은 헛간이 여러 개면 가장 작은 헛간 번호를 출력합니다). 두 번째는 그 헛간까지의 거리를, 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야 합니다.
# 
# # 입력 예시
# 6 7<br>
# 3 6<br>
# 4 3<br>
# 3 2<br>
# 1 3<br>
# 1 2<br>
# 2 4<br>
# 5 2<br>
# 
# # 출력 예시
# 4 2 3

# In[34]:


import heapq
n,m=6,7
graph=[[] for _ in range(n+1)]
INF=int(1e9)
distance=[INF]*(n+1)

for i in range(m):
    a,b=map(int,input().split())
    if a>b:
        temp=a
        a=b
        b=temp
        #print(a,b)
    graph[a].append((b,1))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    
    while q:
        dist,now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(1)
distance[0]=0
    #print(distance.index(max(distance)),max(distance),distance.count(max(distance)))
print(distance.index(max(distance)),max(distance),distance.count(max(distance)))


# In[18]:


INF=int(1e2)

n,m=6,7

graph=[[INF]*(n+1) for _ in range(n+1)]
for a in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0
            
for _ in range(m):
    a,b=map(int,input().split())
    graph[a][b]=1
            
for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])
            
for a in range(1,n+1):
    for b in range(1,n+1):
        
        print(graph[a][b],end=' ')
    print()
            


# In[ ]:




