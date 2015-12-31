
#define RELAY1  13

void setup() {
  pinMode(RELAY1, OUTPUT);

}

void loop() {
   digitalWrite(RELAY1,HIGH);
   delay(2000);             
   digitalWrite(RELAY1,LOW);  
   delay(5000); 

}
