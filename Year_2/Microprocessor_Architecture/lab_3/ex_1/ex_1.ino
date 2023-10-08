void setup()
{
    Serial.begin(9600);
    Serial.println("setup done");
}

void loop()
{


  if (Serial.available()) {
    char a = Serial.read();
    char buf[20];
    sprintf(buf, "%s: %c", "got character", a);
    Serial.println(buf);
  }
}