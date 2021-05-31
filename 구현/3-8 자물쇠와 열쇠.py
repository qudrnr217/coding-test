#!/usr/bin/env python
# coding: utf-8

# 고고학자인 튜븐느 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해주는 종이가 발견되었습니다.<br>
# 잠겨있는 자물쇠는 격자 한 칸의 크기가 1x1인 nxn크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 mxm크기인 정ㅎ사각 격자 형태로 되어 있습니다.<br>
# 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안 됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.<br>
# 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열 수 있으면 true, 없으면 false를 return하도록 solution함수를 완성해주세요.
# 
# # 제한 사항
# key는 MxM(3<=M<=20, M은 자연수)크기 2차원 배열입니다.
# lock은 NxN(3<=N<=20, N은 자연수)크기 2차원 배열입니다.
# M은 항상 N이하입니다.
# key와 lock의 원소는 0또는 1로 이루어져있습니다. 이때 0은 홈 부분, 1은 돌기 부분을 나타냅니다.
# 
# # 입출력 예시
# key=[[0,0,0],[1,0,0],[0,1,1]]<br>
# lock=[[1,1,1],[1,1,0],[1,0,1]]<br>
# result=true

# In[12]:


key=[[0,0,0],[1,0,0],[0,1,1]]
lock=[[1,1,1],[1,1,0],[1,0,1]]
key2=[]
#키 돌리고 이동 후 celar
#시계방향 90도 회전
def rotate_90(key):
    n=len(key)
    ret=[[0]*n for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            ret[j][n-1-i]=key[i][j]
            
    return ret

#상하좌우로 옮기기
#좌우로 먼저 움직여서 0이 있는 열에 모두 있을때 업다운 시켜서 확인
def check(new_lock):
    lock_length=len(new_lock)//3
    for i in range(lock_length,lock_length*2):
        for j in range(lock_length,lock_length*2):
            if new_lock[i][j]!=1:
                return False
    
    return True
            

n=len(lock)
m=len(key)



new_lock=[[0]*(n*3) for _ in range(n*3)]
# print(len(new_lock))
for i in range(n):
    for j in range(n):
        new_lock[i+n][j+n]=lock[i][j]
        
# print(new_lock)

#4가지 방향에 대해서 확인
def solution(key,lock):
    for rotation in range(4):
        key=rotate_90(key) #열쇠 회전
        for x in range(n*2):
            for y in range(n*2):
                #자물쇠에 열쇠를 끼워 넣기
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j]+=key[i][j]
                #새로운 자물쇠에 열쇠가 정확히 들어맞는지 확인
                if check(new_lock)==True:
                    return True
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j]-=key[i][j]

    return False


solution(key,lock)


# In[ ]:




