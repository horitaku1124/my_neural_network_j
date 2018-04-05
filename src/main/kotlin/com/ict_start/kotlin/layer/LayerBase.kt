package com.ict_start.kotlin.layer

import com.ict_start.kotlin.MyNum

interface LayerBase {
  public fun forward(x: MyNum, t: Boolean): MyNum
  public fun backward(dout: MyNum): MyNum
}