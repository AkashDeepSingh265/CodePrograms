package trie;

import java.util.ArrayList;

public class Trie {
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	public void addWord(String word){
		root.addWord(word);
	}
	
	public ArrayList<String> getWords(String prefix){
		TrieNode lastNode = root;
		for(int i=0;i<prefix.length();i++){
			lastNode = lastNode.getNode(prefix.charAt(i));
		}
		if(lastNode==null) return new ArrayList<>();
		else {
			return lastNode.getWords();
		}
	}
	public void deleteWord(String word){
		TrieNode lastNode = root;
		for(int i=0;i<word.length();i++){
			lastNode = lastNode.getNode(word.charAt(i));
		}
		if(lastNode!=null)lastNode.delete();
	}
	public ArrayList<String> getAllWords(){
		return root.getWords();
	}
	public static void main(String[] args){
		Trie trie = new Trie();
		
		trie.addWord("car");
		trie.addWord("card");
		trie.addWord("caravan");
		trie.addWord("cardio");
		System.out.println(trie.getAllWords().toString());
		trie.deleteWord("caravan");
		System.out.println(trie.getAllWords().toString());
	}

}
