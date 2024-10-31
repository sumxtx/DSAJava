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
	}
}
