import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  
  public void settings() {
  
	/**
   * 
   * Sets the window size
   * 
   */
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    /**
     * 
     * Sets up the background color
     * 
     */


    background(210, 255, 173);
  }

 
  public void draw() {
    /**
    * 
    * Draws objects to the screen
    * 
    */
    for (int i = 1; i < 20; i++) {
      drawBamboo(100 + 25* i, 100 + 25 * i, 600, 20);

    }
    drawBamboo(100,100, 600, 20);
    drawBamboo(125, 125, 600, 20);
    drawPanda(100, 100, 33, 78, 123, (float) 1.5);
    //drawPanda(300, 100, 33, 78, 123, 1);
    //drawPanda(500, 500, 33, 78, 123, 1);

  }
  
  // define other methods down here.

  void drawBamboo(float bambooX, float bambooY, float bambooHeight, float bambooWidth){
    /**
     * Draws background bamboo
     * 
     * @param bambooX: X coordinate of bamboo
     * @param bambooY: Y Coordinate of bamboo
     * @param babmooHeight: float for height of bamboo
     * @param bambooWidth: float for width of bamboo
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

  void drawPanda(float pandaX, float pandaY, float colorOne, float colorTwo, float colorThree, float size) {

    /**
     * Draws a panda
     * 
     * @param pandaX: x coordinate of panda
     * @param pandaY: y coordinate of panda
     * @param colorOne: first value of RGB spectrum
     * @param colorTwo: second value of RGB spectrum
     * @param colorThree: third value of RGB spectrum
     * @param size: Size of panda in terms of 1 (1.25 is 25% larger)
     * 
     */

    strokeWeight(4);
    pandaX = posX(pandaX, size);
    pandaY = posY(pandaY, size);

    // Draw Ears
    fill(0,0,0);
    arc(pandaX - 125 * size, pandaY - 120 * size, 200 * size, 200 * size, radians(135), radians(320), OPEN);
    arc(pandaX + 125 * size, pandaY - 120 * size, 200 * size, 200 * size, radians(220), radians(405), OPEN);
    
    // Draw Panda Face
    fill(colorOne,colorTwo,colorThree);
    ellipse(pandaX, pandaY, 450 * size, 375 * size); 
    
    // Draw Panda Eyes
    fill(0,0,0);
    arc(pandaX - 100 * size, pandaY - 15 * size, 150 * size, 150 * size, radians(149), radians(301), OPEN);
    arc(pandaX - 125 * size, pandaY - 40 * size, 150 * size, 150 * size, radians(-32), radians(122), OPEN);
    arc(pandaX + 100 * size, pandaY - 15 * size, 150 * size, 150 * size, radians(239), radians(391), OPEN);
    arc(pandaX + 125 * size, pandaY - 40 * size, 150 * size, 150 * size, radians(58), radians(212), OPEN);

    fill(255, 255, 255);
    ellipse(pandaX - 90 * size, pandaY - 48 * size, 30 * size, 30 * size);
    ellipse(pandaX + 90 * size, pandaY - 48 * size, 30 * size, 30 * size);

    // Draw panda nose
    fill(0, 0, 0);
    ellipse(pandaX, pandaY + 75, 75 * size, 40 * size);
    
    // Draw Panda "Whiskers"
    strokeWeight(8);
    line(pandaX , pandaY + 75 * size, pandaX , + pandaY + 105 * size);
    noFill();
    arc(pandaX - 25 * size, pandaY + 105 * size, 50 * size, 40 * size, 0, radians(135));
    arc(pandaX + 25 * size, pandaY + 105 * size , 50 * size, 40 * size, radians(45), radians(180));

  }

  public float posX(float positionX, float size) {
    /**
     * 
     * keeps panda on the screen
     * param @param positionX: given x coordinate of Panda face
     * return: return an x coordinate that will keep the panda face on the screen
     * 
     */

    if (positionX + (225 * size) > width){
      return positionX + (width - positionX - 225 * size);
    }
    if (positionX - 225 * size < 0){
      return positionX + (0 - positionX + 225 * size);
    }
    return positionX;
  }
  public float posY(float positionY, float size) {
    /**
     * 
     * keeps panda on the screen
     * param @param positionY: given x coordinate of Panda face
     * return: return an Y coordinate that will keep the panda face on the screen
     * 
     */

    if (positionY + 215 * size  > height ){
      return positionY + (height - positionY - 215 * size);
    }
    if (positionY - 225 * size < 0 ){
      return positionY + (0 - positionY + 225 * size);
    }
    return positionY;
  }
}
