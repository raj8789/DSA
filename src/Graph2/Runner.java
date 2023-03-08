package Graph2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        System.out.println("Enter String you Want to Encode");
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        for(int i=0;i<string.length();i++){
            char ch=string.charAt(i);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }
        char ch[]=new char[hashMap.size()];
        int fre[]=new int[hashMap.size()];
        int count=0;
        for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            ch[count]= entry.getKey();
            fre[count]=entry.getValue();
            count++;
        }
        HashMap<Character,String> hashMap1=new HashMap<>();
        HuffManImpl huffMan=new HuffManImpl(ch,fre);
        Node root=huffMan.createTree();
        huffMan.traverseTree(root,"",hashMap1);
        String ans=huffMan.HuffmanEncode(string,hashMap1);
        System.out.println("Encode Value of String :");
        System.out.println(ans);

    }
}
