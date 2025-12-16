package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)

	sc.Scan()
	T, _ := strconv.Atoi(sc.Text())

	arr := make([]string, T)
	for i := 0; i < T; i++ {
		sc.Scan()
		arr[i] = sc.Text()
	}

	for _, v := range arr {
		fmt.Printf("%c%c\n", v[0], v[len(v)-1])
	}

}
