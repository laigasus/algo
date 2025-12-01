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

	var a int
	var b int

	fmt.Fscan(stdio, &a, &b)

	fmt.Println(add(a, b))
}
