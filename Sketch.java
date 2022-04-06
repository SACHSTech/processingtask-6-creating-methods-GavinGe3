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
    
    drawBamboo(100,100);
    drawPanda(600, 600);
    
  }
  
  // define other methods down here.

  void drawBamboo(float bambooX, float bambooY){
    fill(8, 133, 68);
    for (int i = 0; i < 6; i ++){
      rect(bambooX + 120*i, bambooY, 45, 600);
      for (int x = 0; x < 6; x++){
        line(bambooX + 120 * i, bambooY + x * 100, bambooX + 120 * i + 45, bambooY + x * 100);
      }
    }
  }

  void drawPanda(float pandaX, float pandaY) {

    strokeWeight(4);
    // Draw Ears
    fill(0,0,0);
    arc(pandaX - 125, pandaY - 120, 200, 200, radians(135), radians(320), OPEN);
    arc(pandaX + 125, pandaY - 120, 200, 200, radians(220), radians(405), OPEN);
    
    // 
    fill(255,255,255);
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
/*
  public void time(float timeRN) {
    if (timeRN < 1200 && timeRN > 600){
      return 0;
    }
    if (timeRN > 1200 && timeRN < 1800){
      return 1;
    }
    if (timeRN > 1800 && timeRN < 2400){
      return 2;
    }
    if (timeRN > 0 && timeRN< 600){
      return 3;
    }
*/


  }
