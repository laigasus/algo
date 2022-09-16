# while문 개념 배우기(while~continue~break)
x = 0
while x < 10:
    x = x + 1
    if x < 3:
        continue
    print(x)
    if x > 7:
        break
