package com.sonal.scala.scalabasics.scalabasicsproj

class LearnAllFunctionTypes {

  def sumWay1(x: Int, y: Int): Int = {
    var z: Int = x + y
    return z
  }

  def sumWay2(x: Int, y: Int) = {
    // x + y
    var z = x * y
    println(z);
    x + y
  }

  def sumWay3(x: Int, y: Int) = x + y

  def buildGreetings(person: String) = {
    var msg = "Hello !! " + person
    println(msg)
    msg
  }

  def greetPeople(f: (String) => String): Unit = {
    var message : String =  f("Sonal")
    println(message)
  }

  def callGreetPeople() {
    greetPeople(buildGreetings)
  }

  def sumAnnonymousWay1(f: (Int, Int) => Int): String = {
    var result: String = "Result :: " + f(3, 4)
    return result
  }

  def sumAnnonymousWay2(f: => Int): String = {
    var result: String = "Result :: " + f
    return result
  }

  // OR def callSumAnnonymousWay1() {
  def callSumAnnonymousWay1(): Unit = {
    var result1: String = sumAnnonymousWay1(sumWay1)
    var result2: String = sumAnnonymousWay2(sumWay1(3, 4))

    println(result1)
    println(result2)

  }
  
}
