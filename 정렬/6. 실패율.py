#!/usr/bin/env python
# coding: utf-8

# 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌습니다. 그녀가 만든 프렌즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수자 급감했습니다. 원인은 신규 사용자와 기존 사용자 사이의 스테이지 차이가 너무 큰 것이 문제였습니다.
# 이 문제를 어떻게 할까 고민한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했습니다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았습니다. 오렐리를 위해 실패율을 구하는 코드를 완성하세요.
# 실패율은 다음과 같이 정의합니다.
# *스테이지에 도달했으나 아직 클리하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
# 
# 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 return하도록 solution함수를 완성하세요
# 

# # 제한 사항
# 스테이지의 개수 N은 1이상 500이하의 자연수입니다.
# stages의 길이는 1 이상 200,000이하 입니다.
# stages에는 1이상 N+1이하의 자연수가 담겨있습니다.
# -각 자연수는 사용자가 현재 도전중인 스테이지의 번호를 나타냅니다.
# -단 N+1은 마지막 스테이지(N번째 스테이지)까지 클리어한 사용자를 나타냅니다.
# 만약 실패율을 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면됩니다.
# 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의합니다.
# 

# # 입출력 예시
# N -5 stages [2,1,2,6,2,4,3,3] result[3,4,2,1,5]<br>
# N -4 stages [4,4,4,4,4] result[4,1,2,3]

# In[11]:


n=5
stages=[2,1,2,6,2,4,3,3]
result=[]
length=len(stages)
for i in range(1,n+1):
    a=stages.count(i)
    result.append((i,a/length))
    length-=a
    
result=sorted(result,key=lambda x:[x[1] , -x[0]],reverse=True)
print([i[0] for i in result])


# lambda에 키가 2개면 list로 감싸야함. 그리고 reverse가 되면 -는 오름차순 +는 내림차순이된다. 

# In[12]:


n=5
stages=[2,1,2,6,2,4,3,3]
result={}
length=len(stages)
for i in range(1,n+1):
    a=stages.count(i)
    result[i]=a/length
    length-=a
    
result=sorted(result,key=lambda x:result[x],reverse=True)
print(result)


# In[ ]:




