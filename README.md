# IoT-Monitoring-Project  
**IoT System for Status Monitoring via Android Application**

## 📖 Project Description
This project is a **real-time IoT monitoring system** utilizing an ESP32 microcontroller integrated with sensors to track and report system parameters. Designed for flexibility and efficiency, it transmits data to an **Android application** for easy, on-the-go monitoring.

### 🎯 Purpose
The project is intended for applications where monitoring of environmental conditions or system health is crucial, such as smart home systems, industrial setups, or environmental tracking. 

## 🚀 Features
- **Real-Time Data Monitoring**: View system status on your Android device as data updates in real-time.
- **Sensor Integration**: Equipped with an ESP32 board connected to sensors (e.g., temperature, humidity, gas detection) to collect and transmit data.
- **User-Friendly Interface**: Android application designed with intuitive data visualization and easy navigation.
- **Custom Alerts**: (Planned) Configure alerts based on threshold values to stay informed about any critical changes.

## 🛠️ Tech Stack
- **Hardware**: ESP32 microcontroller, sensors (temperature, humidity, gas, motion detection)
- **Android Development**: Java
- **Communication Protocol**: HTTP (customizable for MQTT or Firebase)
- **Backend**: Firebase (optional, for data storage and notifications)

## ⚙️ Setup and Installation

### Prerequisites
- ESP32 microcontroller and compatible sensors
- Android Studio (for building the Android app)
- Firebase account (if using Firebase for backend services)

### Steps
1. **ESP32 Setup**:
   - Connect sensors to the ESP32 board.
   - Flash the ESP32 with the provided code in the `ESP32_Code` directory.
   
2. **Android App Setup**:
   - Clone this repository:  
     ```bash
     git clone https://github.com/Amir0055/IoT-Monitoring-Project.git
     ```
   - Open the project in Android Studio.
   - Configure Firebase or MQTT settings as needed in the code.
   - Build and run the app on an Android device or emulator.

3. **Run and Test**:
   - Power on the ESP32 and ensure it is connected to Wi-Fi.
   - Open the Android app, and you should start seeing data from the ESP32 sensors in real time.

## 📂 Project Structure
- **MachinTalks/**: Root directory containing the project files.
- **src/**: Contains all source code for the Angular frontend.
- **assets/**: Includes images and other assets used in the project.
- **README.md**: Project overview and instructions.
- **Backend Repository**: The backend service is hosted in a separate repository: [MachinTalksBackend](https://github.com/mounakhattat/MachinTalksBackend).

## 📷 Screenshots
![Performance Testing Interface](https://github.com/user-attachments/assets/22ece27d-6eb4-49cd-a3e3-5ade46ee06ac)  
*Performance Testing Interface*

![Report Generation](https://github.com/user-attachments/assets/8915d8a8-fa0c-4416-aca7-3234b5560bd9)  
*Report Generation View*

![Gas and Motion Detection](https://github.com/user-attachments/assets/7e45d181-30bd-4d84-98a8-d15b1318d41b)  
*Gas and Motion Detection Screen*

## 📝 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
