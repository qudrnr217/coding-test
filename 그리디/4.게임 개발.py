#!/usr/bin/env python
# coding: utf-8

# In[137]:


import numpy as np
n,m = map(int,input().split())
print(n,m)
direct=[0,1,2,3]
#go=[(-1,0),(0,-1),(1,0),(0,1)]
gox=[-1,0,1,0]
goy=[0,-1,0,1]
x,y,char=map(int,input().split())
count=0
end_count=0

arr= np.zeros((n,m))
for i in range(len(direct)):
    arr[i]=list(map(int,input().split()))


# In[ ]:


char: 2
direct[i]: 0
x+gox[i] : 1
y+goy[i] : 2
arr: 1
endcount 1
char: 3
direct[i]: 1
x+gox[i] : 2
y+goy[i] : 1
arr: 1
endcount 2
char: 0
direct[i]: 2
x+gox[i] : 3
y+goy[i] : 2
arr: 1
endcount 3
char: 1
direct[i]: 3
x+gox[i] : 2
y+goy[i] : 3
arr: 1
endcount 4
2


# 
# 1 1 1 1
# 1 0 0 1
# 1 1 0 1
# 1 1 1 1

# In[145]:


# 좌표입력
arr= np.array([[1,1,1,1,],[1,0,0,1],[1,1,0,1],[1,1,1,1]])    
    
# direction is over 4
count = 1
end_count = 0
while end_count < 4:
    # 네바퀴
    end_count = 0
    for i in range(len(direct)):
        arr[x][y] =1
        
        # 0을 발견하면 이동
        if int(arr[x+gox[i]][y+goy[i]]) == 0: 
            count+=1
            x += gox[i]
            y += goy[i]
        # 아니면 방향 변경
        else:    
            end_count+=1
    print('end:',end_count)
print(count)


# In[136]:


while True:
    end_count=0
    for i in range(len(direct)):
        print(" ")
        
        print('x+gox[i] :', x+gox[i])
        print('y+goy[i] :', y+goy[i])
        print('arr:',int(arr[x+gox[i]][y+goy[i]]))
        
        arr[x][y]=1
        
        # 이동하면
        if int(arr[x+gox[i]][y+goy[i]]) != 1: 
            print('x,y:',x,y)
            #arr[x][y]=1
            count+=1
            x+=gox[i]
            y+=goy[i]
            continue
            
        # 이동하지 않으면 방향   
        else:
            char+=1
            if(char==4):
                char=0
        end_count+=1
        
        print('endcount', end_count)
        
    if(end_count==4):
        break        
                    
print(count)
    


# In[ ]:


x+gox[i] : 0
y+goy[i] : 1
arr: 1
1
x+gox[i] : 1
y+goy[i] : 0
arr: 1
2
x+gox[i] : 2
y+goy[i] : 1
arr: 1
3
x+gox[i] : 1
y+goy[i] : 2
arr: 0
x,y: 1 1
1
2
3
x+gox[i] : 1
y+goy[i] : 3
arr: 1
4
1

