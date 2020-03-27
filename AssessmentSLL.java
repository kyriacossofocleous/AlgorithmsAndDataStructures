//Kyriacos Sophocleous 2471955s
//do not include package statement 
//do not import any classes
//just complete the methods indicated,
//namely:
//insertTail
//deleteAlternate and
//merge

public class AssessmentSLL<E extends Comparable<E>> {

	// Each SLL object is the header of
	// a singly-linked-list

	private Node<E> first;

	/**
	 * constructor
	 */
	public AssessmentSLL() {
		// Construct an empty SLL.
		first = null;
	}

	// //////// Inner class //////////
	private static class Node<E> {
		// Each Node object is a node of a
		// singly-linked-list.
		protected E element;
		protected Node<E> next;

		public Node(E elem, Node<E> n) {
			element = elem;
			next = n;
		}

	}

	// ////////////////////////////////

	/**
	 * print all elements starting from first node
	 */
	public void printFirstToLast() {
		// Print all elements in this SLL, in first-to-last order.
		Node<E> curr = first;
		while (curr != null) {
			System.out.println(curr.element);
			curr = curr.next;
		}
	}

	/**
	 * insert new node containing elem at front of list
	 * 
	 */
	public void insert(E elem) {
		Node<E> newNode = new Node<E>(elem, first);
		first = newNode;
	}

	/**
	 * add new node to end of list
	 */
	public void insertTail(E elem) {
		Node <E> newNode=new Node<E>(elem,null);
		if (first==null) {
			first=newNode;
		}else {
			Node <E> last=first;
			while (last.next != null){
				last=last.next;
			}
			last.next=newNode;
		}
	}

	/** delete every alternate element
	 *  imagine the elements are indexed 0, 1, 2, ... , n-1
	 *  delete all the odd indexed elements
	 *  so if list had values ant, badger, cat, dog
	 *  the method would delete nodes containing badger and dog
	 */
	public void deleteAlternate() {
		if (first==null) {
			return;
		}
		Node <E> pred=first;
		Node <E> toDelete=first.next;
		while((pred!=null)&&(toDelete!=null)) {
			pred.next=toDelete.next;
			toDelete=null;
			pred=pred.next;
			if (pred!=null) {
				toDelete=pred.next;
			}
		}
	}

	/**
	 * method to merge two ordered lists with this one whilst removing duplicates
	 * order should be preserved
	 * you need to replace the type list1, list2 and list3 and the return type
	 * with the new name of this class
	 */
	public  AssessmentSLL<E> merge(AssessmentSLL<E> list1, AssessmentSLL<E> list2){
		AssessmentSLL<E> mergedList = new AssessmentSLL<E>();
		Node<E> current1=list1.first;
		Node<E> current2=list2.first;
		Node<E> result=helpingMethod(current1,current2);
		mergedList.first=result;
		current1=mergedList.first;
		current2=this.first;
		result=helpingMethod(current1,current2);
		result=removeDuplicates(result);
		mergedList.first=result;
		
		return mergedList;
	}
	public Node<E> helpingMethod(Node<E> current1,Node<E> current2){
		if(current1==null) {
			return current2;
		}
		if (current2==null) {
			return current1;
		}
		Node<E> mergedList=null;
		if (current1.element.compareTo(current2.element)<=0) {
			current1.next=helpingMethod(current1.next,current2);
			mergedList=current1;
		}else {
			current2.next=helpingMethod(current1,current2.next);
			mergedList=current2;
		}
		return mergedList;
	}
	public Node<E> removeDuplicates(Node<E> current){  
		    if (current == null)  
		        return null;  

		    if (current.next != null)  {  
		        if (current.element == current.next.element)  {  
		            current.next = current.next.next; 
		            removeDuplicates(current); 
		        }else {
		            removeDuplicates(current.next); 
		        }  
		    }  
		    return current; 
		}  
	}

