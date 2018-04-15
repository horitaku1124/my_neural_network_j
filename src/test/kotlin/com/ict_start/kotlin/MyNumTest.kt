package com.ict_start.kotlin

import org.junit.Assert.assertEquals
import org.junit.Test


internal class MyNumTest {
  @Test
  fun testSuccess_basic() {
    var a = MyNum.zeros(1)
    assertEquals(1, a.size)
  }
}