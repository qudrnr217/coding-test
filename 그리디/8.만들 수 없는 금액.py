#!/usr/bin/env python
# coding: utf-8

# 동네 편의점주인인 동빈이는 N개의 동전을 가지고 있습니다. 이때 N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램을 작성하세요.<br>
# 예를 들어, N=5이고, 각 동전이 각각 3원, 2원, 1원, 1원, 9원짜리(화폐 단위) 동전이라고 가정합시다. 이때 동빈이가 만들 수 업는 양의 정수 금액 중 최솟값은 8원 입니다.<br>
# 또, 다른 예시로, N=3이고, 각 동전이 각각 3원, 5원, 7원짜리 동전이라고 가정합시다. 이떄 동빈이가 만들 수 업는 양의 정수 금액 중 최솟값은 1원입니다.

# # 입력 조건
# 첫째 줄에는 동전의 개수를 나타내는 양의 정수 N이 주어집니다. (1<=N<=1,000)<br>
# 둘째 줄에는 각 동전의 화폐단위를 나타내는 N개의 자연수가 주어지며, 각 자연수는 공백으로 구분합니다. 이때, 각 화폐 단위는 1,000,000 이하의 자연수입니다.
# 
# # 출력 조건
# 첫째 줄에 주어진 동전들로 만들 수 없는 양의 정수 금액중 최솟값을 출력합니다.
# 
# # 입력 예시
# 5<br>
# 3 2 1 1 9
# 
# # 출력 예시
# 8

# In[32]:


#조합으로 풀기 
from itertools import combinations as combi
n=int(input())
arr=[3,2,1,1,9]
arr.sort()
arr2=[]
for i in range(1,n+1):
    arr2.append(list(combi(arr,i)))

print(arr2)
print(sum(arr2[0][0]))


# 

# In[2]:


n=int(input())
arr=[3,2,1,1,9]
arr.sort()

# 1 1 2 3 9
target=1

for i in arr:
    if target<i: 
        break;
    target+=i
    print(target, i)
    
print(target)
        


# In[ ]:




