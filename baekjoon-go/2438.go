package main

import (
	"fmt"
	"strings"
)

func main() {
	var N int
	fmt.Scanf("%d", &N)

	arr := make([]string, N)

	for i := 0; i < N; i++ {
		const asterisk = "*"

		var str = strings.Repeat(asterisk, i+1)

		arr[i] = str
	}

	fmt.Println(strings.Join(arr, "\n"))
}
