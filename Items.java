package application;
import java.util.Random;

public class Items {
	int jewelX, jewelY, staffX, staffY, gemX, gemY, ringX, ringY;
	Maze mazeInstance = new Maze(6,6);
	Random coordOptions = new Random();
	public void setJewelCoord() {
		boolean valuesGood = false;
		while (valuesGood ==false){
			int jewelYTest = coordOptions.nextInt(mazeInstance.length);
			int jewelXTest = coordOptions.nextInt(mazeInstance.width);
			if (mazeInstance.getStatus(jewelXTest, jewelYTest) == "e") {
				this.jewelX = jewelXTest;
				this.jewelY = jewelYTest;
				Coordinate jewelItem = new Coordinate(jewelX, jewelY, 'j', 'J', false, false, false, false);
				valuesGood = true;
			}
		}
	}
	public void setStaffCoord() {
		boolean valuesGood = false;
		while (valuesGood == false){
			int staffYTest = coordOptions.nextInt(mazeInstance.length);
			int staffXTest = coordOptions.nextInt(mazeInstance.width);
			if (mazeInstance.getStatus(staffXTest, staffYTest) == "e") {
				this.staffX = staffXTest;
				this.staffY = staffYTest;
				Coordinate staffItem = new Coordinate(staffX, staffY, 's', 'S', false, false, false, false);
				valuesGood = true;
			}
		}
	}
	public void setGemCoord() {
		boolean valuesGood = false;
		while (valuesGood ==false){
			int gemYTest = coordOptions.nextInt(mazeInstance.length);
			int gemXTest = coordOptions.nextInt(mazeInstance.width);
			if (mazeInstance.getStatus(gemXTest, gemYTest) == "e") {
				this.gemX = gemXTest;
				this.gemY = gemYTest;
				Coordinate gemItem = new Coordinate(gemX, gemY, 'g', 'G', false, false, false, false);
				valuesGood = true;
			}
		}
	}
	public void setRingCoord() {
		boolean valuesGood = false;
		while (valuesGood == false){
			int ringYTest = coordOptions.nextInt(mazeInstance.length);
			int ringXTest = coordOptions.nextInt(mazeInstance.width);
			if (mazeInstance.getStatus(ringXTest, ringYTest) == "e") {
				this.ringX = ringXTest;
				this.ringY = ringYTest;
				Coordinate staffItem = new Coordinate(ringX, ringY, 'r', 'R', false, false, false, false);
				valuesGood = true;
			}
		}
	}
	public int getJewelX() {
		return this.jewelX;
	}
	public int getJewelY() {
		return this.jewelX;
	}
	public int getStaffX() {
		return this.jewelX;
	}
	public int getStaffY() {
		return this.jewelX;
	}
	public int getRingX() {
		return this.jewelX;
	}
	public int getRingY() {
		return this.jewelX;
	}
	public int getGemX() {
		return this.jewelX;
	}
	public int getGemY() {
		return this.jewelX;
	}
}
