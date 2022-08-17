import java.util.*;

class Node2{
    Node2 left,right;
    int data;
    Node2(int data){
        this.data=data;
        left=right=null;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class BstHeight {
    static void levelOrder(Node2 root){
        ArrayList<Integer> holder = addLevelDataToList(root);
        printLevelData(holder);
    }

    private static ArrayList<Integer> addLevelDataToList(Node2 root) {
        ArrayList<Integer> holder = new  ArrayList<Integer>();
        HashMap<Integer,ArrayList<Node2>> levelList = new HashMap();
        ArrayList<Node2> first = new ArrayList<>();
        first.add(root);
        int level = 0;
        levelList.put(level,first);
        HashMap<Integer,ArrayList<Node2>> resultList = getAllLevels(levelList);
        Set<Integer> keys = resultList.keySet();
        for (int i = 0; i < keys.size(); i++) {
            ArrayList<Node2> currNodeList =resultList.get(i);
            ArrayList<Integer> currNodeListInt = getNodeElements(currNodeList);
            //System.out.println("i:" + i + " \t elems :"+ currNodeListInt.toString());
            holder.addAll(currNodeListInt);
        }
        return holder;
    }

    private static HashMap<Integer, ArrayList<Node2>> getAllLevels(HashMap<Integer, ArrayList<Node2>> levelList) {
        int level = levelList.keySet().size();
        int previousLevel = level-1;
        ArrayList<Node2> tempNodes = levelList.get(previousLevel);
        ArrayList<Node2> temp = new ArrayList<Node2>();
        for (Node2 tempNode : tempNodes) {
            temp.addAll(getAllChildNodes(tempNode));
        }
        levelList.put(level,temp);
        if(hasMoreNodes(temp)){
            return getAllLevels(levelList);
        }else {
            return levelList;
        }
    }

    private static boolean hasMoreNodes(ArrayList<Node2> temp) {
        boolean hasNodes = false;
        for (Node2 node2 : temp) {
            if(node2.left != null || node2.right != null){
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> getNodeElements(ArrayList<Node2> temp) {
        ArrayList<Integer> tempInt = new ArrayList<>();
        for (Node2 node2 : temp) {
            tempInt.add(node2.data);
        }
        return tempInt;
    }

    private static ArrayList<Node2> getAllChildNodes(Node2 root) {
        ArrayList<Node2> childNodes = new ArrayList<Node2>();
        if(root.left!=null){
            childNodes.add(root.left);
        }
        if(root.right!=null){
            childNodes.add(root.right);
        }
        return childNodes;
    }

    private static void printLevelData(ArrayList<Integer> holder) {
        for (Integer integer : holder) {
            System.out.print(integer + " ");
        }
    }

    public static Node2 insert(Node2 root, int data){
        if(root==null){
            return new Node2(data);
        }
        else{
            Node2 cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node2 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
