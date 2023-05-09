package main

import (
	"fmt"
	"math"
)

func main() {

	method1()
	method2()
	method3()
	method4()
	method5()
	method6()
	method7()
}

type Vertex3 struct {
	X, Y float64
}

func (v Vertex3) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

// 结构体方法 A method is a function with a special receiver argument.
func method1() {
	v := Vertex3{3, 4}
	fmt.Println(v.Abs())
}

func Abs(v Vertex3) float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

// 普通方法
func method2() {
	v := Vertex3{3, 4}
	fmt.Println(Abs(v))
}

type MyFloat float64

func (f MyFloat) Abs() float64 {
	if f < 0 {
		return float64(-f)
	}
	return float64(f)
}

// 非结构体方法
func method3() {
	f := MyFloat(-math.Sqrt2)
	fmt.Println(f.Abs())
}

func (v *Vertex3) Scale(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

// 指针接受者
func method4() {
	v := Vertex3{3, 4}
	v.Scale(10)
	fmt.Println(v.Abs())
}

func Abs2(v Vertex3) float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}
func Scale(v *Vertex3, f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}
func method5() {
	v := Vertex3{3, 4}
	Scale(&v, 10)
	fmt.Println(Abs2(v))
}

func (v *Vertex3) Scale2(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

func ScaleFunc(v *Vertex3, f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

// 带指针参数的函数  vs 带接受者的方法, 接受指针
func method6() {
	v := Vertex3{3, 4}
	v.Scale2(2)
	ScaleFunc(&v, 10)

	p := &Vertex3{4, 3}
	p.Scale2(3)
	ScaleFunc(p, 8)

	fmt.Println(v, p)
}

func AbsFunc(v Vertex3) float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

// 带指针参数的函数  vs 带接受者的方法, 接受值
func method7() {
	v := Vertex3{3, 4}
	fmt.Println(v.Abs())
	fmt.Println(AbsFunc(v))

	p := &Vertex3{4, 3}
	fmt.Println(p.Abs())
	fmt.Println(AbsFunc(*p))
}

type Abser interface {
	Abs() float64
}
