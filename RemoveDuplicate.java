import java.util.Scanner;

public class RemoveDuplicate {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
        public static Node removeDuplicates(Node head) {
            Node currentNode = new Node(head.data);
            Node withoutDuplicates = currentNode;
            Node nodeToCheck = head.next;
            while (nodeToCheck !=null){
                System.out.println("withoutDuplicates: "+ withoutDuplicates);
                System.out.println("currentNode: "+ currentNode);
                System.out.println("nodeToCheck: "+ nodeToCheck);
                if(nodeToCheck.data != currentNode.data){
                    currentNode.next  = new Node(nodeToCheck.data);
                    currentNode = currentNode.next;
                }
                nodeToCheck = nodeToCheck.next;
            }
            return withoutDuplicates;
        }

        public static Node insert(Node head, int data)
        {
            Node p=new Node(data);
            if(head==null)
                head=p;
            else if(head.next==null)
                head.next=p;
            else
            {
                Node start=head;
                while(start.next!=null)
                    start=start.next;
                start.next=p;

            }
            return head;
        }
        public static void display(Node head)
        {
            Node start=head;
            while(start!=null)
            {
                System.out.print(start.data+" ");
                start=start.next;
            }
        }
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);
            Node head=null;
            int T=sc.nextInt();
            while(T-->0){
                int ele=sc.nextInt();
                head=insert(head,ele);
            }
            head=removeDuplicates(head);
            display(head);

        }
}
