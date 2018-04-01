package com.ict_start.kotlin

fun main(args: Array<String>) {
//  if (args.isEmpty()) {
//  }
  var data: MyNum = MyNum.zeros(3, 2)
  data.Print()
  var data2: MyNum = MyNum.random(2, 3)
  data2.Print()
}