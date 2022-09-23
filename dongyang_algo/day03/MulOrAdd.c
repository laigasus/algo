#include <stdio.h>
#include <string.h>
int main(void)
{
    char str[20];
    scanf("%s", str);
    // 첫번째 문자를 숫자로 변경한 값을 대입
    int result = str[0] - '0';
    for (int i = 1; i < strlen(str); i++)
    {
        // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
        int num = str[i] - '0';
        if (num <= 1 || result <= 1)
            result += num;
        else
            result *= num;
    }
    printf("%d ", result);
}