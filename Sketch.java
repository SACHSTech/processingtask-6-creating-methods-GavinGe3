import processing.core.PApplet;

/**
* A program that allows you to draw pandas and bamboo while changing their size, color and location
* @author G. Ge
*
*/


public class Sketch extends PApplet {
	
  /**
   * 
   * Sets the window size
   * 
   */
  public void settings() {
	

    size(800, 800);
  }

  /**
     * 
     * Sets up the initial values  bacgkround, stroke, fill
     * 
     */
  public void setup() {

    background(210, 255, 173);
  }

  /**
    * 
    * Draws objects to the screen
    * 
    */

  public void draw() {
    
    for (int i = 1; i < 20; i++) {
      drawBamboo(100 + 25* i, 100 + 25 * i, 600, 20);
    }
    drawBamboo(100,100, 600, 20);
    drawBamboo(125, 125, 600, 20);
    drawPanda(100, 100, 33, 78, 123, (float) 1.1);
    //drawPanda(300, 100, 33, 78, 123, 1);
    //drawPanda(500, 500, 33, 78, 123, 1);

  }
  
  // define other methods down here.

  /**
     * Draws  bamboo
     * 
     * @param bambooX  X coordinate of bamboo
     * @param bambooY  Y Coordinate of bamboo
     * @param babmooHeight  float for height of bamboo
     * @param bambooWidth  float for width of bamboo
     * 
     */
  void drawBamboo(float bambooX, float bambooY, float bambooHeight, float bambooWidth){
    
    fill(8, 133, 68);
    for (int i = 0; i < 1; i ++){
      rect(bambooX, bambooY, bambooWidth, bambooHeight);
      for (int x = 0; x < 6; x++){
        line(bambooX, bambooY + x * bambooHeight / 5, bambooX + bambooWidth, bambooY + x * bambooHeight / 5);
      }
    }
  }

  /**
     * Draws a panda
     * 
     * @param pandaX  x coordinate of panda
     * @param pandaY  y coordinate of panda
     * @param colorOne  first value of RGB spectrum
     * @param colorTwo  second value of RGB spectrum
     * @param colorThree  third value of RGB spectrum
     * @param pandaSize  Size of panda in terms of 1 (1.25 is 25% larger)
     * 
     */
  void drawPanda(float pandaX, float pandaY, float pandaColorOne, float pandaColorTwo, float pandaColorThree, float pandaSize) {

     // Use pos methods to determine x and y coordinates so panda will be drawn on screen
    strokeWeight(4);
    pandaX = posX(pandaX, pandaSize);
    pandaY = posY(pandaY, pandaSize);

    // Draw Ears
    fill(0,0,0);
    arc(pandaX - 125 * pandaSize, pandaY - 120 * pandaSize, 200 * pandaSize, 200 * pandaSize, radians(135), radians(320), OPEN);
    arc(pandaX + 125 * pandaSize, pandaY - 120 * pandaSize, 200 * pandaSize, 200 * pandaSize, radians(220), radians(405), OPEN);
    
    // Draw Panda Face
    fill(pandaColorOne, pandaColorTwo, pandaColorThree);
    ellipse(pandaX, pandaY, 450 * pandaSize, 375 * pandaSize); 
    
    // Draw Panda Eyes
    fill(0,0,0);
    arc(pandaX - 100 * pandaSize, pandaY - 15 * pandaSize, 150 * pandaSize, 150 * pandaSize, radians(149), radians(301), OPEN);
    arc(pandaX - 125 * pandaSize, pandaY - 40 * pandaSize, 150 * pandaSize, 150 * pandaSize, radians(-32), radians(122), OPEN);
    arc(pandaX + 100 * pandaSize, pandaY - 15 * pandaSize, 150 * pandaSize, 150 * pandaSize, radians(239), radians(391), OPEN);
    arc(pandaX + 125 * pandaSize, pandaY - 40 * pandaSize, 150 * pandaSize, 150 * pandaSize, radians(58), radians(212), OPEN);

    fill(255, 255, 255);
    ellipse(pandaX - 90 * pandaSize, pandaY - 48 * pandaSize, 30 * pandaSize, 30 * pandaSize);
    ellipse(pandaX + 90 * pandaSize, pandaY - 48 * pandaSize, 30 * pandaSize, 30 * pandaSize);

    // Draw panda nose
    fill(0, 0, 0);
    ellipse(pandaX, pandaY + 75, 75 * pandaSize, 40 * pandaSize);
    
    // Draw Panda "Whiskers"
    strokeWeight(8);
    line(pandaX , pandaY + 75 * pandaSize, pandaX , + pandaY + 105 * pandaSize);
    noFill();
    arc(pandaX - 25 * pandaSize, pandaY + 105 * pandaSize, 50 * pandaSize, 40 * pandaSize, 0, radians(135));
    arc(pandaX + 25 * pandaSize, pandaY + 105 * pandaSize , 50 * pandaSize, 40 * pandaSize, radians(45), radians(180));

  }

  /**
     * 
     * keeps panda on the screen
     * @param positionX  given x coordinate of Panda face
     * @param pandaSize  given pandaSize values for Panda face
     * @return return an x coordinate that will keep the panda face on the screen
     * 
     */
  public float posX(float positionX, float pandaSize) {
    
    if (positionX + (225 * pandaSize) > width){
      return positionX + (width - positionX - 225 * pandaSize);
    }
    if (positionX - 225 * pandaSize < 0){
      return positionX + (0 - positionX + 225 * pandaSize);
    }
    return positionX;
  }

  /**
     * 
     * keeps panda on the screen
     * 
     * @param positionY  given x coordinate of Panda face
     * @param pandaSize  given pandaSize values for Panda face
     * @return return an Y coordinate that will keep the panda face on the screen
     * 
     */
  public float posY(float positionY, float pandaSize) {
    
    if (positionY + 215 * pandaSize  > height ){
      return positionY + (height - positionY - 215 * pandaSize);
    }
    if (positionY - 225 * pandaSize < 0 ){
      return positionY + (0 - positionY + 225 * pandaSize);
    }
    return positionY;
  }
}
