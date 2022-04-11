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
     * @param fltBambooX  X coordinate of bamboo
     * @param fltBambooY  Y Coordinate of bamboo
     * @param babmooHeight  flt for height of bamboo
     * @param fltBambooWidth  flt for width of bamboo
     * 
     */
  void drawBamboo(float fltBambooX, float fltBambooY, float fltBambooHeight, float fltBambooWidth){
    
    fill(8, 133, 68);
    for (int i = 0; i < 1; i ++){
      // draw bamboo lines
      rect(fltBambooX, fltBambooY, fltBambooWidth, fltBambooHeight);
      for (int x = 0; x < 6; x++){
        line(fltBambooX, fltBambooY + x * fltBambooHeight / 5, fltBambooX + fltBambooWidth, fltBambooY + x * fltBambooHeight / 5);
      }
    }
  }

  /**
     * Draws a panda
     * 
     * @param fltPandaX  x coordinate of panda
     * @param fltPandaY  y coordinate of panda
     * @param colorOne  first value of RGB spectrum
     * @param colorTwo  second value of RGB spectrum
     * @param colorThree  third value of RGB spectrum
     * @param fltPandaSize  Size of panda in terms of 1 (1.25 is 25% larger)
     * 
     */
  void drawPanda(float fltPandaX, float fltPandaY, int intPandaColorOne, int intPandaColorTwo, int intPandaColorThree, float fltPandaSize) {

     // Use pos methods to determine x and y coordinates so panda will be drawn on screen
    strokeWeight(4);
    fltPandaX = posX(fltPandaX, fltPandaSize);
    fltPandaY = posY(fltPandaY, fltPandaSize);

    // Draw Ears
    fill(0,0,0);
    arc(fltPandaX - 125 * fltPandaSize, fltPandaY - 120 * fltPandaSize, 200 * fltPandaSize, 200 * fltPandaSize, radians(135), radians(320), OPEN);
    arc(fltPandaX + 125 * fltPandaSize, fltPandaY - 120 * fltPandaSize, 200 * fltPandaSize, 200 * fltPandaSize, radians(220), radians(405), OPEN);
    
    // Draw Panda Face
    fill(intPandaColorOne, intPandaColorTwo, intPandaColorThree);
    ellipse(fltPandaX, fltPandaY, 450 * fltPandaSize, 375 * fltPandaSize); 
    
    // Draw Panda Eyes
    fill(0,0,0);
    arc(fltPandaX - 100 * fltPandaSize, fltPandaY - 15 * fltPandaSize, 150 * fltPandaSize, 150 * fltPandaSize, radians(149), radians(301), OPEN);
    arc(fltPandaX - 125 * fltPandaSize, fltPandaY - 40 * fltPandaSize, 150 * fltPandaSize, 150 * fltPandaSize, radians(-32), radians(122), OPEN);
    arc(fltPandaX + 100 * fltPandaSize, fltPandaY - 15 * fltPandaSize, 150 * fltPandaSize, 150 * fltPandaSize, radians(239), radians(391), OPEN);
    arc(fltPandaX + 125 * fltPandaSize, fltPandaY - 40 * fltPandaSize, 150 * fltPandaSize, 150 * fltPandaSize, radians(58), radians(212), OPEN);

    fill(255, 255, 255);
    ellipse(fltPandaX - 90 * fltPandaSize, fltPandaY - 48 * fltPandaSize, 30 * fltPandaSize, 30 * fltPandaSize);
    ellipse(fltPandaX + 90 * fltPandaSize, fltPandaY - 48 * fltPandaSize, 30 * fltPandaSize, 30 * fltPandaSize);

    // Draw panda nose
    fill(0, 0, 0);
    ellipse(fltPandaX, fltPandaY + 75, 75 * fltPandaSize, 40 * fltPandaSize);
    
    // Draw Panda "Whiskers"
    strokeWeight(8);
    line(fltPandaX , fltPandaY + 75 * fltPandaSize, fltPandaX , + fltPandaY + 105 * fltPandaSize);
    noFill();
    arc(fltPandaX - 25 * fltPandaSize, fltPandaY + 105 * fltPandaSize, 50 * fltPandaSize, 40 * fltPandaSize, 0, radians(135));
    arc(fltPandaX + 25 * fltPandaSize, fltPandaY + 105 * fltPandaSize , 50 * fltPandaSize, 40 * fltPandaSize, radians(45), radians(180));
  }

  /**
     * 
     * keeps panda on the screen
     * @param fltPositionX  given x coordinate of Panda face
     * @param fltPandaSize  given fltPandaSize values for Panda face
     * @return return an x coordinate that will keep the panda face on the screen
     * 
     */
  public float posX(float fltPositionX, float fltPandaSize) {
    
    if (fltPositionX + (225 * fltPandaSize) > width){
      return fltPositionX + (width - fltPositionX - 225 * fltPandaSize);
    }
    if (fltPositionX - 225 * fltPandaSize < 0){
      return fltPositionX + (0 - fltPositionX + 225 * fltPandaSize);
    }
    return fltPositionX;
  }

  /**
     * 
     * keeps panda on the screen
     * 
     * @param fltPositionY  given x coordinate of Panda face
     * @param fltPandaSize  given fltPandaSize values for Panda face
     * @return return an Y coordinate that will keep the panda face on the screen
     * 
     */
  public float posY(float fltPositionY, float fltPandaSize) {
    
    if (fltPositionY + 215 * fltPandaSize  > height ){
      return fltPositionY + (height - fltPositionY - 215 * fltPandaSize);
    }
    if (fltPositionY - 225 * fltPandaSize < 0 ){
      return fltPositionY + (0 - fltPositionY + 225 * fltPandaSize);
    }
    return fltPositionY;
  }
}
