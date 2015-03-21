package com.sonal.scala.scalabasics.scalabasicsproj

object HelloScalaMain {

  def main(args: Array[String]) {
    println("Hello Scala World !!")
    
    var learnFunctionClass: LearnAllFunctionTypes = new LearnAllFunctionTypes()

    learnToCallFunction(learnFunctionClass)

    underStandAnnonymousFunction(learnFunctionClass)

    underStandAnnonymousApplyOnVarible(learnFunctionClass)

  }

  def random(x: Int): Unit = {
    println(x)
  }

  def learnToCallFunction(learnFunctionClass: LearnAllFunctionTypes): Unit = {
    var z = learnFunctionClass.sumWay1(1, 2)
    println(z)

    var u = learnFunctionClass.sumWay2(1, 2)
    println(u)

    var v = learnFunctionClass.sumWay3(1, 2)
    println(v)
  }

  def underStandAnnonymousFunction(learnFunctionClass: LearnAllFunctionTypes) {

    learnFunctionClass.callGreetPeople()
    learnFunctionClass.callSumAnnonymousWay1()

  }

  def underStandAnnonymousApplyOnVarible(learnFunctionClass: LearnAllFunctionTypes) {
    var someValue1 = (a: Int) => a + 1;

    var someValue2 = (a: Int, b: Int) => a + b;

    random(someValue1(10))
    random(someValue2(10, 20))
  }

}
