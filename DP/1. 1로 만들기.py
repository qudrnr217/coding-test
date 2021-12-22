#!/usr/bin/env python
# coding: utf-8

# 정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
# a. X가 5로 나누어떨어지면 5로 나눈다.
# b. X가 3으로 나누어떨어지면 3으로 나눈다.
# c. X가 2로 나누어떨어지면 2로 나눈다.
# d. X에서 1을 뺀다.
# 정수 X가 주어졌을 떄, 연산 4개를 적절히 사용해서 1을 만들려고한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
# 예를 들어 정수가 26이면 다음과 같이 계산해서 3번의 연산이 최솟값이다.

# In[3]:


d=[0]*100
count=0
def dinamic(x):
    
    for i in range(2, x+1):
        d[i]=d[i-1]+1
        if i%2==0:
            d[i]=min(d[i//2]+1,d[i])
        if i%3==0:
            d[i]=min(d[i//3]+1,d[i])
        if i%5==0:
            d[i]=min(d[i//5]+1,d[i])
    return d[x]
    
    


# In[4]:


x=int(input())
print(dinamic(x))


# 내생각
# 1. 경우의 수를 세어서 중복되는 것이 나올 때 다이나믹을 쓴다는 생각을함
# 2. 하나씩 예를 들어 출력값을 넣어보면서 규칙을 찾아냄

# In[ ]:




