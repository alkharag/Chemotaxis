boolean followMouse = false;
boolean awayMouse = false;
Bacteria [] colony;

 //declare bacteria variables here   
 void setup()   
 {     
 	size(500, 500);
 	colony = new Bacteria[50];
 	for (int i =0; i < colony.length; i ++) {
 		colony[i] = new Bacteria();

 	}

 }   
 void draw()   
 {   
 	background(0,50,130);
 	for (int i =0; i < colony.length; i ++) {
 		colony[i].show();
 		colony[i].move();
 		colony[i].follow();

 	}
 }  
 void mousePressed()
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

 	void show()
 	{
 		fill(0);
 		ellipse(bacX-2, bacY+2, 5, 5);
 		fill(190, 30, 10);
 		ellipse(bacX, bacY, 10, 10);
 		fill(240,100,100);
 		noStroke();
 		ellipse(bacX+2, bacY-2, 5, 5);
 	}
 	
 	void move()
 	{
 		
 		bacX = bacX + (int)(Math.random()*6-3);
 		

 		bacY = bacY + (int)(Math.random()*6-3);


 	}
 	void follow()
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
 
