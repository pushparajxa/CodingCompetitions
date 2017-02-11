/*
 * Copyright 2017 DigitalRoute Route AB. All rights reserved.
 *  Proprietary and Confidential.
 */
object Reverse_Sentence_InMemory {
  /*
     one two three -- First reverse the whole sentence
     eerht owt eon -- Then reverse the words in it
     theee two one

   */

  def swap(sntnc:Array[Char],i: Int, i1: Int) = {
    val temp= sntnc(i)
    sntnc(i) = sntnc(i1)
    sntnc(i1) = temp
  }

  def reverse_word(sntnc:Array[Char]):Array[Char] ={
    if(sntnc.length == 0)
      return sntnc
    for(i<-0 to sntnc.length-1){
      if(i>=sntnc.length-1-i)
        return sntnc
      swap(sntnc,i,sntnc.length-1-i)
    }
    sntnc
  }

  def reverse_word(sntnc:Array[Char],start:Int,end:Int):Unit ={
    if(start == end){
      return
    }
    for(i<-start to end){
      if(i>=end-(i-start))
        return
      swap(sntnc,i,end-(i-start))
    }
  }

  def next_whiteSpace(rSntnc: Array[Char], start: Int):Int = {
      for(i<-start to rSntnc.length-1) {
      if(rSntnc(i)==' ')
        return i
      }
    rSntnc.length
  }

  def reverse_sentence(sntnc:Array[Char]):Array[Char] ={
    val rSntnc = reverse_word(sntnc)
    println("Reveresed String="+ new String(rSntnc))
    var temp = -1
    for(i<-0 to  rSntnc.length-1){
      if(rSntnc(i)!= ' ' && i>temp){
        temp=next_whiteSpace(rSntnc,i)
        reverse_word(rSntnc,i,temp-1)
        }
      }
    rSntnc
  }



  def main(args: Array[String]): Unit = {
    /*println(new String(reverse_word("hello".toCharArray)))
    println(new String(reverse_word("hell".toCharArray)))
    println(new String(reverse_word("h".toCharArray)))
    println(new String(reverse_word("he".toCharArray)))*/

    //println(new String(reverse_word("one    isk Two  Three".toCharArray)))
    println(new String(reverse_sentence("".toCharArray)))

  }



}
