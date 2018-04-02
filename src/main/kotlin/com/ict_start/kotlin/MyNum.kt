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

  operator fun div(that: MyNum):MyNum = MyNum()

  fun divideBy(divideBy: Float) {
    if (this.type == NumType.IntType) {
      val newFloatArray = FloatArray(this.size)
      for (i in 0 until this.size) {
        newFloatArray[i] = this.intData!![i] / divideBy
      }
      this.intData = null
      this.floatData = newFloatArray
      this.type = NumType.FloatType
    } else if (this.type == NumType.FloatType) {
      for (i in 0 until this.size) {
        this.floatData!![i] = this.floatData!![i] / divideBy
      }
    }
  }

  fun divideOf(divideOf: Float) :MyNum {
    val newMyNum = this.clone()
    if (newMyNum.type == NumType.IntType) {
      val newFloatArray = FloatArray(newMyNum.size)
      for (i in 0 until newMyNum.size) {
        newFloatArray[i] = divideOf / newMyNum.intData!![i]
      }
      newMyNum.intData = null
      newMyNum.floatData = newFloatArray
      newMyNum.type = NumType.FloatType
    } else if (newMyNum.type == NumType.FloatType) {
      for (i in 0 until newMyNum.size) {
        newMyNum.floatData!![i] = divideOf / newMyNum.floatData!![i]
      }
    }
    return newMyNum
  }

  fun clone(): MyNum {
    val newMyNum = MyNum()
    newMyNum.size = this.size
    newMyNum.dimension = this.dimension
    newMyNum.type = this.type
    newMyNum.intData = this.intData
    newMyNum.floatData = this.floatData
    return newMyNum
  }

  fun print() {
    for (i in 0 until this.size) {
      if (this.type == NumType.IntType) {
        println(this.intData!![i].toString())
      }
      if (this.type == NumType.FloatType) {
        println(this.floatData!![i].toString())
      }
    }
  }

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
    fun randome_randn(vararg shape: Int) : MyNum {
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
    fun num_array(array: IntArray): MyNum {
      val returnVal = MyNum()
      returnVal.shape = intArrayOf(array.size)
      returnVal.type = NumType.IntType
      returnVal.intData = array
      returnVal.size = array.size
      return returnVal
    }
    fun sqrt(that: MyNum): MyNum {
      if (that.type == NumType.IntType) {
        val newFloatArray = FloatArray(that.size)
        for (i in 0 until that.size) {
          newFloatArray[i] = Math.sqrt(that.intData!![i].toDouble()).toFloat()
        }
        that.intData = null
        that.floatData = newFloatArray
        that.type = NumType.FloatType
      } else if (that.type == NumType.FloatType) {
        for (i in 0 until that.size) {
          that.floatData!![i] = Math.sqrt(that.floatData!![i].toDouble()).toFloat()
        }
      }
      return that
    }
  }
}

operator fun Float.div(that: MyNum):MyNum {
  return that.divideOf(this)
}