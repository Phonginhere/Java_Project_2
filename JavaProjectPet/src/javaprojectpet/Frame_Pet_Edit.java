/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectpet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaprojectpet.dao.ConnectDB.ketNoi;
import javaprojectpet.entitys.Pet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author phanh
 */

public class Frame_Pet_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Frame_TimeCare_Add
     */
    Connection con;
    PreparedStatement pst;
    DefaultTableModel model1;
    DefaultTableModel model;
    public Frame_Pet_Edit() {
        initComponents();
        this.setTitle("Sửa thông tin thú cưng");
        this.setLocationRelativeTo(null);
        model1 = (DefaultTableModel)jTablePet.getModel();
        model = (DefaultTableModel)jTableGuest.getModel();
        showTable();
        showTableGuest();
        jTablePet.setRowHeight(40);
        jTableGuest.setRowHeight(40);
        
        choiceIDGuest.setVisible(false);
        jLabel1.setVisible(false);
         try {
            con = ketNoi();
        } catch (Exception e) {
            System.out.println(e);
        }
         fill_idkhach();
    }
      public void showTableGuest(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thucungcare", "root", "");
        
        PreparedStatement ps = con.prepareStatement("select * from khachhang");
        
        java.sql.ResultSet rs=ps.executeQuery();
        
        DefaultTableModel tm = (DefaultTableModel)jTableGuest.getModel();
        
        tm.setRowCount(0);
        
        while(rs.next()){
            
            Object o[]={rs.getInt("id_khachhang"), rs.getString("ten_khachhang"), rs.getString("Email"), rs.getString("sdt_khachhang"), rs.getString("ngaythem_khachhang"), rs.getString("Email")};
            
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
public void showTable(){
        try{
          
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT tc.id_thucung, tc.name_thucung, tc.tuoi_thucung, tc.loaidongvat_thucung, tc.id_khachhang_thucung, kh.ten_khachhang from thucung AS tc LEFT JOIN khachhang AS kh ON tc.id_khachhang_thucung = kh.id_khachhang");
        java.sql.ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTablePet.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("tc.id_thucung"), rs.getString("tc.name_thucung"), rs.getInt("tc.tuoi_thucung"), rs.getString("tc.loaidongvat_thucung"),rs.getString("tc.id_khachhang_thucung"), rs.getString("kh.ten_khachhang")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
private void fill_idkhach(){
     try{
         String sql = "select khachhang.id_khachhang from khachhang";
         pst=con.prepareStatement(sql);
         ResultSet rs=pst.executeQuery();
         
         while(rs.next()){
             String name = rs.getString("id_khachhang");
             choiceIDGuest.addItem(name);
         }
         
     }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
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
        jTablePet = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNamePet = new javax.swing.JTextField();
        jTextFieldAgePet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPetCategorie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSearchPet = new javax.swing.JTextField();
        jButtonBack = new javax.swing.JButton();
        choiceIDGuest = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNameKH = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFindGuest = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGuest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTablePet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "tên", "tuổi ", "Loài động vật", "ID khách hàng", "Tên khách hàng"
            }
        ));
        jTablePet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePet);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));

        jTextFieldNamePet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldNamePet.setToolTipText("");
        jTextFieldNamePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamePetActionPerformed(evt);
            }
        });

        jTextFieldAgePet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldAgePet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAgePetKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên thú");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("tuổi");

        jTextFieldPetCategorie.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("loài động vật");

        jButtonReset.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonEdit.setText("Sửa");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tìm kiếm theo thú cưng");

        jTextFieldSearchPet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldSearchPet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSearchPetKeyTyped(evt);
            }
        });

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.setToolTipText("");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        choiceIDGuest.setFont(new java.awt.Font("Dialog", 0, 34)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID khách hàng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên khách hàng");

        jLabelNameKH.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelNameKH.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tìm kiếm theo khách hàng");

        jTextFieldFindGuest.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldFindGuest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFindGuestKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButtonReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEdit)
                .addGap(143, 143, 143))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceIDGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButtonBack))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPetCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2)
                                    .addGap(62, 62, 62)
                                    .addComponent(jTextFieldNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldAgePet, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNameKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldFindGuest)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSearchPet, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(201, 201, 201))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButtonBack)
                .addGap(218, 218, 218)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAgePet, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPetCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelNameKH, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceIDGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonEdit))
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearchPet, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFindGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(110, 89, 222));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thông tin sửa thú cưng");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Thú Cưng/Sửa Thú Cưng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel9)))
                .addContainerGap(749, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addGap(39, 39, 39))
        );

        jTableGuest.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTableGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên khách hàng", "số điện thoại", "địa chỉ", "ngày thêm khách hàng", "Email"
            }
        ));
        jTableGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGuestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGuest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1839, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
         jTextFieldNamePet.setText("");
        jTextFieldPetCategorie.setText("");
        jTextFieldAgePet.setText("");
        jTextFieldSearchPet.setText("");
        jTextFieldFindGuest.setText("");
        jLabelNameKH.setText("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        new Frame_Pet_Information().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        Frame_Pet_Edit framepetedit = new Frame_Pet_Edit();
         String NamePet = jTextFieldNamePet.getText();
        String CateGoryPet = jTextFieldPetCategorie.getText();
        String AgePet = jTextFieldAgePet.getText();
        String ID_khachhang = choiceIDGuest.getSelectedItem().toString();
        Pet pet = new Pet(NamePet, CateGoryPet, AgePet, ID_khachhang);
        
        
        if(jTextFieldNamePet.getText().trim().isEmpty() 
                || jTextFieldPetCategorie.getText().trim().isEmpty() 
                || jLabelNameKH.getText().trim().isEmpty()
                || jTextFieldAgePet.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(framepetedit, "Chưa điền đầy đủ");
        }else{
        JOptionPane.showMessageDialog(framepetedit, "Sửa thành công!!. Sẽ Chuyển Trang trong 2 giây nữa.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame_Pet_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        int row = jTablePet.getSelectedRow();
        TableModel model=jTablePet.getModel();
        String value =  (jTablePet.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE `ql_thucungcare`.`thucung` SET `name_thucung`=?,`tuoi_thucung`=?,`loaidongvat_thucung`=?, `id_khachhang_thucung`=?  WHERE id_thucung="+value;
             try{
                 pst = con.prepareStatement(sql);
                  pst.setString(1, pet.getName());
                   pst.setString(2, pet.getAge());
                   pst.setString(3, pet.getCategory());
                   pst.setString(4, pet.getId_khachhang());
                   
                    pst.executeUpdate();
             }catch (Exception e) {
//                 System.out.println(e);
                // TODO: handle exception
    }
        new Frame_Pet_Information().setVisible(true);
        dispose();
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jTextFieldNamePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamePetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamePetActionPerformed

    private void jTextFieldAgePetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAgePetKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAgePetKeyTyped

    private void jTablePetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePetMouseClicked
        // TODO add your handling code here:   
             int index=jTablePet.getSelectedRow();
             TableModel model=jTablePet.getModel();
        jTextFieldNamePet.setText(model.getValueAt(index, 1).toString());
         jTextFieldAgePet.setText(model.getValueAt(index, 2).toString());
          jTextFieldPetCategorie.setText(model.getValueAt(index, 3).toString());
        choiceIDGuest.select(model.getValueAt(index, 4).toString());
        jLabelNameKH.setText(model.getValueAt(index, 5).toString());
    }//GEN-LAST:event_jTablePetMouseClicked
private void FilterPet(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model1); 
        jTablePet.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldSearchPetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchPetKeyTyped
        // TODO add your handling code here:
         String query = jTextFieldSearchPet.getText();
        if(query != null && query.length() > 0){
           FilterPet(query); 
        }
    }//GEN-LAST:event_jTextFieldSearchPetKeyTyped

    private void jTableGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGuestMouseClicked
        // TODO add your handling code here:
         int index=jTableGuest.getSelectedRow();
             TableModel model=jTableGuest.getModel();
        jLabelNameKH.setText(model.getValueAt(index, 1).toString());
        choiceIDGuest.select(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_jTableGuestMouseClicked
private void FilterGuest(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model); 
        jTableGuest.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldFindGuestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFindGuestKeyTyped
        // TODO add your handling code here:
        String query = jTextFieldFindGuest.getText();
        if(query != null && query.length() > 0){
           FilterGuest(query); 
        }
    }//GEN-LAST:event_jTextFieldFindGuestKeyTyped

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
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Pet_Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceIDGuest;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNameKH;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGuest;
    private javax.swing.JTable jTablePet;
    private javax.swing.JTextField jTextFieldAgePet;
    private javax.swing.JTextField jTextFieldFindGuest;
    private javax.swing.JTextField jTextFieldNamePet;
    private javax.swing.JTextField jTextFieldPetCategorie;
    private javax.swing.JTextField jTextFieldSearchPet;
    // End of variables declaration//GEN-END:variables
}