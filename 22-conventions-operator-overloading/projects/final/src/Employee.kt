/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

data class Employee(val company: Company, val name: String, var salary: Int) : Comparable<Employee> {

  operator fun plusAssign(increaseSalary: Int) {
    salary += increaseSalary
    println("$name got a raise to $$salary")
  }

  operator fun minusAssign(decreaseSalary: Int) {
    salary -= decreaseSalary
    println("$name's salary decreased to $$salary")
  }

  operator fun plus(employee: Employee): List<Employee> {
    return listOf(this, employee)
  }

  operator fun dec(): Employee {
    salary -= 5000
    println("$name's salary decreased to $$salary")
    return this
  }

  operator fun inc(): Employee {
    salary += 5000
    println("$name got a raise to $$salary")
    return this
  }

  operator fun rangeTo(other: Employee): List<Employee> {
    val currentIndex = company.allEmployees.indexOf(this)
    val otherIndex = company.allEmployees.indexOf(other)

    if (currentIndex >= otherIndex) {
      return emptyList()
    }

    return company.allEmployees.slice(currentIndex..otherIndex)
  }

  override operator fun compareTo(other: Employee): Int {
    return when (other) {
      this -> 0
      else -> name.compareTo(other.name)
    }
  }
}
