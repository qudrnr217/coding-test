#!/usr/bin/env python
# coding: utf-8

# # DFS

# In[23]:


def dfs(graph,v,visted):
    #현재 노드를 방문 처리
    visited[v]=True
    print(v, end=' ')
    #print()
    #현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        #print('그래프: ',graph[v])
        if not visited[i]:
            dfs(graph,i,visited)       
graph=[
    [],
    [2,3,6],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
#각 노드가 방문된 정보를 리스트 자료형으로 표현
visited =[False]*9

#정의된 DFS함수 호출
dfs(graph,1,visited)


# # BFS

# In[24]:


from collections import deque

#BFS 메서드 정리
def bfs(graph,start,visited):
    #큐 구현을 ㅜ이해 deque라이브러리 사용
    queue=deque([start])
    #현재 노드를 방문처리
    visited[start]=True
    #큐가 빌때 까지 반복
    while queue:
        #큐에서 하나의 원소를 뽑아 출력
        v=queue.popleft()
        print(v,end=' ')
        #해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True
graph=[
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
visited=[False]*9

bfs(graph,1,visited)


# In[ ]:


def bfs(graph,start,visited):
    queue=deque([start])
    visited[start]=True
    while queue:
        v=queue.popleft()
        print(v,end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True
                

