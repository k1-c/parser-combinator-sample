package parserCombinator
import parserCombinator.MyList;

object Main {
  def main(args: Array[String]): Unit = {
    val a = MyIntList.apply(2)
    println(MyIntList.sum(a))
  }
}
