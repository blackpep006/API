package task9.threadlocal;

import task9.LocalThread;

public class ClassC {

	public String getDataFromDB() {
		//Activity
		return LocalThread.getValue();
	}

}
