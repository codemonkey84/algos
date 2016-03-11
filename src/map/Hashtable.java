/**
 * 
 */
package map;

/**
 * @author lenovo Simple Hashtable implementation using Array
 */
public class Hashtable<K, V> {

	private int capacity = 16;
	Entry<K, V>[] buckets = new Entry[capacity];

	/**
	 * Add an entry
	 * 
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) {
		int hash = key.hashCode() % capacity;
		int i = 0;
		while (buckets[hash] != null && !key.equals(buckets[hash].getKey())) {
			hash = (hash + 1) % capacity;
			++i;
			if (i >= capacity) {
				increaseCapacity();
			}
		}
		
		buckets[hash] = new Entry<K, V>(key, val);
	}

	private void increaseCapacity() {
		capacity *= 2;
		Entry<K, V>[] buckets = new Entry[capacity * 2];
		System.arraycopy(this.buckets, 0, buckets, 0, capacity/2);
		this.buckets = buckets;
	}
	/**
	 * Retrieve value against a key
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		V val = null;
		int hash = key.hashCode() % capacity;
		while (buckets[hash] != null && !key.equals(buckets[hash].getKey())) {
			hash = (hash + 1) % capacity;
		}
		if (buckets[hash] != null) {
			val = buckets[hash].getVal();
		}
		return val;
	}
	
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		System.out.println(hashtable.get("Anindya"));
		hashtable.put("Anindya", "Mishra");
		hashtable.put("Biraj", "Ch");
		hashtable.put("Biraj", "Bis");
		System.out.println(hashtable.get("Biraj"));
	}
}

class Entry<K, V> {

	private K key;
	private V val;

	Entry(K key, V val) {
		this.key = key;
		this.val = val;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the val
	 */
	public V getVal() {
		return val;
	}

	/**
	 * @param val
	 *            the val to set
	 */
	public void setVal(V val) {
		this.val = val;
	}

}
