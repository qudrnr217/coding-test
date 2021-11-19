#!/usr/bin/env python
# coding: utf-8

# 동빈이네 전자 매장에는 부품이 N개가 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다. 동빈이는 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야한다. 이떄 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.

# In[8]:


def binary_search(arr,target,start,end):
    if start>end:
        return None
    mid=(start+end)//2
    if arr[mid]==target:
        return mid
    elif arr[mid]>target:
        return binary_search(arr,target,start,mid-1)
    else:
        return binary_search(arr,target,mid+1,end)
    
        


# In[11]:


n=int(input())
parts = list(map(int,input().split()))
m=int(input())
find_parts = list(map(int,input().split()))
parts=[8, 3, 7, 9, 2]
find_parts=[5, 7, 9]
parts.sort()

for i in find_parts:
    result=binary_search(parts,i,0,n-1)
    if result==None:
        print('No')
    else:
        print('Yes')


# In[ ]:




