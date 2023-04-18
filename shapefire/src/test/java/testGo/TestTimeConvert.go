package main

import (
	"fmt"
	"time"
)

func main() {
	var str = "0001-01-01 00:00:00"

	tmpUseCouponTime, _ := time.ParseInLocation("2006-01-02 15:04:05", str, time.Local)

	fmt.Println(tmpUseCouponTime)
	fmt.Println(tmpUseCouponTime.Unix())


	str = "2021-01-01 00:00:00";

	tmpUseCouponTime2, _ := time.ParseInLocation("2006-01-02 15:04:05", str, time.Local)

	fmt.Println(tmpUseCouponTime2)
	fmt.Println(tmpUseCouponTime2.Unix())
}
