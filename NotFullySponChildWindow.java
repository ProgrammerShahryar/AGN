/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAGN;

import java.time.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Shahryar
 */
public class NotFullySponChildWindow extends javax.swing.JFrame {
    
    /**
     * Internal attributes of a Children who are not 100% sponsored
     */
    private AGN theAgn;
    private NotFullySponChildTableModel nfs;
    private Child theChild;
    private Donor theDonor;
    private Sponsorship theSponsorship;
    
    /**
     * Constructor for NotFullySponChildWindow
     * @param a
     * @param theDonor 
     */
    public NotFullySponChildWindow(AGN a, Donor theDonor) {
        initComponents();
        theAgn = a;
        setupChildModels();
        this.theDonor = theDonor;
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Record Sponsorship Contribution");
    }
    
    /**
     * setting up model for the frame that shows children who don't have 100% sponsorship
     */
    public void setupChildModels() {
        nfs = new NotFullySponChildTableModel(theAgn.allNotFullySponsoredChild()); 						// get all orders
        childNot100Table.setModel(nfs);
        childNot100Table.setAutoCreateRowSorter(true);
        childNot100Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        childNot100Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) 
            {
                update();
            }
        });
    }
    
    /**
     * getting the selected child from childTable
     * @return 
     */
    public Child getChild()
    {
        int row = childNot100Table.getSelectedRow();
        theChild = nfs.getChildAt(row);
        return theChild;
    }
    
    /**
     * updating textAreas after selecting a child from table
     */
    public void update()
    {
        int row = childNot100Table.getSelectedRow();
        theChild = nfs.getChildAt(row);
        
        nameTF.setText(theChild.getChildName());
        myKadTF.setText(theChild.getMyKadNo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        childNot100Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        myKadTF = new javax.swing.JTextField();
        dateTF = new com.toedter.calendar.JDateChooser();
        percentageTF = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        childNot100Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(childNot100Table);

        jLabel1.setText("Child Name");

        jLabel2.setText("MyKad Number");

        jLabel3.setText("Date of Sponsorship");

        jLabel4.setText("Percentage of Sponsorship");

        nameTF.setEnabled(false);

        myKadTF.setEnabled(false);

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentageTF))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(myKadTF)
                                    .addComponent(nameTF)
                                    .addComponent(dateTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(addBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(myKadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(percentageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * action when add button is clicked with validation
     * @param evt 
     */
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        
        try
        {
            LocalDate date = dateTF.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int percentage = Integer.parseInt(percentageTF.getText());
            
            if(percentageTF.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Enter the percentage!");
            else
            {
                Sponsorship spon = getChild().addSponsorship(date, percentage);
                theSponsorship = theDonor.addSponsorship(spon);
                theSponsorship.setDonor(theDonor);
                spon.setTheChild(getChild());
            }
            this.dispose();
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(this, "Percentage of Sponsorship must be a number!");
        }
        catch(NullPointerException npe)
        {
            JOptionPane.showMessageDialog(this, "Enter the date!");
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {
            JOptionPane.showMessageDialog(this, "Select a child!");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * action when cancel button is clicked
     * @param evt 
     */
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTable childNot100Table;
    private com.toedter.calendar.JDateChooser dateTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField myKadTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField percentageTF;
    // End of variables declaration//GEN-END:variables
}
