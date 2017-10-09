const int buttonPin = 2;
int counter = 0;
int buttonState;
int lastButtonState= LOW;

unsigned long lastDebounceTime = 0;
unsigned long debounceDelay = 50;

void buttonPressed() {
  Serial.println("Interrupt");
  counter++;
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed,CHANGE);
  Serial.begin(9600);
 
}

void loop() {
  for(int i=0;i<100;i++) {
    Serial.println(i);
    Serial.print("Button Counter");
  Serial.println(counter);
    delay(1000);
  }
}

