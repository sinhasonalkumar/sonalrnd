package com.sonal.random

class TestClass(name : String) {
  
  def this(){
     this("default")
  }
  
  val say : String =  "Hello !! " + name 
  def show()  {
    println(say)
  }
}