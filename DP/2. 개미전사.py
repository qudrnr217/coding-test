#!/usr/bin/env python
# coding: utf-8

# 개미 전사는 부족한 식량을 충당하고자 메뚜기 마을의 식량창고를 몰래 공격하려고 한다. 메뚜기 마을에는 여러 개의 식량창고가 있는데 식량창고는 일직선으로 이어져 있다. 각 식량창고에는 정해진 수의 식량을 저장하고 있으며 개미 전사는 식량창고를 선택적으로 약탈하여 식량을 빼앗을 예정이다. 이때 메뚜기 정찰병들은 일직선상에 존재하는 식량창고 중에서 서로 인접한 식량창고가 공격받으면 바로 알아챌 수 있다. 따라서 개미 전사가 정찰병에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸 이상 떨어진 식량창고를 약탈해야한다. 예를 들어 식량창고 4개가 다음과 같이 존재한다고 가정한다.
# {1,3,1,5}
# 이때 개미 전사는 두 번째 식량창고와 네 번째 식량창고를 선택했을 때 최댓값인 총 8개의 식량을 빼앗을 수 있다. 개미전사는 식량창고가 이렇게 일직선상일 때 최대한 많은 식량을 얻길 원한다. 개미 전사를 위해 식량창고 N개에 대한 정보가 주어졌을 때 얻을 수 있는 식량의 최댓값을 구하는 프로그램을 작성하시오.

# # 입력 조건

# 첫째 줄에 식량창고 개수가 N이 주어진다.(3<=N<=100)
# 둘째 줄에 공백으로 구분되어 각 식량창고에 저장된 식량의 개수 K가 주어진다.(0<=K<=1000)

# # 출력 조건

# 첫째 줄에 개미 전사가 얻을 수 있는 식량의 최댓값을 출력하시오.

# In[51]:


n=int(input())
w_house=list(map(int,input().split()))


# In[56]:


d=[0]*101
for i in range(n-3):
    #i+2, i+3을 비교
    if w_house[i]+w_house[i+2]>=w_house[i]+w_house[i+3]:
        if i+2>=len(w_house):
            d[i]=w_house[i]
            break
        d[i]=w_house[i]+w_house[i+2]
        
    else:
        if i+3>=len(w_house):
            d[i]=w_house[i]
            break
        d[i]=w_house[i]+w_house[i+3]
        


# In[ ]:


#i=0과 i=1의 총합을 더해 최댓값 구하기.
for i in range(len(w_house)):
    
    


# In[57]:


n=int(input())
w_house=list(map(int,input().split()))


# In[58]:


d=[0]*101
d[0]=w_house[0]
d[1]=w_house[1]

j=0
for i in range(2):
    while True:
        #j+2, j+3을 비교
        if j+3>=n-1:
            d[i]+=w_house[n-1]
            j=1
            break
        if w_house[j]+w_house[j+2]>=w_house[j]+w_house[j+3]:
            if j+2>=n-1:
                continue
            d[i]+=w_house[j+2]
            j+=2       
        else: 
            if j+2>=n-1:
                continue
            d[i]+=w_house[j+3]
            j+=3
            
if d[0]>=d[1]:
    print(d[0])
else:
    print(d[1])
        


# In[63]:


# bottom-up
d=[0]*101
d[0] = w_house[0]
d[1] = max(w_house[0], w_house[1])

for i in range(2, n):
    # 1,3,5,1
    #d[i]+=max(w_house[i+2],w_house[i+3])
    if d[i-1] > d[i-2]:
        d[i] = max(d[i-1],w_house[i])
    else:
        d[i] = d[i-2] + w_house[i]
        
    #max(w_house[i],d[i-1]+w_house[i+1])
for i in range(n):
    print(d[i])


# In[73]:


n=int(input())
w_house=list(map(int,input().split()))


# In[74]:


d=[0]*101
d[0]=w_house[0]
d[1]=max(w_house[0],w_house[1])

for i in range (2,n):
    d[i]=max(d[i-1],d[i-2]+w_house[i])
    print('d[i]=',d[i])
print(d[n-1])


# In[ ]:


# top-down
d=[0]*101
def dynamic(x):
    # exit
    if x==0:
        return 1
    
    # memoization
    if ():
        d[i] = d[i-1] + 1 
    # recursive
    elif (조건):
        return dynamic(x-1) + 1
    else:
        
print(dynamic(x))

