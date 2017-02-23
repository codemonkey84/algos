package map;

public class DoubleHash {

	int capacity = 17;
	Entry [] entries;

	DoubleHash () {
		entries = new Entry[capacity];
	}

	public void put(String k, String v) {
		if (k == null) {
			throw new RuntimeException("Null key not allowed");
		}
		int hash = hashCode(k) % capacity;
		int step = 5 - hash%5; // calculate double hash
		while (entries[hash] != null && entries[hash].key != null) {
			hash += step; // probing usnig double hash
			hash %= capacity; // wrapping in case hash is more than capacity
		}
		Entry entry = new Entry(k, v);
		entries[hash] = entry;
	}

	public String find(String k) {
		int hash = hashCode(k) % capacity;
		int step = 5 - hash%5; // calculate double hash
		while (entries[hash] != null && entries[hash].key != null) {
			if (entries[hash].key.equals(k)) {
				return entries[hash].val;
			}
			hash += step; // probing usnig double hash
			hash %= capacity; // wrapping in case hash is more than capacity
			System.out.println("hash 2"+hash);
		}
		return null;
	}

	public String delete(String k) {
		int hash = hashCode(k) % capacity;
		int step = 5 - hash%5; // calculate double hash
		String v = null;
		while (entries[hash] != null && entries[hash].key != null) {
			if (entries[hash].key.equals(k)) {
				v = entries[hash].val;
				entries[hash] = null;
				return v;
			}
			hash += step; // probing usnig double hash
			hash %= capacity; // wrapping in case hash is more than capacity
		}
		return v;
	}

	private int hashCode(String k) {
		int hashCode = 0;
		int c = 0;
		if (k != null) {
			for (int i = 0; i < k.length(); i++) {
				c = k.charAt(i);				
				hashCode = hashCode + 256*c;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		DoubleHash dh = new DoubleHash();
		dh.put("anindya", "mishra");
		dh.put("arindam", "ghosh");
		dh.put("biraj", "choudhury");
		dh.put("pritam", "biswas");

		System.out.println(dh.find("biraj"));
		System.out.println(dh.delete("biraj"));
		System.out.println(dh.find("biraj"));
		System.out.println(dh.find("anindya"));
	}
}

class Entry {
	String key;
	String val;

	Entry (String k, String v) {
		key = k;
		val = v;
	}
}