#!/usr/bin/env python
# coding: utf-8

# 카카오에 신입 개발자로 입사한 '콘'은 선배 개발자로 부터 개발역량 강화를 위해 다른 개발자가 작성한 소스코드를 분석하여 문제점을 발견하고 수정하라는 업무 과제를 받았습니다. 소스를 컴파일하여 로그를 보니 대부분 소스코드 내 작성된 괄호가 개수는 맞지만 짝이 맞지 않은 형태로 작성되어 오류가 나는 것을 알게 되었습니다.<br>
# 수정해야 할 소스 파일이 너무 많아서 고민하던 '콘'은 소스코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램을 다음과 같이 개발하려고 합니다.<br>
# 
# 용어의 정의<br>
# '('와')'로만 이루어진 문자열이 있을 경우, '('의 개수와 ')'의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다. 그리고 여기에 '('와')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.<br>
# 예를 들어, '(()))('와 같은 문자열은 '균형잡힌 괄호 문자열'이지만 올바른 괄호 문자열은 아닙니다. 반면에'(())()'와 같은 문자열은 '균형잡힌 괄호 문자열' 이면서 동시에 올바른 괄호 문자열 입니다.<br>
# '('와')'로만 이루어진 문자열 w가 '균형잡힌 괄호 문자열'이라면 다음과 같은 과정을 통해 올바른 괄호 문자열로 변환할 수 있습니다.<br>
# 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.<br>
# 2. 문자열 w를 두 '균형잡힌 괄호 문자열' u,v로 분리합니다. 단 u는 '균형잡힌 괄호 문자열'로 더이상 분리할 수 없어야하며, v는 빈 문자열이 될 수 있습니다.<br>
# 3. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.<br>
# 3-1. 문자열u가 '올바른 괄호 문자열'이라면 문자열 v에대해 1단계부터 다시 수행합니다.<br>
# 4. 문자열 u가 '올바른 괄호 문자열'이 아니라면 아래 과정을 수행합니다.<br>
# 4-1. 빈 문자열에 첫 번째 문자로'('를 붙입니다.<br>
# 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어붙입니다.<br>
# 4-3. ')'를 다시 붙입니다.<br>
# 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.<br>
# 4-5. 생성된 문자열을 반환합니다.<br>
# '균형잡힌 괄호 문자열' p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 '올바른 괄호 문자열'로 변환한 결과를 return하도록 solution함수를 완성해주세요.
# 
# 매개변수 설명
# p는 ( 와 ) 로만 이루어진 문자열이며 길이는 2이상 1000이하인 짝수입니다.<br>
# 문자열p를 이루는 ( 와 ) 의 개수는 항상 같습니다.
# 만약 p가 이미 올바른 괄호 문자열이라면 그대로 return합니다.
# 
# # 입력 예시1,2,3
# "(()())()"<br> ")(" <br>"()))((()"
# 
# # 출력 예시 1,2,3
# "(()())()"<br> "()"<br> "()(())()"

# In[5]:


#괄호의 개수가 맞는지 확인해야함.
def divided(x):
    l_count=0
    r_count=0
#     print(x)
    for i in range(len(x)):
        if l_count==0 or r_count==0 or l_count!=r_count:
            if a[i]=='(':
                l_count+=1
                u.append(x[i])
            else:
                r_count+=1
                u.append(x[i])
        else:
            v.append(x[i])
    #print(u)

#괄호를 split시키기.
p=""
a=list(p)
#print(a)
u=[]
v=[]
u2=[]



divided(a)
#1.번째 u가 올바른 괄호 문자인지 확인해야함.
flag=0 #flag=0일때는 충분한 괄호 flag=1일때는 올바른 괄호
while len(u2)<len(p):
    if u[0]=='(':
        flag=1
        u2+=u
        #print(u2)
        a=v
        u=[]
        v=[]
        divided(a)

    else: #충분한 괄호이긴하나 올바른 괄호가 아닐 때
        flag=0
        for i in range(len(u)):
            if i==0:
                u[i]='('
            elif i==len(u)-1:
                u[i]=')'
            else:
                if u[i]=='(':
                    u[i]=')'
                else:
                    u[i]='('
#         print(u)
#         print(v)
        u2+=u
        a=v
        u=[]
        v=[]
        divided(a)

    
u2="".join(u2)
print(u2)


# In[77]:


a=['a','b','c']
a.pop()


# In[91]:


a=['a']
b=['b']
print(a+b)


# # 정답

# In[7]:


p="()))((()"
#균형잡힌 괄호 문자열의 인덱스 반환
def balanced_index(p):
    count=0 #왼쪽 괄호의 개수
    for i in range(len(p)):
        if p[i]=='(':
            count+=1
        else:
            count-=1
        if count==0:
            return i

#올바른 괄호 문자열인지 판단
def check_proper(p):
    count=0 #왼쪽 괄호의 개수
    for i in p:
        if i=='(':
            count+=1
        else:
            if count==0: #상이 맞지 않는 경우에는 False반환
                return False
            count-=1
    return True #쌍이 맞는 겨웅에 True 반환
def solution(p):
    answer=''
    if p=='':
        return answer
    index = balanced_index(p)
    u=p[:index+1]
    v=p[index+1:]
    #올바른 괄호 문자열이면 v에 대해 함수를 수행한 결과를 붙여 반환
    if check_proper(u):
        answer=u+solution(v)
    #올바른 괄호 문자열이 아니라면 아래의 과정을 수행
    else:
        answer='('
        answer+=solution(v)
        answer+=')'
        u=list(u[1:-1]) #첫번째와 마지막문자를 제거
        print(u)
        for i in range(len(u)):
            if u[i]=='(':
                u[i]=')'
            else:
                u[i]='('
                
        answer+="".join(u)
    return answer
                
solution(p)


# In[ ]:


"(()())()"
")("
"()))((()"

