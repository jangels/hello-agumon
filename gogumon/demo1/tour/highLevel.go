package main

import (
	"fmt"
	"math"
	"strings"
)

func main() {

	pointer1()

	struct1()
	struct2()
	struct3()
	struct4()

	array1()

	slices1()
	slices2()
	slices3()
	slices4()
	slices5()
	slices6()
	slices7()
	slices8()
	slices9()
	slices10_range()
	slices10_range2()

	map1()
	map2()
	map3()
	map4()
	fmt.Println("---------------")

	funcValue1()
	fmt.Println("---------------")

	funcValue2_closure()
	fmt.Println("---------------")

	funcValue2_closure2()
	fmt.Println("---------------")

}

func pointer1() {
	i, j := 42, 2701

	p := &i         // 指向 i
	fmt.Println(*p) // 通过指针读取 i 的值
	*p = 21         // 通过指针设置 i 的值
	fmt.Println(i)  // 查看 i 的值

	p = &j       // 指向 j
	*p = *p / 37 // 通过指针对 j 进行除法运算
	fmt.Println("%T", p)
	fmt.Println("%T", *p)
	fmt.Println(j) // 查看 j 的值
}

type Vertex struct {
	X int
	Y int
}

func struct1() {
	fmt.Println(Vertex{1, 2})
}

// 结构体字段
func struct2() {
	v := Vertex{1, 2}
	v.X = 4
	fmt.Println(v.X)
}

// 结构体指针
func struct3() {
	v := Vertex{1, 2}
	p := &v
	p.X = 1e9
	fmt.Println(v)
	(*p).X = 1e10
	fmt.Println(v)
}

var (
	v1 = Vertex{1, 2}  // 创建一个 Vertex 类型的结构体
	v2 = Vertex{X: 1}  // Y:0 被隐式地赋予
	v3 = Vertex{}      // X:0 Y:0
	p  = &Vertex{1, 2} // 创建一个 *Vertex 类型的结构体（指针）
)

// 结构体文法
func struct4() {
	fmt.Println(v1, p, v2, v3)
}

// 数组
func array1() {
	var a [2]string
	a[0] = "Hello"
	a[1] = "World"
	fmt.Println(a[0], a[1])
	fmt.Println(a)

	primes := [6]int{2, 3, 5, 7, 11, 13}
	fmt.Println(primes)
}

// 切片
func slices1() {
	primes := [6]int{2, 3, 5, 7, 11, 13}

	var s []int = primes[1:4]
	fmt.Println(s)
}

// 切片指针
func slices2() {
	names := [4]string{
		"John",
		"Paul",
		"George",
		"Ringo",
	}
	fmt.Println(names)

	a := names[0:2]
	b := names[1:3]
	fmt.Println(a, b)

	b[0] = "XXX"
	fmt.Println(a, b)
	fmt.Println(names)
}

// 切片文法
func slices3() {
	q := []int{2, 3, 5, 7, 11, 13}
	fmt.Println(q)

	r := []bool{true, false, true, true, false, true}
	fmt.Println(r)

	s := []struct {
		i int
		b bool
	}{
		{2, true},
		{3, false},
		{5, true},
		{7, true},
		{11, false},
		{13, true},
	}
	fmt.Println(s)
}

// 切片默认行为
func slices4() {
	s := []int{2, 3, 5, 7, 11, 13}

	s = s[1:4]
	fmt.Println(s)

	s = s[:2]
	fmt.Println(s)

	s = s[1:]
	fmt.Println(s)
}

// 切片长度和容量
func slices5() {
	s := []int{2, 3, 5, 7, 11, 13}
	printSlice(s)

	// 截取切片使其长度为 0
	s = s[:0]
	printSlice(s)

	// 拓展其长度
	s = s[:4]
	printSlice(s)

	// 舍弃前两个值
	s = s[2:]
	printSlice(s)
}

func printSlice(s []int) {
	fmt.Printf("len=%d cap=%d %v\n", len(s), cap(s), s)
}

