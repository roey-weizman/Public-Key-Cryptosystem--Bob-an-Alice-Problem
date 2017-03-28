import java.io.PrintWriter;


/* Class AVLTree */
class AVLTree {
	private AVLNode root;
	private int counter;

	/* Constructor */
	public AVLTree() {
		root = null;
		counter = 0;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Make the tree logically empty */
	public void makeEmpty() {
		root = null;
	}

	/* Function to insert data */
	public void insert(Comparable data) {
	/*	if (this.isEmpty())
			root = new AVLNode(data);
		else
			insert(data, root);*/
		root = insert(data, root);
	}

	/* Function to insert data recursively */
	private AVLNode insert(Comparable x, AVLNode t) {
		int lheight=-1;
		int rheight=-1;
		if (t == null)
            t = new AVLNode(x);
        else if (x.compareTo(((Improved)(t.data)).getImRiddle()) < 0)
        {
            t.left = insert( x, t.left );
            
            rheight = -1;
    		lheight = -1;
    		if (t.right != null) {
    			rheight = t.right.height;
    		}
    		if (t.left != null) {
    			lheight = t.left.height ;
    		}
    		
            if( lheight- rheight == 2 )
                if( x.compareTo(((Improved)(t.left.data)).getImRiddle()) < 0 )
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if(x.compareTo(((Improved)(t.data)).getImRiddle()) > 0)
        {
            t.right = insert( x, t.right );
            
            rheight = -1;
    		lheight = -1;
    		if (t.right != null) {
    			rheight = t.right.height;
    		}
    		if (t.left != null) {
    			lheight = t.left.height ;
    		}
            
            if(  rheight - lheight == 2 )
                if(x.compareTo(((Improved)(t.right.data)).getImRiddle()) > 0 )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        t.height = max( lheight,rheight)+1 ;
        return t;
		
		
		/*if (x.compareTo(((Improved)(t.data)).getImRiddle()) > 0) {
			if (t.right != null)
				insert(x, t.right);
			else
				t.right = new AVLNode(x);
		} else {
			if (t.left != null)
				insert(x, t.left);
			else
				t.left = new AVLNode(x);
		}

		int rheight = 0;
		int lheight = 0;
		if (t.right != null) {
			rheight = t.right.height;
		}
		if (t.left != null) {
			lheight = t.left.height ;
		}

		// check if the tree is still an AVL tree, if not rotate to fix it
		if (Math.abs(lheight - rheight) > 1) {
			if (rheight == 0 || lheight == 0) {
				if (rheight == 0) // case 1
					t = rotateWithRightChild(t);
				if (lheight == 0) // case 2
					t = rotateWithLeftChild(t);
			} else if (lheight > rheight) {
				// left child has 2 children
				if (t.left.left.height > t.left.right.height)
					t = rotateWithRightChild(t);// case 1
				else
					t = doubleWithLeftChild(t); // case 4
			} else {
				// right child has 2 children
				if (t.right.left.height < t.right.right.height)
					t = rotateWithLeftChild(t);// case 2
				else
					t = doubleWithRightChild(t); // case 3
			}
		}

		t.height = max(lheight, rheight) + 1;
		return (t);*/

	}

	/* Function to get height of node */
	private int height(AVLNode t) {
		return t.height;
	}

	/* Function to max of left/right node */
	private int max(int lhs, int rhs) {
		return Math.max(lhs, rhs);
	}

	/* Rotate binary tree node with left child */
	private AVLNode rotateWithLeftChild(AVLNode k2) {// left rotation
		AVLNode z = k2;
		AVLNode y = z.right;
		AVLNode x = y.right;// signing start values
		AVLNode temp = y.left;
		y.left = z;
		z.right = temp;// rotation-change pointers
		return y;
	}

	/* Rotate binary tree node with right child */
	private AVLNode rotateWithRightChild(AVLNode k1) {// right rotation
		AVLNode z = k1;
		AVLNode y = z.left;
		AVLNode x = y.left;// signing start values
		AVLNode temp = y.right;
		y.right = z;
		z.left = temp;// rotation-change pointers
		return y;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child
	 */
	private AVLNode doubleWithLeftChild(AVLNode k3) {// first rotate left than
														// rotate right
		AVLNode z = k3;
		z.left = rotateWithLeftChild(z.left);
		z = rotateWithRightChild(z);
		return z;
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child
	 */
	private AVLNode doubleWithRightChild(AVLNode k1) {// first rotate right than
														// rotate left
		AVLNode z = k1;
		z.right = rotateWithRightChild(z.right);
		z = rotateWithLeftChild(z);
		return z;
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		if (root == null)
			return 0;
		else
			return countNodes(root);
	}

	private int countNodes(AVLNode r) {
		int counter = 1;
		if (r.left != null)
			counter = counter + countNodes(r.left);
		if (r.right != null)
			counter = counter + countNodes(r.right);
		return counter;
	}

	/* Functions to search for an element */
	public boolean search(Comparable val) {
		if (root == null)
			return false;
		else
			return search(root, val);
	}

	private boolean search(AVLNode r, Comparable val) {
		boolean ans = false;
		if (((Comparable) r.data).equals(val))
			ans = true;
		else {
			if ((((Comparable) r.data).compareTo(val) > 0) && (r.left != null))
				ans = search(r.left, val);
			else if ((((Comparable) r.data).compareTo(val) < 0) && (r.right != null))
				ans = search(r.right, val);
		}
		return ans;
	}

	/* Function for inorder traversal */
	public void inorder(PrintWriter out) {
		if (root != null)
			inorder(root, out);
	}

	private void inorder(AVLNode r, PrintWriter out) {
		if (r.left != null)
			inorder(r.left, out);
		out.print(r.data);
		if (r.right != null)
			inorder(r.right, out);
	}

	public Pair<int[], Integer> getPrivateKey(String sIndex) {
		if (root != null)
			return getPrivateKey(root, sIndex);
		return null;
	}

	private Pair<int[], Integer> getPrivateKey(AVLNode r, String sIndex) {
		int[] ans = new int[sIndex.length()];

		if (((Improved)r.data).compareTo(sIndex) > 0) {
			counter++;
			return getPrivateKey(r.left, sIndex);
			
		} else if (((Improved)r.data).compareTo(sIndex) < 0) {
			counter++;
			return getPrivateKey(r.right, sIndex);
		} else {
			counter++;
			ans=General.strToArr(((Improved)(r.data)).getImKey());
			}
			return new Pair(ans, counter);
	}
}