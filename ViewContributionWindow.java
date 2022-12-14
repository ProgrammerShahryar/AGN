/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyAGN;

import java.time.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Shahryar
 */
public class ViewContributionWindow extends javax.swing.JFrame {
    
    LocalDate starttDate;
    LocalDate enddDate;
    
    /**
     * Internal attributes of a view contribution frame
     */
    private AGN theAgn;
    private agnGUI theParent;
    private ViewContributionTableModel vct;
    private SponsorshipTableModel stm;
    private MaterialTableModel mat;
    private MonetaryTableModel mon;

    /**
     * Constructor that  Creates new form ViewContributionWindow
     * @param theAgn
     * @param parentWindow 
     */
    public ViewContributionWindow(AGN theAgn, agnGUI parentWindow) {
        initComponents();
        this.theAgn = theAgn;
        setupModel();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        theParent = parentWindow;
        theParent.setEnabled(false);
        setTitle("View Contributions");
    }

    /**
     * setting up the model for ViewContributionWindow
     */
    public void setupModel()
    {
        vct = new ViewContributionTableModel(theAgn.getAllContr());
        contrTable.setModel(vct);
        contrTable.setAutoCreateRowSorter(true);
        
        contrTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contrTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                update();
                
            }
        });
    }
    
    /**
     * updating the second table when contribution is selected
     */
    public void update()
        {
            int row = contrTable.getSelectedRow();
            Contribution theContr = vct.getContrAt(row);
            if(theContr.getType().equalsIgnoreCase("sponsorship"))
            {
                stm = new SponsorshipTableModel(theContr);
                typeTable.setModel(stm);
                stm.setSponsor(theContr);
                typeTable.removeAll();
                stm.fireTableDataChanged();
            }
            else if(theContr.getType().equalsIgnoreCase("material"))
            {
                mat = new MaterialTableModel(theContr);
                typeTable.setModel(mat);
                mat.setMaterial(theContr);
                typeTable.removeAll();
                mat.fireTableDataChanged();
            }else
            {
                mon = new MonetaryTableModel(theContr);
                typeTable.setModel(mon);
                mon.setMonetary(theContr);
                typeTable.removeAll();
                mon.fireTableDataChanged();
            }
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
        contrTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        searchBtn = new javax.swing.JButton();
        CloseBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        typeTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalContr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contrTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(contrTable);

        jLabel1.setText("Start Date");

        jLabel2.setText("End Date");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        CloseBtn.setText("Close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBtnActionPerformed(evt);
            }
        });

        typeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(typeTable);

        jLabel3.setText("Please, select contribution to view more details!");
        jLabel3.setIconTextGap(5);
        jLabel3.setPreferredSize(new java.awt.Dimension(250, 14));

        jLabel4.setText("Total value of all contributions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CloseBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(searchBtn)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalContr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalContr, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(searchBtn)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CloseBtn))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public LocalDate getStartDate(LocalDate startDate)
    {
        return startDate;
    }
    public LocalDate getEndDate(LocalDate endDate)
    {
        return endDate;
    }
    
    /**
     * action when search button is clicked
     * @param evt 
     */
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        try
        {
            starttDate = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            enddDate = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            vct = new ViewContributionTableModel(theAgn.getAllContr(starttDate, enddDate));
            contrTable.setModel(vct);
            contrTable.setAutoCreateRowSorter(true);
            contrTable.removeAll();
            vct.fireTableDataChanged();
            totalContr.setText(Double.toString(theAgn.totalContr(starttDate, enddDate)));
            
        }
        catch(NullPointerException npe)
        {
            JOptionPane.showMessageDialog(this, "Enter the dates!");
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {
            JOptionPane.showMessageDialog(this, "No Contributions recorded between those dates!");
        }
        
    }//GEN-LAST:event_searchBtnActionPerformed

    /**
     * action when close button is clicked
     * @param evt 
     */
    private void CloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBtnActionPerformed
        // TODO add your handling code here:
        
        theParent.setEnabled(true);	 
        this.setVisible(false);

    }//GEN-LAST:event_CloseBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseBtn;
    private javax.swing.JTable contrTable;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBtn;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JLabel totalContr;
    private javax.swing.JTable typeTable;
    // End of variables declaration//GEN-END:variables
}
