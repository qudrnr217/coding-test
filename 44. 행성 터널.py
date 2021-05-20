#!/usr/bin/env python
# coding: utf-8

# 때는 2040년, 이민혁은 우주에 자신만의 왕국을 만들었습니다. 왕국은 N개의 행성으로 이루어져 있습니다. 민혁이는 이 행성을 효율적으로 지배하기 위해서 행성을 연겨하는 터널을 만들려고 합니다.<br>
# 해성은 3차원 좌표 위의 한 점으로 생각하면 됩니다. 두 행성 A(xa,ya,za)와 B(xb,yb,zb)를 터널로 연결할 때 드는 비용은 min(|xa-xb|,|ya-yb|,|za-zb|)입니다.<br>
# 민혁이는 터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 합니다. 이때, 모든 행성을 터널로 연결하는데 필요한 최소 비용을 구하는 프로그램을 작성하세요.
# 
# # 입력 조건
# 첫째 줄에 행성의 개수 N이 주어집니다.(1<=N<=100,000)<br>
# 다음 N개 줄에는 각 행성의 x,y,z좌표가 주어집니다.<br>
# 모든 좌표 값은 -10^9보다 크거나 같고, 10^9보다 작거나 같은 정수입니다.<br>
# 한 위치에 행성이 두 개 이상 있는 경우는 없습니다.
# 
# # 출력 조건
# 첫째 줄에 모든 행성을 터널로 연결하는데 필요한 최소 비용을 출력합니다.<br>
# 
# # 입력 예시
# 5<br>
# 11 -15 -15<br>
# 14 -5 -15<br>
# -1 -1 -5<br>
# 10 -4 -1<br>
# 19 -4 19<br>
# 
# # 출력 조건
# 4

# In[38]:


n=int(input())
arr=[[11,-15,-15],[14,-5,-15],[-1,-1,-5],[10,-4,-1],[19,-4,19]]
arrx=[]
arry=[]
arrz=[]
#xyz에 대한 정렬,인덱스 포함.
for i in range(n):
    arrx.append((arr[i][0],i))
    arry.append((arr[i][1],i))
    arrz.append((arr[i][2],i))



parent=[0]*n
#parent 초기화
for i in range(n):
    parent[i]=i
    
def find_parent(parent,x):
    if parent[x]!=x:
        parent[x]=find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a=find_parent(parent,a)
    b=find_parent(parent,b)
    
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

arrx.sort()
arry.sort()
arrz.sort()



new_arr=[]
result=0

for i in range(n-1):
    new_arr.append((abs(arrx[i][0]-arrx[i+1][0]),arrx[i][1],arrx[i+1][1])) #new_arr=[거리, 행성인덱스]
    new_arr.append((abs(arry[i][0]-arry[i+1][0]),arry[i][1],arry[i+1][1]))
    new_arr.append((abs(arrz[i][0]-arrz[i+1][0]),arrz[i][1],arrz[i+1][1]))

new_arr.sort() 

for i in new_arr:
    cost,a,b=i
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=cost
        
print(result)


# In[ ]:




