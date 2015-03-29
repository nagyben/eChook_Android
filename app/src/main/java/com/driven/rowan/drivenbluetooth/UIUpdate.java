package com.driven.rowan.drivenbluetooth;

/**
 * Created by BNAGY4 on 26/03/2015.
 */

/* This class should only be used by posting to the UI thread */
public class UIUpdate extends Thread {
	private volatile boolean stopWorker = false;
	public void run() {

			// code to update UI elements
			// hopefully this is inherently thread safe

		// Voltage
		try {
			MainActivity.myVoltage.setText(Global.Volts.get(Global.Volts.size() - 1).get(1).toString());
			MainActivity.myVoltsDataCount.setText(Integer.toString(Global.Volts.size()));
		} catch (Exception e) {
			e.toString();
		}

		// Speed
		try {
			MainActivity.mySpeed.setText(Global.SpeedMPH.get(Global.SpeedMPH.size() - 1).get(1).toString());
			MainActivity.mySpeedDataCount.setText(Integer.toString(Global.SpeedMPH.size()));
		} catch (Exception e) {
			e.toString();
		}

		// Current
		try {
			MainActivity.myCurrent.setText(Global.Amps.get(Global.Amps.size() - 1).get(1).toString());
			MainActivity.myAmpsDataCount.setText(Integer.toString(Global.Amps.size()));
		} catch (Exception e) {
			e.toString();
		}
	}

	public void cancel() {
		this.stopWorker = true;
	}
}
