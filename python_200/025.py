# 비트 연산자 이해하기(&, |, ~, ^, >>, <<)
bit1 = 0x61
bit2 = 0x62
print(hex(bit1 & bit2))     # 0x60이 출력됨
print(hex(bit1 | bit2))     # 0x63이 출력됨
print(hex(bit1 ^ bit2))     # 0x3이 출력됨
print(hex(bit1 >> 1))       # 0x30이 출력됨
print(hex(bit1 << 2))       # 0x184이 출력됨

"""
비트연산자
A&B
A|B
A^B
~A
a>>n
A<<n
"""