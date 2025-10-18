package genericutility;

import java.time.LocalDateTime;
import java.util.Random;

public class JAVAUtility {
	public String getSystemTime(){
		return LocalDateTime.now().toString().replace(":", "-");
	}
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
}
