#!/usr/bin/env python
# coding: utf-8

# 어떤 나라에는 1~N번까지의 도시와 M개의 단방향 도로가 존재합니다. 모든 도로의 거리는 1입니다. 이때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시의 번호를 출력하는 프로그램을 작성하세요. 또한 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정합니다.
# 예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 합시다. 이때 1번도시에서 출발하여 도달할 수 있는 도시중에서, 최단 거리가 2인 도시는 4번도시 뿐입니다. 2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않습니다.

# # 입력조건
# 첫째 줄에 도시의 개수N, 도로의 개수M, 거리정보 K, 출발 도시의 번호 X가 주어집니다.(2<=N<=300,000, 1<=M<=1,000,000, 1<=k<=300,000, 1<=X<=N)
# 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A,B가 주어지며, 각 자연수는 공백으로 구분합니다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미입니다.(1<=A, B<=N)단, A와 B는 서로다른 자연수 입니다.

# # 출력조건
# X로부터 출발하여 도달할 수 있는 도시 중에서, 최단거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력합니다.
# 이때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력합니다.

# # 입력예시
# 4 4 2 1
# 
# 1 2
# 
# 1 3
# 
# 2 3
# 
# 2 4
# 
# # 출력예시
# 4

# In[7]:


from collections import deque

n,m,k,x=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)
distance=[0]*(n+1)

#그래프 간선 연결
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)

#bfs
def bfs(graph,start,visited):
    queue=deque([start])
    visited[start]=True
    
    while queue:
        v=queue.popleft()
        
        for i in graph[v]:
            if not visited[i]:
                distance[i]=distance[v]+1
                queue.append(i)
                visited[i]=True
    
bfs(graph,x,visited)
for i in range(n+1):
    if distance[i]==k:
        print(i)


# In[8]:


print(distance)


# *dijkstra는 distance가 여러개, dfs,bfs는 distance가 1일때 사용 한다는 점!

# In[ ]:




