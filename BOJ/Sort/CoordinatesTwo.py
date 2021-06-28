'''
11651. 좌표 정렬하기 2
- 요구사항 : 2차원 평면 위의 점 N개가 주어졌을 때, 
            y좌표가 증가하는 순, y좌표가 같다면 x좌표가 증가하는 순으로
            점들을 정렬한 후 출력하기
- 함수
    - 입력 : 첫째줄 ~ 점의 개수 N
            둘째줄부터 N+1째줄 ~ i번 점의 위치 Xi와 Yi
    - 제약 : 1 <= N <= 100,000
            -100,000 <= Xi, Yi <= 100,000
            좌표는 항상 정수
            위치가 같은 두 점은 없음
    - 출력 : 첫째줄부터 N째줄 ~ 점을 순서대로 정렬한 결과
- 손코딩 
    점의 개수를 입력받는다.
    입력받은 점의 수만큼 반복문을 돌면서
        띄어쓰기를 기준으로 숫자 두 개씩 점을 입력받는다.
    0부터 N-1까지 반복하면서
        y좌표가 더 작으면 순서를 바꾸고
            y좌표가 같다면 x좌표가 더 작은게 앞으로 가도록 정렬한다.
    N만큼 반복하면서
        모든 점을 띄어쓰기를 기준으로 출력한다.
'''
# import sys
# n = int(sys.stdin.readline())
# so = []
# for i in range(n):
#     so.append(list(map(int, sys.stdin.readline().split())))
# so.sort(key=lambda x: (x[1], x[0]))
# for i in so:
#     print(i[0], i[1])

import sys

n = int(input())
arr = []
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    arr.append([x, y])

arr.sort(key = lambda x : (x[1], x[0]))

for i in arr:
    print(i[0], i[1])