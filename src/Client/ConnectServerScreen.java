package Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectServerScreen extends javax.swing.JFrame {
    List<ServerData> serverList;
    private static final long serialVersionUID = 1L;
    public ServerData connectedServer;
    JTable serverTable;
    JDialog askNameDialog = new JDialog();

    public ConnectServerScreen() {
        this.setVisible(true);
        initComponents();
       // serverList = FileManager.getServerList();
        MyInit();
    }

    void MyInit() {
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfIP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.setActionCommand("join");
        jLabel4 = new javax.swing.JLabel();
        jtfPort = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHAT ROOM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 30));
        jPanel1.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Địa chỉ IP:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 30));

        jtfIP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtfIP.setText("127.0.0.1");
        jPanel1.add(jtfIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 110, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Port:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 40, 30));

        jtfPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtfPort.setText("8888");
        jPanel1.add(jtfPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 270));

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int port = Integer.parseInt(jtfPort.getText());
        String nickName = jtfName.getText();
        String ip = jtfIP.getText();
        ServerData selectedServer = new ServerData(nickName, ip, port, false, 0);
        Main.socketController = new SocketController(jtfName.getText(),selectedServer);
        Main.socketController.Login();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnectServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfIP;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPort;



    public void loginResultAction(String result) {
        if (result.equals("success")) {


            this.setVisible(false);
            this.dispose();
            Main.mainScreen = new MainScreen();

        } else if (result.equals("existed"))
            JOptionPane.showMessageDialog(this, "Username đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else if (result.equals("closed"))
            JOptionPane.showMessageDialog(this, "Server đã đóng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    }
}
