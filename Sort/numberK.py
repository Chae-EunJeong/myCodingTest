'''
11004. K번째 수
- 요구사항 : 수 N개가 주어지고, N개의 수를 오름차순 정렬한 후에
            정렬된 수들 중 K번째의 수를 출력해라
- 함수
    - 입력 : 첫째줄 ~ 공백으로 구분한 수의 개수 N과 요구하는 K
            둘째줄 ~ 공백으로 구분한 N개의 수
    - 제약 : 1 <= N <= 5,000,000
            1 <= K <= N
            -10^9 <= 주어지는 수 <= 10^9
    - 출력 : 정렬한 후 앞에서부터 K번째에 있는 수
- 손코딩
    N과 K 입력받기
    N개의 수를 공백으로 나누어 리스트로 저장
    리스트 정렬
    k-1번째에 해당하는 요소 출력
'''

import sys

n, k = map(int, sys.stdin.readline().split())

a_list = list(map(int, sys.stdin.readline().split()))
a_list.sort()
print(a_list[k-1])