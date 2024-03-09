import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class App  {
    JLabel Tittle,RollNo, Name, Tamil, English, Maths, Science, Social;
    JTextField RollNoIn, NameIn, TamilIn , EnglishIn, MathsIn, ScienceIn, SocialIn;
    JButton Submit, Reset, Result;


    public void MarkTool(){
        JFrame frame1 = new JFrame("MarkEntry");
        frame1.getContentPane().setBackground(Color.decode("#191E29"));
        Tittle= new JLabel("MARK ENTRY TOOL");
        Tittle.setForeground(Color.decode("#01C38D"));
        Tittle.setBounds(150,10,120,40);
        RollNo= new JLabel("RollNo");
        RollNo.setForeground(Color.decode("#01C38D"));
        RollNo.setBounds(90, 70, 50, 40);
        RollNoIn= new JTextField();
        RollNoIn.setBackground(Color.decode("#132D46"));
        RollNoIn.setForeground(Color.decode("#01C38D"));
        RollNoIn.setBounds(200,75,120,25);

        Name= new JLabel("Name");
        Name.setForeground(Color.decode("#01C38D"));
        Name.setBounds(90,122,50,40);
        NameIn= new JTextField();
        NameIn.setBackground(Color.decode("#132D46"));
        NameIn.setForeground(Color.decode("#01C38D"));
        NameIn.setBounds(200,125,120,25);

        Tamil= new JLabel("Tamil");
        Tamil.setForeground(Color.decode("#01C38D"));
        Tamil.setBounds(90,170,50,40);
        TamilIn=new JTextField();
        TamilIn.setBackground(Color.decode("#132D46"));
        TamilIn.setForeground(Color.decode("#01C38D"));
        TamilIn.setBounds(200,175,120,25);


        English= new JLabel("English");
        English.setForeground(Color.decode("#01C38D"));
        English.setBounds(90,220,50,40);
        EnglishIn= new JTextField();
        EnglishIn.setBackground(Color.decode("#132D46"));
        EnglishIn.setForeground(Color.decode("#01C38D"));
        EnglishIn.setBounds(200,225,120,25);

        Maths= new JLabel("Maths");
        Maths.setForeground(Color.decode("#01C38D"));
        Maths.setBounds(90,270,50,40);
        MathsIn= new JTextField();
        MathsIn.setBackground(Color.decode("#132D46"));
        MathsIn.setForeground(Color.decode("#01C38D"));
        MathsIn.setBounds(200,275,120,25);


        Science= new JLabel("Science");
        Science.setForeground(Color.decode("#01C38D"));
        Science.setBounds(90,320,50,40);
        ScienceIn= new JTextField();
        ScienceIn.setBackground(Color.decode("#132D46"));
        ScienceIn.setForeground(Color.decode("#01C38D"));
        ScienceIn.setBounds(200,325,120,25);


        Social= new JLabel("Social");
        Social.setForeground(Color.decode("#01C38D"));
        Social.setBounds(90,368,50,40);
        SocialIn= new JTextField();
        SocialIn.setBackground(Color.decode("#132D46"));
        SocialIn.setForeground(Color.decode("#01C38D"));
        SocialIn.setBounds(200,375,120,25);


        Submit= new JButton("Submit");
        Submit.setBackground(Color.decode("#01C38D"));
        Submit.setForeground(Color.decode("#132D46"));
        Submit.setBounds(110,430,80,25);
        Reset= new JButton("Reset");
        Reset.setBackground(Color.decode("#01C38D"));
        Reset.setForeground(Color.decode("#132D46"));
        Reset.setBounds(230,430,80,25);
        Result= new JButton("Result");
        Result.setBackground(Color.decode("#01C38D"));
        Result.setForeground(Color.decode("#132D46"));
        Result.setBounds(165,480,80,25);

        frame1.add(Tittle);
        frame1.add(RollNo);frame1.add(RollNoIn);
        frame1.add(Name);frame1.add(NameIn);
        frame1.add(Tamil);frame1.add(TamilIn);
        frame1.add(English);frame1.add(EnglishIn);
        frame1.add(Maths);frame1.add(MathsIn);
        frame1.add(Science);frame1.add(ScienceIn);
        frame1.add(Social);frame1.add(SocialIn);
        frame1.add(Submit);frame1.add(Reset);
        frame1.add(Result);
        frame1.setSize(400, 570);
        frame1.setLocationRelativeTo(null);
        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setVisible(true);
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String query="insert into stu_details (Roll_no, Name, Tamil, English, Maths, Science, Social) values (?,?,?,?,?,?,?);";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails", "root", "1234");
                    PreparedStatement pst= con.prepareStatement(query);
                    pst.setInt(1, Integer.parseInt(RollNoIn.getText()));
                    pst.setString(2, NameIn.getText());
                    pst.setInt(3,Integer.parseInt(TamilIn.getText()));
                    pst.setInt(4,Integer.parseInt(EnglishIn.getText()));
                    pst.setInt(5,Integer.parseInt(MathsIn.getText()));
                    pst.setInt(6,Integer.parseInt(ScienceIn.getText()));
                    pst.setInt(7,Integer.parseInt(SocialIn.getText()));
                    int i= pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Inserted into Database!!");

                }catch (Exception er){

                    JOptionPane.showMessageDialog(null,er.getMessage());

                }
            }
        });
        Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RollNoIn.setText(null);
                NameIn.setText(null);
                TamilIn.setText(null);
                EnglishIn.setText(null);
                MathsIn.setText(null);
                ScienceIn.setText(null);
                SocialIn.setText(null);
            }
        });
        Result.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                Result();

            }
        });

    }
    public void Result(){
        //creating Result frame
        JFrame frame2=new JFrame("RESULT");
        JLabel Topic2=new JLabel("RESULT");
        Topic2.setBounds(165,5,100,40);
        JLabel EnterRollNo=new JLabel("Enter the RollNo");
        EnterRollNo.setBounds(80,50,150,40);
        JTextField RollNo2=new JTextField();
        RollNo2.setBounds(210,60,120,20);
        JButton GetMarks=new JButton("GetMarks");
        GetMarks.setBounds(90,120,95,25);
        JButton Back=new JButton("Back");
        Back.setBounds(230,120,80,25);
        JLabel ShowResult=new JLabel("Your Result Shown Below : ");
        ShowResult.setBounds(78,165,160,40);

        frame2.add(Topic2);
        frame2.add(EnterRollNo);
        frame2.add(RollNo2);
        frame2.add(GetMarks);
        frame2.add(Back);
        frame2.add(ShowResult);
        frame2.setSize(400,570);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setLayout(null);
        frame2.setVisible(true);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                MarkTool();
            }
        });
        GetMarks.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                try {
                    String queryG="select*from stu_details where Roll_no="+Integer.parseInt(RollNo2.getText());
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails", "root", "1234");
                    Statement st= con1.createStatement();
                    ResultSet rs=st.executeQuery(queryG);
                    rs.next();
                    JLabel FinalResultRollNo = new JLabel("RollNo       :" + "    " + rs.getInt(1));
                    FinalResultRollNo.setBounds(80, 210, 120, 25);
                    JLabel FinalResultName = new JLabel("Name          :" + "    " + rs.getString(2));
                    FinalResultName.setBounds(80, 235, 200, 25);
                    JLabel FinalResultTamil = new JLabel("Tamil           :" + "    " + rs.getInt(3));
                    FinalResultTamil.setBounds(80, 263, 120, 25);
                    JLabel FinalResultEnglish = new JLabel("English       :" + "    " + rs.getInt(4));
                    FinalResultEnglish.setBounds(80, 290, 120, 25);
                    JLabel FinalResultMaths = new JLabel("Maths          :" + "    " + rs.getInt(5));
                    FinalResultMaths.setBounds(80, 320, 120, 25);
                    JLabel FinalResultScience = new JLabel("Science       :" + "    " + rs.getInt(6));
                    FinalResultScience.setBounds(80, 350, 120, 25);
                    JLabel FinalResultSocial = new JLabel("Social           :" + "   " + rs.getInt(7));
                    FinalResultSocial.setBounds(80, 380, 120, 25);
                    int FinalTotal=rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7);
                    JLabel Total=new JLabel("Total             :"+"   "+FinalTotal+"/"+"500");
                    Total.setBounds(80,410,140,25);
                    JButton Clear=new JButton("Clear");
                    Clear.setBounds(150,445,80,25);
                    frame2.add(FinalResultRollNo);
                    frame2.add(FinalResultName);
                    frame2.add(FinalResultTamil);
                    frame2.add(FinalResultEnglish);
                    frame2.add(FinalResultMaths);
                    frame2.add(FinalResultScience);
                    frame2.add(FinalResultSocial);
                    frame2.add(Total);
                    frame2.add(Clear);
                    frame2.setSize(400, 570);
                    frame2.setResizable(false);
                    frame2.setLayout(null);
                    frame2.setLocationRelativeTo(null);
                    frame2.setVisible(true);
                    GetMarks.setVisible(false);
                    Clear.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            FinalResultRollNo.setText(null);
                            FinalResultTamil.setText(null);
                            FinalResultName.setText(null);
                            FinalResultEnglish.setText(null);
                            FinalResultMaths.setText(null);
                            FinalResultScience.setText(null);
                            FinalResultSocial.setText(null);
                            Total.setText(null);
                            Clear.setVisible(false);
                            GetMarks.setVisible(true);
                        }
                    });
                }catch (Exception er){
                    JOptionPane.showMessageDialog(null,er.getMessage());
                }

            }
        });
    }
    public static void main(String[] args) {
        App a=new App();
        a.MarkTool();
    }
}

