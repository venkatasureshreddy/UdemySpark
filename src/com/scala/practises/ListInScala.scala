package com.scala.practises



object ListInScala {
  
  def main(args:Array[String]){
    
    // Tabulate function
    //var list = List.tabulate(15)(a=>a*a)
    //list.foreach(println)
    
    //FIll Method  ---> it fill 100 in 10 times
    // var lis = List.fill(10)(100)
    // lis.foreach(println)
    
    // Ragne function
//    var s = List.range(1,20,4)
//    s.foreach(println)
//    
    // Filter function
    
    val x  = List.range(1,40)
    var y = x.filter(bul)
    y.foreach(println)
    
  }
  
  def bul(X:Int):Boolean = {
    return true
  }
}