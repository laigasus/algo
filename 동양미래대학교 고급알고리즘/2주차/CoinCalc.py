cost = int(input("비용 입력>"))
n = int(input("반복 횟수>"))
coin = []
cnt = 0

for i in range(n):
    cn = int(input("동전입력>"))
    coin.append(cn)

for i in coin:
    cnt += cost//i
    print(i, "원 동전 개수>", int(cost/i))
    cost %= i

print("필요한 동전의 개수>", cnt)