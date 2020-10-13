package om.bridgelabz.hashtable;

public class MapNode<K, V> implements INode<K, V> {

	K key;
	V value;
	MapNode<K, V> next;

	// Constructor
	public MapNode(K key, V value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	// Setters and Getters
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public INode getNext() {
		return next;
	}

	@Override
	public void setNext(INode next) {
		this.next = (MapNode<K, V>) next;
	}

	@Override
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append("Map Node{" + "K = ").append(key).append(" V = ").append(value).append("}");
		if (next != null)
			myMapNodeString.append("->").append(next);
		return myMapNodeString.toString();
	}
}
