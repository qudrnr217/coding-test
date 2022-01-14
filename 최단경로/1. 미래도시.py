#!/usr/bin/env python
# coding: utf-8

# In[5]:


import heapq
import sys



n,m=map(int,input().split())
INF=int(1e9)
graph=[[] for i in range(n+1)]
distance=[INF]*(n+1)


for _ in range(m): #간선을 연결
    a,b=map(int,input().split())
    graph[a].append((b,1))

#x와 k
x,k=map(int,input().split())
    
#dijkstar
def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    
    while q:
        dist, now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost=dist+1
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
                    
#start지점
#1->k

dijkstra(1)
sum1=distance[k]
if(distance[k]==INF):
    print(-1)
    sys.exit()
#k->x
dijkstra(k)
sum2=distance[x]
if(distance[x]==INF):
    print(-1)
    sys.exit()
sum=sum1+sum2
print(sum)



    


# In[ ]:




