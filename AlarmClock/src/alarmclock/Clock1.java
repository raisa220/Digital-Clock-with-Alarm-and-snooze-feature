package alarmclock;
import java.io.*;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Thread.sleep;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Clock1 extends JFrame {

    private Container c;
    private Font f, f1, f2, f3, f4, f5,f6;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7,jLabel10, jLabel8,jLabel9,imgLabel;
    private ImageIcon icon;
    private ImageIcon img, img2, img3;
    private JTextField tfh, tfm, tfam, tfh2, tfm2, tfam2, tfh3, tfm3, tfam3;
    private JButton btnOk, btndlt,btnOk2, btndlt2,btnOk3 ,btndlt3;

    public int temp_h, temp_m,temp_h2, temp_m2,temp_h3, temp_m3;
    public String temp_am,temp_am2,temp_am3;
    private int flag = 1;
    private int flag2 = 1;
    private int flag3 = 1;

    public String alarmhour, alarmminute, alarmampm , alarmhour2, alarmminute2, alarmampm2, alarmhour3, alarmminute3, alarmampm3;

    int snooze_hour = 0;
    int snooze_minute = 0;


    Clock1() {
        initComponents();
        currentTime();

    }

    public static final String path = "E:\\Clock with alarm\\AlarmClock\\alarmbeep.mp3";

    MP3Player mp3 = new MP3Player(new File(path));

    public void initComponents() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(150, 170, 540, 540);
        this.setTitle("Alarm Clock by Group 1");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Digital-7 Mono", Font.BOLD, 46);
        f3 = new Font("Digital-7", Font.PLAIN, 70);
        f4 = new Font("Tahoma", Font.BOLD, 29);
        f5 = new Font("Tahoma", Font.BOLD, 15);
        f6 = new Font("Tahoma", Font.BOLD, 22);

        icon = new ImageIcon(getClass().getResource("Miscellaneous-Icon.jpg"));
        this.setIconImage(icon.getImage());

        img = new ImageIcon(getClass().getResource("alarm.jpg"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(30, 225, img.getIconWidth(), 40);
        c.add(imgLabel);



        img2 = new ImageIcon(getClass().getResource("alarm.jpg"));
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(30, 290, img.getIconWidth(), 40);
        c.add(imgLabel);



        img3 = new ImageIcon(getClass().getResource("alarm.jpg"));
        imgLabel = new JLabel(img3);
        imgLabel.setBounds(30, 355, img.getIconWidth(), 40);
        c.add(imgLabel);

        //TIME Running
        jLabel1 = new JLabel();
        jLabel1.setBounds(60, 15, 500, 130);
        jLabel1.setFont(f3);
        jLabel1.setForeground(new Color(0, 204, 51));
        c.add(jLabel1);

        //AMPM
        jLabel3 = new JLabel();
        jLabel3.setBounds(390, 30, 100, 110);
        jLabel3.setFont(f2);
        jLabel3.setForeground(new Color(0, 204, 51));
        c.add(jLabel3);

        //Date
        jLabel2 = new JLabel();
        jLabel2.setBounds(140, 140, 260, 50);
        jLabel2.setFont(f4);
        jLabel2.setForeground(new Color(0, 204, 51));
        c.add(jLabel2);

        //day
        jLabel4 = new JLabel();
        jLabel4.setBounds(330, 140, 230, 50);
        jLabel4.setFont(f4);
        jLabel4.setForeground(new Color(0, 204, 51));
        c.add(jLabel4);

        //current time label
        jLabel10 = new JLabel("Current Time");
        jLabel10.setBounds(160, 3, 260, 50);
        jLabel10.setFont(f6);
        jLabel10.setForeground(new Color(0, 204, 51));
        c.add(jLabel10);




        //Text field1
        tfh = new JTextField();
        tfh.setBounds(100, 225, 50, 40);
        tfh.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfh.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfh);

        tfh2 = new JTextField();
        tfh2.setBounds(100, 290, 50, 40);
        tfh2.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfh2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfh2);



        tfh3 = new JTextField();
        tfh3.setBounds(100, 355, 50, 40);
        tfh3.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfh3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfh3);



        jLabel5 = new JLabel("Hour");
        jLabel5.setBounds(105, 180, 230, 50);
        jLabel5.setFont(f5);
        jLabel5.setForeground(new Color(0, 204, 51));
        c.add(jLabel5);

        tfm = new JTextField();
        tfm.setBounds(165, 225, 50, 40);
        tfm.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfm.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfm);


        tfm2 = new JTextField();
        tfm2.setBounds(165, 290, 50, 40);
        tfm2.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfm2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfm2);

        tfm3 = new JTextField();
        tfm3.setBounds(165, 355, 50, 40);
        tfm3.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfm3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfm3);


        jLabel6 = new JLabel("Min");
        jLabel6.setBounds(175, 180, 230, 50);
        jLabel6.setFont(f5);
        jLabel6.setForeground(new Color(0, 204, 51));
        c.add(jLabel6);



        tfam = new JTextField();
        tfam.setBounds(230, 225, 50, 40);
        tfam.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfam.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfam);

        tfam2 = new JTextField();
        tfam2.setBounds(230, 290, 50, 40);
        tfam2.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfam2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfam2);

        tfam3 = new JTextField();
        tfam3.setBounds(230, 355, 50, 40);
        tfam3.setFont(new Font("Tahoma", Font.BOLD, 20));
        tfam3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tfam3);




        jLabel7 = new JLabel("AM/PM");
        jLabel7.setBounds(230, 180, 230, 50);
        jLabel7.setFont(f5);
        jLabel7.setForeground(new Color(0, 204, 51));
        c.add(jLabel7);

        jLabel8 = new JLabel("Alarms");
        jLabel8.setBounds(30, 180, 230, 50);
        jLabel8.setFont(f5);
        jLabel8.setForeground(new Color(0, 204, 51));
        c.add(jLabel8);

        jLabel9 = new JLabel("Date:");
        jLabel9.setBounds(30, 140, 230, 50);
        jLabel9.setFont(f4);
        jLabel9.setForeground(new Color(0, 204, 51));
        c.add(jLabel9);




        //Buttons design
        btnOk = new JButton("Ok");
        btnOk.setBounds(295, 225, 60, 40);
        btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btnOk);

        btndlt = new JButton("Delete");
        btndlt.setBounds(370, 225, 100, 40);
        btndlt.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btndlt);



        btnOk2 = new JButton("Ok");
        btnOk2.setBounds(295, 290, 60, 40);
        btnOk2.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btnOk2);

        btndlt2 = new JButton("Delete");
        btndlt2.setBounds(370, 290, 100, 40);
        btndlt2.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btndlt2);




        btnOk3 = new JButton("Ok");
        btnOk3.setBounds(295, 355, 60, 40);
        btnOk3.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btnOk3);

        btndlt3 = new JButton("Delete");
        btndlt3.setBounds(370, 355, 100, 40);
        btndlt3.setFont(new Font("Tahoma", Font.BOLD, 16));
        c.add(btndlt3);






        //Button Ok
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                temp_h = Integer.parseInt(tfh.getText());
                temp_m = Integer.parseInt(tfm.getText());
                alarmhour =Integer.toString(temp_h);
                alarmminute = Integer.toString(temp_m);

                temp_am = tfam.getText();
                alarmampm = temp_am;
                flag = 1;

                try{

                    FileWriter alarmfile = new FileWriter("Alarmfile.txt", true);
                    //alarmfile.write(jLabel2.setText(day + "-" + month + "-" + year))

                    if(alarmhour.equals(null) )
                    {
                        System.out.println("Couldn't save");

                    }
                    else {
                        alarmfile.write(""+alarmhour+ ":"+alarmminute+alarmampm );
                        alarmfile.write(System.getProperty("line.separator"));

                        alarmfile.close();
                        System.out.println("Successfully saved to file");
                    }


                }catch(IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }

                JOptionPane.showMessageDialog(null, "Alarm is set ");
            }
        });




        //Button Ok2
        btnOk2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                temp_h2 = Integer.parseInt(tfh2.getText());
                temp_m2 = Integer.parseInt(tfm2.getText());
                alarmhour2 =Integer.toString(temp_h2);
                alarmminute2 = Integer.toString(temp_m2);

                temp_am2 = tfam2.getText();
                alarmampm2 = temp_am2;
                flag2 = 1;

                try{

                    FileWriter alarmfile = new FileWriter("Alarmfile.txt", true);

                    if(alarmhour.equals(null) )
                    {
                        System.out.println("Couldn't save");

                    }
                    else {
                        alarmfile.write(""+alarmhour2+ ":"+alarmminute2+alarmampm2);
                        alarmfile.write(System.getProperty("line.separator"));
                        alarmfile.close();
                        System.out.println("Successfully saved to file");
                    }


                }catch(IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }

                JOptionPane.showMessageDialog(null, "Alarm is set ");
            }
        });



        //Button Ok3
        btnOk3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                temp_h3 = Integer.parseInt(tfh3.getText());
                temp_m3 = Integer.parseInt(tfm3.getText());
                alarmhour3 =Integer.toString(temp_h3);
                alarmminute3 = Integer.toString(temp_m3);

                temp_am3 = tfam3.getText();
                alarmampm3 = temp_am3;
                flag3 = 1;

                try{

                    FileWriter alarmfile = new FileWriter("Alarmfile.txt", true);

                    if(alarmhour.equals(null) )
                    {
                        System.out.println("Couldn't save");

                    }
                    else {
                        alarmfile.write(""+alarmhour3+ ":"+alarmminute3+alarmampm3);
                        alarmfile.write(System.getProperty("line.separator"));
                        alarmfile.close();
                        System.out.println("Successfully saved to file");
                    }


                }catch(IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }

                JOptionPane.showMessageDialog(null, "Alarm is set ");
            }
        });




        //delete1--------
        btndlt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                flag = 0;
                tfh.setText("");
                tfm.setText("");
                tfam.setText("");
                JOptionPane.showMessageDialog(null, "Alarm reset");
                File tempFile = new File("myTempFile.txt");
                try{
                    File f = new File("E:\\Clock with alarm\\AlarmClock\\Alarmfile.txt");

                    if(f.exists() && !f.isDirectory()) {
                        BufferedReader reader = new BufferedReader(new FileReader(f));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String lineToRemove = ""+alarmhour+ ":"+alarmminute+alarmampm;
                        String currentLine;

                        while((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            if(trimmedLine.equals(lineToRemove)) continue;
                            writer.write(currentLine + System.getProperty("line.separator"));
                        }
                        writer.close();
                        reader.close();
                        f.delete();


                        Path oldFile
                                = Paths.get("E:\\Clock with alarm\\AlarmClock\\myTempFile.txt");

                        try {
                            Files.move(oldFile, oldFile.resolveSibling(
                                    "Alarmfile.txt"));
                            System.out.println("Deleted successfully");
                        }
                        catch (IOException e) {
                            System.out.println("operation failed");
                        }


                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }




            }
        });

        //delete2--------
        btndlt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                flag2 = 0;
                tfh2.setText("");
                tfm2.setText("");
                tfam2.setText("");
                JOptionPane.showMessageDialog(null, "Alarm reset");


                File tempFile = new File("myTempFile.txt");
                try{
                    File f = new File("E:\\Clock with alarm\\AlarmClock\\Alarmfile.txt");

                    if(f.exists() && !f.isDirectory()) {
                        BufferedReader reader = new BufferedReader(new FileReader(f));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String lineToRemove = ""+alarmhour2+ ":"+alarmminute2+alarmampm2;
                        String currentLine;

                        while((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            if(trimmedLine.equals(lineToRemove)) continue;
                            writer.write(currentLine + System.getProperty("line.separator"));
                        }
                        writer.close();
                        reader.close();
                        f.delete();
                        Path oldFile
                                = Paths.get("E:\\Clock with alarm\\AlarmClock\\myTempFile.txt");

                        try {
                            Files.move(oldFile, oldFile.resolveSibling(
                                    "Alarmfile.txt"));
                            System.out.println("Deleted successfully");
                        }
                        catch (IOException e) {
                            System.out.println("operation failed");
                        }


                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });

        //delete3--------
        btndlt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                flag3 = 0;
                tfh3.setText("");
                tfm3.setText("");
                tfam3.setText("");
                JOptionPane.showMessageDialog(null, "Alarm reset");

                File tempFile = new File("myTempFile.txt");
                try{
                    File f = new File("E:\\Clock with alarm\\AlarmClock\\Alarmfile.txt");

                    if(f.exists() && !f.isDirectory()) {
                        BufferedReader reader = new BufferedReader(new FileReader(f));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String lineToRemove = ""+alarmhour3+ ":"+alarmminute3+alarmampm3;
                        String currentLine;

                        while((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            if(trimmedLine.equals(lineToRemove)) continue;
                            writer.write(currentLine + System.getProperty("line.separator"));
                        }
                        writer.close();
                        reader.close();
                        f.delete();
                        Path oldFile
                                = Paths.get("E:\\Clock with alarm\\AlarmClock\\myTempFile.txt");

                        try {
                            Files.move(oldFile, oldFile.resolveSibling(
                                    "Alarmfile.txt"));
                            System.out.println("Deleted successfully");
                        }
                        catch (IOException e) {
                            System.out.println("operation failed");
                        }


                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });



    }



    //SNOOOZE TiME
    public void snooze_time (int h, int m, int num){
        snooze_hour = h;
        snooze_minute = m;




        snooze_minute = snooze_minute+2;
        if(snooze_minute == 60){
            snooze_hour = snooze_hour+1;
            snooze_minute = 0;
        }
        else if(snooze_minute == 61){
            snooze_hour = snooze_hour+1;
            snooze_minute = 1;
        }
        if(num == 1){
            temp_h = snooze_hour;
            temp_m = snooze_minute;

        }else if (num == 2){
            temp_h2 = snooze_hour;
            temp_m2 = snooze_minute;


        }else if(num == 3){
            temp_h3 = snooze_hour;
            temp_m3 = snooze_minute;

        }


        currentTime();

        mp3.stop();

        JOptionPane.showMessageDialog(null,"Alarm set at "+snooze_hour +"."+ snooze_minute+temp_am);
    }

    public void currentTime()
    {

        Thread clock;
        clock = new Thread() {

            public void run() {

                for (;;) {
                    Calendar cal = new GregorianCalendar();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH) + 1;
                    int year = cal.get(Calendar.YEAR);

                    //AM_PM
                    Calendar datetime = Calendar.getInstance();
                    String am_pm = "";
                    if (datetime.get(Calendar.AM_PM) == Calendar.AM) {
                        am_pm = "AM";
                    } else if (datetime.get(Calendar.AM_PM) == Calendar.PM) {
                        am_pm = "PM";
                    }

                    //week day
                    String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
                            "Friday", "Saturday"};
                    String wd;
                    wd = strDays[datetime.get(Calendar.DAY_OF_WEEK) - 1];

                    //setting to label
                    jLabel1.setText(hour + " : " + minute + " : " + second);
                    jLabel2.setText(day + "-" + month + "-" + year);
                    jLabel3.setText(am_pm);
                    jLabel4.setText(", " + wd);

                    //Alarm 1---------------

                    if (temp_h == hour && temp_m == minute && temp_am.equals(am_pm) && flag == 1) {
                        mp3.play();

                        if (second == 59 || flag == 0) {
                            mp3.stop();
                        }
                        String[] options = { "Snooze for 2 mins!", "Stop"};
                        var selection = JOptionPane.showOptionDialog(null, "Wake up ! Wake up!", "AlARM RINGING!!",
                                0, 2, null, options, options[0]);
                        if (selection == 0) {
                            snooze_time(temp_h, temp_m,1);
                        }
                        if (selection == 1) {
                            flag =0;
                            mp3.stop();
                        }
                    }

                    //Alarm 2---------------
                    if (temp_h2 == hour && temp_m2 == minute && temp_am2.equals(am_pm) && flag2 == 1) {
                        mp3.play();

                        if (second == 59 || flag2 == 0) {
                            mp3.stop();
                        }
                        String[] options = { "Snooze for 2 mins!", "Stop"};
                        var selection = JOptionPane.showOptionDialog(null, "Wake up ! Wake up!", "AlARM RINGING!!",
                                0, 2, null, options, options[0]);
                        if (selection == 0) {
                            snooze_time(temp_h2, temp_m2,2);
                        }
                        if (selection == 1) {
                            flag2 =0;
                            mp3.stop();
                        }


                    }

                    //Alarm 3---------------

                    if (temp_h3 == hour && temp_m3 == minute && temp_am3.equals(am_pm) && flag3 == 1) {
                        mp3.play();

                        if (second == 59 || flag3 == 0) {
                            mp3.stop();
                        }

                        String[] options = { "Snooze for 2 mins!", "Stop"};
                        var selection = JOptionPane.showOptionDialog(null, "Wake up ! Wake up!", "AlARM RINGING!!",
                                0, 2, null, options, options[0]);
                        if (selection == 0) {
                            snooze_time(temp_h3, temp_m3,3);
                        }
                        if (selection == 1) {
                            flag3 =0;
                            mp3.stop();
                        }
                    }



                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                }
            }
        };
        clock.start();
    }


    public static void main(String[] args)
    {
        new Clock1();
    }


}