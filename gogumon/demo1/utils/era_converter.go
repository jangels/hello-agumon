package main

import (
	"fmt"
	"os"
	"strconv"
)

// 定义天干和地支数组
var tianGan = []string{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"}
var diZhi = []string{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"}

// ToChineseEra 将公历年份转换为天干地支纪年
func ToChineseEra(year int) string {
	base := year - 4

	// 处理负数取模问题
	ganIndex := (base%10 + 10) % 10  // 天干索引（0-9）
	zhiIndex := (base%12 + 12) % 12  // 地支索引（0-11）

	return tianGan[ganIndex] + diZhi[zhiIndex]
}

//func main() {
//	// 测试用例
//	fmt.Println(ToChineseEra(2023))  // 输出：癸卯
//	fmt.Println(ToChineseEra(2024))  // 输出：甲辰
//	fmt.Println(ToChineseEra(1984))  // 输出：甲子
//	fmt.Println(ToChineseEra(4))     // 输出：甲子（基准年）
//	fmt.Println(ToChineseEra(2020))  // 输出：庚子
//}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Usage:  <year1> <year2> ...")
		fmt.Println("Example:  2023 1984")
		os.Exit(1)
	}

	for _, arg := range os.Args[1:] {
		year, err := strconv.Atoi(arg)
		if err != nil {
			fmt.Printf("Invalid year: %s\n", arg)
			continue
		}
		fmt.Printf("%d -> %s\n", year, ToChineseEra(year))
	}
}