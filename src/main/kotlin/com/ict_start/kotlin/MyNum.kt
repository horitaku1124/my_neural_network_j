package com.ict_start.kotlin

class MyNum {
  enum class NumType {
    IntType, FloatType
  }
  private var shape: IntArray? = null
  private var size: Int = 0
  private var dimension: Int = 0
  private var type: NumType? = null
  private var intData: IntArray? = null
  private var floatData: FloatArray? = null


  companion object {
    fun zeros(vararg shape: Int) : MyNum {
      val returnVal = MyNum()
      returnVal.shape = shape
      returnVal.size = 1

      for (i in shape) {
        returnVal.size *= i
      }
      returnVal.dimension = shape.size
      returnVal.type = NumType.IntType

      returnVal.intData = IntArray(returnVal.size)

      return returnVal
    }
    fun random(vararg shape: Int) : MyNum {
      val returnVal = MyNum()
      returnVal.shape = shape
      returnVal.size = 1

      for (i in shape) {
        returnVal.size *= i
      }
      returnVal.dimension = shape.size
      returnVal.type = NumType.FloatType
      returnVal.floatData = FloatArray(returnVal.size)

      for (i in 0 until returnVal.size) {
        returnVal.floatData!![i] = Math.random().toFloat()
      }

      return returnVal
    }
  }

  public fun Print() {
    for (i in 0 until this.size) {
      if (this.type == NumType.IntType) {
        println(this.intData!![i].toString())
      }
      if (this.type == NumType.FloatType) {
        println(this.floatData!![i].toString())
      }
    }
  }
}