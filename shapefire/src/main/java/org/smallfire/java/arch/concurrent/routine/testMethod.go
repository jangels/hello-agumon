package main

import (
	"fmt"
)

type Employee struct {
	name     string
	salary   int
	currency string
}

/*
 displaySalary() method has Employee as the receiver type
*/
func (e Employee) displaySalary() {
	fmt.Printf("Salary of %s is %s%d, ", e.name, e.currency, e.salary)
	e.salary = 6000
}

func (e *Employee) displaySalaryWithPointer() {
	fmt.Printf("Salary of %s is %s%d, ", e.name, e.currency, e.salary)
	e.salary = 6000
}

func main() {
	emp1 := Employee {
		name:     "Sam Adolf",
		salary:   5000,
		currency: "$",
	}
	emp1.displaySalary() //Calling displaySalary() method of Employee type
	fmt.Println(emp1.salary)

	emp1.displaySalaryWithPointer();
	fmt.Println(emp1.salary)

}