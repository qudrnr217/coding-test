#!/usr/bin/env python
# coding: utf-8

# 'Dummy'라는 도스 게임이 있습니다. 이 게임에는 뱀이 나와서 기어 다니는데, 사과를 먹으면 뱀 길이가 늘어납니다. 뱀이 이리저리 기어 다니다가 벽 또는 자기 자신의 몸과 부딪히면 게임이 끝납니다.<br>
# 게임은 NxN 정사각 보드 위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있습니다. 보드의 상하좌우 끝에는 벽이 있습니다. 게임을 시작할 때 뱀은 맨 위 맨 좌측에 위치하고 뱀의 길이는 1입니다. 뱀은 처음에 오른쪽을 향합니다.<br>
# 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따릅니다.<br>
# 먼저 뱀은 몸길이를 늘려 머리를 다음 칸에 위치시킵니다.<br>
# 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않습니다.<br>
# 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워줍니다. 즉, 몸길이는 변하지 않습니다.<br>
# 사과의 위치와 뱀의 이동 경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하세요.<br>
# 
# # 입력 조건
# 첫째 줄에 보드의 크기 n이 주어집니다.(2<=n<=100) 다음 줄에 사과의 개수 K가 주어집니다.(0<=K<=100)<br>
# 다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두번째 정수는 열의 위치를 의미합니다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측(1행 1열)에는 사과가 없습니다.<br>
# 다음 줄에는 뱀의 방향 변환 횟수 L이 주어집니다.(1<=L<=100)<br>
# 다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데, 정수 X와 문자 C로 이루어져 이씅며, 게임시작 시간으로부터 X초가 끝난 뒤에 왼쪽 (C가 'L')또는 오른쪽(C가 'D')으로 90도 방향을 회전시킨다는 뜻입니다. X는 10,000이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 이루어집니다.
# 
# # 출력 조건
# 첫째 줄에 게임이 몇 초에 끝나는지 출력합니다.
# 
# # 입력 예시1
# 6<br>
# 3<br>
# 3 4<br>
# 2 5<br>
# 5 3<br>
# 3<br>
# 3 D<br>
# 15 L<br>
# 17 D<br>
# 
# # 출력 예시 1
# 9
# 
# # 입력 예시2
# 10<br>
# 4<br>
# 1 2<br>
# 1 3<br>
# 1 4<br>
# 1 5<br>
# 4<br>
# 8 D<br>
# 10 D<br>
# 11 D<br>
# 13 L<br>
# 
# # 출력 예시 2
# 21
# 
# # 입력 예시3
# 10<br>
# 5<br>
# 1 5<br>
# 1 3<br>
# 1 2<br>
# 1 6<br>
# 1 7<br>
# 4<br>
# 8 D<br>
# 10 D<br>
# 11 D<br>
# 13 L<br>
# 
# # 출력 예시3
# 13

# In[28]:


#보드판
n=6
#보드판 만들기
board=[[0]*(n) for _ in range(n)]

#사과 개수
k=3
arr=[[3,4],[2,5],[5,3]]
#사과 위치 2로 추가
board[3][4]=3
board[2][5]=3
board[5][3]=3


#뱀이 방향트는 횟수
l=3
# D,L

lr=[[3,'D'],[15,'L'],[17,'D']]

#북 동 남 서
dx=[0,1,0,-1]
dy=[-1,0,1,0]
x,y=0,0
cnt=0
board[x][y]=1
direction=1

def change(d,c):
    if c=='D':
        d=(d+1)%4
    else:
        d(d-1)%4
    return d

while True:
        cnt+=1
        pre_x=x
        pre_y=y
        x,y=x+dx[direction],y+dy[direction]
        if x>=0 and x<n and y>=0 and y<n: #벽을 넘어가지않을때
            if board[x][y]!=3: #사과가 없는경우
                board[pre_x][pre_y]=0
            board[x][y]+=1
            if board[x][y]==2: #본인 몸에 부딪힐 경우
                print(cnt)
                break
            for i in range(l): #방향전환
                if cnt==lr[i][0]:
                    direction=change(direction,lr[i][1])
        
        else:#벽을 넘어 갈경우
            print(cnt)
            break
            




# In[76]:


from collections import deque
#보드판
n=int(input())
#보드판 만들기
board=[[0]*(n) for _ in range(n)]

#사과 개수
k=int(input())
for i in range(k):
    a,b=map(int,input().split())
    board[a-1][b-1]=3

#뱀이 방향트는 횟수
l=int(input())
lr=[]
for i in range(l):
    a,b=input().split()
    a=int(a)
    lr.append((a,b))

#서 남 동 북
dx=[0,1,0,-1]
dy=[-1,0,1,0]
x,y=0,0
cnt=0
board[x][y]=1
direction=2

def change(d,c):
    if c=='D':
        d=(d-1)%4
    else:
        d=(d+1)%4
    return d

q=deque([[x,y]])

while True:
        print(cnt)
        cnt+=1
        for i in range(n):
            print(board[i])
        print(' ')
        x,y=x+dx[direction],y+dy[direction]
        if x>=0 and x<n and y>=0 and y<n: #벽을 넘어가지않을때
            if board[x][y]==3: #사과가 있는 경우
                board[x][y]=0
                board[x][y]+=1
            else:
#             board[x][y]!=3: #사과가 없는경우
                board[x][y]+=1
                if board[x][y]==2: #본인 몸에 부딪힐 경우
                    print(cnt)
                    break
                pre_x,pre_y=q.popleft()
                board[pre_x][pre_y]=0
            
            
           
            q.append((x,y))
            
            
            
            for i in range(l): #방향전환
                if cnt==lr[i][0]:
                    direction=change(direction,lr[i][1])
            
        else:#벽을 넘어 갈경우
            print(cnt)
            break
            




# In[32]:





# In[ ]:




