#!/usr/bin/env python
# coding: utf-8

# 빙하가 깨지면서 스노우타운에 떠내려온 죠르디는 인생 2막을 위해 주택 건축사업에 뛰어들기로 결심하였습니다. 죠르디는 기둥과 보를 이용하여 벽면 구조물을 자동으로 세우는 로봇을 개발할 계획인데, 그에 앞서 로봇의 동작을 시뮬레이션 할 수 있는 프로그램을 만들고 있습니다.<br>
# 프로그램은 2차원 가상 벽면에 기둥과 보를 이용한 구조물을 설치할 수 있는데, 기둥과 보는 길이가 1인 선분으로 표현되며 다음과 같은 규칙을 가지고 있습니다.<br>
# 기둥은 바닥 위에 있거나 보의 한쪽 끝부분 위에 있거나, 또는 다른 기둥 위에 있어야합니다.<br>
# 보는 한쪽 끝부분이 기둥 위에 있거나, 또는 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 합니다.<br>
# 단, 바닥은 벽면의 맨 아래 지면을 말합니다.<br>
# 2차원 벽면은 nxn 크기 정사각 격자 형태이며, 각 격자는 1x1 크기입니다. 맨 처음 벽면은 비어 있는 상태입니다. 기둥과 보는 격자 선의 교차점에 걸치지 않고, 격자 칸의 각 변에 정확히 일치하도록 설치할 수 있습니다. 다음은 기둥과 보를 설치해 구조물을 만든 예시입니다.<br>
# 
# 1. (1,0)에서 위쪽으로 기둥하나 설치 후, (1,1)에서 오른쪽으로 보를 하나 만듭니다.<br>
# 2. (2,1)에서 위쪽으로 기둥을 하나 설치 후, (2,2)에서 오른쪽으로 보를 하나 만듭니다.<br>
# 3. (5,0)에서 위쪽으로 기둥을 하나 설치 후, (5,1)에서 위쪽으로 기둥을 하나 더 설치합니다.
# 4. (4,2)에서 오른쪽으로 보를 설치 후, (3,2)에서 오른쪽으로 보를 설치합니다.
# 
# 만약 (4,2)에서 오른쪽 보를 먼저 설치하지않고, (3,2)에서 오른쪽으로 보를 설치하려 한다면 2번 규칙에 맞지 않으므로 설치가 되지 않습니다. 기둥과 보를 삭제하는 기능도 있는데 기둥과 보를 삭제한 후에 남은 기둥과 보 또한 위 규칙을 만족해야 합니다. 만약, 작업을 수행한 결과가 조건을 만족하지 않는다면 해당 작업은 무시됩니다.<br>
# 벽면의 크기n 기둥과 보를 설치하거나 삭제하는 작업이 순서대로 담긴 2차원 배열 build_frame이 매개변수로 주어질 떄, 모든 명령어를 수행한 후 구조물의 상태를 return하도록 solution 함수를 완성해주세요.<br>
# <br>
# 제한 사항
# n은 5이상 100이하인 자연수입니다.<br>
# build_frame의 세로 길이는 1이상 1,000이하입니다.<br>
# build_frame의 가로길이는 4입니다.<br>
# build_frame의 원소는 [x,y,a,b]형태 입니다.<br>
# -x,y는 기둥, 보를 설치 또는 삭제할 교차점의 좌표이며,[가로좌표,세로좌표] 형태입니다.<br>
# -a는 서치 또는 삭제할 구조물의 종류를 나타내며, 0은 기둥 1은 보를 나타냅니다.<br>
# -b는 구조물을 설치할 지, 혹은 삭제할 지를 나타내며 0은 삭제 1은 설치를 나타냅니다.<br>
# -벽면을 벗어나게 기둥, 보를 설치하는 경우는 없습니다.<br>
# -바닥에 보를 설치하는 경우는 없습니다.<br>
# 구조물은 교차점 좌표를 기준으로 보는 오른쪽, 기둥은 위쪽방향으로 설치 또는 삭제합니다.<br>
# 구조물이 겹치도록 설치하는 경우와 없는 구조물을 삭제하는 경우는 입력으로 주어지지 않습니다.<br>
# 최종 구조물으 ㅣ상태는 아래 규칙에 맞춰 return 해주세요.<br>
# -return 하는 배열은 가로(열) 길이가 3인 2차원 배열로, 각 구조물의 좌표를 담고 있어야합니다.<br>
# -return 하는 배열의 원소는 [x,y,z]형식입니다.<br>
# -x,y는 기둥,보의 교차점 좌표이며,[가로좌표,세로좌표]형태입니다.<br>
# -기둥,보는 교차점 좌표를 기준으로 오른쪽 또는 위쪽 방향으로 설치되어 있음을 나타냅니다.<br>
# -a는 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.<br>
# -return하는 배열은 x좌표기준으로 오름차순 정렬하며, x좌표가 같을경우 y좌표 기준으로 오름차순 정렬 해주세요.<br>
# -x,y 좌표가 모두 같은 경우 기둥이 보보다 앞에오면됩니다.<br>

# In[53]:


n=5
# map=[[0]*(n+1) for _ in range(n+1)]

build_frame=[[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],
             [2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]


def build(result): #설치가 되는 조건
    for x,y,a in result:
        if a==0: #기둥일 때
            #1.바닥 위에 있어야함
            #2.보의 한쪽 끝 부분 위에 있어야함.
            #3. 다른 기둥 위에 있어야함.
            if y==0 or [x,y-1,0] in result or [x-1,y,1] in result or [x,y,1] in result:
                continue
            else:
                return False
        else: #보일때
            #1. 한쪽 끝 부분이 기둥 위에 있어야함.
            #2. 양쪽 끝 부분이 양쪽 보와 동시에 연결되어야함.
            if [x,y-1,0] in result or [x+1,y-1,0] in result or ([x-1,y,1] in result and [x+1,y,1] in result):
                continue 
            else:
                return False
    return True




result=[]
for x,y,a,b in build_frame:

    if b: #설치할 때
        result.append([x,y,a])
        if build(result) == False:
            result.remove([x,y,a])
    else:
        print(x,y,a)
        result.remove([x,y,a])
        if build(result) == False:
            result.append([x,y,a])
            
result.sort()
print(result)
        


# In[ ]:




