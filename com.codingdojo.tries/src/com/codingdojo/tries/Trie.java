package com.codingdojo.tries;

import java.util.Iterator;
import java.util.Set;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
            
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix) {
    	Node currentNode = this.root;
    	
    	for(int i = 0; i < 2; i++) {
            
            Character currentLetter = prefix.charAt(i);
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                return false;
            } 
            currentNode = child;
    	}
    	return true;
   }
   public boolean isWordValid(String word) {
	   Node currentNode = this.root;
   	
   	for(int i = 0; i < word.length(); i++) {
   		Character currentLetter = word.charAt(i);
   		Node child = currentNode.children.get(currentLetter);
        if(child == null) {
        	return false;
        } 
        currentNode = child;
   	}
   	return true;
   }
   
   private void printAllKeys(Node node) {
	   Iterator <Character> keys = node.children.keySet().iterator();
	   
	   while(keys.hasNext()) {
		   Character key = keys.next();
		   System.out.println(key);
		   printAllKeys(node.children.get(key));
	   }
   
   }
   
   
   public void printAllKeys() {
	   printAllKeys(this.root);
   }
}