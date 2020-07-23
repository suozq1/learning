package com.suo.book.algorithm.datastructure;

import java.util.Arrays;

public class BasicBinaryTree<T> {
	
	public static class BinaryTreeNode<T>{
		
		private T node;
		private BinaryTreeNode<T> leftNode;
		private BinaryTreeNode<T> rightNode;
		
		public BinaryTreeNode(T node) {
			this(node, null, null);
		}
		public BinaryTreeNode(T node,BinaryTreeNode<T> leftNode,BinaryTreeNode<T> rightNode) {
			this.node=node;
			this.leftNode=leftNode;
			this.rightNode=rightNode;
		}
		
		public T get() {
			return node;
		}
		
		public BinaryTreeNode<T> getLeft(){
			return leftNode;
		}
		
		public BinaryTreeNode<T> getRight(){
			return rightNode;
		}
		
		public T set(T node) {
			T n=this.node;
			this.node=node;		
			return n;		
		}
		
	}
	
	private BinaryTreeNode<T> header;
	
	public BasicBinaryTree(T ... arrs) {
		this(Arrays.asList(arrs));
	}
    
	public BasicBinaryTree(Iterable<T> list) {
		list.forEach(x->{
			BinaryTreeNode<T> b=new BinaryTreeNode<T>(x);
		});
	}
}
