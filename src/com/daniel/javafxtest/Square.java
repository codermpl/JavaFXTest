package com.daniel.javafxtest;

import java.util.ArrayList;
import java.util.List;

public class Square {

	int x;
	int y;
	List<Square> adjList;
	private boolean visited;
	
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		adjList = new ArrayList<Square>();
		visited = false;
	}
	
	public void addEdge(Square sq){
		if(sq != null){
			adjList.add(sq);
		}
		return;
	}
	
	public List<Square> getAdjacentNodes(){
		return adjList;
	}
	
	public String toString(){
		return x + "," + y;
	}
	public boolean isVisited(){
		return visited;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	public boolean isAdjacent(Square sq){
		return adjList.contains(sq);
	}
	public boolean hasMove(){
		for(Square sq : adjList){
			if(!sq.isVisited()){return true;}
		}
		return false;
	}
	
}
