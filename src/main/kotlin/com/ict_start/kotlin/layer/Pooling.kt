package com.ict_start.kotlin.layer

import com.ict_start.kotlin.MyNum

class Pooling: LayerBase {
  constructor(pool_h: Int, pool_w: Int, stride: Int = 1, pad: Int = 0)
  override fun forward(x: MyNum, t:Boolean) : MyNum{
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun backward(dout: MyNum) : MyNum{
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}