# 시퀀스 자료 슬라이싱 이해하기
strdata = "Time is money!!"
print(strdata[1:5]+"<")     # ime <
print(strdata[:7]+"<")      # Time is<
print(strdata[9:]+"<")      # oney!!<
print(strdata[:-3]+"<")     # Time is mone<
print(strdata[-3:]+"<")     # y!!<
print(strdata[:]+"<")       # Time is money!!<
print(strdata[::2]+"<")     # Tm smny!<


"""
인덱싱은 인덱스에 해당하는 요소 하나를 취하는 방법이지만
슬라이싱은 시퀸스 자료에서 일정 범위에 해당하는 부분을 
취하는 방법이며 표현은 다음과 갗습니다

[시작 인덱스:끝 인덱스:스텝]
시작 인덱스: 슬라이싱 범위의 시작
끝 인덱스: 슬라이싱 범위의 끝
스텝: 자료를 취하는 간격

여기서 스텝은 생략해도 되며 디폴트 값은 1입니다. 따라서 보통 슬라이싱 범위는 [시작 인덱스: 끝 인덱스]로 지정하며,
시작 인덱스 이상부터 끝 인덱스 미만까지 자료를 취하라는 뜻입니다. 이를 부등식으로 표형하면 다음과 같습니다.

시작 인덱스<= [시작 인덱스: 끝 인덱스]< 끝 인덱스

다음 표는 슬라이싱 범위를 표현하는 다양한 방법입니다.
[m:n]   시퀀스 자료의 인덱스가 m 이상 n미만인 요소를 슬라이싱합니다.
[:n]    시퀀스 자료의 처름부터 인덱스가 n 미만인 요소까지 슬라이싱합니다.
[m:]    시퀀스 자료의 인덱스가 m인 요소부터 시퀀스 자료의 끝까지 슬라이싱합니다.
[:-n]   시퀀스 자료의 처음부터 끝에서 n번째 미만인 요소까지 슬라이싱합니다.
[-m:]   시퀀스 자료의 끝에서 m번째 요소부터 시퀀스 자료의 끝까지 슬라이싱합니다.
"""