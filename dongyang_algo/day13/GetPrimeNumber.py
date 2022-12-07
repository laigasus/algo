import math

def is_prime_num(start, end):

    arr = [False, False] + [True] * (end - 1)

    for i in range(2, int(math.sqrt(end))+1):
        if arr[i]:
            j = 2
            while i * j <= end:
                arr[i*j] = False
                j += 1
    return [i for i in range(start, end+1) if arr[i]]


print(is_prime_num(3, 16))