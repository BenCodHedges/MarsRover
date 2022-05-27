package org.ben;

public class Rover {
	public static final char FORWARD = 'M';
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';
	public static final String NORTH = "N";
	public static final String WEST = "W";
	public static final String SOUTH = "S";
	public static final String EAST = "E";
	public static final boolean CLOCKWISE = true;
	public static final boolean ANTICLOCKWISE = false;
	public static final int MAX_GRID_HEIGHT = 10;
	public static final int MIN_GRID_HEIGHT = 0;
	private int roverPositionX = MIN_GRID_HEIGHT;
	private int roverPositionY = MIN_GRID_HEIGHT;
	private String roverDirection = "N";

	public Rover(int roverPositionX, int roverPositionY, String roverDirection) {
		this.roverPositionX = roverPositionX;
		this.roverPositionY = roverPositionY;
		this.roverDirection = roverDirection;
	}

	public String position() {
		return "" + roverPositionX + ":" + roverPositionY + ":" + roverDirection;
	}

	public void execute(String move) {

		for (int i = MIN_GRID_HEIGHT; i < move.length(); i++) {
			moveRover(move.charAt(i));
		}
	}


	private void moveRover(char currentLetter) {
		if (currentLetter == FORWARD) {
			checkDirectionAndThenMove();
			if (roverPositionY > MAX_GRID_HEIGHT) {
				roverPositionY = MIN_GRID_HEIGHT;
			}
		}

		if (currentLetter == RIGHT) {
			turn(CLOCKWISE);
		}
		if (currentLetter == LEFT) {
			turn(ANTICLOCKWISE);
		}

	}

	private void checkDirectionAndThenMove() {
		switch (roverDirection) {
			case NORTH:
				roverPositionY++;
				break;
			case EAST:
				roverPositionX++;
				break;
		}
	}

	private void turn(boolean clockwise) {
		switch (roverDirection) {
			case NORTH:
				roverDirection = clockwise ? EAST : WEST;
				break;
			case EAST:
				roverDirection = clockwise ? SOUTH : NORTH;
				break;
			case SOUTH:
				roverDirection = clockwise ? WEST : EAST;
				break;
			case WEST:
				roverDirection = clockwise ? NORTH : SOUTH;
				break;
		}
	}
}
