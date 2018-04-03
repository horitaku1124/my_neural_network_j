package com.ict_start.kotlin

import com.ict_start.kotlin.layer.Convolution
import com.ict_start.kotlin.layer.LayerBase
import com.ict_start.kotlin.layer.Pooling
import com.ict_start.kotlin.layer.Relu

class DeepConvNet {
  var layers: MutableList<LayerBase> = ArrayList()

  class FilterParam(filterNum: Int, filterSize: Int, var pad: Int, var stride: Int) {
    var num: Int = filterNum
    var size: Int = filterSize
  }

  constructor() {
    var inputDim: IntArray = intArrayOf(1, 28, 28)
    val param1 = FilterParam(16, 3, 1, 1)
    val param2 = FilterParam(16, 3, 1, 1)
    val param3 = FilterParam(32, 3, 1, 1)
    val param4 = FilterParam(32, 3, 2, 1)
    val param5 = FilterParam(64, 3, 1, 1)
    val param6 = FilterParam(64, 3, 1, 1)

    val hiddenSize = 50
    val outputSize = 10

    // 重みの初期化===========
    // 各層のニューロンひとつあたりが、前層のニューロンといくつのつながりがあるか（TODO:自動で計算する）
    val preNodeNums = MyNum.num_array(intArrayOf(1*3*3, 16*3*3, 16*3*3, 32*3*3, 32*3*3, 64*3*3, 64*4*4, hiddenSize))
    val wightInitScales = MyNum.sqrt(2.0F / preNodeNums)

    var preChannelNum = inputDim[0]
    val params = HashMap<String, MyNum>()
    val enumerate = listOf(param1, param2, param3, param4, param5, param6)

    for (i in 0 until enumerate.size) {
      val param = enumerate.get(i)
      val w = wightInitScales.getF(i) * MyNum.randome_randn(param.num, preChannelNum, param.num, param.size)
      params.put("W" + (i + 1), w)
      params.put("b" + (i + 1), MyNum.zeros(param.num))
      preChannelNum = param.num
    }
    val w7 = wightInitScales.getF(6) * MyNum.randome_randn(64*4*4, hiddenSize)
    val b7 = MyNum.zeros(hiddenSize)
    params.put("W7", w7)
    params.put("b7", b7)

    val w8 = wightInitScales.getF(7) * MyNum.randome_randn(hiddenSize, outputSize)
    val b8 = MyNum.zeros(outputSize)
    params.put("W8", w8)
    params.put("b8", b8)


    layers.add(Convolution(params.get("W1")!!, params.get("b1")!!, param1.num, param1.pad))
    layers.add(Relu())
    layers.add(Convolution(params.get("W2")!!, params.get("b2")!!, param2.num, param2.pad))
    layers.add(Relu())

    layers.add(Pooling(2, 2, 2))

    layers.add(Convolution(params.get("W3")!!, params.get("b3")!!, param3.num, param3.pad))
    layers.add(Relu())
    layers.add(Convolution(params.get("W4")!!, params.get("b4")!!, param4.num, param4.pad))
    layers.add(Relu())

    layers.add(Pooling(2, 2, 2))
  }
}