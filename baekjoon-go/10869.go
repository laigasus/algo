package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var stdio = bufio.NewReadWriter(
		bufio.NewReader(os.Stdin),
		bufio.NewWriter(os.Stdout),
	)

	defer stdio.Flush()

	var add = func(a int, b int) int {
		return a + b
	}

	var subtract = func(a int, b int) int {
		return a - b
	}

	var multiply = func(a int, b int) int {
		return a * b
	}

	var divide = func(a int, b int) int {
		return a / b
	}

	var remainder = func(a int, b int) int {
		return a % b
	}

	var a int
	var b int

	fmt.Fscan(stdio, &a, &b)

	fmt.Println(add(a, b))
	fmt.Println(subtract(a, b))
	fmt.Println(multiply(a, b))
	fmt.Println(divide(a, b))
	fmt.Println(remainder(a, b))
}
