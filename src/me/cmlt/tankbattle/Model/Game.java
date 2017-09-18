package me.cmlt.tankbattle.Model;

import java.util.Vector;

public class Game {
	
	private Tank  tank;//我方坦克
	private Vector<Tank> enemyTanks;//敌方坦克集合
	

	public Game(Tank tank, Vector<Tank> enemyTanks) {
		super();
		this.tank = tank;
		this.enemyTanks = enemyTanks;	
		
	}



	public Vector<Tank> getEnemyTanks() {
		return enemyTanks;
	}

	public void setEnemyTanks(Vector<Tank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}

	public Game() {
		super();
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}




	
	
	

}
