/**
 * 
 */
package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amishra
 *
 */
public class LRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2);
		cache.set("user1", "Alex");
		cache.set("user2", "Brian");
//		System.out.println(cache.get("user1"));
		cache.set("user3", "Chris");
		System.out.println(cache.get("user2"));
	}
	
	private int size;	
	private Map<String, CacheNode> map = new HashMap<>();
	private CacheNode start;
	private CacheNode end;
	
	LRUCache(int size) {
		this.size = size;
	}
	
	public void set(String key, String val) {
		CacheNode node = new CacheNode(key, val);
		
		// Add the key if the same doesn't exist already
		if (!map.containsKey(key)) {
			// Remove least recently used key (the last from the list) if size is full
			if (size == map.size()) {
				if (null != this.end) {
					map.remove(this.end.key);
					remove(this.end);
				}				
			}
			map.put(key, node);
			insert(node);
		}
		// Update existing key and move to the front
		else {
			map.put(key, node);
			moveToFront(node);
		}
	}
	
	public String get(String key) {
		String val = null;
		CacheNode node = map.get(key);
		if (null != node) {
			val = node.val;
			moveToFront(node);
		}
		return val;
	}
	
	/**
	 * Insert always at the the from of the list
	 * @param node
	 */
	private void insert(CacheNode node) {
		if (null == end)
			this.end = node;
		if (null != this.start) {
			this.start.prev = node;
			node.next = this.start;
		}
		this.start = node;
	}
	
	private void remove(CacheNode node) {
		CacheNode next = node.next;
		CacheNode prev = node.prev;
		
		if (null != prev)
			prev.next = next;
		if (null != next)
			next.prev = prev;
		if (node == this.start)
			this.start = next;
		if (node == this.end)
			this.end = prev;
	}
	
	// Move a node to the front of the list when updated / accessed
	private void moveToFront(CacheNode node) {
		remove(node);
		insert(node);
	}

}

// Doubly-linked List
class CacheNode {

	String key;
	String val;
	CacheNode prev;
	CacheNode next;

	CacheNode (String key, String val) {
		this.key = key;
		this.val = val;
	}
}
