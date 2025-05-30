package tampilan;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
//import tampilan.Nota;
import koneksi.koneksi;

/**
 *
 * @author erica aghestin
 */
public class Nota extends javax.swing.JFrame {
public String id_nota, nama, jenis, telp, almt;
public String kdbrg, nmbrg, jenisbrg, hb, hj;
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

    /**
     * Creates new form Nota
     */

    public Nota plgn = null;
    
    public Nota() {
        initComponents();
        String KD = UserID.getUserLogin();
        jLabel16.setText(KD);
        kosong();
        aktif();
        autonumber();
    }
protected void nama(){
    try {
        String sql = "SELECT * FROM KASIR WHERE id_kasir='"+jLabel16.getText()+"'";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        if(hasil.next()){
            jLabel17.setText(hasil.getString("nama_kasir"));
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
         }
}

protected void aktif(){
        txtqty.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl,"yyyy/MM/dd"));
        Object[] Baris ={"KD Barang","Nama","Harga Beli","Harga jual","QTY","Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tbltransaksi.setModel(tabmode);
}

protected void kosong(){
          txtid_nota.setText("");
          txtnm.setText("");
          txtkdbrg.setText("");
          txthb.setText("");
          txthj.setText("");
          txtqty.setText("");
          txttotal.setText("");
}

protected void autonumber(){
     try { 
             String sql = "SELECT id_nota FROM nota order by id_nota asc";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             txtkdbrg.setText("IN0001");
             while (rs.next()) {
                 String id_nota = rs.getString("id_nota").substring(2);
                 int AN = Integer.parseInt(id_nota) + 1;
                 String Nol ="";

                     if(AN<10)
                     {Nol = "000";}
                     else if(AN<100)
                     {Nol = "00";}
                     else if (AN<1000)
                     {Nol = "0";}
                     else if (AN<10000)
                     {Nol = "";}

                      txtkdbrg.setText("IN" + Nol + AN);
             }
     }catch(Exception e){
     JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
      }        
}

public void itemTerpilih(){
        Popup_pelanggan Pp = new Popup_pelanggan();
        Pp.plgn = this;
        Pp.setVisible(true);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid_nota = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        txtalmt = new javax.swing.JTextField();
        bcarip = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        txtkdbrg = new javax.swing.JTextField();
        txtnmbrg = new javax.swing.JTextField();
        txthb = new javax.swing.JTextField();
        txthj = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        bcaribrg = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        bhapus = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtttotal = new javax.swing.JTextField();

        jLabel9.setText("jLabel9");

        jLabel21.setText("Hapus");

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nota");

        jLabel2.setText("ID Nota");

        jLabel3.setText("Data Pelanggan");

        jLabel4.setText("ID Pelanggan");

        jLabel5.setText("Nama");

        jLabel6.setText("Alamat");

        bcarip.setText("Cari");
        bcarip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripActionPerformed(evt);
            }
        });

        jLabel7.setText("Tgl Nota");

        jLabel8.setText("Data Barang");

        jLabel10.setText("KD Barang");

        jLabel11.setText("Nama");

        jLabel12.setText("Harga Beli");

        jLabel13.setText("Harga Jual");

        jLabel14.setText("QTY");

        jLabel15.setText("Total");

        jLabel16.setText("ID Kasir");

        jLabel17.setText("Nama Kasir");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        bcaribrg.setText("Cari");
        bcaribrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribrgActionPerformed(evt);
            }
        });

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel20.setText("Transaksi");

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbltransaksi);

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        jLabel23.setText("Total Harga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(291, 291, 291))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel19)
                                .addGap(117, 117, 117))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bcarip, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtnm, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                .addComponent(txtalmt)))
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bcaribrg, javax.swing.GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE))
                                    .addComponent(txtnmbrg)
                                    .addComponent(txthb)
                                    .addComponent(txthj, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtqty, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txttotal))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bsimpan)
                                        .addGap(41, 41, 41)
                                        .addComponent(bbatal)
                                        .addGap(45, 45, 45)
                                        .addComponent(bkeluar)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bhapus))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarip)
                    .addComponent(jLabel10)
                    .addComponent(txtkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaribrg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txthb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txthj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtalmt))
                .addGap(18, 18, 18)
                .addComponent(btambah)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bhapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bbatal)
                    .addComponent(bkeluar)
                    .addComponent(jLabel23)
                    .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcaripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripActionPerformed
            Popup_pelanggan Pp = new Popup_pelanggan();
            Pp.plgn = this;
            Pp.setVisible(true);
            Pp.setResizable(false);
    }//GEN-LAST:event_bcaripActionPerformed

    public void itemTerpilihbrg(){
           Popup_barang Pbrg = new Popup_barang();
           Pbrg.brg = this;
           txtkdbrg.setText(kdbrg);
           txtnmbrg.setText(nmbrg);
           txthb.setText(hb);
           txthj.setText(hj);
           txtqty.requestFocus();
    } 
    
    private void bcaribrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribrgActionPerformed
            Popup_barang Pbrg = new Popup_barang();
            Pbrg.brg = this;
            Pbrg.setVisible(true);
            Pbrg.setResizable(false);
    }//GEN-LAST:event_bcaribrgActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
            int xhrgj=Integer.parseInt(txthj.getText());
            int xqty=Integer.parseInt(txtqty.getText());
            int xjml=xhrgj*xqty;
            txttotal.setText(String.valueOf(xjml));
    }//GEN-LAST:event_txtqtyActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
            try{
                String kode = txtkdbrg.getText();
                String nama = txtnmbrg.getText();
                int hargab = Integer.parseInt(txthb.getText());
                int hargaj = Integer.parseInt(txthj.getText());
                int qty = Integer.parseInt(txtqty.getText());
                int total = Integer.parseInt(txttotal.getText());
                
                tabmode.addRow(new Object[]{kode,nama,hargab,hargaj,qty,total});
                tbltransaksi.setModel(tabmode);
                }
                catch(Exception e)
                {
                System.out.println("Error : "+e);
            }
             txtid_nota.setText("");
             txtnm.setText("");
             txtkdbrg.setText("");
             txthb.setText("");
             txthj.setText("");
             txtqty.setText("");
             txttotal.setText("");
             hitung();
    }

    private void hitung(){
        //contoh sederhana menampilkan jumlah baris di table
        int table = tbltransaksi.getRowCount();
        txttotal.setText(String.valueOf(txttotal));
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
            int index = tbltransaksi.getSelectedRow();
            tabmode.removeRow(index);
            tbltransaksi.setModel(tabmode);
            hitung();
    }//GEN-LAST:event_bhapusActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            String fd = sdf.format(jtgl.getValue());
            String sql = "insert into nota values (?,?,?,?)";
            String zsql = "insert into isi values (?,?,?,?)";
            try{
                
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txtid_nota.getText());
                stat.setString(2, fd);
                stat.setString(3, txtid.getText());
                stat.setString(4, jLabel16.getText());
                
                stat.executeUpdate();
                
                int t = tbltransaksi.getRowCount();
                for(int i=0; i < t ; i++)
                {
                String txtkdbrg = tbltransaksi.getValueAt(i, 0).toString();
                String txthb = tbltransaksi.getValueAt(i, 2).toString();
                String txthj = tbltransaksi.getValueAt(i, 3).toString();
                String txtqty = tbltransaksi.getValueAt(i, 4).toString();
                
                PreparedStatement stat2 = conn.prepareStatement(zsql);
                stat2.setString(1, txtid_nota.getText());
                stat2.setString(2, txtkdbrg);
                stat2.setString(3, txthb);
                stat2.setString(4, txthj);
                stat2.setString(5, txtqty);
                
                stat2.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
            }
                kosong();
                aktif();
                autonumber();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
            kosong();
            aktif();
            autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
            dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcaribrg;
    private javax.swing.JButton bcarip;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextField txtalmt;
    private javax.swing.JTextField txthb;
    private javax.swing.JTextField txthj;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtid_nota;
    private javax.swing.JTextField txtkdbrg;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnmbrg;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtttotal;
    // End of variables declaration//GEN-END:variables
}
