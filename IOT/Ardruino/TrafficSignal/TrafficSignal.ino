
void setup() {
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(8, OUTPUT);
}


void loop() {
  digitalWrite(13, HIGH);
  digitalWrite(12, LOW);   
  digitalWrite(8, LOW);
  
  delay(6000);

   digitalWrite(8, HIGH);
  digitalWrite(13, LOW);
  digitalWrite(12, LOW);

  delay(3000);
  
  digitalWrite(8, LOW);
  digitalWrite(13, LOW);
  digitalWrite(12, HIGH);  
  delay(6000);             
  
  
  digitalWrite(13, LOW);
  digitalWrite(12, LOW);
  
   delay(2000);
  

}
