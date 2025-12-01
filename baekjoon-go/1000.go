package main

import (
	"bufio"
	"fmt"
	"os"
)

var stdio = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

func add(a int, b int) int {
	return a + b
}

func main() {
	defer stdio.Flush()

	var a int
	var b int
	fmt.Fscan(stdio, &a, &b)

	fmt.Println(add(a, b))
}
