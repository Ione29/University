#include <SPI.h>
#include <WiFi101.h>

char ssid[] = "DUBA FILAJ D.I.I.C.O.T. 177013";
char pass[] = "qweasdzxc";

int keyIndex = 0;
int status = WL_IDLE_STATUS;
WiFiServer server(80);

WiFiClient client = server.available();

int ledPin = 2;

void setup(){
    Serial.begin(9600);
    pinMode(ledPin, OUTPUT);
    while(!Serial);

    enable_WiFi();
    connect_WiFi();

    server.begin();
    printWifiStatus();
}

void loop(){
    client = server.available();

    if(client){
        printWeb();
    }
}

void printWifiStatus(){
    Serial.print("SSID: ");
    Serial.println(WiFi.SSID());

    IPAddress ip = WiFi.localIP();
    Serial.print("IP Address: ");
    Serial.println(ip);

    long rssi = WiFi.RSSI();
    Serial.print("Signal Strength (RSSI): ");
    Serial.print(rssi);
    Serial.println(" dBm");
}

void enable_WiFi(){
    String fv = WiFi.firmwareVersion();

    if(fv < "1.0.0"){
        Serial.println("Upgrade the firmware");
    }
}

void connect_WiFi(){
    while(status != WL_CONNECTED){
        Serial.print("Attempting to connect to SSID: ");
        Serial.println(ssid);

        status = WiFi.begin(ssid, pass);
    }

    delay(10000);
}

void printWeb(){
    if(client){
        Serial.println("New Client");
        String currentLine = "";
        while(client.connected()){
            if(client.available()){
                char c = client.read();
                Serial.write(c);

                if(c == '\n'){
                    if(currentLine.length() == 0){
                        client.println("HTTP/1.1 200 OK");
                        client.println("Content-type:/html");
                        client.println();

                        client.print("Click<a href=\"/H\">here</a> to turn the LED on<br>");
                        client.print("Click<a href=\"/L\">here</a> to turn the LED off<br>");

                        int ledReading = analogRead(A1);
                        client.print("Random reading from analog pin:");
                        client.print(ledReading);

                        client.println();
                        break;
                    }
                    else{
                        currentLine = "";
                    }
                }
                else if(c != '\r'){
                    currentLine += c;
                }

                if(currentLine.endsWith("GET /H")){
                    digitalWrite(ledPin, HIGH);
                }
                if(currentLine.endsWith("Get /L")){
                    digitalWrite(ledPin, LOW);
                }
            }
        }

        client.stop();
        Serial.println("Client disconnected");
    }
}