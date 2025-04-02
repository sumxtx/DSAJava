public class SimpleLL
{
	private ListNode head;

	private static class ListNode
	{
		private int data;
		private ListNode next;

		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	public void display()
	{
		ListNode current = head;
		while(current != null)
		{
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void displayArg(ListNode head)
	{
		ListNode current = head;
		while(current != null)
		{
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public int length()
	{
		if(head == null)
		{
			return (0);
		}
		int count = 0;
		ListNode current = head;
		while(current != null)
		{
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(int value)
	{
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}

	public void insertLast(int value)
	{
		ListNode newNode = new ListNode(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		ListNode current = head;
		while(null != current.next)
		{
			current = current.next;
		}
		current.next = newNode;
	}

  public void insertAtPosition(int position, int value)
  {
    ListNode node = new ListNode(value);

    if(position == 1)
    {
      node.next = head;
      head = node;
    }
    else
    {
      ListNode previous = head;
      int count = 1;
      try
      {
        while(count < position -1)
        {
          previous = previous.next;
          count++;
        }
        ListNode current = previous.next;
        previous.next = node;
        node.next = current;
      }
      catch (Exception e)
      {
        System.out.println("ERROR. Trying To Insert Node out of Boundary.");
      }
    }
  }

	public ListNode deleteFirst()
	{
		if(head == null)
		{
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

  public ListNode deleteLast()
  {
    if (head == null || head.next == null)
    {
      return head;
    }
    ListNode current = head;
    ListNode previous = null;

    while(current.next != null)
    {
      previous = current;
      current = current.next;
    }
    previous.next = null;
    return current;
  }

  public void deleteAtPosition(int position)
  {
    if(position == 1)
    {
      head = head.next;
    }
    else
    {
      ListNode previous = head;
      int count = 1;
      try
      {
        while(count < position -1)
        {
          previous = previous.next;
          count++;
        }

        ListNode current = previous.next;
        previous.next = current.next;
      }
      catch (Exception e)
      {
        System.out.println("ERROR. Trying To Delete Node out of Boundary.");
      }
    }
  }

  public int searchFirst(ListNode head, int searchKey)
  {
    if(head == null)
    {
      return -1;
    }
    int pos = 0;
    ListNode current = head;
    while(current != null)
    {
      if(current.data == searchKey)
      {
        return pos;
      }
      pos++;
      current = current.next;
    }
    return -1;
  }

  public ListNode getNthNodeFromEnd(int n)
  {
    if(head == null)
    {
      return null;
    }
    if(n <= 0)
    {
      throw new IllegalArgumentException("Invalid value: n = " + n);
    }
    ListNode mainPtr = head;
    ListNode refPtr = head;

    int count = 0;
    while(count < n)
    {
      if(refPtr == null)
      {
        throw new IllegalArgumentException(n + " is greater than the number of nodes in list");     
      }
      refPtr = refPtr.next;
      count++;
    }
    while (refPtr != null)
    {
      refPtr = refPtr.next;
      mainPtr = mainPtr.next;
    }
    return mainPtr;
  }

  public ListNode reverseList(ListNode head)
  {
    if(head == null)
    {
      return head;
    }

    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;

    while(current != null)
    {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  // Working on Sorted Linked lists
  // To see Sorting algorihtms on Linked Lists

  public void removeDuplicates()
  {
    if(head == null)
    {
      return ;
    }
    
    ListNode current = head;
    
    while(current != null && current.next != null)
    {
      if (current.data == current.next.data)
      {
        current.next = current.next.next;
      }
      else
      {
        current = current.next;
      }
    }
  }

  public ListNode insertInSortedList(int value)
  {
    ListNode newNode = new ListNode(value);

    if(head == null)
    {
      return newNode;
    }

    ListNode current = head;
    ListNode temp = null;

    while(current != null && current.data < newNode.data)
    {
      temp = current;
      current = current.next;
    }

    newNode.next = current;
    temp.next = newNode;
    return head;
  }

  public void deleteNodeByValue(int value)
  {
    ListNode current = head;
    ListNode temp = null;

    if(current != null && current.data == value)
    {
      head = current.next;
      return;
    }

    while(current != null && current.data != value)
    {
      temp = current;
      current = current.next;
    }

    if(current == null)
    {
      return;
    }

    temp.next = current.next;
  }
  
  public boolean loopDetector()
  {
    ListNode fastPtr = head;
    ListNode slowPtr = head;

    while(fastPtr != null && fastPtr.next != null)
    {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;

      if(slowPtr == fastPtr)
      {
        return true;
      }
    }
    return false;
  }

  //7:37:20 


	public static void main(String args[])
	{
		SimpleLL sll = new SimpleLL();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);

		sll.head.next = second;
		second.next = third;
		third.next = fourth;

		// Print the Elements of the list
		sll.display();

		// Print the amount of elements in the list
		System.out.println("List length: " + sll.length());

		// Insert Element at the Beginning of the list
		sll.insertFirst(89);
		sll.display();
		System.out.println("List length: " + sll.length());
		sll.insertFirst(890);
		sll.display();
		System.out.println("List length: " + sll.length());

		// Insert Elements at the end of the list
		sll.insertLast(7890);
		sll.display();
		System.out.println("List length: " + sll.length());

		// Delete the first element of a list
		sll.deleteFirst();
		sll.display();
		System.out.println("List length: " + sll.length());

    // Insert Node at Position
    sll.insertAtPosition(10, 80); //Bad
		sll.display();
		System.out.println("List length: " + sll.length());
    //
    sll.insertAtPosition(10, 3); //Good
		sll.display();
		System.out.println("List length: " + sll.length());

		// Delete the last element of a list
		sll.deleteLast();
		sll.display();
		System.out.println("List length: " + sll.length());

		// Delete the an element at a given position of a list
		sll.deleteAtPosition(13); //Bad
		sll.display();
		System.out.println("List length: " + sll.length());
    //
		sll.deleteAtPosition(3); //Good
		sll.display();
		System.out.println("List length: " + sll.length());

    // Search the first appearance of a item in a linked list
    int toSearch = 80;
    int atPosition = sll.searchFirst(sll.head, toSearch);
    if(atPosition >= 0)
    {
      System.out.printf("Found: %d at position: %d\n", toSearch, atPosition + 1);
    }
    else
    {
      System.out.printf("%d Not Found in the List\n", toSearch);
    }
    toSearch = 11;
    atPosition = sll.searchFirst(sll.head, toSearch);
    if(atPosition >= 0)
    {
      System.out.printf("Found: %d at position: %d\n", toSearch, atPosition + 1);
    }
    else
    {
      System.out.printf("%d Not Found in the List\n", toSearch);
    }

    //Reverse a Linked List
    //ListNode reversedLLHead = sll.reverseList(sll.head);
    //sll.displayArg(reversedLLHead);

    // Find the nth element from the end of a Linked List

    // Adding more nodes to the list
    sll.display();
		sll.insertLast(78);
		sll.insertLast(98);
		sll.insertLast(68);
		sll.insertLast(18);
    sll.display();

    ListNode penultim = sll.getNthNodeFromEnd(2);
    System.out.println(penultim.data);

    // Delete fist node with value 11 on it
    sll.deleteNodeByValue(11);
    sll.display();


	}
}
