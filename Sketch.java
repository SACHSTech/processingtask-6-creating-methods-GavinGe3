import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	// sample code, delete this stuff
    drawBamboo(100,100, 600, 20);
    drawBamboo(125, 125, 600, 20);
    drawPanda(700, 100, 1, 255, 255, 255);
  }
  
  // define other methods down here.

  void drawBamboo(float bambooX, float bambooY, float bambooHeight, float bambooWidth){
    /**
     * Draws background bamboo
     * 
     * @param bambooX: X coordinate of bamboo
     * @param bambooY: Y Coordinate of bamboo
     * 
     */
    fill(8, 133, 68);
    for (int i = 0; i < 1; i ++){
      rect(bambooX, bambooY, bambooWidth, bambooHeight);
      for (int x = 0; x < 6; x++){
        line(bambooX, bambooY + x * bambooHeight / 5, bambooX + bambooWidth, bambooY + x * bambooHeight / 5);
      }
    }
  }

  void drawPanda(float pandaX, float pandaY, float size, float colorOne, float colorTwo, float colorThree) {

    /**
     * Draws a panda
     * 
     * @param pandaX: x coordinate of panda
     * @param pandaY: y coordinate of panda
     * @param size: size of panda
     * @param colorOne: first value of RGB spectrum
     * @param colorTwo: second value of RGB spectrum
     * @param colorThree: third value of RGB spectrum
     * 
     */

    strokeWeight(4);
    pandaX = posX(pandaX);
    pandaY = posY(pandaY);

    // Draw Ears
    fill(0,0,0);
    arc(pandaX - 125, pandaY - 120, 200, 200, radians(135), radians(320), OPEN);
    arc(pandaX + 125, pandaY - 120, 200, 200, radians(220), radians(405), OPEN);
    
    // Draw Panda Face
    fill(colorOne,colorTwo,colorThree);
    ellipse(pandaX, pandaY, 450, 375); 
    
    // Draw Panda Eyes
    fill(0,0,0);
    arc(pandaX - 100, pandaY - 15, 150, 150, radians(149), radians(301), OPEN);
    arc(pandaX - 125, pandaY - 40, 150, 150, radians(-32), radians(122), OPEN);
    arc(pandaX + 100, pandaY - 15, 150, 150, radians(239), radians(391), OPEN);
    arc(pandaX + 125, pandaY - 40, 150, 150, radians(58), radians(212), OPEN);

    fill(255, 255, 255);
    ellipse(pandaX - 90, pandaY - 48, 30, 30);
    ellipse(pandaX + 90, pandaY - 48, 30, 30);

    // Draw panda nose
    fill(0, 0, 0);
    ellipse(pandaX, pandaY + 75, 75, 40);
    
    // Draw Panda "Whiskers"
    strokeWeight(8);
    line(pandaX, pandaY + 75, pandaX, + pandaY + 105);
    noFill();
    arc(pandaX - 25, pandaY + 105, 50, 40, 0, radians(135));
    arc(pandaX + 25, pandaY + 105, 50, 40, radians(45), radians(180));

  }

  public float posX(float positionX) {
    /**
     * 
     * keeps panda on the screen
     * param @param positionX: given x coordinate of Panda face
     * return: return an x coordinate that will keep the panda face on the screen
     * 
     */

    if (positionX + 225 > width){
      return positionX + (width - positionX - 225);
    }
    if (positionX - 225 < 0){
      return positionX + (0 - positionX + 225);
    }
    return positionX;
  }
  public float posY(float positionY) {
    /**
     * 
     * keeps panda on the screen
     * param @param positionY: given x coordinate of Panda face
     * return: return an Y coordinate that will keep the panda face on the screen
     * 
     */
    
    if (positionY + 225 > height ){
      return positionY + (height - positionY - 225);
    }
    if (positionY - 235 < 0 ){
      return positionY + (0 - positionY + 235);
    }
    return positionY;
  }
}
