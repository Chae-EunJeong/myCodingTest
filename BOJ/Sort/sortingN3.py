'''
10989. 수 정렬하기 3
- 요구사항


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