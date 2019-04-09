package MapLogic;

import java.io.IOException;

public class Driver {

	String[][] driverInfo = new String[10][10];
	FileReaderUtils loader = new FileReaderUtils();

	public Driver() {

		try {
			this.driverInfo = loader.readDriverFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
