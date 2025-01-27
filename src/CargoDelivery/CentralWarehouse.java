package CargoDelivery;

public class CentralWarehouse <Thing>{
	Node<Thing> head,tail;
	private int sizeOfTheQueue;
	
	public CentralWarehouse() {
		// TODO Auto-generated constructor stub
		head = tail = null;
		sizeOfTheQueue=0;
	}
	
	boolean isEmpty() {
		if(sizeOfTheQueue==0)
		return true;
		else
		return false;
	}
	
	private void enqueue(Thing vehicle) {
		if(isEmpty()) {
			Node<Thing> newNode=new Node<>();
			head = newNode;
			head.item=vehicle;
			head.next=tail;
			head.previous=null;
			sizeOfTheQueue++;
			
		
		}else if(sizeOfTheQueue==1) {
			Node<Thing> newNode= new Node<>();
			newNode.item = vehicle;
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			tail=head.next;
			tail.next=null;
			head.previous=null;
			sizeOfTheQueue++;
			
			
		}else {
			Node<Thing> newNode= new Node<>();
			newNode.item = vehicle;
			newNode.next = head;
			head.previous=newNode;
			head = newNode;
			head.previous=null;
			sizeOfTheQueue++;
			
			
		}
	}
	
	private Thing dequeue() {
		if(sizeOfTheQueue>=2) {
			Thing temp = tail.item ;
			tail.previous.next=null;
			tail.previous=null;
			sizeOfTheQueue--;
			return temp;
		}else if(sizeOfTheQueue==1) {
			Thing temp = head.item ;
			tail=head=null;
			sizeOfTheQueue--;
			return temp;
		}else
		return null;
	}
	
	void addVehicleToTheWarehouse(Thing vehicle) {
		enqueue(vehicle);
	}
	
	Thing getVehicleFromWarehouse() {
		
		return dequeue();
	}
	

	
	
	
	
	
	
}
