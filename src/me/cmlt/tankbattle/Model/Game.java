package me.cmlt.tankbattle.Model;

import java.util.Vector;

public class Game {
	
	private Tank  tank;//�ҷ�̹��
	private Vector<Tank> enemyTanks;//�з�̹�˼���
	

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