// nil 切片
func slices6() {
	var s []int
	fmt.Println(s, len(s), cap(s))
	if s == nil {
		fmt.Println("nil!")
	}
}

func printSlice2(s string, x []int) {
	fmt.Printf("%s len=%d cap=%d %v\n",
		s, len(x), cap(x), x)
}

// make 切片
func slices7() {
	a := make([]int, 5)
	printSlice2("a", a)

	b := make([]int, 0, 5)
	printSlice2("b", b)

	c := b[:2]
	printSlice2("c", c)

	d := c[2:5]
	printSlice2("d", d)
}

// 切片的切片
func slices8() {
	// 创建一个井字板（经典游戏）
	board := [][]string{
		[]string{"_", "_", "_"},
		[]string{"_", "_", "_"},
		[]string{"_", "_", "_"},
	}

	// 两个玩家轮流打上 X 和 O
	board[0][0] = "X"
	board[2][2] = "O"
	board[1][2] = "X"
	board[1][0] = "O"
	board[0][2] = "X"

	for i := 0; i < len(board); i++ {
		fmt.Printf("%s\n", strings.Join(board[i], " "))
	}
}

// 扩容, append
func slices9() {
	var s []int
	printSlice3(s)

	// 添加一个空切片
	s = append(s, 0)
	printSlice3(s)

	// 这个切片会按需增长
	s = append(s, 1)
	printSlice3(s)

	// 可以一次性添加多个元素
	s = append(s, 2, 3, 4)
	printSlice3(s)
}

func printSlice3(s []int) {
	fmt.Printf("len=%d cap=%d %v\n", len(s), cap(s), s)
}

var pow1 = []int{1, 2, 4, 8, 16, 32, 64, 128}

func slices10_range() {
	for i, v := range pow1 {
		fmt.Printf("2**%d = %d\n", i, v)
	}
}

func slices10_range2() {
	pow := make([]int, 10)
	for i := range pow {
		pow[i] = 1 << uint(i) // == 2**i
	}
	for _, value := range pow {
		fmt.Printf("%d\n", value)
	}
}

type Vertex2 struct {
	Lat, Long float64
}

var m map[string]Vertex2

func map1() {
	m = make(map[string]Vertex2)

	k1 := "Bell Labs"
	m[k1] = Vertex2{
		40.68433, -74.39967,
	}
	m["lzh"] = Vertex2{
		12, 31,
	}

	fmt.Println(m[k1])
	fmt.Println(m["lzh"])
}

func map2() {
	var m = map[string]Vertex2{
		"Bell Labs": Vertex2{
			40.68433, -74.39967,
		},
		"Google": Vertex2{
			37.42202, -122.08408,
		},
	}
	fmt.Println(m)
}

func map3() {
	var m = map[string]Vertex2{
		"Bell Labs": {40.68433, -74.39967},
		"Google":    {37.42202, -122.08408},
	}
	fmt.Println(m)
}

func map4() {
	m := make(map[string]int)

	m["Answer"] = 42
	fmt.Println("The value:", m["Answer"])

	m["Answer"] = 48
	fmt.Println("The value:", m["Answer"])

	delete(m, "Answer")
	fmt.Println("The value:", m["Answer"])

	v, ok := m["Answer"]
	fmt.Println("The value:", v, "Present?", ok)
}

func compute(fn func(float64, float64) float64) float64 {
	return fn(3, 4)
}

func funcValue1() {
	hypot := func(x, y float64) float64 {
		return math.Sqrt(x*x + y*y)
	}
	fmt.Println(hypot(5, 12))

	fmt.Println(compute(hypot))
	fmt.Println(compute(math.Pow))
}

func adder() func(int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}

// 闭包
func funcValue2_closure() {
	pos, neg := adder(), adder()
	for i := 0; i < 10; i++ {
		fmt.Println(
			pos(i),
			neg(-2*i),
		)
	}
}

// 返回一个“返回int的函数”
func fibonacci() func() int {
	a, b := 0, 1
	return func() int {
		a, b = b, a+b
		return a
	}
}

func funcValue2_closure2() {
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}
