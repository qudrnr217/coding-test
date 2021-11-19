#!/usr/bin/env python
# coding: utf-8

# # py 순차 탐색 소스코드

# In[1]:


def sequential_search(n,target,array):
    #각 원소를 하나씩 확인하며
    for i in range(n):
        #현재의 원소가 찾고자 하는 원소와 동일한 경우
        if array[i]==target:
            return i+1 #현재의 위치 반환(인덱스는 0부터 시작하므로 1을 더함)

print("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.")
input_data=input().split()
n=int(input_data[0]) #원소의 개수
target=input_data[1] #찾고자하는 문자열

print("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어씌기 한 칸으로 합니다.")
array=input().split()

#순차 탐색 수행결과 출력
print(sequential_search(n,target,array))


# # py재귀함수로 구현한 이진탐색 코드

# In[3]:


#이진 탐색 소스코드 구현(재귀 함수)
def binary_search(array,target,start,end):
    if start>end:
        return None
    mid = (start+end)//2
    #찾은 경우 중간점 인덱스 반환
    if array[mid]==target:
        return mid
    #중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    elif array[mid]>target:
        return binary_search(array,target,start,mid-1)
    #중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else:
        return binary_search(array,target, mid+1,end)

#n(원소의 개수)과 target(찾고자하는 문자열)을 입력받기
n, target = list(map(int,input().split()))
#전체 원소 입력 받기
array=list(map(int,input().split()))

#이진 탐색 수행 결과 출력
result= binary_search(array,target,0,n-1)
if result==None:
    print("원소가 존재하지 않습니다.")
else:
    print(result+1)
    


# # 반복문으로 구현한 이진 탐색 소스코드

# In[4]:


#이진 탐색 소스코드 구현(반복문)
def binary_search(array,target,start,end):
    while start<=end:
        mid = (start+end)//2
        #찾은 경우 중간점 인덱스 반환
        if array[mid]==target:
            return mid
        #중간점의 값보다 찾고자 하는 값이 작은 경우 왼족 확인
        elif array[mid]>target:
            end=mid-1
        #중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            start=mid+1
    return None

#n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
n, target=list(map(int,input().split()))
#전체 원소 입력
array=list(map(int,input().split()))

#이진 탐색 수행 결과 출력
result=binary_search(array,target,0,n-1)
if result==None:
    print("원소가 존재하지 않습니다")
else:
    print(result+1)


# # py 한 줄 입력받아 출력하는 소스코드

# In[2]:


import sys
#하나의 문자열 데이터 입력받기
input_data=sys.stdin.readline().rstrip()

#입력받은 문자열 그대로 출력
print(input_data)

