#!/usr/bin/env python
# coding: utf-8

# n(1<=n<=100)개의 도시가 있고, 한 도시에서 출발하여 다른 도시에 도착하는 m(1<=m<=100,000)개의 버스가 있스니다. 각 버스는 한 번 사용할 때 필요한 비용이 있습니다. 모든 도시의 쌍(A,B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하세요.

# # 입력조건
# 첫째 줄에 도시의 개수n(1<=n<=100)이 주어집니다.
# 둘째 줄에는 버스의 개수m(1<=m<=100,000)이 주어집니다.
# 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어집니다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어집니다. 버스의 정보는 버시의 시작도시a, 도착도시는 , 한 번 타는데 필요한 비용 c로 이루어져있스니다. 시작 도시와 도착 도시가 같은경우는 없습니다. 비용은 100,000보다 작거나 같은 자연수입니다.
# 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있습니다.
# 
# # 출력 조건
# n개의 줄을 출력해야 합니다. i번째 줄에 출력하는 j번째 숫자는 도시i에서 j로 가는 데 필요한 최소 비용입니다. 만약 i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력합니다.

# In[13]:


import heapq
n=int(input())
m=int(input())
INF=int(1e9)

graph=[[] for _ in range(n+1)]

distance=[INF]*(n+1)

#간선 연결
for i in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    
#dijkstra

def dijkstra(start):
    distance=[INF]*(n+1)
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist, now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for j in graph[now]:
            cost=dist+j[1]
                
            if cost<distance[j[0]]:
                distance[j[0]]=cost
                heapq.heappush(q,(cost,j[0]))
    for i in range(1,n+1):
        print(distance[i],end=' ')
        
# for i in range(1,n+1):
#     dijkstra(i)
#     print()


# In[14]:


for i in range(1,n+1):
    dijkstra(i)
    print()


# In[ ]:




