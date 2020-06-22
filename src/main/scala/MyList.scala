package parserCombinator

trait MyList

object MyIntList {
  def apply(numbers: Int*): MyList = {
    if (numbers.isEmpty) Nil
    else {
      Cons(numbers.head, apply(numbers.tail:_*))
    }
  }
  def fold(list: MyList, z: Int, func: (Int, Int) => Int): Int = list match {
    case Nil => z
    case Cons(x, xs) => fold(xs, func(z, x), func)
  }
  def sum(list: MyList): Int =  {
    fold(list, 0, _+_)
  }
  def product(list: MyList): Int = list match {
    case Nil => 0
    case _ => fold(list, 1, _*_)
  }
  def prepend(list: MyList, number: Int): MyList = {
    Cons(number, list)
  }
  def map(list: MyList, func: (Int) => Int): MyList = list match {
    case Nil => Nil
    case Cons(x, Nil) => Cons(func(x), Nil)
    case Cons(x, xs) => Cons(func(x),map(xs, func))
  }
}

case object Nil extends MyList
case class Cons(number: Int, nextList: MyList) extends MyList