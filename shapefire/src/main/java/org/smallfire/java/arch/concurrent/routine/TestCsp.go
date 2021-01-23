package main

import (
	"fmt"
	"time"
)

func main() {
	// 变量声明
	var result, i uint64
	// 单个协程执行累加操作
	start := time.Now()
	for i = 1; i <= 10000000000; i++ {
		result += i
	}
	// 统计计算耗时
	elapsed := time.Since(start)
	fmt.Printf("执行消耗的时间为:", elapsed)
	fmt.Println(", result:", result)

	// 4个协程共同执行累加操作
	start = time.Now()
	ch1 := calc(1, 2500000000)
	ch2 := calc(2500000001, 5000000000)
	ch3 := calc(5000000001, 7500000000)
	ch4 := calc(7500000001, 10000000000)
	// 汇总4个协程的累加结果
	result = <-ch1 + <-ch2 + <-ch3 + <-ch4
	// 统计计算耗时
	elapsed = time.Since(start)
	fmt.Printf("执行消耗的时间为:", elapsed)
	fmt.Println(", result:", result)
}

// 在协程中异步执行累加操作，累加结果通过channel传递
func calc(from uint64, to uint64) <-chan uint64 {
	// channel用于协程间的通信
	ch := make(chan uint64)
	// 在协程中执行累加操作
	go func() {
		result := from
		for i := from + 1; i <= to; i++ {
			result += i
		}
		// 将结果写入channel
		ch <- result
	}()
	// 返回结果是用于通信的channel
	return ch
}
