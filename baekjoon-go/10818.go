package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')

	N, _ := strconv.Atoi(strings.TrimSpace(input))

	nums := make([]float64, N)

	input, _ = reader.ReadString('\n')
	strs := strings.Split(strings.TrimSpace(input), " ")

	for idx, str := range strs {
		num, _ := strconv.ParseFloat(str, 10)
		nums[idx] = num
	}

	printMinMax(nums)
}

func printMinMax(nums []float64) {
	const MIN_VALUE float64 = -1_000_000
	const MAX_VALUE float64 = 1_000_000

	var minValue = MAX_VALUE
	var maxValue = MIN_VALUE

	for _, num := range nums {
		minValue = math.Min(minValue, num)
		maxValue = math.Max(maxValue, num)
	}

	fmt.Printf("%.0f %.0f", minValue, maxValue)
}
