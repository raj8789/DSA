package Graph2;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffManImpl {
    private PriorityQueue<Node> priorityQueue;
    char ch[];
    int fre[];

    public HuffManImpl(char[] ch, int[] fre) {
        priorityQueue=new PriorityQueue<Node>();
        this.ch = ch;
        this.fre = fre;
        for(int i=0;i<ch.length;i++){
            priorityQueue.add(new Node(ch[i],fre[i],null,null));
        }
    }
    public Node createTree() {
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            priorityQueue.add(new Node('_', left.fre + right.fre, left, right));
        }
        return  priorityQueue.peek();
    }
    public void traverseTree(Node root, String s, HashMap<Character,String> map){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            map.put(root.ch,s);
        }
        traverseTree(root.left,s+'0',map);
        traverseTree(root.right,s+1,map);
    }
    public String HuffmanEncode(String str,HashMap<Character,String> map){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++){
            sb.append(map.get(str.charAt(i)));
        }
        return sb.toString();
    }
}
class Node implements Comparable<Node>{

    char ch;
    int fre;
    Node left;
    Node right;

    public Node(char ch, int fre, Node left, Node right) {
        this.ch = ch;
        this.fre = fre;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.fre-o.fre;
    }
}
