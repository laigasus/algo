n = int(input())  # 첫째줄 입력
que = list(map(int, input().split()))  # 기다리는 사람들 리스트 형태로 입력 받음

que.sort()  # 작은 순서대로 정렬
resTime = 0  # 정답 변수 0

for x in range(1, n+1):
    resTime += sum(que[0:x]) # 0 에서 n까지의 합
print(resTime)