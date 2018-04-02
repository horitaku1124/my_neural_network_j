package com.ict_start.kotlin

class DeepConvNet {
  public class FilterParam {
    var num: Int = 0
    var size: Int = 0
    var pad: Int = 0
    var stride: Int = 0
    constructor(filterNum:Int, filterSize:Int, pad:Int, stride:Int) {
      this.num = filterNum
      this.size = filterSize
      this.pad = pad
      this.stride = stride
    }
  }

  public class ParamsArray {
    var W1: MyNum? = null
    var W2: MyNum? = null
    var W3: MyNum? = null
    var W4: MyNum? = null
    var W5: MyNum? = null
    var W6: MyNum? = null
    var W7: MyNum? = null
    var W8: MyNum? = null

    var b1: MyNum? = null
    var b2: MyNum? = null
    var b3: MyNum? = null
    var b4: MyNum? = null
    var b5: MyNum? = null
    var b6: MyNum? = null
    var b7: MyNum? = null
    var b8: MyNum? = null
  }

  constructor() {
    var inputDim: IntArray = intArrayOf(1, 28, 28)
    var param1 = FilterParam(16, 3, 1, 1)
    var param2 = FilterParam(16, 3, 1, 1)
    var param3 = FilterParam(32, 3, 1, 1)
    var param4 = FilterParam(32, 3, 2, 1)
    var param5 = FilterParam(64, 3, 1, 1)
    var param6 = FilterParam(64, 3, 1, 1)

    var hiddenSize = 50
    var outputSize = 10

    // 重みの初期化===========
    // 各層のニューロンひとつあたりが、前層のニューロンといくつのつながりがあるか（TODO:自動で計算する）
    var preNodeNums = MyNum.num_array(intArrayOf(1*3*3, 16*3*3, 16*3*3, 32*3*3, 32*3*3, 64*3*3, 64*4*4, hiddenSize))
  }

}