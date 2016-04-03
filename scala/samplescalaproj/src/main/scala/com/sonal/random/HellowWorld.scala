package com.sonal.random


object HellowWorld {
  
  def main(args: Array[String]): Unit = {
    val testClass : TestClass = new TestClass("sonal")
    val testClass1 : TestClass = new TestClass;
    
    testClass.show()
    testClass1.show()
    
    //testClass  = new TestClass("sonal")
    
  }
}