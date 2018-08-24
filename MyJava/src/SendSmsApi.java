import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random; 
public class SendSmsApi{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        // TODO code application logic here
    	String mobno="8145187247";
    	String pass="priyanka@123";
    	String to="7750856955";
    	String key="bisenEmNtp8oxBJveS7aG4lQzgM9qu";
    	Random random=new Random();
    	int n=random.nextInt((99999 - 10000) + 1) + 10000;
    	String msg=String.valueOf(n);
        try {
            URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile="+mobno+"&Password="+pass+"&Message="+msg+"&To="+to+"&Key="+key+"");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response="";
            while ((i = stream.read()) != -1) {
                response+=(char)i;
            }
            if(response.contains("success")){
                System.out.println("Successfully send SMS");
                //your code when message send success
            }else{
                System.out.println(response);
                //your code when message not send
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
                            