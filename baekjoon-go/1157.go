package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	var m = make(map[string]int)

	input, _ := reader.ReadString('\n')
	alphabets := strings.TrimSpace(input)

	for _, alphabet := range alphabets {
		alphabet := strings.ToUpper(string(alphabet))
		m[alphabet]++
	}

	maxCount := 0
	maxAlphabet := ""
	isDuplicate := false

	for alphabet, count := range m {
		if count > maxCount {
			isDuplicate = false

			maxCount = count
			maxAlphabet = alphabet
		} else if count == maxCount {
			isDuplicate = true
		}
	}

	if isDuplicate {
		fmt.Println("?")
	} else {
		fmt.Printf("%s\n", maxAlphabet)
	}

}
