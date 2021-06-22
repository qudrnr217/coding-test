#!/usr/bin/env python
# coding: utf-8

# In[31]:


N=int(input())
load=input().split()
print(load)
x,y=1,1

for i in load:
    if i=='R':
        y+=1
        if y>N:
            y-=1
    elif i=='L':
        y-=1
        if y<1:
            y+=1
    elif i=='U':
        x-=1
        if x<1:
            x+=1;
    elif i=='D':
        x+=1
        if x>N:
            x-=1
print(x,y)
    


# # 정답

# In[39]:


n=int(input())
x,y=1,1
plans=input().split()

#L, R, U, D에 따른 이동 방향
dx=[0,0,-1,1]
dy=[-1,1,0,0]
move_types=['L','R','U','D']

for plan in plans:
    for i in range(len(move_types)):
        if plan==move_types[i]:
            nx=x+dx[i]
            ny=y+dy[i]
    if nx<1 or ny<1 or nx>N or ny>N:
        continue
    
    x,y=nx, ny

print(x,y)


# 
