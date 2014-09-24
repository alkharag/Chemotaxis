import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

boolean followMouse = false;
boolean awayMouse = false;
Bacteria [] colony;

 //declare bacteria variables here   
 public void setup()   
 {     
 	size(500, 500);
 	colony = new Bacteria[50];
 	for (int i =0; i < colony.length; i ++) {
 		colony[i] = new Bacteria();

 	}

 }   
 public void draw()   
 {   
 	background(0,50,130);
 	for (int i =0; i < colony.length; i ++) {
 		colony[i].show();
 		colony[i].move();
 		colony[i].follow();

 	}
 }  
 public void mousePressed()
 {
 	if(mousePressed == true && followMouse == false && (mouseButton == LEFT)){
 		followMouse = true;
 	}else if(mousePressed == true && followMouse == true && (mouseButton == LEFT))
 	{
 		followMouse = false;
 	}
 }

 class Bacteria    
 {     
 	int bacX, bacY;

 	Bacteria()
 	{
 		bacX = (int)(Math.random()*501);
 		bacY = (int)(Math.random()*501);
 		bacX = (int)(Math.random()*501);
 		bacY = (int)(Math.random()*501);


 	}

 	public void show()
 	{
 		fill(0);
 		ellipse(bacX-2, bacY+2, 5, 5);
 		fill(190, 30, 10);
 		ellipse(bacX, bacY, 10, 10);
 		fill(240,100,100);
 		noStroke();
 		ellipse(bacX+2, bacY-2, 5, 5);
 	}
 	
 	public void move()
 	{
 		
 		bacX = bacX + (int)(Math.random()*6-3);
 		

 		bacY = bacY + (int)(Math.random()*6-3);


 	}
 	public void follow()
 	{
 		if (followMouse == true)
 		{
 			if(bacX > mouseX){
 				bacX = bacX + (int)(Math.random()*(-5)+1);
 			}else {
 				bacX = bacX + (int)(Math.random()*(5)-1);
 			}
 			if(bacY > mouseY){
 				bacY = bacY + (int)(Math.random()*(-5)+1);
 			}else {
 				bacY = bacY + (int)(Math.random()*(5)-1);
 			}	
 		}
 		
 	}

 }    
 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
