package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)

	sc.Scan()
	N, _ := strconv.Atoi(sc.Text())

	arr := make([]int, N)

	sc.Scan()
	for idx, v := range strings.Split(sc.Text(), "") {
		arr[idx], _ = strconv.Atoi(v)
	}

	fmt.Println(sum(arr))
}

func sum(arr []int) int {
	sum := 0
	for _, v := range arr {
		sum += v
	}

	return sum
}
