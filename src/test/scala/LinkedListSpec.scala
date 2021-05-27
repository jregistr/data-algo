import collection.mutable.Stack
import org.scalatest.*
import flatspec.*
import matchers.*

class LinkedListSpec extends AnyFlatSpec with should.Matchers:
    "An empty list" should "be returned if nothing is added" in {
        val list = LinkedList[Int]()
        list.asList() shouldBe List.empty[Int]
    }

    "A an expected list" should "be returned after append" in {
        val list = LinkedList[Int]()
        list.append(10)
        list.append(100)
        val out = list.asList()
        out shouldBe List(10, 100)
    }

    "An expected value" should "be returned from pop" in {
        val list = LinkedList[Int]()
        list.append(10)
        list.pop() shouldBe 10
    }