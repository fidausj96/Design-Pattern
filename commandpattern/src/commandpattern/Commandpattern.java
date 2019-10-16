/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;



//Test The remote control--------------------------
public class Commandpattern {

   
    public static void main(String[] args) {
     //  SimpleRemoteControl remote = new SimpleRemoteControl();
     
     RemoteControl remoteControl=new RemoteControl();
    Light  LivingRoomLight = new Light("Living Room");
    
    LightOnCommand livingRoomLightOn = new LightOnCommand(LivingRoomLight);
    LightOffCommand lightOffCommand = new LightOffCommand(LivingRoomLight);
    
       
        remoteControl.setCommand(0, livingRoomLightOn, lightOffCommand);
      System.out.println(remoteControl);
      
      remoteControl.onButtonWasPush(0);
      remoteControl.offButtonWasPush(0);
      
         
    }
    
}

//Test The remote control--------------------------




interface Command{
public void execute();
}
//lamp on-------------------------
 class LightOnCommand implements Command{
 Light light;
    public LightOnCommand(Light light) {
        this.light=light;
    }
    

     
    @Override
    public void execute() {
        light.on();
      }
 }
//lamp on -------------------------
//lamp off -------------------------
class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light) {
        this.light=light;
    }
    
    
    @Override
    public void execute() {
        
        light.off();
     }


}

//Remote Control----------------------
 class SimpleRemoteControl{

     Command slot;
    public SimpleRemoteControl() {
    }
 
    public  void setCommand (Command command){
    slot = command;
    }
    
    public void buttonWasPressed(){
    slot.execute();
    }
 }
//Remote Control----------------------


class Light{
String place ;
    public Light(String place) {
        
       this.place=place;
    }
    

public void on(){
    System.out.println(place +" light is on");
}
public void off(){
    System.out.println(place+" Light is off");
}
}

class GarageDoor {

public void up(){
    System.out.println("the door is up");
}
public void down(){
    System.out.println("the door is down");
}
public void stop(){
    System.out.println("the door stop");
}
public void lighton(){
    System.out.println("door light is on");
}
public void lightoff(){
    System.out.println("door light is off");
}
}

class GarageDoorOpenCommand implements Command{
    GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor=garageDoor;
    }
    

     
    @Override
    public void execute() {
        garageDoor.up();
      }
}

class RemoteControl{
Command[] onCommands;
Command[] offCommands;

    public RemoteControl() {
      onCommands = new Command[7];
      offCommands = new Command[7];
    
   
    
    NoCommand noCommand =new NoCommand();
    for(int i = 0 ; i<7 ; i++){
        
     onCommands[i] =noCommand;
     offCommands[i]=noCommand;
    }

   
}
    
    public void setCommand (int slot, Command onCommand,Command offCommand){
     onCommands[slot]=onCommand;
     offCommands[slot]=offCommand;
    }
    
    public void onButtonWasPush(int slot){
    
    onCommands[slot].execute();
    
    }
    
    public void offButtonWasPush(int slot){
    offCommands[slot].execute();
    }
    
@Override
    public  String toString(){
    StringBuffer stringBuffer= new StringBuffer();
    stringBuffer.append("\n---------Remote Control------------\n");
    for(int i=0; i < onCommands.length;i++){
    
    stringBuffer.append("[slot"+i+"]" + onCommands[i].getClass().getName()+"  "+offCommands[i].getClass().getName()+"\n");
    }
    return stringBuffer.toString();
    }
}


class NoCommand implements Command{

        @Override
        public void execute() {
          }
    
 }


