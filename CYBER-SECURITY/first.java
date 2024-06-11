import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.io.*;
class first{
    public static void onclick(int key)
    {
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(null);
        File file=fc.getSelectedFile();
        try
        {
            FileInputStream fis=new FileInputStream(file);
            byte data[]=new byte[fis.available()];
            int i=0;
            for(byte b:data)
            {
                System.out.println(data[i]);
                data[i]=(byte)(b^key);
                System.out.println(data[i]);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fis.close();
            fos.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String args[])
    {
        // TO GIVE GUI FOR THE IMAGE PROCESSING.
        JFrame f=new JFrame();
        f.setTitle("IMAGE ENCRYPTION");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        Font font=new Font("calibri",Font.BOLD,25);

        JTextField jt=new JTextField(15);
        jt.setFont(font);


        JButton jb=new JButton();
        jb.setText("OPEN IMAGE");
        jb.setFont(font);
        f.setLayout(new FlowLayout());
        jb.addActionListener(e->{
            String text=jt.getText();
            int key=Integer.parseInt(text);
            onclick(key);
        });
        f.add(jt);
        f.add(jb);
        f.setVisible(true);
    }
}