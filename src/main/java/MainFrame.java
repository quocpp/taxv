import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by bean on 17/07/2017.
 */
public class MainFrame {

    private JPanel MainFrame1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JLabel lblLoginResult;
    private JButton logoutButton;
    private JButton updateButton;
    private JTable table1;
    private JTable tabdetail;
    private JTable tabkythue;
    private JScrollPane tbKyThue;
    private JScrollPane tbDetail;
    private JButton getKyThueButton;
    private JLabel StatusVal;
    private static MainController myMainController;
    private LoginInfo loginRes;
    List<CusInfo> myCusInfo;
    List<KyThue> myListKyThue;
    List<ttno> myListTTNo;
    List<ttno> allmyListTTNo;
    public MainFrame() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    try {
                        loginRes = myMainController.vLogin(textField1.getText(),textField2.getText());
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
                            else
                            {
                                loginButton.setEnabled(false);
                                logoutButton.setEnabled(true);
                                updateButton.setEnabled(true);
                                getKyThueButton.setEnabled(true);
                                textField1.setEnabled(false);
                                textField2.setEnabled(false);
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
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    loginRes.setReCorNum("2");
                    myMainController.GetBill(loginRes,2);
                    StatusVal.setText("Donloading");
                    myCusInfo = myMainController.GetBill(loginRes,1);
                    StatusVal.setText("Finished");
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    int i = 0;
                    //for (CusInfo eCusInfo : myCusInfo)
                    //{
                    //    int j = 0;
                    //    myListKyThue = myMainController.GetKyThue(eCusInfo,loginRes);
                    //    myCusInfo.get(i).setKyThue(myListKyThue);
                    //    for(KyThue eKyThue : myListKyThue)
                    //    {
                    //        myListTTNo = myMainController.GetTTNo(eCusInfo,loginRes,eKyThue.getID());
                    //        myCusInfo.get(i).addttno(myListTTNo,j);
                    //        j++;
                    //    }
                    //    i++;
                    //}
                    i = 0;
                    for (CusInfo eCusInfo : myCusInfo) {
                        Vector row = new Vector();
                        row.add(i);
                        row.add(eCusInfo.getMSt());
                        row.add(eCusInfo.getTEN_NNT());
                        model.addRow(row);
                        i++;
                    }
                    table1.setPreferredScrollableViewportSize(new Dimension(50,400));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                int rowselected = table1.getSelectedRow();
                CusInfo selCus = myCusInfo.get(rowselected);
                DefaultTableModel model = (DefaultTableModel) tabdetail.getModel();
                model.setRowCount(0);
                model.addRow(new Object[] { "MST", selCus.getMSt()});
                model.addRow(new Object[] { "TEN_NNT", selCus.getTEN_NNT()});
                model.addRow(new Object[] { "SO", selCus.getS0()});
                model.addRow(new Object[] { "MA_CQT_QL", selCus.getMA_CQT_QL()});
                model.addRow(new Object[] { "MOTA_DIACHI", selCus.getMOTA_DIACHI()});
                model.addRow(new Object[] { "MA_TINH", selCus.getMA_TINH()});
                model.addRow(new Object[] { "MA_HUYEN", selCus.getMA_HUYEN()});
                model.addRow(new Object[] { "MA_XA", selCus.getMA_XA()});
                model.addRow(new Object[] { "SO_NHA", selCus.getSO_NHA()});
                model.addRow(new Object[] { "DIACHI_TT", selCus.getDIACHI_TT()});
                model.addRow(new Object[] { "MA_TINH_TT", selCus.getMA_TINH_TT()});
                model.addRow(new Object[] { "MA_HUYEN_TT", selCus.getMA_HUYEN_TT()});
                model.addRow(new Object[] { "MA_XA_TT", selCus.getMA_XA_TT()});
                model.addRow(new Object[] { "SO_NHA_TT", selCus.getSO_NHA_TT()});
                model.addRow(new Object[] { "MOBILE", selCus.getMOBILE()});
                model.addRow(new Object[] { "EMAIL", selCus.getEMAIL()});
                model.addRow(new Object[] { "MA_NV", selCus.getMA_NV()});
                model.addRow(new Object[] { "MA_T", selCus.getMA_T()});
                model.addRow(new Object[] { "MA_UNT", selCus.getMA_UNT()});
                model.addRow(new Object[] { "DIA_BAN", selCus.getDIA_BAN()});
                model.addRow(new Object[] { "KBNN", selCus.getKBNN()});
                model.addRow(new Object[] { "DA_GIAO", selCus.getDA_GIAO()});
                model.addRow(new Object[] { "SOTIEN", selCus.getSOTIEN()});
            }
        });
        getKyThueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                int rowselected = table1.getSelectedRow();
                allmyListTTNo = new ArrayList<ttno>();
                DefaultTableModel model = (DefaultTableModel) tabkythue.getModel();
                model.setRowCount(0);
                try {
                    myListKyThue = myMainController.GetKyThue(myCusInfo.get(rowselected),loginRes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int j = 0;
                int k = 0;
                for(KyThue eKyThue : myListKyThue)
                {
                    try {
                        myListTTNo = myMainController.GetTTNo(myCusInfo.get(rowselected),loginRes,eKyThue.getID());
                        for (ttno ettno : myListTTNo)
                        {

                            StatusVal.setText("Downloading ky thue: "+ eKyThue.getName());
                            allmyListTTNo.add(ettno);
                            Vector row = new Vector();
                            row.add(k);
                            row.add(ettno.getKYTHUE());
                            row.add(ettno.getTEN_CHUONG());
                            row.add(ettno.getTENTIEUMUC());
                            model.addRow(row);
                            k++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    j++;
                }

                StatusVal.setText("Finished");
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                updateButton.setEnabled(false);
                getKyThueButton.setEnabled(false);
                logoutButton.setEnabled(false);
                textField1.setEnabled(true);
                textField2.setEnabled(true);
            }
        });
        tabkythue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                                int rowselected = table1.getSelectedRow();
                ttno selttno = allmyListTTNo.get(rowselected);
                DefaultTableModel model = (DefaultTableModel) tabdetail.getModel();
                model.setRowCount(0);
                model.addRow(new Object[] { "NO_CUOI_KY", selttno.getNO_CUOI_KY()});
                model.addRow(new Object[] { "TIEN_TRA", selttno.getTIEN_TRA()});
                model.addRow(new Object[] { "SOTIEN", selttno.getSOTIEN()});
                model.addRow(new Object[] { "MA_CHUONG", selttno.getMA_CHUONG()});
                model.addRow(new Object[] { "MA_CQ_THU", selttno.getMA_CQ_THU()});
                model.addRow(new Object[] { "MA_TMUC", selttno.getMA_TMUC()});
                model.addRow(new Object[] { "SO_TAIKHOAN_CO", selttno.getSO_TAIKHOAN_CO()});
                model.addRow(new Object[] { "SO_QDINH", selttno.getSO_QDINH()});
                model.addRow(new Object[] { "NGAY_QDINH", selttno.getNGAY_QDINH()});
                model.addRow(new Object[] { "LOAI_TIEN", selttno.getLOAI_TIEN()});
                model.addRow(new Object[] { "TI_GIA", selttno.getTI_GIA()});
                model.addRow(new Object[] { "LOAI_THUE", selttno.getLOAI_THUE()});
                model.addRow(new Object[] { "TEN_CHUONG", selttno.getTEN_CHUONG()});
                model.addRow(new Object[] { "TENTIEUMUC", selttno.getTENTIEUMUC()});
                model.addRow(new Object[] { "KYTHUE", selttno.getKYTHUE()});
                model.addRow(new Object[] { "CHUKY", selttno.getCHUKY()});

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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Object columnNames[] = {"STT","MST", "TEN"};
        Object rowData[][] = {};
        table1 = new JTable();
        table1.setModel(new DefaultTableModel(rowData,columnNames));
        table1.getColumnModel().getColumn(0).setMaxWidth(50);
        table1.getColumnModel().getColumn(0).setMinWidth(50);
        table1.getColumnModel().getColumn(1).setMinWidth(90);
        table1.getColumnModel().getColumn(1).setMaxWidth(90);
        table1.getColumnModel().getColumn(2).setMinWidth(200);
        table1.getColumnModel().getColumn(2).setMaxWidth(200);

        Object columnNames1[] = {"Name","Value"};
        Object rowData1[][] = {};

        tabdetail = new JTable();
        tabdetail.setModel(new DefaultTableModel(rowData1,columnNames1));

        Object columnNames2[] = {"STT","Ky Thue","Ten Chuong", "Ten Tieu Muc"};
        Object rowData2[][] = {};
        tabdetail.getColumnModel().getColumn(0).setMaxWidth(150);
        tabdetail.getColumnModel().getColumn(0).setMinWidth(150);

        tabkythue = new JTable();
        tabkythue.setModel(new DefaultTableModel(rowData2,columnNames2));
        tabkythue.getColumnModel().getColumn(0).setMaxWidth(30);
        tabkythue.getColumnModel().getColumn(0).setMinWidth(30);
        tabkythue.getColumnModel().getColumn(1).setMinWidth(60);
        tabkythue.getColumnModel().getColumn(1).setMaxWidth(60);
        tabkythue.getColumnModel().getColumn(2).setMinWidth(100);
        tabkythue.getColumnModel().getColumn(2).setMaxWidth(100);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
        updateButton.setEnabled(false);
        logoutButton.setEnabled(false);
        loginButton.setEnabled(true);
    }
}
