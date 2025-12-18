package main

import (
	"fmt"
	"math"
	"strconv"
)

func main() {

	var a, b string
	fmt.Scanf("%s %s", &a, &b)

	rs := math.Max(
		reverseAndConvertNumber([]rune(a)),
		reverseAndConvertNumber([]rune(b)),
	)
	fmt.Println(rs)
}

func reverseAndConvertNumber(arr []rune) float64 {
	var str string

	for i := len(arr) - 1; i >= 0; i-- {
		str += string(arr[i])
	}

	rs, _ := strconv.Atoi(str)

	return float64(rs)
}
