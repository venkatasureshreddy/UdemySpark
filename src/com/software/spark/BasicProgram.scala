package com.software.spark

class BasicProgram(val ac:Int,val bc:Double,val cc:String) {
  var a :Int = ac
  var b:Double = bc
  var c:String = cc
  
  def printDetails(x:Int,y:Double,z:String) {
    a = a + x
    b = b + y
    c = c + z
    
  }
  
 }
class BasicProgramSubClass(override val ac:Int,override val bc:Double,override val cc:String, val kc : String)extends BasicProgram(ac,bc,cc){
  
  var k:String = kc
  
  def printDetails(da:Int,db:Int,dc:String,dd:String){
  
  a = a + da
  b = b +db
  c = c + dc
  k = k + dd
  
  println(a)
  println(b)
  println(c)
  println(k)
  
 }
  
}

object objectName{
  
  def main(args:Array[String]){
    
  val obj = new BasicProgramSubClass(10,20,"suresh","ramesh")
  
  obj.printDetails(1, 2,"reddy","naidu")
  
  // for Looping
  for(a<-1 to 5){
    print(a+" ")
  }
    
    
    
    
  }
  
}