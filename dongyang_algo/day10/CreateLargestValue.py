def largestNumber(array):
    if len(array) == 1:
        return str(array[0])

    # 정수 -> 문자열
    for i in range(len(array)):
        array[i] = str(array[i])

    # xyab>abxy 비교
    for i in range(len(array)):
        for j in range(i+1, len(array)):
            if array[j]+array[i] > array[i]+array[j]:
                array[i], array[j] = array[j], array[i]
        array[i] = str(array[i])

    result = ''.join(array)
    if (result == '0'*len(result)):
        return '0'
    else:
        return result


arr = [10, 58, 65, 73, 8, 9]
print(largestNumber(arr))
