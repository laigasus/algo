# 자료형 출력 개념 배우기(print)
a = 200
msg = "I love Python"
list_data = ['a', 'b', 'c']
dict_data = {'a': 97, 'b': 98}
print(a)
print(msg)
print(list_data)
print(list_data[0])
print(dict_data)
print(dict_data['a'])

"""
print()는 기본적으로 인자로 입력된 값을 화면에 출력한 후 줄바꿈을 합니다. 다시 말해, print()는
값을 출력하고 다음에 출력할 때는 줄을 바꾸어 출력합니다 print()는 기본적으로 출력되는 값 뒤에
항상 '\n'을 추가한다는 의미입니다. '\n'은 줄바꿈을 의미하는 문자입니다. 만약 줄바꿈 문자 '\n'을
추가하지 않으려면 라인 끝에서 첫번째: 다음과 같이 print()의 두 번째 인자로 end="를 지정하면 됩니다.
"""

print('#', end="")
print('#')