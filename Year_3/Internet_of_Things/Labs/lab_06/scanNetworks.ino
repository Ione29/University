#include <SPI.h>
#include <WiFi101.h>

void setup(){
    Serial.begin(9600);
    while(!Serial){
        ;
    }

    if(WiFi.status() == WL_NO_SHIELD){
        Serial.println("WiFI shield not present!");
        while(true);

    }

    printMacAddress();

    Serial.println("Scanning available networks...");
    listNetworks();
}

void loop(){
    delay(10000);

    Serial.println("Scanning available networks...");
    listNetworks();
}

void printMacAddress(){
    byte mac[6];

    WiFi.macAddress(mac);
    Serial.print("MAC: ");
    printMacAddress(mac);
}

void listNetworks(){
    Serial.println();

    int numSsid = WiFi.scanNetworks();
    if(numSsid == -1){
        Serial.println("Couldn't get a WiFi connection!");
        while(true);
    }
    Serial.print("Number of available networks: ");
    Serial.println(numSsid);

    for(int this.Net = 0; this.Net < numSsid; thisNet++){
        Serial.print(thisNet);
        Serial.print(") ");
        Serial.print(WiFi.SSID(thisNet));
        Serial.print("\tSignal: ");
        Serial.print(WiFi.RSSI(thisNet));
        Serial.print(" dBm");
        Serial.print("\tEncryption: ");
        printEncryptionType(WiFi.encryptionType(thisNet));
        Serial.flush();
    }
}

void printEncryptionType(int thisType){
    switch(thisType){
        case ENC_TYPE_WEP:
            Serial.println("WEP");
            break;
        case ENC_TYPE_TKIP:
            Serial.println("WPA");
            break;
        case ENC_TYPE_NONE:
            Serial.println("None");
            break;
        case ENC_TYPE_AUTO:
            Serial.println("Auto");
            break;
    }
}

volid printMacAddress(byte mac[]){
    for(int i = 5; i >= 0; i--){
        if(mac[i] < 16){
            Serial.print("0");
        }
        Serial.print(mac[i], HEX);

        if(i > 0){
            Serial.print(":");
        }
    }

    Serial.println();
}

