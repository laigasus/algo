package main

import (
	"fmt"
)

func main() {
	const SIZE int = 9
	arr2D := [SIZE][SIZE]int{}

	maxV := -1
	maxIdxY := -1
	maxIdxX := -1

	for y := 0; y < SIZE; y++ {
		for x := 0; x < SIZE; x++ {
			var num int
			fmt.Scanf("%d", &num)
			arr2D[y][x] = num

			if arr2D[y][x] >= maxV {
				maxV, maxIdxX, maxIdxY = arr2D[y][x], x+1, y+1
			}
		}
	}

	fmt.Printf("%d\n", maxV)
	fmt.Printf("%d %d", maxIdxY, maxIdxX)
}
