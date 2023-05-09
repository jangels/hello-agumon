package main

import (
	"fmt"
	"math"
	"math/cmplx"
	"math/rand"
	"time"
)

const Pi = 3.14

func main() {

	helloworld()
	import1()
	exportedNames()
	functions()
	functions2()
	multiResults()
	namedResults()
	var1()
	shortSetValue()
	basicTypes()
	zeroValue()
	typeConvert()
	typeInference()
	const1()
	numConst()
}

func shortSetValue() {
	k := 3
	fmt.Println(k)
}

// hello w
func helloworld() {
	fmt.Println("Hello, 世界")
}

func import1() {
	// import
	fmt.Println("The time is", time.Now())
	fmt.Println("My favorite number is", rand.Intn(10))
	fmt.Printf("Now you have %g problems.\n", math.Sqrt(7))
}

func exportedNames() {
	// Exported names
	fmt.Println(math.Pi)
}

func functions() {
	// Functions
	fmt.Println(add(42, 13))
}

func functions2() {
	// Functions consecutive
	fmt.Println(add2(42, 13))
}

func multiResults() {
	// Multiple results
	a, b := swap("hello", "world")
	fmt.Println(a, b)
}

func namedResults() {
	// Named return results
	fmt.Println(split(17))
}

func add(x int, y int) int {
	return x + y
}

func add2(x, y int) int {
	return x + y
}

func swap(x, y string) (string, string) {
	return y, x
}

func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return
}

func var1() {
	// var
	var c, python, java bool
	var i int
	fmt.Println(i, c, python, java)
	var i1, j1 int = 1, 2
	var c1, python1, java1 = true, false, "no!"
	fmt.Println(i1, j1, c1, python1, java1)
}

func basicTypes() {
	var (
		ToBe   bool       = false
		MaxInt uint64     = 1<<64 - 1
		z      complex128 = cmplx.Sqrt(-5 + 12i)
	)

	fmt.Printf("Type: %T Value: %v\n", ToBe, ToBe)
	fmt.Printf("Type: %T Value: %v\n", MaxInt, MaxInt)
	fmt.Printf("Type: %T Value: %v\n", z, z)
}

// 零值
func zeroValue() {
	var i int
	var f float64
	var b bool
	var s string
	fmt.Printf("%v %v %v %q\n", i, f, b, s)
}

// 类型转换
func typeConvert() {
	i := 42
	f := float64(i)
	u := uint(f)
	fmt.Printf("%T %T %T\n", i, f, u)
	fmt.Printf("%v %v %v\n", i, f, u)
}

// 类型推导
func typeInference() {
	v := 42.0 // 修改这里！
	//i := 42           // int
	//f := 3.142        // float64
	//g := 0.867 + 0.5i // complex128
	fmt.Printf("v is of type %T\n", v)
}

// 常量
func const1() {
	const World = "世界"
	fmt.Println("Hello", World)
	fmt.Println("Happy", Pi, "Day")

	const Truth = true
	fmt.Println("Go rules?", Truth)
}

func numConst() {
	fmt.Println(needInt(Small))
	fmt.Println(needFloat(Small))
	fmt.Println(needFloat(Big))
}

const (
	// 将 1 左移 100 位来创建一个非常大的数字
	// 即这个数的二进制是 1 后面跟着 100 个 0
	Big = 1 << 100
	// 再往右移 99 位，即 Small = 1 << 1，或者说 Small = 2
	Small = Big >> 99
)

func needInt(x int) int {
	return x*10 + 1
}
func needFloat(x float64) float64 {
	return x * 0.1
}
