arr=[10, 58, 65, 73, 8, 9]


def bubble(arr):
    for i in range(1, len(arr)):
        for j in range(0,len(arr)-i):
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1]=arr[j+1], arr[j]
    print(arr)


def selection(arr):
    for j in range(len(arr)):
        index=j
        for i in range(1+j,len(arr)):
            if arr[i]<arr[index]:
                index=i
        arr[j],arr[index]=arr[index],arr[j]
    print(arr)


def insertion(arr):
    for i in range(1, len(arr)):
        memory=arr[i]
        j=i-1
        while j>=0 and memory<arr[j]:
            arr[j+1]=arr[j]
            j-=1
        arr[j+1]=memory
    print(arr)


bubble(arr)
selection(arr)
insertion(arr)