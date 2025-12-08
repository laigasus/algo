package main

import (
	"fmt"
	"strings"
)

func main() {
	var T int
	fmt.Scanf("%d", &T)
	withArray(T)
}

func withArray(T int) {
	var array []int
	var sb strings.Builder

	for i := 0; i < T; i++ {

		var a, b int
		fmt.Scanf("%d %d", &a, &b)

		array = append(array, a+b)
		line := fmt.Sprintf("Case #%d: %d\n", i+1, array[i])
		sb.WriteString(line)
	}

	fmt.Print(sb.String())
}
