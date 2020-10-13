package om.bridgelabz.hashtable;

public class LinkedList<K, V> {
	public INode head;
	public INode tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Append the given node
	public void append(INode newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (tail == null) {
			tail = newNode;
		} else {
			this.tail.setNext(newNode);
			tail = newNode;
		}
	}

	// Search Node with given key
	public INode search(K key) {
		INode tempNode = this.head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}

	@Override
	public String toString() {
		return "LinkedList {" + head + "}";
	}

	// Delete a node
	public void delete(INode node) {
		if (node.equals(this.head)) {
			INode tempNode = this.head;
			this.head = head.getNext();
		}
		if (node.equals(this.tail)) {
			INode tempNode = head;
			while (tempNode.getNext().getNext() != null) {
				tempNode = tempNode.getNext();
			}
			this.tail = tempNode;
			tempNode.setNext(null);
		} else {
			INode tempNode = head;
			while (tempNode.getNext() != node) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(node.getNext());
			node.setNext(null);
		}

	}

}
