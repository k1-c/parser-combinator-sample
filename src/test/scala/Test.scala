import parserCombinator.{MyIntList, Cons, Nil}
import org.scalatest.FunSuite

class TestMyList extends FunSuite {
  test("Apply") {
    // 引数が空のとき
    {
      val actual = MyIntList()
      assert(actual == Nil)
    }
    // 引数が一つのとき
    {
      val actual = MyIntList(1)
      assert(actual == Cons(1, Nil))
    }
    // 引数が複数のとき
    {
      val actual = MyIntList(1, 2)
      assert(actual == Cons(1, Cons(2, Nil)))
    }
  }
  test("Fold") {
    // 空のリスト
    {
      val actual = MyIntList.fold(Nil, 0, _+_)
      assert(actual==0)
    }
    // 要素が１つのとき
    {
      val actual = MyIntList.fold(Cons(1, Nil), 0, _+_)
      assert(actual==1)
    }
    // 要素が２つのとき
    {
      val actual = MyIntList.fold(Cons(1, Cons(2, Nil)), 0, _+_)
      assert(actual==3)
    }
    // 要素が３つ以上のとき
    {
      val actual = MyIntList.fold(Cons(1, Cons(2, Cons(3, Nil))), 0, _+_)
      assert(actual==6)
    }
  }
  test("Prepend") {
    // 空のリスト
    {
      val actual = MyIntList.prepend(Nil, 1)
      assert(actual == Cons(1, Nil))
    }
    // 空でないリスト
    {
      val actual = MyIntList.prepend(Cons(1, Nil), 2)
      assert(actual == Cons(2, Cons(1, Nil)))
    }
  }
  test("Sum") {
    // リストが空のとき
    {
      val actual = MyIntList.sum(Nil)
      assert(actual == 0)
    }
    // リストが空でないとき
    {
      val actual = MyIntList.sum(Cons(1, Cons(1, Nil)))
      assert(actual == 2)
    }
  }
  test("Product") {
    // リストが空のとき
    {
      val actual = MyIntList.product(Nil)
      assert(actual == 0)
    }
    // リストが空でないとき
    {
      val actual = MyIntList.product(Cons(1, Cons(2, Cons(3, Nil))))
      assert(actual == 6)
    }
  }
  test("Map") {
    // リストが空のとき
    {
      val actual = MyIntList.map(Nil,(x: Int) => x+1)
      assert(actual == Nil)
    }
    // 要素が１つのとき
    {
      val actual = MyIntList.map(Cons(1, Nil), (x: Int) => x+1)
      assert(actual == Cons(2, Nil))
    }
    // 要素が２つのとき
    {
      val actual = MyIntList.map(Cons(1, Cons(2, Nil)), (x: Int) => x+1)
      assert(actual == Cons(2, Cons(3, Nil)))
    }
    // 要素が３つ以上のとき
    {
      val actual = MyIntList.map(Cons(1, Cons(2, Cons(3, Nil))), (x: Int) => x+1)
      assert(actual == Cons(2, Cons(3, Cons(4, Nil))))
    }
  }
}