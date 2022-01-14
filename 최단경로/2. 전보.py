#!/usr/bin/env python
# coding: utf-8

# In[8]:


#import sys
import heapq
#input=sys.stdin.readline
INF=int(1e9)
count=0
#입력
n,m,c=map(int,input().split())
start=c
graph=[[] for i in range(n+1)]
distance=[INF]*(n+1)

#간선 입력
for _ in range(m):
    x,y,z=map(int,input().split())
    graph[x].append((y,z))

#dijkstra
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
                
dijkstra(start)
for i in range(1,n+1):
    if distance[i]==INF:
        continue
    else:
        count+=1
#print(distance)
distance[0]=0
h_num=max(distance)        
print(count-1, h_num)#자기 자신은 빼야하므로 -1
        

        
        
    


# In[ ]:




