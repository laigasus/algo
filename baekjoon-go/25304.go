package main

import (
	"fmt"
)

func main() {
	var X int
	fmt.Scanf("%d", &X)

	var N int
	fmt.Scanf("%d", &N)

	var sum = 0
	for i := 0; i < N; i++ {
		var price, quantity int
		fmt.Scanf("%d %d", &price, &quantity)

		sum += multiply(price, quantity)
	}

	if sum == X {
		fmt.Println("Yes")
	} else {
		fmt.Println("No")
	}
}

func multiply(a int, b int) int {
	return a * b
}
