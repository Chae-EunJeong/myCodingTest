'''
11652. 카드
- 요구사항 : 카드 하나당 숫자 하나가 적힌 숫자 카드 N장이 있을 때
            가장 많이 가진 카드의 점수를 출력해라
- 함수
    - 입력 : 첫째줄 ~ 숫자 카드 개수 N
            둘째줄부터 N+1째줄 ~ 숫자 카드에 적힌 정수
    - 제약 : -2^62 <= 숫자 카드에 적힌 수 <= 2^62
            1 <= N <= 100,000
            가장 많이 가지고 있는 카드가 여러장이면, 그 중 가장 작은 정수 출력
    - 출력 : 가장 많이 가진 카드의 정수
- 손코딩
    카드 개수 N 입력받기
    N만큼 반복하면서
        카드에 적힌 정수 입력받기

'''
import sys

card = {}
n = int(input())
for i in range(n):
    key = int(sys.stdin.readline())
    if key in card:
        card[key] += 1
    else:
        card[key] = 1

card = sorted(card.items(), key = lambda num : (-num[1], num[0]))

print(card[0][0])