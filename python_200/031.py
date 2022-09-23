# 시퀀스 자료 크기 이해하기(len)

strdata1 = "I love Python"
strdata2 = "나는 파이썬을 사랑합니다."
listdata = ['a', 'b', 'c', strdata1, strdata2]
print(len(strdata1))        # 13
print(len(strdata2))        # 14
print(len(listdata))        # 5
print(len(listdata[3]))     # 13