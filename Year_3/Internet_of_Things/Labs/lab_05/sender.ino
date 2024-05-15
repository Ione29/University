#include <ArduinoMqttClient.h>
#include <WiFi101.h>
#include "arduino_secrets.h"

WiFiClient wifiClient;
MqttClient mqttClient(wifiClient);
const char broker[] = "test.mosquitto.org";
int port = 1883;
const cahr topic[] = "real_unique_topic";
const char topic2[] = "real_unique_topic_2";
const char topic3[] = "real_unique_topic_3";

const long interval = 800;
unsigned long previousMillis = 0;
int count = 0;

void setup(){
    Serial.begin(9600);
    while(!Serial){
        ;
    }

    Serial.print("Attempting to connect to WPA SSID: ");
    Serial.println(ssid);
    while(WiFi.begin(ssid, pass) != WL_CONNECTED){
        Serial.print(".");
        delay(5000);
    }

    Serial.println("You're connected to the network!");
    Serial.println();
    Serial.println(broker);

    if(!mqttCleint.connect(broker, port)){
        Serial.print("MQTT connection failed! Error code = ");
        Serial.println(mqttClient.connectError());
        while(true);
    }

    Serial.println("You're connected to the MQTT broker!");
    Serial.println();
}

void loop(){
    mqttClient.pool();
    unsigned long currentMillis = millis();
    if(currentMillis - previousMillis >= interval){
        previousMillis = currentMillis;
        int Rvalue = analogRead(A0);
        int Rvalue2 = analogRead(A1);
        int Rvalue3 = analogRead(A2);

        Serial.print("Sending message to topic: ");
        Serial.println(topic);
        Serial.println(Rvalue);
        
        Serial.print("Sending message to topic: ");
        Serial.println(topic2);
        Serial.println(Rvalue2);
        
        Serial.print("Sending message to topic: ");
        Serial.println(topic3);
        Serial.println(Rvalue3);

        mqttClient.beginMessage(topic);
        mqttClient.print(Rvalue);
        mqttClient.endMessage();
        
        mqttClient.beginMessage(topic2);
        mqttClient.print(Rvalue2);
        mqttClient.endMessage();
        
        mqttClient.beginMessage(topic3);
        mqttClient.print(Rvalue3);
        mqttClient.endMessage();
    }
}