package com.ict_start.kotlin.layer

import com.ict_start.kotlin.MyNum

class Dropout: LayerBase {
  constructor(dropout_ratio: Float)
  override fun forward(x: MyNum, t:Boolean): MyNum {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun backward(dout: MyNum) : MyNum{
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}