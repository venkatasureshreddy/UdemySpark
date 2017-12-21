package com.scala.practises

// Currying is the method of converting a function taht takes multiple parameters as arguments to a function that will take single parameter as a
//parameter and return type is of ananmous function which take remaining data types.

object Currying {
  
  def main(args:Array[String]){
    
    //normalfunction(10, 20)
    curryingmethod(10)(20)     //-------> you call like this
    
  }
  
//  def normalfunction(a:Int,b:Int) = {
//    println(a+b)
//  }
  
  //----> applying curryign to upper function
  
  def curryingmethod(x:Int)={
    (y:Int)=>println(y)
  }
  
  
}