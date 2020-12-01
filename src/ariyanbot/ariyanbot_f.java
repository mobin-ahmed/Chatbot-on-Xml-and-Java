/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ariyanbot;

import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

public class ariyanbot_f extends javax.swing.JDialog {

    private static final boolean TRACE_MODE = false;
    static String botName = "super";

    public ariyanbot_f(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Q_panel = new javax.swing.JScrollPane();
        Q_area = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ans_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        setPreferredSize(new java.awt.Dimension(500, 700));

        Q_area.setBackground(new java.awt.Color(102, 102, 0));
        Q_area.setColumns(20);
        Q_area.setRows(5);
        Q_panel.setViewportView(Q_area);

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 0));
        jButton1.setText("click");
        jButton1.setPreferredSize(new java.awt.Dimension(45, 37));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Ans_area.setBackground(new java.awt.Color(153, 0, 51));
        Ans_area.setColumns(20);
        Ans_area.setForeground(new java.awt.Color(255, 255, 255));
        Ans_area.setRows(5);
        jScrollPane2.setViewportView(Ans_area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Q_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Q_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Ans_area.setText(qs);
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        MagicBooleans.trace_mode = TRACE_MODE;
        Bot bot = new Bot("super", path);
        Chat chatSession = new Chat(bot);
        bot.brain.nodeStats();
        String textLine;

        //while(true) {
        //System.out.print("Human : ");
        textLine = Q_area.getText();
        Q_area.setText(null);
        if ((textLine == null) || (textLine.length() < 1)) {
            textLine = MagicStrings.null_input;
        }
        if (textLine.equals("q")) {
            System.exit(0);
        } else if (textLine.equals("wq")) {
            bot.writeQuit();
            System.exit(0);
        } else {
            String request = textLine;
            if (MagicBooleans.trace_mode) {
                System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
            }
            String response = chatSession.multisentenceRespond(request);
            while (response.contains("&lt;")) {
                response = response.replace("&lt;", "<");
            }
            while (response.contains("&gt;")) {
                response = response.replace("&gt;", ">");
            }
            
            
            response=response.replaceAll("<split/>", "\n");
            response=response.replaceAll("<button>", "");
            response=response.replaceAll("</button>", "");
            response=response.replaceAll("<text>", "");
            response=response.replaceAll("</text>", "");
            response=response.replaceAll("<title>", "");
            response=response.replaceAll("</title>", "");
            response=response.replaceAll("<subtitle>", "");
            response=response.replaceAll("</subtitle>", "");
            response=response.replaceAll("<card>", "");
            response=response.replaceAll("</card>", "");
            response=response.replaceAll("<carousel>", "");
            response=response.replaceAll("</carousel>", "");
            
            Ans_area.setText("NEUB : " + response);
        }
    }
    //}

    private String getResourcesPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ariyanbot_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ariyanbot_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ariyanbot_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ariyanbot_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ariyanbot_f dialog = new ariyanbot_f(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Ans_area;
    private javax.swing.JTextArea Q_area;
    private javax.swing.JScrollPane Q_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
