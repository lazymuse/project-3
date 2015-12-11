Table pooltable;
Ball poolball;

void setup() {
  size(700,600);
  pooltable= new Table();
  reset();
}
void reset() {
  pooltable.wall=true;
  poolball= new Ball();
}  

void draw() {
  background(114,240,230);
  pooltable.tabledisplay();
  poolball.Show();
  poolball.Move();
}
void keyPressed() {
  if (key == 'q') exit();
  if (key == 'r') reset();
}

class Table {
  float left=50, top=150, right=width-50, bottom=height-50, middle;
  boolean wall;
  
  Table(){
    middle= (right+left) / 2;
  }
  
  void tabledisplay(){
    fill(100,250,100); //green table
    strokeWeight(20);
    stroke(127,0,0);   //brown walls
    rectMode( CORNERS );
    rect( left,top, right,bottom );
    stroke(0);
    strokeWeight(1);
    
    if (wall){
      stroke(0,127,0);
      strokeWeight(10);
      line(middle,top+15,middle,bottom+165);
}
  }
}


class Ball{
  color c;
  float x,y,DX,DY;
  float r,g,b;
  String name="";
  
  Ball(){
    r = random(1,255);
    g = random(1,255);
    b = random(1,255);
    //
    x=  pooltable.right-100;
    y=  (pooltable.top+pooltable.bottom) / 2;
    
    DX = 9;
    DY = 9;
  }
  void Show(){
    fill(r,g,b);
    //--  ellipse( x+pooltable.right, y+pooltable.middle, 30,30 );
    ellipse( x, y, 30,30 );
  }
  void Move(){
    x= x+DX;
    y= y+DY;
    
     // bounce//
    if (x > pooltable.right-30  ||  x < pooltable.left+30  ) {
      DX = -DX;
    }
    
     if (y > pooltable.bottom-30  ||  y < pooltable.top+30 ){
     DY= -DY;
    } 
  }
}
