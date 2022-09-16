cost = 1260
coin = [500, 100, 50, 10]
cnt = 0

for i in coin:
    cnt += cost//i
    print(i, "원 동전 개수>", int(cost/i))
    cost %= i

print("필요한 동전의 개수>", cnt)