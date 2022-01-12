#!/usr/bin/env python
# coding: utf-8

# N명의 병사가 무작위로 나열되어 있습니다. 각 병사는 특정한 값의 전투력을 보유하고 있으며, 병사를 배치할 때는 전투력이 높은 병사가 앞쪽에 오도록 내림차순으로 배치를 하고자 합니다. 다시 말해 앞쪽에 있는 병사의 전투력이 항상 뒤쪽에 있는 병사보다 높아야합니다.<br>
# 또한 배치 과정에서는 특정한 위치에 있는 병사를 열외시키는 방법을 이용합니다. 그러면서도 남아 있는 병사의 수가 최대가 되도록 하고 싶습니다.<br>
# 예를 들어, N=7일 때 나열된 병사들의 전투력이 다음과 같다고 가정하겠습니다.<br>
# 병사 번호<br>
# 1 2 3 4 5 6 7<br>
# 전투력<br>
# 15 11 4 8 5 2 4<br>
# 이때 3번 병사와 6번 병사를 열외 시키면, 다음과 같이 남아 있는 병사의 수가 내림차순의 형태가 되며 5명이 됩니다. 이는 남아 있는 병사의 수가 최대가 되도록 하는 방법입니다.<br>
# 병사 번호<br>
# 1 2 4 5 7<br>
# 전투력<br>
# 15 11 8 5 4<br>
# 병사에 대한 정보가 주어졌을 때, 남아 있는 병사의 수가 최대가 되도록 하기 위해서 열외시켜야 하는 병사의 수를 출력하는 프로그램을 작성하세요.
# 
# # 입력 조건 
# 첫째 줄에 N이 주어집니다.(1<=N<=2,000)둘째 줄에 각 병사의 전투력이 공백으로 구분되어 차례대로 주어집니다. 각 병사의 전투력은 10,000,000보다 작거나 같은 자연수입니다.<br>
# 
# # 출력 조건
# 첫째 줄에 남아 있는 병사의 수가 최대가 되도록 하기 위해서 열외시켜야 하는 병사의 수를 출력합니다.<br>
# 
# # 입력 예시
# 7<br>
# 15 11 4 8 5 2 4<br>
# 
# # 출력 예시
# 2

# In[12]:


d=[]
# arr=[15, 11, 4, 8, 5, 2, 4]
#arr=[15,3,5,11,4,2,1]
for i in range(len(arr)):
    if i+1<len(arr):
        d.append(max(arr[i],arr[i+1]))

data=set(d)
print(data)
print(len(arr)-len(data))

    


# In[33]:


n=7
d=[]
arr=[15,3,5,11,4,2,1]

arr2=sorted(arr,reverse=True)

print(arr2)

while arr:
    for i in arr2:
        if arr[0]==i:
            d.append(arr[0])
            arr.pop(0)
        else:
            print(arr[0])
            while arr[0]!=i:
                arr.pop(0)
            d.append(arr[0])
            arr.pop(0)
            
    print(d)
    
    


# In[113]:


n=7
d=[]
#arr=[15,3,5,11,4,2,1]
#arr=[11,3,5,15,4,2,1]
length=len(arr)-1

j=1

for com in arr:
    start=len(arr)-length
#     print(com)
#     print('start=',start)
#     print('length=',length)
    cnt=0
    if start==len(arr):
        d.append(com)
    for b in range(start,len(arr)):
        if com>=arr[b]:
            cnt+=1
        else:
            length-=j
            break

        if cnt==length:
            d.append(com)
            length-=j

hi=len(d)
print(len(arr)-hi)


# In[112]:


n=7
d=[1]*n
#arr=[15,3,5,11,4,2,1]
#arr=[11,3,5,15,4,2,1]
arr=[10,20,10,30,20,50]
arr.reverse()
print(arr)

for i in range(len(arr)):
    for j in range(i):
        if arr[i]>arr[j]:
            d[i]=max(d[i],d[j]+1)

print(n-max(d))


# In[ ]:




