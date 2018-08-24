

public class SingleLinkedListMerge2Sortedlist {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

   
    
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode result = null, temp;

		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		if (head1.data <= head2.data) {
			result = head1;
			head1 = head1.next;
		} else {
			result = head2;
			head2 = head2.next;
		}
		temp = result;
		while (true) {
			if (head1 == null || head2 == null) {
				result.next = head1 == null ? head2 : head1;
				break;
			}
			
			if (head1.data <= head2.data) {
				result.next = head1;
				result = result.next;
				head1 = head1.next;
			} else {
				result.next = head2;
				result = result.next;
				head2 = head2.next;
			}
		}
		return temp;

	}

    public static void main(String[] args) {

       

        
            SinglyLinkedList llist1 = new SinglyLinkedList();


                llist1.insertNode(1);
                llist1.insertNode(2);
                llist1.insertNode(3);
                llist1.insertNode(5);
                llist1.insertNode(10);
          	SinglyLinkedList llist2 = new SinglyLinkedList();

           

                llist2.insertNode(3);
                llist2.insertNode(4);
                llist2.insertNode(6);
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

             
            	while(llist3!=null) {
            		System.out.println(llist3.data);
            		llist3=llist3.next;
            	}

    }
}
