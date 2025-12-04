package main

import IO "fmt"

func main() {
	var score int
	count, err := IO.Scanf("%d", &score)

	IO.Printf("입력 개수: %d\n", count)
	IO.Printf("오류: %s\n", err)

	IO.Println(estimateRank(score))
}

func estimateRank(score int) string {
	switch score / 10 {
	case 10:
		fallthrough
	case 9:
		return "A"
	case 8:
		return "B"
	case 7:
		return "C"
	case 6:
		return "D"
	default:
		return "F"
	}
}
