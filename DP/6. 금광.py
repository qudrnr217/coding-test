#!/usr/bin/env python
# coding: utf-8

# nxm 크기의 금광이 있스니다. 금광은 1x1 크기의 칸으로 나누어져 있으며, 각 칸은 특정한 크기의 금이 들어 있습니다. 채굴자는 첫 번째 열부터 출발하여 금을 캐기 시작합니다. 맨 처음에는 첫번째 열의 어느행에서든 출발할 수 있스니다. 이후에 m번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동해야 합니다. 결과적으로 채굴자가 얻을 수 있는 금의 최대 크기를 출력하는 프로그램을 작성하세요.
# 만약 다음과 같이 3x4크기의 금광이 존재한다고 가정합시다.
# 
# 1 3 3 2
# 
# 2 1 4 1
# 
# 0 6 4 7
# 
# 가장 왼쪽 위치를 (1,1) 가장 오른쪽 위치를 (n,m)이라고 할 때, 위 예시에서는 (2,1)->(3,2)->(3,3)->(3,4)의 위치로 이동하면 총 19만큼의 금을 채굴할 수 있으며, 이때의 값이 최댓값입니다.

# # 입력 조건
# 첫째 줄에 테스트 케이스 T가 입력됩니다.(1<=T<=1000)
# 매 테스에 케이스 첫째 줄에 n과 m이 공백으로 구분되어 입력됩니다.(1<=n,m<=20) 둘째 줄에 nxm개의 위치에 매장된 금의 개수가 공백으로 구분되어 입력됩니다.(1<=각 위치에 매장된 금의 개수<=100)
# 
# # 출력 조건
# 테스트 케이스마다 채굴자가 얻을 수 있는 금의 최대 크기를 출력합니다. 각 테스트 케이스는 줄 바꿈을 이용해 구분합니다.

# # 입력 예시
# 2
# 
# 3 4
# 
# 1 3 3 2 2 1 4 1 0 6 4 7
# 
# 4 4
# 
# 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
# 
# # 출력 예시
# 19
# 
# 16
# 
# 

# In[45]:


import numpy as np
t=int(input())
for k in range(1):
    n,m=map(int,input().split())
    #arr=list(map(int,input().split()))
    arr=[1, 3, 3, 2, 2, 1, 4, 1, 0, 6, 4, 7]
    arr2=np.reshape(arr,(n,m))
    print(arr2)
    print(arr2[1][0])


# In[52]:


#dp
dp=[0]*(n*m)
dp2=np.reshape(dp,(n,m))
dp2[0][0]=arr2[0][0]
dp2[1][0]=arr2[1][0]
dp2[2][0]=arr2[2][0]

for i in range(1,m):
    for j in range(n):
        if j==0:
            dp2[j][i]=arr2[j][i]+max(dp2[j][i-1],dp2[j+1][i-1])
        elif j==n-1:
            dp2[j][i]=arr2[j][i]+max(dp2[j][i-1],dp2[j-1][i-1])
        else:
            dp2[j][i]=arr2[j][i]+max(dp2[j][i-1],dp2[j-1][i-1],dp2[j+1][i-1])
            
            
dp3=np.reshape(dp2,(1,n*m))
print(dp3)
print(max(max(dp3)))
    

        


# In[32]:


import numpy as np
arr=1,2,3,4,7,8,9,10
arr2=np.reshape(arr,(2,4))
print(arr2)
print(arr2[0][0])


# In[39]:


import numpy as np
m=3
n=4
arr=[[0]*m for i in range(n)]
arr[2][2]=1
print(list(map(max(arr))))

dp=[0]*(n*m)
dp2=np.reshape(dp,(n,m))
dp2[2][2]=1
print(dp2[2][2])


# In[ ]:




