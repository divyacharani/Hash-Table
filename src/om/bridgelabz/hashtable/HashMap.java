package om.bridgelabz.hashtable;

public class HashMap<K, V> {

	LinkedList<K, V> myLinkedList;

	// Constructor
	public HashMap() {
		this.myLinkedList = new LinkedList<>();
	}

	// Method to get value when key is given
	public V get(K key) {
		MapNode<K, V> myMapNode = (MapNode<K, V>) this.myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	// Method to add key, value pair or update value corresponding to existent key
	public void add(K key, V value) {
		MapNode<K, V> myMapNode = (MapNode<K, V>) this.myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MapNode<>(key, value);
			this.myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "LinkedList { " + myLinkedList + " }";
	}
}
