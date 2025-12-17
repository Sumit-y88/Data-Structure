public class LL {
    Node head;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next= null;
        }
    }

    //add - first, last
   public void addFirst(String data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode;
        return;
    }

    newNode.next = head;
    head = newNode;
   }
public void addLast(){
     Node newNode = new Node();
    if(head == null){
        head = newNode;
        return;
    }
    Node currNode = head;
    while(currNode != null){
        currNode = currNode.next;
    }


}


    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
    }
}
