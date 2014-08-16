package com.daniel.javafxtest;

import java.util.ArrayList;
import java.util.List;

public class KnightsTourModel {

	private int width;
	private int length;
	private List<Square> board;
	private List<Square> moveList;
	private Square currentSquare;
	
	
	public KnightsTourModel(int width, int length){
		this.width = width;
		this.length = length;
		currentSquare = null;
		moveList = new ArrayList<Square>();
		board = new ArrayList<Square>();
		
		//Create Squares
		int i, j;
		for(i = 0; i < width; i++){
			for(j = 0; j < length; j++){
				board.add(new Square(i,j));
			}
		}
		//Create Adjacency List
		Square sq;
		for(i = 0; i < width; i++){
			for(j = 0; j < length; j++){
				sq = this.getSquare(i,j);
		        System.out.println(sq.toString());	
				sq.addEdge(this.getSquare(i + 1, j + 2));
				sq.addEdge(this.getSquare(i + 1, j - 2));
				sq.addEdge(this.getSquare(i - 1, j + 2));
				sq.addEdge(this.getSquare(i - 1, j - 2));
				sq.addEdge(this.getSquare(i + 2, j + 1));
				sq.addEdge(this.getSquare(i + 2, j - 1));
				sq.addEdge(this.getSquare(i - 2, j + 1));
				sq.addEdge(this.getSquare(i - 2, j - 1));
			}
		}
	visit(getSquare(0,0));
	}
	
	public Square getSquare(int x, int y){
		if(x < width && x >= 0 && y < length && y >= 0){
			return board.get(x * this.width + y);
		}
		else return null;
	}

	public Square getCurrentSquare(){
		return currentSquare;
	}
	public void visit(Square sq){
		currentSquare = sq;
		sq.setVisited(true);
		moveList.add(sq);
	}
	public int getWidth(){
		return width;
	}
	public int getLength(){
		return length;
	}
}
