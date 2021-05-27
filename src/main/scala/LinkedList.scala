/**
 * An imperative style implemetation of a Linked List
*/
sealed class LinkedList[T]:

    case class Node[T](data: T, var next: Node[T] = null)

    private var head: Node[T] = null
    private var tail: Node[T] = null

    def prepend(item: T): Unit = 
        val node = Node(item)
        node.next = head
        head = node
        if tail == null then
            tail = head

    def append(item: T): Unit =
        val node = Node(item)
        if tail == null then
            head = node
            tail = head
        else
            tail.next = node
            tail = node

    def peek(): T | Null =
        if head == null then
            head.data
        else
            null

    def pop(): T | Nothing =
        if head eq null then
            throw NullPointerException()
        else
            val value = head.data
            head = head.next
            value

    def asList(): List[T] =
        def inner(node: Node[T], concat: List[T]): List[T] =
            if node eq null then
                concat
            else
                inner(node.next, concat :+ node.data)
        inner(head, Nil)


    