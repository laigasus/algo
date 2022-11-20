# Python3 program to implement
# run length encoding
def printRLE(st):

    n = len(st)
    i = 0
    while i < n - 1:

        count = 1
        while (i < n - 1 and
                st[i] == st[i + 1]):
            count += 1
            i += 1
        i += 1

        print(str(count) + st[i - 1], end="")


if __name__ == "__main__":

    st = "aabbaccc"
    printRLE(st)
