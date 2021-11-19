#!/usr/bin/env python
# coding: utf-8

# N개의 원소를 포함하고 있는 수열이 오름차순으로 정렬되어 있습니다. 이때 이 수열에서 x가 등장하는 횟수를 계산하세요. 예를들어 [1,1,2,2,2,2,3]이 있을 때 x=2라면, 현재 수열에서 값이 2인 우너소가 4개이므로 4를 출력합니다.
# 단, 이문제는 시간 복잡도 O(lonN)으로 알고리즘을 설계하지 않으면 '시간 초과' 판정을 받습니다.

# # 입력 조건
# 첫째 줄에 N과 x가 정수 형태로 공백으로 구분되어 입력됩니다.
# (1<=N<=1,000,000), (-10^9<=x<=10^9)
# 둘째 줄에 N개의 원소가 정수 형태로 공백으로 구분되어 입력됩니다.(-10^9<=각 원소의 값<=10^9)
# 
# # 출력 조건
# 수열의 원소 중에서 값이 x인 원소의 개수를 출력합니다. 단, 값이 x인 원소가 하나도 없다면 -1을 출력합니다.
# 

# # 입력 예시
# 7 2
# 
# 1 1 2 2 2 2 3
# 
# 7 4
# 
# 1 1 2 2 2 2 3
# # 출력 예시
# 4
# 
# -1

# In[41]:


n,x = map(int,input().split())
#arr=list(map(int,input.split()))
arr=[1,1,2,2,2,2,3]
count=0
def f_binary_search(arr,target,start,end):
    while start<=end:
        mid=(start+end)//2
        if arr[mid]==target and (mid==0 or arr[mid-1]<target):
            return mid
        elif arr[mid]>=target:
            end=mid-1
        else:
            start=mid+1
        
    return None

def l_binary_search(arr,target,start,end):
    while start<=end:
        mid=(start+end)//2
        if arr[mid]==target and (mid==n-1 or arr[mid+1]>target):
            return mid
        elif arr[mid]>target:
            end=mid-1
        else:
            start=mid+1
            
    return None
result=f_binary_search(arr,x,0,n-1)
result2=l_binary_search(arr,x,0,n-1)

print(result2-result+1)


# In[42]:


from bisect import bisect_left,bisect_right

arr=[1,1,2,2,2,2,3]
n=2

bisect_right(arr,n)-bisect_left(arr,n)


# In[ ]:




