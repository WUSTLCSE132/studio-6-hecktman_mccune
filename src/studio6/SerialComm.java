package studio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jssc.*;

public class SerialComm {

	SerialPort port;
	public  byte[] intake ;
	private  boolean debug;  // Indicator of "debugging mode"

	// This function can be called to enable or disable "debugging mode"
	public static void main(String[] args) throws SerialPortException {
		SerialComm newPort = new SerialComm("/dev/cu.usbserial-DN035W8Q");
		while (true){
			if (available()==true){
				char character = (char)intake[0];
				System.out.print(character);

			}
		}

		void setDebug(boolean mode) {
			debug = mode;
		}	




		public byte[] getIntake() {
			return intake;
		}
		public void setIntake(byte[] intake) {
			this.intake = intake;
		}
		// Constructor for the SerialComm class
		public SerialComm(String name) throws SerialPortException {
			port = new SerialPort(name);		
			port.openPort();
			port.setParams(SerialPort.BAUDRATE_9600,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			debug = false; // Default is to NOT be in debug mode
		}

		// TODO: Add writeByte() method from Studio 5
		void writeByte(String send) {
			//char byteSender [] = new char [send.length()];
			for(int i = 0; i<send.length(); i++){
				try {
					port.writeByte((byte) send.charAt(i));
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}



		// TODO: Add available() method
		static boolean available() {
			try {
				if(port.getInputBufferBytesCount()>0){
					return true;
				}
				else if(port.getInputBufferBytesCount()==0){
					return false;
				}

			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return debug;
		}

		static // TODO: Add readByte() method	
		byte[] readByte(){

			try {
				intake = port.readBytes(port.getInputBufferBytesCount());
				return intake;
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return intake;
		}

		// TODO: Add a main() method



	}

