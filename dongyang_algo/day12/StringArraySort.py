data = "K1KA5CB7"
result = []
value = 0

for i in data:
    if i.isalpha():
        result.append(i)
    else:
        value += int(i)

result.sort()

if value != 0:
    result.append(str(value))


print(result)
