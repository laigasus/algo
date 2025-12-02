package main

import (
	"fmt"
)

func main() {
	var A, B int
	fmt.Scanf("%d %d", &A, &B)

	fmt.Printf("%s", comp(A, B))
}

func comp(a int, b int) string {
	var result = a - b
	if result > 0 {
		return ">"
	} else if result < 0 {
		return "<"
	} else {
		return "=="
	}
}
