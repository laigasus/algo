cost = int(input("비용 입력>"))
n = int(input("화폐 종류>"))
coin = []
cnt = 0

for i in range(n):
    cn = int(input("화폐 단위 입력>"))
    coin.append(cn)

for i in coin:
    cnt += cost//i
    print(i, "원권 개수>", int(cost/i))
    cost %= i

print("필요한 현금 수>", cnt)