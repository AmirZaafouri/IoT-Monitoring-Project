#include "FirebaseESP32.h"	// BIB ESP32 library
#include <WiFi.h>
#include <DHT.h>		// Install DHT11 Library and Adafruit Unified Sensor Library


#define FIREBASE_HOST "last-version-6dd41-default-rtdb.firebaseio.com"                          // the project name address from firebase id
#define FIREBASE_AUTH "395lAzGInnaxHA7ufNDYunMXvV1Yt1hVV7Rx2tkE"            // the secret key generated from firebase
#define WIFI_SSID "Wifi-FSM"
#define WIFI_PASSWORD "12457894"

#define DHTPIN 21		// Connect Data pin of DHT to D4
#define MVT 5   // Connect Data pin of capteur Mvt
int led =2;			// Connect LED to D2
int compteur=0;     
int Gas_analog = 33;   
int Gas_digital = 25; 
int val =0 ; //initialisation de capteur de mvt


   #define DHTTYPE    DHT11
  DHT dht(DHTPIN, DHTTYPE);

//Define FirebaseESP32 data object
FirebaseData firebaseData ;
FirebaseJson json;


void setup()
{
  pinMode(5,INPUT); //capteur de MVT
  pinMode(Gas_analog, INPUT);
  Serial.begin(115200);

  dht.begin();
  pinMode(led,OUTPUT);
  
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);
  Serial.println("ESP3-------CONNECTING");

}

void sensorUpdate(){
         Serial.println("MVT VALUE");
         Serial.println(digitalRead(MVT));
         val=digitalRead(MVT);
         
         if (val!=0){
         delay(500);
         Firebase.setFloat(firebaseData, "SALLLE1/MOUVMENT/value", val);
        }
        
  float h = dht.readHumidity();
 //  Read temperature as Celsius (the default)
  float t = dht.readTemperature();
  // Read temperature as Fahrenheit (isFahrenheit = true)
  float f = dht.readTemperature(true);

  // Check if any reads failed 
  if (isnan(h) || isnan(t) || isnan(f)) {
    Serial.println(F("Failed to read from DHT sensor!"));
    return;
  }

  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print(F("%  Temperature: "));
  Serial.print(t);
  Serial.print(F("C  ,"));
  Serial.print(f);
  Serial.println(F("F  "));

  if (Firebase.setFloat(firebaseData, "SALLLE1/lecture/temp", t))
  {
    Serial.println("PASSED");
    
  }
  else
 {
    Serial.println("FAILED");
    
  }

  if (Firebase.setFloat(firebaseData, "SALLLE1/lecture/hum", h))
  {
    Serial.println("PASSED");
  }
  else
  {
    Serial.println("FAILED");
    
  }
}

      void GAZ(){ 
        Serial.println("MVT VALUE");
        Serial.println(digitalRead(MVT));
       val=digitalRead(MVT);
       if (val!=0){
       delay(500);
       Firebase.setFloat(firebaseData, "SALLLE1/MOUVMENT/value", val);
        }
       int gassensorAnalog = analogRead(Gas_analog);
       int gassensorDigital = analogRead(Gas_digital);
          Firebase.setFloat(firebaseData, "SALLLE1/gaz/value",gassensorAnalog );
          Serial.print("Gas Sensor: ");
          Serial.print(gassensorAnalog);
          Serial.print("\t");
          Serial.print("Gas Class: ");
          Serial.print(gassensorDigital);
          Serial.print("\t");
          Serial.print("\t");
 
          if (gassensorAnalog > 1000) {
           Serial.println("Gas");
           digitalWrite (led, HIGH) ; //GAZ
           delay(500);
           digitalWrite (led, LOW) ;//no GAZ
           Firebase.setFloat(firebaseData, "SALLLE1/gaz/detection", 1);
            }
            else {
            Serial.println("No Gas");
             Firebase.setFloat(firebaseData, "SALLLE1/gaz/detection", 0);
                  }
                  }
                      void COMPTEUR (){ //compteur
                       compteur=compteur+1;
                       delay(500);
                       Firebase.setFloat(firebaseData, "SALLLE1/lecture/time", compteur);
                       if(compteur==60)
                       compteur=0;
                                    }
void loop() {
 

   //  add capeur de MVT:
  Serial.println("MVT VALUE");
  Serial.println(digitalRead(MVT));
  val=digitalRead(MVT);
  delay(500);
  Firebase.setFloat(firebaseData, "SALLLE1/MOUVMENT/value", val);

  GAZ();
  sensorUpdate();
  COMPTEUR ();

 

 
  
}
  
