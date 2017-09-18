package me.cmlt.tankbattle.Model;

public interface Move {

	//移动方法
	public void move();
	//转向方法
	public boolean turn(int dir);
}
