package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Credentials;
import me.mlhmz.sqlApplication.objects.Orders;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class sqlCredentials {

    public static void get() {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\data.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; values.length > i; i++) {
                    if(values[i].equals("null")){
                        values[i] = "";
                    }
                }
                System.out.println(values[3]);
                Credentials credentials = new Credentials(values[0], values[1], values[2], values[3]);
                Database.credentialList.add(credentials);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
