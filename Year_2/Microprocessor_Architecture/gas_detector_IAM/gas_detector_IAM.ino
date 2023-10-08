#include <LiquidCrystal.h>

LiquidCrystal lcd(8, 9, 10, 11, 12, 13);
int RLED = 3;
int GLED = 4;
int BUZZ = 2;

int MQ2Pin = A5;
int MQ2Threshold = 450;
void setup() {
  pinMode(RLED, OUTPUT);
  pinMode(GLED, OUTPUT);
  pinMode(BUZZ, OUTPUT);
  pinMode(MQ2Pin, INPUT);
  Serial.begin(9600);
  lcd.begin(16,2);

  Serial.print("MQ2 sensor needs to warm up for around 20 seconds!");
  lcd.setCursor(0, 0);
  lcd.print("Sensor needs to");
  lcd.setCursor(0, 1);
  lcd.print("heat for 20s");
  delay(20000);
  lcd.clear();
}
void loop() {
  
  int MQ2Sensor = analogRead(MQ2Pin);

  Serial.print("Pin A5: ");
  Serial.println(MQ2Sensor);
  lcd.print("Gas:");
  lcd.print(MQ2Sensor);
  // Checks if it has reached the threshold value
  if(MQ2Sensor > MQ2Threshold)
  {
    digitalWrite(GLED, LOW);
    digitalWrite(RLED, HIGH);
    lcd.setCursor(0, 2);
    lcd.print("Gas was detected");
    digitalWrite(12, LOW);
    tone(BUZZ, 500);
    delay(250);
    noTone(BUZZ);
    MQ2Sensor = analogRead(MQ2Pin);
  }
  else{
    digitalWrite(RLED, LOW);
    digitalWrite(GLED, HIGH);
    lcd.setCursor(0, 2);
    lcd.print("Everything okay!");
  }

  noTone(BUZZ);

  delay(500);
  lcd.clear();
}