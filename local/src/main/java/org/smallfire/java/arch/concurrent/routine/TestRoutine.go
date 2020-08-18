package main

import (
	"fmt"
	"time"
)

/**
协程
*/
func hello(msg string) {
	fmt.Println("Hello " + msg)
}
func main() {
	//在新的协程中执行hello方法
	go hello("World")
	fmt.Println("Run in main")
	//等待100毫秒让协程执行结束
	time.Sleep(100 * time.Millisecond)
}
