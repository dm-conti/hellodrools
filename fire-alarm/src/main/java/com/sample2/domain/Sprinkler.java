package com.sample2.domain;

public class Sprinkler {
	private Room room;

    public Sprinkler(Room room) {
		super();
		this.room = room;
	}

	private boolean on;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
    
    
}
