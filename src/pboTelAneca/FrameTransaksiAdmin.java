package pboTelAneca;

import dao.ButtonEditor;
import dao.ButtonRenderer;
import dao.TransaksiDao;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;


public class FrameTransaksiAdmin extends javax.swing.JFrame {

    private int userId;
    

    public FrameTransaksiAdmin(int userId) {
        initComponents();
        this.userId = userId;
        configureTable();
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        BtnLaporan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bukaFrameLaporanAdmin(userId);
            }
        });
        BtnKembali.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bukaFrameDashboardAdmin();
            }
        });
    }

    private void configureTable() {
        jTable1.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Tgl Transaksi", "Nama Pembeli", "No Telp", "Total Bayar", "Catatan", "Action"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        });

        jTable1.getColumn("Action").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), "transaksi"));
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0); 

        ArrayList<Transaksi> list = TransaksiDao.getAllTransaksiByPenjual(userId);

        if (list.isEmpty()) {
            JLabel label = new JLabel("Maaf, data kosong");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setForeground(Color.RED);
            label.setFont(new Font("Arial", Font.BOLD, 14));

            jPanel2.add(label); 
            jPanel2.revalidate();
            jPanel2.repaint();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            for (Transaksi transaksiObj : list) {
                String formattedDate = (transaksiObj.getTglTransaksi() != null) 
                                        ? sdf.format(transaksiObj.getTglTransaksi()) 
                                        : "N/A";

                dtm.addRow(new Object[]{
                transaksiObj.getId(),
                formattedDate,
                transaksiObj.getNamaPembeli(),
                transaksiObj.getNoTelp(),
                transaksiObj.getTotalBayar(),
                transaksiObj.getCatatan(),
                "Details"
            });

            }

            jPanel2.revalidate();
            jPanel2.repaint();
        }
    }


    private void bukaFrameDashboardAdmin() {
        dispose();

        FrameDashboardAdmin frameBaru = new FrameDashboardAdmin();
        frameBaru.setVisible(true);
    }
    
    private void bukaFrameLaporanAdmin(int userId) {
        dispose();

        FrameLaporanAdmin frameBaru = new FrameLaporanAdmin(userId);
        frameBaru.setVisible(true);
    }
    
    public void openTransaksiDetails(int userId) {
        dispose();
        new FrameDetailTransaksi(userId).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnLaporan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnKembali = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        BtnLaporan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Laporan");

        javax.swing.GroupLayout BtnLaporanLayout = new javax.swing.GroupLayout(BtnLaporan);
        BtnLaporan.setLayout(BtnLaporanLayout);
        BtnLaporanLayout.setHorizontalGroup(
            BtnLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnLaporanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        BtnLaporanLayout.setVerticalGroup(
            BtnLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnLaporanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        BtnKembali.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Kembali");

        javax.swing.GroupLayout BtnKembaliLayout = new javax.swing.GroupLayout(BtnKembali);
        BtnKembali.setLayout(BtnKembaliLayout);
        BtnKembaliLayout.setHorizontalGroup(
            BtnKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnKembaliLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        BtnKembaliLayout.setVerticalGroup(
            BtnKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnKembaliLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(BtnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Transaksi");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tanggal", "Nama Pembeli", "No Telp", "Total Bayar", "Catatan", "Action"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            int userId = 1;
            new FrameTransaksiAdmin(userId).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnKembali;
    private javax.swing.JPanel BtnLaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
