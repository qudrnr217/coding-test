#!/usr/bin/env python
# coding: utf-8

# 정렬된 두 묶음의 숫자 카드가 있을 때 각 묶음의 카드의 수를 A,B라 하면 보통 두묶음을 합쳐셔 하나로 만드는 데에는 A+B번의 비교를 해야 합니다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요합니다.<br>
# 매우 많은 숫자 카드 묶음이 책상 위에 놓여 있습니다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라집니다. 예를 들어 10장, 20장 ,40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10+20)+(30+40)=100번의 비교가 필요합니다. 그러나 10장과 40장을 합친 뒤, 합친50장 묶음과 20장을 합친다면 (10+40)+(50+20)=120번의 비교가 필요하므로 덜 효율적인 방법입니다.<br>
# N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하세요.

# # 입력 조건
# 첫째 줄에 N이 주어집니다.(1<=N<=100,000)이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어집니다.
# 
# # 출력 조건
# 첫째 줄에 최소 비교 횟수를 출력합니다.(21억이하)
# 
# # 입력 예시
# 3<br>
# 10<br>
# 20<br>
# 40<br>
# 
# # 출력 예시
# 100

# In[2]:


import heapq
n=int(input())
arr=[10,20,40,50]
count=0
hi=0
result=[]
# for i in range(n):
#     a=int(input())
#     arr.append(a)

q=[]
#q에다가 넣어!
for i in arr:
    heapq.heappush(q,i)
    
print(q)
#q에서 가장 작은 것끼리 더해나간다
while q:
    a=heapq.heappop(q)
    count+=1
    hi+=a
    if count==2:
        heapq.heappush(q,hi)
        result.append(hi)
        hi=0
        count=0

print(result)
a=sum(result)
print(a)



    


# In[ ]:




