package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println("Hello, 世界2")
	amount := fmt.Sprintf("%.2f", float64(250)/100)
	fmt.Println("amount:", amount)

	converTime := ConvertTime(6400)
	fmt.Println("converTime:", converTime)

	// 计算时间差
	// 初始化一个时间类型
	endTime := time.Now()
	formatTime := endTime.Format("2006-01-02 15:04:05")
	fmt.Println("formatTime:", formatTime)
}
func ConvertTime(totalTime int) string {
	if totalTime <= 0 {
		return "0秒"
	}

	hours := totalTime / 3600
	remainingSeconds := totalTime % 3600
	minutes := remainingSeconds / 60
	seconds := remainingSeconds % 60

	if hours > 0 {
		return fmt.Sprintf("%d小时%d分钟%d秒", hours, minutes, seconds)
	} else if minutes > 0 {
		return fmt.Sprintf("%d分钟%d秒", minutes, seconds)
	} else {
		return fmt.Sprintf("%d秒", seconds)
	}
}
