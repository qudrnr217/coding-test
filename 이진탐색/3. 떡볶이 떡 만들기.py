#!/usr/bin/env python
# coding: utf-8

# 오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다. 오늘은 떡을 만드는 날이다. 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
# 절단기에 높이(H)를 저장하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
# 예를 들어 높이가 19,14,10,17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡의 높이는 15, 13, 19 ,15가 될 것이다. 잘린 떡의 길이는 차례대로 4,0,0,2cm이다. 손님은 6cm만큼의 길이를 가져간다.
# 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
# 

# In[12]:


def binary_search(arr,target,start,end):
    sum=0
    if start>end: #해당하는 떡의 길이가 없을 때
        return None
    mid=(start+end)//2
    for i in arr: #칼의 높이를 뺀 떡의 총합의 길이
        if i>mid: #떡을 잘랐을 떄 0은 배제하고 나머지길이를 더함
            sum+=i-mid
    if sum==target: #sum과 고객이 가져가는 총 떡의 길이가 같을 때
        return mid
    elif sum>target: #sum이 target보다 길 때는 start가 mid보다 길어야함.
        return binary_search(arr,target,mid+1,end)
    else: #sum이 target보다 짧을 때는 end가 mid보다 짧아야함.
        return binary_search(arr,target,start,mid-1)


# In[14]:


n,m=map(int,input().split())
h=list(map(int,input().split()))
max_h=max(h)
#arr=[x for x in range((max_h)+1)]
#print(arr)
print(binary_search(h,6,0,max_h))


# In[ ]:




