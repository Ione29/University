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

    mqttClient.onMessage(onMqttMessage);
    Serial.print("Subscribing to topic: ");
    Serial.println(topic);
    Serial.print();

    mqttClient.subscribe(topic);
    mqttClient.subscribe(topic2);
    mqttClient.subscribe(topic3);

    Serial.print("Topic: ");
    Serial.println(topic);

    Serial.print("Topic: ");
    Serial.println(topic2);
    
    Serial.print("Topic: ");
    Serial.println(topic3);

    Serial.println();
}

void loop(){
    mqttClient.poll();
}

void onMqttMessage(int messageSize){
    Serial.println("Received a message with topic: ");
    Serial.print(mqttClient.messageTopic());
    Serial.print(", length ");
    Serial.print(messageSize);
    Serial.println(" bytes;");

    while(mqttClient.available())
        Serial.print((char)mqttClient.read());
    
    Serial.println();
    Serial.println();
}