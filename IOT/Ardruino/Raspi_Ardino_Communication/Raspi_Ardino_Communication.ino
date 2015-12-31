const int ledPin = 8;

void setup(){
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop(){
  if (Serial.available())  {
     light(Serial.read() - '0');
      Serial.println("Done");
  }
  delay(2000);
}

void light(int n){
  for (int i = 0; i < n; i++)  {
    digitalWrite(ledPin, HIGH);
    delay(2000);
    digitalWrite(ledPin, LOW);
    delay(2000);
  }
}
