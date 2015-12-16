Table pooltable;
Ball a,b,c,d,e;
Grass grass;
Cloud cloud;
Bird bird;
Mouse mouse;
Button one, two, three, four;

void setup() {
  size(700,600);
  pooltable= new Table();
  grass = new Grass();
  cloud = new Cloud();
  bird = new Bird();
  mouse = new Mouse();
  one = new Button(0,0);
  two = new Button(100,0);
   mouse.mouse =false;
  reset();
}
void reset() {
 
  pooltable.wall=true;
  a = new Ball();
  b = new Ball();
  c = new Ball();
  d = new Ball();
  e = new Ball();
}  

void draw() {
  background(114,240,230);
  pooltable.tabledisplay();
  a.Show();
  a.Move();
  a.num = "1";
  b.Show();
  b.Move();
  b.num = "2";
  c.Show();
  c.Move();
  c.num = "3";
  d.Show();
  d.Move();
  d.num = "4";
  e.Show();
  e.Move();
  e.num = "5";
  one.name = "mouse";
  two.name = "wall";
  
  cloud.Cshow();
  cloud.Cmove();
  bird.Bshow();
  bird.Bmove();
  mouse.Mshow();
  mouse.Mmove();
  one.Bshow();
  one.mousePressed();
  two.Bshow();
 // grass.GShow();
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
        
    if (wall){
      strokeWeight(10);
      stroke(0,127,0);
      line(middle,top+15,middle,bottom-15);
}
  }
}


class Ball{
  float x,y,DX,DY;
  float r,g,b;
  String num = "";
  
  Ball(){
    r = random(1,255);
    g = random(1,255);
    b = random(1,255);
    //
    x=  random(pooltable.right-100, pooltable.left-100);
    y=  random(pooltable.top+400,pooltable.bottom)/2 ;
    
    DX = random(1,5);
    DY = random(1,5);
  }
  void Show(){
    fill(r,g,b);
    strokeWeight(0);
    ellipse( x, y, 30,30 );
    fill(0);
    text(num, x,y);
  }
  void Move(){
    x= x+DX;
    y= y+DY;
    
     // bounce off walls//
    if (x > pooltable.right-30  ||  x < pooltable.left+30  ) {
      DX = -DX;
    }
     if (y > pooltable.bottom-30  ||  y < pooltable.top+30 ){
     DY= -DY;
    } 
    // ball collision//
    float tmp;
    
    if ( dist(x,y,this.y, this.x) < 30){
    
    }
    
    } 
}


//grass//

class Grass {
  float x;
  
  void GShow() {
    x = 20;
    while ( x < width) {
      line (x+20,20,20,20);
    }
  }
}
// cloud//
class Cloud {
    float x =20, y= 40;
 
  void Cshow(){
   fill(255);
     strokeWeight(0);
     for( int i = 0; i < width; i = i+90){
    arc(x+i,y,30+i,30,HALF_PI+i,PI+HALF_PI+QUARTER_PI);
    arc(x+15+i,y-15,30+i,30,HALF_PI+QUARTER_PI+i,TWO_PI+QUARTER_PI);
    arc(x+30+i,y-15,30+i,30,HALF_PI+QUARTER_PI+i,TWO_PI+QUARTER_PI);
    arc(x+45+i,y,30+i,30,PI+QUARTER_PI+i,TWO_PI+HALF_PI);
    line(x+i,y+15,x+45+i,y+15);
    noStroke();
    ellipse(x+22+i,y-16,25,25);
    ellipse(x+11+i,y-7,25,25);
    ellipse(x+33+i,y-7,25,25);
    rectMode(CORNER);
    rect(x-1+i,y-1,47,15);
     }
  }
  
  void Cmove(){
    x = x+1;
    if ( x > width){
      x = 0;
    }
  }
}

class Bird {
 float x =20; 
 float y =20;
 int w = 0;
 
 void Bshow() {
    fill(0);
    triangle(x+50,y+80,x+150,y+80,x+50,y+50 );   // body//
    fill(255);
    triangle( x+80,y+70, x+100,y+70, x+90,y+40+w ); // wing //
}

void Bmove() {
  x = x+1;
  if (frameCount/20 % 2 > 0) w = +60;
  else w = -20;
}
}

class Mouse{
  float x;
  float height = random(pooltable.top, pooltable.bottom);
  boolean mouse;
  
  void Mshow(){
    
    if (mouse){
    fill(155,67,16); ellipse(x+35,height-40,40,20); ///body
    fill(155,67,16); triangle(x+50,height-30,x+80, height-39,x+50,height-50);///head
    fill(237,120,135); ellipse(x+51,height-52,9,9);    //ears
    fill(237,120,135); ellipse(x+52,height-28,9,9);     ///ears
    fill(0); ellipse(x+56,height-43,3,3);       ///eyes
    fill(0); ellipse(x+56,height-36,3,3);       ///eyes
    fill(0); ellipse(x+80,height-39,5,5); ////nose
  }
  }
  void Mmove() {
    if (mouse == true){
    x = x+1;}
  }
  
}

//button function//
class Button {
  float x ,y;
  String name = "";
  
  Button(float tmpX, float tmpY){
    x = tmpX;
    y = tmpY;
  }
 
  void Bshow() {
    fill(255);
    rectMode(CORNER);
    rect(x+50,y+100,50,30);
    fill(0);
    text( name, x+59,y+120);
    
  }
  void mousePressed(){
    fill(0);
    if (mouseButton > x+30 && mouseButton <x+100 && mouseButton > y+100 && mouseButton < y) {
      mouse.mouse=true;
      }
     
}
}            
