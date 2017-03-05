package graph;

class Village {

	int id;
	int destLeft;
	Village left;
	int destRight;
	Village right;
	int visitCount;

	Village (int i) {
		id = i;
	}

	int neighborDist(Village neighbor) {
		int dist = Integer.MAX_VALUE;
		if (this.left == neighbor) {
			dist = this.destLeft;
		} else if (this.right == neighbor) {
			dist = this.destRight;
		}
		return dist;
	}
}

public class Kingdom {

	Village[] villages;

	Kingdom (Village[] vs) {
		villages = vs;
	}

	String reach(Village dest) {
		int path = 0;
		if (villages == null || dest == null) {
			return ""+path;
		}
		/*
		 * Assumption 1: The starting point would be the first village of the
		 * kingdom, which is the first elem of villages array
		 */
		Village current = villages[0];
		/*
		 *  Assumption 2: A village will have either left and right tunnels or
		 *  none of them (in case it's destination village)
		 */
		while (current != dest) {
			current.visitCount += 1;
			if (current.visitCount%2 == 1) {
				current = current.left;
			} else {
				current = current.right;
			}
			++path;

			/*
			 * Check if all the villages are visited at least twice, can't
			 * reach exit
			 */
			int vistiedCount = 0;
			for (int i = 0; i < villages.length; i++) {
				if (villages[i] != dest && villages[i].visitCount/2 >= 1) {
					++vistiedCount;
				} else {
					break;
				}
			}
			if (vistiedCount == villages.length-1) {
				return "infinity";
			}
		}
		/* 
		 * This indicates a village is reached which has neither left nor
		 * right tunnel. So reached the exit.
		 */
		return ""+path;
	}

	/* Calculate the maximum distance to be travelled between two villages of
	 * the kingdom without revisiting any single village on the way.
	 * Assumption 3: Since revisit is not considered, path = min(UNVISITED left, UNVISITED right)
	 */
	void farthestDistance() {
		int maxPath = 0;
		int start = 0;
		int end = 0;
		if (villages == null) {
			return;
		}
		Village current = null;
		Village prev = null;
		for (int i = 0; i < villages.length; i++) {
			int currentMaxPath = 0;
			reset();
			current = villages[i];
			current.visitCount += 1;
			if (current == null) {
				continue;
			}
			/*
			 * Measure the distance from the current village by visiting the
			 * UNVISITED village on left or right (whichever is nearest) and
			 * keep on till an already visited village (in case of acyclic
			 * nature) or the source village itself is reached (in case of
			 * cyclic nature)
			 */
			while (current.left != null && current.right != null) {
				if (current.left.visitCount == 0 && current.right.visitCount == 0) {
					currentMaxPath += (current.destLeft < current.destRight) ? current.destLeft : current.destRight;
					prev = current;
					current = (current.destLeft < current.destRight) ? current.left : current.right;
				} else if (current.left.visitCount == 0) {
					currentMaxPath += current.destLeft;
					prev = current;
					current = current.left;
				} else if(current.right.visitCount == 0) {
					currentMaxPath += current.destRight;
					prev = current;
					current = current.right;
				} else {
					break;
				}
				// Source village is reached again
				if (current == villages[i]) {
					current = prev;
					break;
				}
				current.visitCount += 1;
			}
			// System.out.println(currentMaxPath);
			if (villages[i].neighborDist(current) != Integer.MAX_VALUE) {
				currentMaxPath = villages[i].neighborDist(current);
			}
			if (currentMaxPath > maxPath) {
				maxPath = currentMaxPath;
				start = villages[i].id;
				end = current.id;
			}
		}
		System.out.println("Distance: "+maxPath+" village_1: "+start+" village_2: "+end);
	}

	private void reset() {
		if (villages != null) {
			for (int i = 0; i < villages.length; i++) {
				villages[i].visitCount = 0;
			}
		}
	}

	public static void main (String [] args) {
		// Finite destination
		Village v1 = new Village(1);
		Village v2 = new Village(2);
		Village v3 = new Village(3);
		Village v4 = new Village(4);
		Village v5 = new Village(5);
		Village v6 = new Village(6);
		Village v7 = new Village(7);
		Village v8 = new Village(8);

		v1.left = v2;
		v1.destLeft = 4;
		v1.right = v8;
		v1.destRight = 8;

		v2.left=v3;
		v2.destLeft=8;
		v2.right=v8;
		v2.destRight=11;

		v3.left=v4;
		v3.destLeft=7;
		v3.right=v6;
		v3.destRight=4;

		v4.left=v5;
		v4.destLeft=9;
		v4.right=v6;
		v4.destRight=14;

		v6.left=v7;
		v6.destLeft=2;
		v6.right=v3;
		v6.destRight=4;

		v7.left=v8;
		v7.destLeft=1;
		v7.right=v3;
		v7.destRight=8;

		v8.left=v1;
		v8.destLeft=8;
		v8.right=v3;
		v8.destRight=7;

		Kingdom finiteKingdom = new Kingdom(new Village[]{v1, v2, v3, v4, v5, v6, v7, v8});
		System.out.println("Paths: "+finiteKingdom.reach(v5));
		finiteKingdom.farthestDistance();

		// Infinite kingdom
		Village v9 = new Village(9);
		Village v10 = new Village(10);
		Village v11 = new Village(11);
		Village v12 = new Village(12);

		v9.left = v10;
		v9.destLeft = 4;
		v9.right = v11;
		v9.destRight = 8;

		v10.left=v9;
		v10.destLeft = 8;
		v10.right=v11;
		v10.destRight = 11;

		v11.left=v9;
		v11.destLeft = 7;
		v11.right=v10;
		v11.destRight = 4;

		Kingdom infiniteKingdom = new Kingdom(new Village[]{v9, v10, v11, v12});
		System.out.println("Paths: "+infiniteKingdom.reach(v12));
		infiniteKingdom.farthestDistance();
	}
}