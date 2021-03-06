package com.torvbell.game_engine.defined_type

trait defined_type {

  type Error = Throwable
  type Bool = Boolean
  type Y = true
  type N = false

  type Null = null

  type typeof = Unit
  /* 类型判断 */
  type sizeof = Unit /* 对象大小计算 */

  type Un_Int = type_unint

}
