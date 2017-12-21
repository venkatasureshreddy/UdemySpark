package com.scala.practises

// a function that take anonymous function as an argument

object HigherOrderFunctions {
  
  def perfom(f:(Int,Int)=>Int){
    
    println(f(1,2))
    
  }
  
  var p = (p:Int,q:Int)=>p*q
  
  def main(args:Array[String]){
    perfom(p)
  }
  
}
