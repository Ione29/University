#define LED_PIN 13
#define BUTTON_PIN 2

void setup()
{
    pinMode(LED_PIN, OUTPUT);
    pinMode(BUTTON_PIN, INPUT_PULLUP);
    digitalWrite(LED_PIN, LOW);
    Serial.begin(9600);
    Serial.println("setup is done");
}

int prevMillis = 0;
int led_state = LOW;

void loop()
{
      while(Serial.available()){
        String command = Serial.readString();
        command.trim();
        Serial.println(command);
        if(command == "on")
            digitalWrite(LED_PIN, HIGH);
        else if(command == "off")
            digitalWrite(LED_PIN, LOW);
        else if(command == "get"){
            int state = digitalRead(BUTTON_PIN);
            char buf[50];
            sprintf(buf, "%s: %d", "state is", state);
            Serial.println(buf);
        }
        else if(command == "blink") 
          while(Serial.available() == 0){
            if (millis() - prevMillis >= 200){
              prevMillis = millis();
            
            if (led_state == LOW) {
              led_state = HIGH;
            } else {
              led_state = LOW;
            }
            digitalWrite(LED_PIN, led_state);
          }
      }
    }
}