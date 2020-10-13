package om.bridgelabz.hashtable;

import java.util.ArrayList;

public class LinkedHashMap<K, V> {
	private final int bucketSize;
	ArrayList<LinkedList<K, V>> myBucketArray;

	// Constructor
	public LinkedHashMap() {
		this.bucketSize = 10;
		this.myBucketArray = new ArrayList<>(bucketSize);
		for (int index = 0; index < bucketSize; index++) {
			this.myBucketArray.add(null);
		}
	}

	// Method to return value when key is given
	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MapNode<K, V> myMapNode = (MapNode<K, V>) myLinkedList.search(key);
			return (myMapNode == null) ? null : myMapNode.getValue();
		}
	}

	// Get index when key is given
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % bucketSize;
		return index;
	}

	// Add key and value pair to hashmap
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new LinkedList<>();
			MapNode<K, V> myMapNode = new MapNode<>(key, value);
			this.myBucketArray.set(index, myLinkedList);
		}
		MapNode<K, V> myMapNode = (MapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "LinkedHashMap List {" + myBucketArray + "}";
	}

	// To remove a node
	public MapNode remove(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MapNode<K, V> myMapNode = (MapNode<K, V>) myLinkedList.search(key);
			if (myMapNode == null) {
				return null;
			} else {
				myLinkedList.delete(myMapNode);
				return myMapNode;
			}
		}
	}
}
