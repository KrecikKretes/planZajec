package com.zawisza.planZajec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DownloadPage {

    public static void main(String[] args) throws IOException {



        String grupName;
        int idGrupName;



        // Make a URL to the web page
        URL url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/o1.html");
        //URL url = new URL("https://podzial.mech.pk.edu.pl/stacjonarne/html/plany/n25.html");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            //List<String> list = new ArrayList<>();
            String[] tydzien = {"Pon : ", "Wt : ", "Sr : ", "Czw : ", "Pt : "};



            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                //<span class="tytulnapis">14K1</span></td></tr></table>
                if(line.contains("<span class=\"tytulnapis\">")){
                    line = line.replaceAll("<.*?>", "");
                    System.out.println(line);
                    grupName = line;

                    String sqlSelectAllPersons = "SELECT id FROM grupy";
                    String connectionUrl = "jdbc:mariadb://localhost:3306/planzajec";


                    //Class.forName("com.mysql.jdbc.Driver");
                    try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
                         PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
                         ResultSet rs = ps.executeQuery()) {

                        System.out.println("Connect to database : success");
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            // do something with the extracted data...
                            System.out.println("Znalezione id : " + id);
                        }
                    } catch (SQLException e) {
                        // handle the exception
                        System.out.println("Connect to database : failed");
                        System.out.println(e);
                    }



                    System.out.println("----------------");
                    System.out.println("Nieparzysty tydzień");
                    continue;
                }

                if(line.contains("<td class=\"g\">")) {
                    line = line.replaceAll("<.*?>", "");
                    System.out.println(line);

                    for (int i = 0; i < 5; i++) {
                        line = br.readLine();
                        if (line.contains("&nbsp;")) {
                            //System.out.println();
                            continue;
                        }
                        line = line.replaceAll("<.*?>", "");
                        line = line.replaceAll("-n", "-n ");

                        while (line.contains("-n")) {
                            //System.out.println(line);
                            String text = "";
                            if (line.indexOf("-n") > 0) {
                                //System.out.println("Posiada -n");
                                text = line.substring(0, line.indexOf("-n") + 2);
                                line = line.substring(line.indexOf("-n") + 2);
                            //} else {
                                //if(line.indexOf("-p") > 0){
                                //    System.out.println("Posiada -p");
                                //    text = line.substring(0, line.indexOf("-p") + 2);
                                //    line = line.substring(line.indexOf("-p") + 2, line.length());
                                //}
                            }

                            System.out.println(tydzien[i] + "  " + text);
                        }
                    }

                    System.out.println();
                }
            }
        }


        con = url.openConnection();
        is = con.getInputStream();

        try(BufferedReader br2 = new BufferedReader(new InputStreamReader(is))) {
            String line;

            //List<String> list = new ArrayList<>();
            String[] tydzien = {"Pon : ", "Wt : ", "Sr : ","Czw : ", "Pt : "};


            System.out.println("----------------");
            System.out.println("Parzysty tydzień");
            // read each line and write to System.out
            while ((line = br2.readLine()) != null) {
                //System.out.println(line);
                if(line.contains("<td class=\"g\">")){
                    line = line.replaceAll("<.*?>", "");
                    System.out.println(line);

                    for(int i = 0; i < 5; i++){
                        line = br2.readLine();
                        if(line.contains("&nbsp;")){
                            //System.out.println();
                            continue;
                        }
                        line = line.replaceAll("<.*?>", "");
                        line = line.replaceAll("-n", "-n ");

                        while(line.contains("-p")){
                            //System.out.println(line);
                            String text = "";
                            if(line.indexOf("-p") > 0){
                                //System.out.println("Posiada -p");
                                if(line.indexOf("-n") > 0){
                                    text = line.substring(line.indexOf("-n") + 2, line.indexOf("-p") + 2);
                                }else{
                                    text = line.substring(0, line.indexOf("-p") + 2);
                                }
                                //text = line.substring(0, line.indexOf("-p") + 2);
                                line = line.substring(line.indexOf("-p") + 2);
                            }

                            System.out.println(tydzien[i] + "  " + text);
                        }
                    }

                    System.out.println();
                }
            }
        }
    }
}