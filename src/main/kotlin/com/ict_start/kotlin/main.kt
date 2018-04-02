package com.ict_start.kotlin

fun main(args: Array<String>) {
//  if (args.isEmpty()) {
//  }
  var data: MyNum = MyNum.zeros(3, 2)
  data.print()
  var data2: MyNum = MyNum.randome_randn(2, 3)
  data2.print()

  var data3 = MyNum.num_array(intArrayOf(1, 2, 3))
  data3.print()

  println(" --------  \n\n\n")
  data3 = data3.divideOf(2.0F)
  data3.print()
  data3 = 3.0F / data3
  data3.print()
}