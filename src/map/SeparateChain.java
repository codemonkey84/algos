package map;

public class SeparateChain {

	int capacity = 17;
	SeparateChainEntry[] entries;

	SeparateChain () {
		entries = new SeparateChainEntry[capacity];
	}

	public void put(String k, String v) {
		if (k == null) {
			throw new RuntimeException("null key not allowed");
		}
		int hash = hashCode(k) % capacity;
		Node node = new Node(k, v);
		if (entries[hash] != null && entries[hash].node != null) {
			entries[hash].node.next = node;
		} else {
			entries[hash] = new SeparateChainEntry(node);
		}
	}

	public String find(String k) {
		int hash = hashCode(k) % capacity;
		Node current = null;
		if (entries[hash] != null) {
			current = entries[hash].node;
			while (current != null) {
				if (current.key.equals(k)) {
					return current.val;
				}
				current = current.next;
			}
		}
		return null;
	}

	public String delete(String k) {
		int hash = hashCode(k) % capacity;
		Node current = null;
		if (entries[hash] != null) {
			current = entries[hash].node;
			while (current != null) {
				if (current.key.equals(k)) {
					String tmp = current.val;
					entries[hash] = null;
					return tmp;
				}
				current = current.next;
			}
		}
		return null;
	}

	private int hashCode(String k) {
		int hashCode = 0;
		if (k != null) {
			for (int i = 0; i < k.length(); i++) {
				int c = k.charAt(i);
				hashCode = hashCode + 256*c;
			}
		}
		return hashCode;
	}
 	
	public static void main(String [] args) {
		SeparateChain sc = new SeparateChain();

		sc.put("anindya", "mishra");
		sc.put("srijata", "bhadra");
		sc.put("biraj", "choudhury");
		sc.put("arindam", "ghosh");
		sc.put("pritam", "biswas");

		System.out.println(sc.find("srijata"));

		sc.delete("srijata");

		System.out.println(sc.find("srijata"));

		System.out.println(sc.find("biraj"));		


	}
}

class Node {

	String key;
	String val;
	Node next;

	Node (String k, String v) {
		key =k;
		val = v;
	}
}

class SeparateChainEntry {

	Node node;

	SeparateChainEntry (Node n) {
		node = n;
	}
}