package com.ict_start.kotlin.layer

import com.ict_start.kotlin.MyNum

interface LayerBase {
  public fun forward(x: Int);
  public fun backward(dout: Int)
}