# x = "xyz321"
# a = ["abc123", "def456", "ghi789"]
# a.append(x)
# a.remove("def456")
# print(a[1][-4:])
# print(a[1][-4:-1])
# print(a[1][-4:-2])

# print(a[1][-3:], a[2][:-3], sep=',')

# for i in range(3, 6):
#     print(i, end=' ')

# asia = {"한국", "중국", "일본"}
# asia.add("베트남")
# asia.add("중국")
# asia.remove("일본")
# asia.update({"한국", "홍콩", "태국"})
# print(asia)

class CharClass:
    a = ["Seoul", "Kyeongi", "Inchon", "Daejeon", "Daegu", "Pusan"]


myVar = CharClass()
str01 = ''
for i in myVar.a:
    str01 = str01+i[0]
print(str01)
