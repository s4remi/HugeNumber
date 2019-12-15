import java.util.*;

public class HugeNumber1 {

	private class Node {
		int data;
		private Node next;
		private Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	Node head = null;

	HugeNumber1(String n) {

		for (int i = 0; i < n.length(); i++) {
			Node new_node = new Node(Character.getNumericValue(n.charAt(i)));
			new_node.next = null;
			if (head == null) {
				new_node.prev = null;
				head = new_node;
				// System.out.println("test");

			} else {// System.out.println("hi");
				Node last = head;
				while (last.next != null) {
					last = last.next;
				}
				last.next = new_node;
				new_node.prev = last;

			}
		}

	}

	String getNumber() {
		if (this.head == null)
			return "no number is present";
		else {
			Node ref = this.head;
			String num = "";
			while (ref != null) {
				num += String.valueOf(ref.data);
				ref = ref.next;
			}

			return num;

		}

	}

	Node addMostSigDigit(int d) {
		Node new_node = new Node(d);
		new_node.prev = null;
		if (this.head == null) {
			new_node.next = null;
			head = new_node;

		} else {
			new_node.next = head;
			head = new_node;

		}
		return head;

	}

	void reset() {
		this.head = null;
		System.out.println("Number resetted");

	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		String n = s.next();
		HugeNumber1 h1 = new HugeNumber1(n);
		System.out.println(h1.getNumber());
		System.out.println("Enter a digit to add at begenning of the number");
		Scanner sc = new Scanner(System.in);
		int bn = sc.nextInt();
		h1.addMostSigDigit(bn);
		System.out.println(h1.getNumber());
		h1.reset();
		System.out.println(h1.getNumber());

	}

}
