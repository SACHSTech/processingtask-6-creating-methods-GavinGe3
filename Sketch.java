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
      drawBamboo(0 + 35* i, 0 + 15 * i, 600, 20);
    }
    drawBamboo(100,100, 600, 20);
    drawBamboo(125, 125, 600, 20);
    drawPanda(250, 250, 33, 78, 123, (float) 1.1);
    drawPanda(300, 100, 33, 78, 123, 1);
    drawPanda(500, 500, 33, 78, 123, 1);

  }
  
  // define other methods down here.

  /**
     * Draws  bamboo
     * 
     * @param floatBambooX  X coordinate of bamboo
     * @param floatBambooY  Y Coordinate of bamboo
     * @param babmooHeight  float for height of bamboo
     * @param floatBambooWidth  float for width of bamboo
     * 
     */
  void drawBamboo(float floatBambooX, float floatBambooY, float floatBambooHeight, float floatBambooWidth){
    
    fill(8, 133, 68);
    for (int i = 0; i < 1; i ++){
      // draw bamboo lines
      rect(floatBambooX, floatBambooY, floatBambooWidth, floatBambooHeight);
      for (int x = 0; x < 6; x++){
        line(floatBambooX, floatBambooY + x * floatBambooHeight / 5, floatBambooX + floatBambooWidth, floatBambooY + x * floatBambooHeight / 5);
      }
    }
  }

  /**
     * Draws a panda
     * 
     * @param floatPandaX  x coordinate of panda
     * @param floatPandaY  y coordinate of panda
     * @param colorOne  first value of RGB spectrum
     * @param colorTwo  second value of RGB spectrum
     * @param colorThree  third value of RGB spectrum
     * @param floatPandaSize  Size of panda in terms of 1 (1.25 is 25% larger)
     * 
     */
  void drawPanda(float floatPandaX, float floatPandaY, int intPandaColorOne, int intPandaColorTwo, int intPandaColorThree, float floatPandaSize) {

     // Use pos methods to determine x and y coordinates so panda will be drawn on screen
    strokeWeight(4);
    floatPandaX = posX(floatPandaX, floatPandaSize);
    floatPandaY = posY(floatPandaY, floatPandaSize);

    // Draw Ears
    fill(0,0,0);
    arc(floatPandaX - 125 * floatPandaSize, floatPandaY - 120 * floatPandaSize, 200 * floatPandaSize, 200 * floatPandaSize, radians(135), radians(320), OPEN);
    arc(floatPandaX + 125 * floatPandaSize, floatPandaY - 120 * floatPandaSize, 200 * floatPandaSize, 200 * floatPandaSize, radians(220), radians(405), OPEN);
    
    // Draw Panda Face
    fill(intPandaColorOne, intPandaColorTwo, intPandaColorThree);
    ellipse(floatPandaX, floatPandaY, 450 * floatPandaSize, 375 * floatPandaSize); 
    
    // Draw Panda Eyes
    fill(0,0,0);
    arc(floatPandaX - 100 * floatPandaSize, floatPandaY - 15 * floatPandaSize, 150 * floatPandaSize, 150 * floatPandaSize, radians(149), radians(301), OPEN);
    arc(floatPandaX - 125 * floatPandaSize, floatPandaY - 40 * floatPandaSize, 150 * floatPandaSize, 150 * floatPandaSize, radians(-32), radians(122), OPEN);
    arc(floatPandaX + 100 * floatPandaSize, floatPandaY - 15 * floatPandaSize, 150 * floatPandaSize, 150 * floatPandaSize, radians(239), radians(391), OPEN);
    arc(floatPandaX + 125 * floatPandaSize, floatPandaY - 40 * floatPandaSize, 150 * floatPandaSize, 150 * floatPandaSize, radians(58), radians(212), OPEN);

    fill(255, 255, 255);
    ellipse(floatPandaX - 90 * floatPandaSize, floatPandaY - 48 * floatPandaSize, 30 * floatPandaSize, 30 * floatPandaSize);
    ellipse(floatPandaX + 90 * floatPandaSize, floatPandaY - 48 * floatPandaSize, 30 * floatPandaSize, 30 * floatPandaSize);

    // Draw panda nose
    fill(0, 0, 0);
    ellipse(floatPandaX, floatPandaY + 75, 75 * floatPandaSize, 40 * floatPandaSize);
    
    // Draw Panda "Whiskers"
    strokeWeight(8);
    line(floatPandaX , floatPandaY + 75 * floatPandaSize, floatPandaX , + floatPandaY + 105 * floatPandaSize);
    noFill();
    arc(floatPandaX - 25 * floatPandaSize, floatPandaY + 105 * floatPandaSize, 50 * floatPandaSize, 40 * floatPandaSize, 0, radians(135));
    arc(floatPandaX + 25 * floatPandaSize, floatPandaY + 105 * floatPandaSize , 50 * floatPandaSize, 40 * floatPandaSize, radians(45), radians(180));

  }

  /**
     * 
     * keeps panda on the screen
     * @param floatPositionX  given x coordinate of Panda face
     * @param floatPandaSize  given floatPandaSize values for Panda face
     * @return return an x coordinate that will keep the panda face on the screen
     * 
     */
  public float posX(float floatPositionX, float floatPandaSize) {
    
    if (floatPositionX + (225 * floatPandaSize) > width){
      return floatPositionX + (width - floatPositionX - 225 * floatPandaSize);
    }
    if (floatPositionX - 225 * floatPandaSize < 0){
      return floatPositionX + (0 - floatPositionX + 225 * floatPandaSize);
    }
    return floatPositionX;
  }

  /**
     * 
     * keeps panda on the screen
     * 
     * @param floatPositionY  given x coordinate of Panda face
     * @param floatPandaSize  given floatPandaSize values for Panda face
     * @return return an Y coordinate that will keep the panda face on the screen
     * 
     */
  public float posY(float floatPositionY, float floatPandaSize) {
    
    if (floatPositionY + 215 * floatPandaSize  > height ){
      return floatPositionY + (height - floatPositionY - 215 * floatPandaSize);
    }
    if (floatPositionY - 225 * floatPandaSize < 0 ){
      return floatPositionY + (0 - floatPositionY + 225 * floatPandaSize);
    }
    return floatPositionY;
  }
}
