package CargoDelivery;

public class DistributionCenter <Thing>{
	private Node<Thing> head,tail;// My DistriutionCenter holds cargos normally and like the our hoca asked from us every DistributionCenter has CentralWareHouse which has the vehicles of The city
	private CentralWarehouse<Vehicle<Thing>> warehouse;
	

	private int sizeOfTheStack;
	
	public DistributionCenter() {
		head=tail=null;
		sizeOfTheStack=0;
		warehouse= new CentralWarehouse<>();
		
	}
	
	public CentralWarehouse<Vehicle<Thing>> enterTheWarehouse() {
		return warehouse;
	}
	
	boolean isEmpty() {
		if(sizeOfTheStack==0)
		return true;
		else
		return false;
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
			
			return temp;
		}else
			return null;
		
	}
	
	
	
	
	


}
