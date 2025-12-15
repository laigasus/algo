package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {

	var scanner = bufio.NewScanner(os.Stdin)
	scanner.Scan()
	S := scanner.Text()

	scanner.Scan()
	i, _ := strconv.Atoi(scanner.Text())

	fmt.Printf("%c", S[i-1])
}
