package com.scala.practises

object ExceptionExample {
  
  def main(args:Array[String]){
    
    val x:Double =10
    val y:Int =0
    
    try { 
          println("try block "+ x/y)
      
    }
    
    catch{ case exception : ArithmeticException => println(y/x) }
      
    finally {println("This is finally block")}
  }
  
}