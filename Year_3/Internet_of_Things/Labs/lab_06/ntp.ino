#include <SPI.h>
#include <WiFi101.h>
#include <WiFiUdp.h>

int status = WL_IDLE_STATUS;
char ssid[] = YOUR_SSID_HERE;
char pass[] = YOUR_PASSWORD_HERE;

int keyIndex = 0;

unsigned int localPort = 2390;

IPAddress timeServer(129, 6, 15, 28);

const int NTP_PACKET_SIZE = 48;

byte packetBuffer[NTP_PACKET_SIZE];

WiFiUDP Udp;

void setup(){
    Serial.begin(9600);

    while(!Serial){}

    if(WiFi.status() == WL_NO_SHIELD){
        Serial.println("The WiFi shield is not present!");
        while(true);
    }

    while(status != WL_CONNECTED){
        Serial.print("Attempting to connect to SSID");
        Serial.println(ssid);
        status = WiFi.begin(ssid, pass);
        delay(10000);
    }

    Serial.println("Connected to WiFi successfully");
    printWiFiStatus();

    Serial.println("\nStarting connection to server...");
    Udp.begin(localPort);
}

void loop(){
    sendNTPpacket(timeServer);

    delay (1000);

    if(Udp.parsePacket()){
        Serial.println("Packet received!");

        Udp.read(packetBuffer, NTP_PACKET_SIZE);

        unsigned long highWord = word(packetBuffer[40], packetBuffer[41]);
        unsigned long lowWord = word(packetBuffer[42], packetBuffer[43]);

        unsigned long secsSince1900 = highWord << 16 | lowWord;
        Serial.print("Seconds since Jan 1 1900 = ");
        Serial.println(secsSince1900);

        Serial.print("Unix time = ");
        const unsigned long seventyYears = 2208988800UL;

        unsigned long epoch = secsSince1900 - seventyYears;

        Serial.println(epoch);

        Serial.print("The UTC time is ");
        Serial.print((epoch % 86400L) / 3600);
        Serial.print(':');
        
        if((( epoch % 3600 ) / 60 ) < 10)
            Serial.print('0');

        Serial.print((epoch % 3600) / 60);
        Serial.print(':');

        if((epoch % 60) < 10)
            Serial.print('0');

        Serial.println(epoch % 60);
    }

    delay(10000);
}

unsigned long sendNTPpacket(IPAddress& address){
    memset(packetBuffer, 0, NTP_PACKET_SIZE);

    packetBuffer[0] = 0b11100011;
    packetBuffer[1] = 0;
    packetBuffer[2] = 6;
    packetBuffer[3] = 0xEC;

    packetBuffer[12] = 49;
    packetBuffer[13] = 0x4E;
    packetBuffer[14] = 49;
    packetBuffer[15] = 52;
    
    Udp.beginPacket(address, 123);
    Udp.write(packetBuffer, NTP_PACKET_SIZE);
    Udp.endPacket();
}

void printWiFiStatus(){
    Serial.print("SSID: ");
    Serial.println(WiFi.SSID());

    IPAddress ip = WiFi.localIP();
    Serial.print("IP Address: ");
    Serial.println(ip);

    long rssi = WiFi.RSSI();
    Serial.print("Signal strength (RSSI): ");
    Serial.print(rssi);
    Serial.println( "dBm");
}