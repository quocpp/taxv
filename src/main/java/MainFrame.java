import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bean on 17/07/2017.
 */
public class MainFrame {

    private JPanel MainFrame1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JLabel lblLoginResult;
    private static MainController myMainController;
    public MainFrame() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    try {
                        LoginInfo loginRes = myMainController.vLogin(textField1.getText(),textField2.getText());
                        if(!loginRes.getResult().equals("0"))
                        {
                            lblLoginResult.setText(loginRes.getSerial());
                        }
                        else {
                            loginRes = myMainController.GetUserInfo(loginRes);
                            if(!loginRes.getInfores().equals("0"))
                            {
                                lblLoginResult.setText("Get info: "+loginRes.getMaNvThu());
                            }
                        }
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().MainFrame1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        myMainController = new MainController();
    }
}
