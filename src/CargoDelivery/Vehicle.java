package CargoDelivery;

public class Vehicle <Thing> extends CargoPackage{
	
	private Node<Thing> head,tail;// ı will use my Vehicle objects to collect cargoPackages to deliver cargos
	private int sizeOfTheStack;
	private double hocanınVerdiğiDouble;
	
	public Vehicle(String name,String cityThatBelongsTo,double hocanınVerdiğiDouble) {
		super(name,cityThatBelongsTo);
		head = tail = null;
		sizeOfTheStack = 0;
		this.hocanınVerdiğiDouble=hocanınVerdiğiDouble;
	}
	
	
	
	boolean isEmpty() {
		if(sizeOfTheStack==0)
		return true;
		else
		return false;
	}
	
	
	public int getSizeOfTheStack() {
		return sizeOfTheStack;
	}



	double getHocanınVerdiğiDouble() {
		return hocanınVerdiğiDouble;
	}
	
	
	 void push(Thing item) {
		Node<Thing> newNode= new Node<>();
		if(isEmpty()) {// There is no element in here so ı am adding new item and set it as item. Then head.next=tail tail is also empty makes it head.next=null then same progress for previous.
			
			newNode.item = item;
			head = newNode;
			head.next = tail;
			head.previous = null;
			sizeOfTheStack++;
			
			
		}else if(sizeOfTheStack==1) {// there is one element which is head with adding new item ı am making it the new head and old head is the tail now. For to not confuse old head.next should be null and new head.previous should be null to and yes ı did that.
		
			newNode.item = item;
			newNode.next = head;
			head.previous = newNode;
			head= newNode;
			tail=head.next;
			tail.next = null;
			head.previous = null;
			sizeOfTheStack++;
			
			
		}else {// this one is lot easier after all we dont deal with the tail anymore. ı am just doing new item. next= old head and its previous is item then making item the new head.
			
			newNode.item= item;
			newNode.next=head;
			head.previous= newNode;
			head=newNode;
			head.previous=null;
			sizeOfTheStack++;	
			
			
		}	
	}
	
	
	 Thing pop() {
		if(sizeOfTheStack>=2) {// when have two or more element we dont need to deal with tail so ı am taking only head and remaining one ore the old head.next one is new head.
		
			Thing temp = head.item;
			head.next.previous=null;
			head=head.next;//this will change with generic ı hope which is in the node class
			head.previous=null;
			sizeOfTheStack--;
			
			
			
			return temp;
		}
		else if(sizeOfTheStack==1) {// if we head only head then ım taking the head and now in our stack we dont have any elements
			
			Thing temp = head.item;
			head=tail=null;
			sizeOfTheStack--; 
			/*CargoPackage temp=head;
			head=null;
			sizeOfTheStack--; */
			return temp;
		}else
			return null;
		
	}
	
	
	
	
	public Thing dropPackageByIndex(int index) {
		Thing temp=null;
		Node<Thing> tempNode=null;
		for(int a=0;a<=index;a++) {
			if (a==0) {
				tempNode=head;
			}else {
				tempNode=tempNode.next;
			}
			
			if (a==index) {
				if(index==(sizeOfTheStack-1)&&(a!=0)) {
					tempNode=tail;
					temp=tempNode.item;
					
					tail=tail.previous;
					tail.next=null;
					sizeOfTheStack--;
				}else if(a==0) {
					temp=tempNode.item;
					head=head.next;
					if(sizeOfTheStack==1) {
						head=tail=null;
						break;
					}
					head.previous=null;
					sizeOfTheStack--;
				}else {
					Node<Thing> tempNode2;
					temp=tempNode.item;
					tempNode2=tempNode.previous;
					tempNode2.next=tempNode.next;
					tempNode.next.previous=tempNode2;
					tempNode.next=null;
					tempNode.previous=null;
					sizeOfTheStack--;
				}
			}
				
		}
		
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
