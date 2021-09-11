#!/usr/bin/env python
# coding: utf-8

# 평소 식욕이 왕성한 무지는 자신의 재능을 뽐내고 싶어졌고 고민 끝에 카카오 TV라이브 방송을 하기로 마음 먹었습니다. 그냥 먹방을 하면 다른 방송과 차별성이 없기 때문에 무지는 다음과 같이 독특한 방식을 생각해냈습니다.<br>
# 회전판에 먹어야 할 N개의 음식이 있습니다. 각 음식에는 1부터 N까지의 번호가 붙어있으며, 각 음식을 섭취하는데 일정 시간이 소요됩니다. 무지는 다음과 같은 방법으로 음식을 섭취합니다.<br>
# 1. 무지는 1번 음식부터 먹기 시작하며, 회전판은 번호가 증가하는 순서대로 음식을 무지 앞으로 가져다 놓습니다.
# 2. 마지막 번호의 음식을 섭취한 후에는 회전판에 의해 다시 1번 음식이 무지 앞으로 옵니다.
# 3. 무지는 음식 하나를 1초 동안 섭취한 후 남은 음식은 그대로 두고, 다음 음식을 섭취합니다. 다음 음식이란, 아직 남은 음식 중 다음으로 섭취해야할 가장 가까운 번호의 음식을 말합니다.
# 4. 회전판이 다음 음식을 무지 앞으로 가져오는데 걸리는 시간은 없다고 가정합니다.
# 
# 무지가 먹방을 시작한 지 K초 후에 네트워크 장애로 인해 방송이 잠시 중단되었습니다. 무지는 네트워크 정상화 후 다시 방송을 이어갈 때, 몇 번 음식부터 섭취해야 하는지를 알고자 합니다. 각 음식을 모두 먹는 데 필요한 시간이 담겨 있는 배열 food_times, 네트워크 장애가 발생한 시간 K초가 매개변수로 주어질 때 몇 번 음식부터 다시 섭취하면 되는지 return 하도록 solution함수를 완성하세요.
# 
# # 제한 사항
# food_times는 각 음식을 모두 먹는 데 필요한 시간이 음식의 번호 순서대로 들어 있는 배열입니다.<br>
# k는 방송이 중단된 시간을 나타냅니다.<br>
# 만약 더 섭취해야 할 음식이 없다면 -1을 반환합니다.
# 
# # 정확성 테스트 제한 사항
# food_times의 길이는 1이상 2000이하입니다.<br>
# food_times의 원소는 1이상 1000이하의 자연수입니다.
# k는 1 이상 2000000이하의 자연수입니다.
# 
# # 효율성 테스트 제한 사항
# food_times의 길이는 1이상 200000이하 입니다.
# food_times의 원소는 1이상 100000000이하의 자연수입니다.
# k는 1이상 2x10^13이하의 자연수입니다.
# 
# # 입출력 예시
# food times =[3,1,2]<br>
# k=5<br>
# result=1
# 
# # 입출력 예시에 대한 설명
# 0-1초 동안에 1번 음식을 섭취한다. 남은시간은 [2,1,2]입니다.<br>
# 1-2초 동안에 2번 음식을 섭취한다. 남은시간은 [2,0,2]입니다.<br>
# 2-3초 동안에 3번 음식을 섭취한다. 남은시간은 [2,0,1]입니다.<br>
# 3-4초 동안에 1번 음식을 섭취한다. 남은시간은 [1,0,1]입니다.<br>
# 4-5초 동안에 (2번 음식은 다먹었으므로) 3번 음식을 섭취한다. 남은시간은[1,0,0]입니다.<br>
# 5초에서 네트워크 장애가 발생했습니다. 1번 음식을 섭취해야 할 때 중단되었으므로, 장애 복구 후에 1번 음식부터 다시 먹기 시작하면됩니다.

# In[11]:


import heapq
food_times = [3, 1, 2]   
k = 5
answer=0

q=[]
for i in range(len(food_times)):
    heapq.heappush(q,(food_times[i],i+1))

print(q)
# a,b=heapq.heappop(q)
# min_food=a
min_food=q[0][0]
pre_food=0
length=len(food_times)    
while True:
    #사이클이 돌고 k보다 작으면 탈출문
    if k - (min_food-pre_food)*length<0:
        break
        
    k-=(min_food-pre_food)*length
    print(k)
    pre_food=min_food
    heapq.heappop(q)
    length-=1
     #큐가 다 비었는데 아직 k가 남아있다면 음식을 다먹었다는 뜻임
#     print(q)
    if not q:
        print(-1)
        break
    min_food=q[0][0]
    
idx=k%length
print(idx)
q.sort(key=lambda x: x[1])
print(q)
answer=q[idx][1]
print(answer)
   
    


# In[ ]:


# 시간 초과 코드들


# In[71]:


import heapq
food_times = [4, 3, 5, 6, 2]   
k = 7
result=[]
answer=0
cnt=0
total=0
q=[]
for i in range(len(food_times)):
    heapq.heappush(q,(food_times[i],i+1))
    
while q:
    a,b=heapq.heappop(q)
    if k-a>0:
        k-=a
    else:
        result.append((a-k,b))
        # [1,3,4]
        

# print(result)
# if k>max(result[0]):
#     answer=-1
if result==[]:
    answer=-1

else:
    total=k%len(result)
    answer=result[total][0]
    print(answer)
    


# In[11]:


food_times =[3,1,2]
k=5
answer=0

a=k//len(food_times)
b=k%len(food_times)
cnt=b+1

for i in range(len(food_times)):
    food_times[i]-=a
print(food_times)

while cnt!=0:
    for i in range(len(food_times)):
        if food_times[i]>0:
            food_times[i]-=1
            cnt-=1
            if cnt==0:
                print(i+1)
        else:
            continue
  
    


# In[20]:


food_times =[3,1,2]
k=5
answer=0
cnt=0


# min_a=min([x for x in food_times if x!=0])
# print(min_a)
for i in range(len(food_times),-1,-1):
    if k//min([x for x in food_times if x!=0])*i!=0: 
        k-=min([x for x in food_times if x!=0])*i
        #배열에서 최솟값을 빼주기
        for j in range(len(food_times)):
            if food_times[j]==0:
                continue
            food_times[j]-=k
    else:
        cnt=k+1
        break
        
while cnt!=0:
    for i in range(len(food_times)):
        if food_times[i]==0:
            continue
        else:
            cnt-=1
            if cnt==0:
                print(i)
        

    


# In[23]:


food_times =[3,1,2]
k=5
result=0
time=0

while True:
    for i in range(len(food_times)):
        
        if time==k:
            result=i+1
        print(food_times)
        if food_times[i]==0:
            continue
        food_times[i]-=1
        time+=1
    if time==k+1:
        break
        
print(result)
        

