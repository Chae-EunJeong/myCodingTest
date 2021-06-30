'''
10989. 수 정렬하기 3
- 요구사항 : N개의 수가 주어졌을 때, 이 수들을 오름차순으로 정렬한 후 출력하기
- 함수
    - 입력 : 첫째줄 ~ 수의 개수 N
            둘째줄부터 N+1째줄 ~ 한 줄에 하나씩 숫자 입력
    - 제약 : 1 <= N <= 10,000,000
            0 < 입력되는 숫자 <= 10,000
    - 출력 : 첫째줄부터 N째줄 ~ 한 줄에 하나씩 오름차순으로 정렬된 숫자
- 주의 !! 메모리초과
    - 여태 풀어온 sort() 를 이용한 방법을 사용하면 메모리 초과때문에 실패함
    - 입력값을 받을 때마다 그 입력값을 인덱스로 사용하고 값을 +1씩 해준다.
    - 그 후 10,000개의 리스트를 돌면서 인덱스에 값이 0이 아니면 그 값을 출력하는 식으로 진행해야한다.
'''

import sys

n = int(input())
numbers = []
result = [0 for _ in range(10001)]
for _ in range(n):
    number = int(sys.stdin.readline())
    result[number] += 1

for i in range(len(result)):
    if result[i] != 0:
        for j in range(result[i]):
            print(i)