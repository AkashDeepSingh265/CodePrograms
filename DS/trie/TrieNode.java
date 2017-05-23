package trie;

import java.util.ArrayList;

public class TrieNode {
	
	private TrieNode parent;
	private boolean isWord=false;
	private boolean isLeaf=true;
	private TrieNode[] childrens;
	private char data;
	private int noOfChildrens=0;
	
	public TrieNode(){
		this.childrens = new TrieNode[26];
	}
	
	public TrieNode(char c){
		this.childrens = new TrieNode[26];
		this.data = c;
	}
	public void addWord(String str){
		if(str==null)return;
		isLeaf = false;
		int position = str.charAt(0) - 'a';
		if(childrens[position]==null){
			childrens[position] = new TrieNode(str.charAt(0));
			noOfChildrens++;
			childrens[position].parent = this;
		}
		if(str.length()>1){
			childrens[position].addWord(str.substring(1));
		}else{
			childrens[position].isWord = true;
		}
	}
	public ArrayList<String> getWords(){
		ArrayList<String> list = new ArrayList<>();
		if(isWord){
			list.add(toString());
		}
		for(int i=0;i<childrens.length;i++){
			if(childrens[i]!=null){
				list.addAll(childrens[i].getWords());
			}
		}
		return list;
	}
	public TrieNode getNode(char c){
		return childrens[c-'a'];
	}
	public void delete(){
		if(isLeaf){
			parent.childrens[data-'a']=null;
			parent.noOfChildrens--;
			if(parent.noOfChildrens==0){
				parent.isLeaf=true;
			}
			parent.delete();
		}
	}
	public String toString(){
		if(parent == null)return "";
		return parent.toString() + data;
	}
}
