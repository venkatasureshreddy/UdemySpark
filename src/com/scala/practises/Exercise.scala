package com.scala.practises

object Exercise {
  
  def main(args:Array[String]){
    
    val list = List.range(1,21)
    
    for(i<-list.filter(x=>(x%3==0))){
      print(i+" ")
    }
    
  }
  
}