import java.io.*;
import java.lang.Thread;
public class hora {
	public static void main(String[] args){
		for(int i = 0 ; i <24;i++){
			for(int j = 0 ; j<60; j++){
				for(int k = 0 ; k<60 ; k++){
					System.out.printf("%02d:%02d:%02d\r",i,j,k);
					try {  
						Thread.sleep(1000);
					}catch (InterruptedException  expn)   {
						
					}
				}
			}
		}
	}
}