#!/usr/bin/env python
# coding: utf-8

# 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있습니다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 합니다. 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것입니다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미합니다.
# 예를 들어 S=000110011일 떄는 다음과 같습니다.
# 1.전체를 뒤집으면 1110011이 됩니다.
# 2.4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 두번 만에 모두 같은 숫자로 만들 수 있습니다.
# 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
# 문자열 S가 주어졌을 떄, 다솜이가 해야하는 행동의 최소 횟수를 출력하세요.
# 

# # 입력 조건
# 첫째 줄에 0과 1로만 이루어진 문자열 S가 주어집니다. S의 길이는 100만보다 작습니다.
# 
# # 출력 조건
# 첫째 줄에 다솜이가 해야 하는 행동의 최소 횟수를 출력합니다.
# 
# # 입력 예시
# 0001100
# 
# # 출력 예시
# 1

# In[22]:


s='0001100'
zero_count=0
one_count=0
for i in range(len(s)-1):
    if s[i+1]=='1':
        if i=='0':
            zero_count+=1
        else:
            one_count+=1
        break
    if s[i]=='0' and s[i+1]=='1':
        zero_count+=1
    elif s[i]=='1' and s[i+1]=='0':
        one_count+=1
        
result=min(zero_count,one_count)
print(result)


# In[29]:


S=input()
S=list(S)

zero_count=0
one_count=0
for i in range(len(S)-1):
    if S[i] != S[i+1]:
        if S[i+1]=='1':
            zero_count+=1
        else:
            one_count+=1
    
    
    if s[-1]=='0':
        zero_count+=1
    else:
        one_count+=1
        
print(min(zero_count,one_count))


# # 답

# In[ ]:


S=input()
zero_count=0
one_count=0
for i in range(len(S)-1):
    if S[i]!=S[i+1]:
        if S[i+1]=='1':
            zero_count+=1
        else:
            one_count+=1
if S[0]=='1':
    zero_count+=1
else:
    one_count+=1
        
print(min(zero_count,one_count))


