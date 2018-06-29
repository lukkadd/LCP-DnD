/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.AdventureGearController;
import controller.ArmorController;
import controller.WeaponController;
import db.ResultSetTableModel;
import entity.AdventureGear;
import entity.Armor;
import entity.Weapon;
import entity.Access;
import gui.frmRelAdv;
import gui.frmRelArmor;
import gui.frmRelWpn;
import gui.FrmRegister;
import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author aluno
 */
public class frmVault extends javax.swing.JFrame {
    
    private Armor armor;
    private ArmorController armorC = new ArmorController();
    private AdventureGear advGear;
    private AdventureGearController advGController = new AdventureGearController();
    private Weapon weapon;
    private WeaponController weaponC = new WeaponController();
    private ResultSet advGList;
    private ResultSet armorList;
    private ResultSet weaponList;
    private Access access;
    /**
     * Creates new form frmVault
     */
    public frmVault(){
        initComponents();
        
        btnAdvRel.setVisible(false);
        btnAdvRel.setEnabled(false);
        btnRelArmor.setVisible(false);
        btnRelArmor.setEnabled(false);
        btnRelWeapon.setVisible(false);
        btnRelWeapon.setEnabled(false);
        mnRegister.setEnabled(false);
        mnRegister.setVisible(false);
    }
    
    public frmVault(Access acc) {
        initComponents();
        access = acc;
        if(access.getPermission() == 0){
            btnAdvRel.setVisible(false);
            btnAdvRel.setEnabled(false);
            btnRelArmor.setVisible(false);
            btnRelArmor.setEnabled(false);
            btnRelWeapon.setVisible(false);
            btnRelWeapon.setEnabled(false);
            mnRegister.setEnabled(false);
            mnRegister.setVisible(false);
        }
    }    
    
    public void fillTable(ResultSet rs, JTable table){
        ResultSetTableModel model = new ResultSetTableModel(rs);
        table.setModel(model);
    }
    
    public void fillFields(AdventureGear a){
        txtGearName.setText(a.getName());
        txtGearCost.setText(String.valueOf(a.getCost()));
        txtGearWeight.setText(a.getWeight());
        txtDescription.setText(a.getDescription());
        cmbGearType.setSelectedItem(a.getGear_type());
    }
    
    public void clearFields(){
        advGear = null;
        txtGearName.setText("");
        txtGearCost.setText("");
        txtGearWeight.setText("");
        txtDescription.setText("");
        cmbGearType.setSelectedIndex(0);
    }
    
    public void habilitaDesabilitaCamposGear(boolean habilita) {
        txtGearName.setEnabled(habilita);
        txtGearCost.setEnabled(habilita);
        txtGearWeight.setEnabled(habilita);
        txtDescription.setEnabled(habilita);
        cmbGearType.setEnabled(habilita);
    }
    
    public void preencheCamposArmor(Armor a) {
        txtArmorName.setText(a.getName());
        txtArmorCost.setText(Integer.toString(a.getCost()));
        txtArmorWeight.setText(a.getWeight());
        btnArmorIsEquiped.setSelected(a.isIsEquiped());
        if (a.isIsEquiped()) {
            btnArmorIsEquiped.setText("True");
        }
        else {
            btnArmorIsEquiped.setText("False");
        }
        cmbArmorType.setSelectedItem(a.getArmor_type());
        txtACBonus.setText(Integer.toString(a.getBase_AC_bonus()));
        cmbModifier.setSelectedIndex(a.getModifier());
        btnStealthDArmor.setSelected(a.isStealth_disadvantage());
        if (a.isStealth_disadvantage()) {
            btnStealthDArmor.setText("True");
        }
        else {
            btnStealthDArmor.setText("False");
        }
        txtStrenghtRArmor.setText(Integer.toString(a.getStrength_requirement()));
    }
    
    public void habilitaDesabilitaCamposArmor(boolean habilita) {
        txtArmorName.setEnabled(habilita);
        txtArmorCost.setEnabled(habilita);
        txtArmorWeight.setEnabled(habilita);
        btnArmorIsEquiped.setEnabled(habilita);
        cmbArmorType.setEnabled(habilita);
        txtACBonus.setEnabled(habilita);
        cmbModifier.setEnabled(habilita);
        btnStealthDArmor.setEnabled(habilita);
        txtStrenghtRArmor.setEnabled(habilita);
    }
    
    public void limpaCamposArmor() {
        armor = null;
        txtArmorName.setText("");
        txtArmorCost.setText("");
        txtArmorWeight.setText("");
        btnArmorIsEquiped.setSelected(false);
        btnArmorIsEquiped.setText("False");
        cmbArmorType.setSelectedIndex(0);
        txtACBonus.setText("");
        cmbModifier.setSelectedIndex(0);
        btnStealthDArmor.setSelected(false);
        btnStealthDArmor.setText("False");
        txtStrenghtRArmor.setText("");
    }
    
    public void preencheCamposWeapon(Weapon w) {
        txtWpnName.setText(w.getName());
        txtWpnCost.setText(Integer.toString(w.getCost()));
        txtWpnWeight.setText(w.getWeight());
        btnWpnIsEquiped.setSelected(w.isIsEquiped());
        if (w.isIsEquiped()) {
            btnWpnIsEquiped.setText("True");
        }
        else {
            btnWpnIsEquiped.setText("False");
        }
        cmbWpnType.setSelectedItem(w.getWeapon_type());
        txtWpnMinRange.setText(Integer.toString(w.getMin_range()));
        txtWpnMaxRange.setText(Integer.toString(w.getMax_range()));
        chkWpnHeavy.setSelected(w.isHeavy());
        chkWpnLoading.setSelected(w.isLoading());
        chkWpnThrown.setSelected(w.isThrown());
        chkWpnTwoHanded.setSelected(w.isTwo_handed());
        chkWpnAmmunition.setSelected(w.isAmmunition());
        chkWpnFinesse.setSelected(w.isFinesse());
        txtWpnAttack.setText(w.getNormal_attack());
        txtWpnTHAttack.setText(w.getTwo_handed_attack());
    }
    
    public void habilitaDesabilitaCamposWeapon(boolean habilita) {
        txtWpnName.setEnabled(habilita);
        txtWpnCost.setEnabled(habilita);
        txtWpnWeight.setEnabled(habilita);
        btnWpnIsEquiped.setEnabled(habilita);
        cmbWpnType.setEnabled(habilita);
        txtWpnMinRange.setEnabled(habilita);
        txtWpnMaxRange.setEnabled(false);
        chkWpnHeavy.setEnabled(habilita);
        chkWpnLoading.setEnabled(habilita);
        chkWpnThrown.setEnabled(habilita);
        chkWpnTwoHanded.setEnabled(habilita);
        chkWpnAmmunition.setEnabled(habilita);
        chkWpnFinesse.setEnabled(habilita);
        txtWpnAttack.setEnabled(habilita);
        txtWpnTHAttack.setEnabled(habilita);
    }
    
    public void limpaCamposWeapon() {
        weapon = null;
        txtWpnName.setText("");
        txtWpnCost.setText("");
        txtWpnWeight.setText("");
        btnWpnIsEquiped.setSelected(false);
        btnWpnIsEquiped.setText("False");
        cmbWpnType.setSelectedIndex(0);
        txtWpnMinRange.setText("");
        txtWpnMaxRange.setText("");
        chkWpnHeavy.setSelected(false);
        chkWpnLoading.setSelected(false);
        chkWpnThrown.setSelected(false);
        chkWpnTwoHanded.setSelected(false);
        chkWpnAmmunition.setSelected(false);
        chkWpnFinesse.setSelected(false);
        txtWpnAttack.setText("");
        txtWpnTHAttack.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVault = new javax.swing.JPanel();
        jtVault = new javax.swing.JTabbedPane();
        jpAdventureGear = new javax.swing.JPanel();
        lblDescriptionGear = new javax.swing.JLabel();
        lblTypeGear = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        tbAdventureGear = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAdvRel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGear = new javax.swing.JTable();
        cmbGearType = new javax.swing.JComboBox<String>();
        lblGearName = new javax.swing.JLabel();
        txtGearName = new javax.swing.JTextField();
        lblGearCost = new javax.swing.JLabel();
        txtGearCost = new javax.swing.JTextField();
        lblGearWeight = new javax.swing.JLabel();
        txtGearWeight = new javax.swing.JTextField();
        jpArmor = new javax.swing.JPanel();
        lblTypeArmor = new javax.swing.JLabel();
        lblACBonus = new javax.swing.JLabel();
        lblModifierArmor = new javax.swing.JLabel();
        lblStealthDArmor = new javax.swing.JLabel();
        lblStrenghtRArmor = new javax.swing.JLabel();
        txtACBonus = new javax.swing.JTextField();
        txtStrenghtRArmor = new javax.swing.JTextField();
        tbArmor = new javax.swing.JToolBar();
        btnNewArmor = new javax.swing.JButton();
        btnUpdateArmor = new javax.swing.JButton();
        btnDeleteArmor = new javax.swing.JButton();
        btnSaveArmor = new javax.swing.JButton();
        btnCancelArmor = new javax.swing.JButton();
        btnRelArmor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblArmor = new javax.swing.JTable();
        cmbModifier = new javax.swing.JComboBox<String>();
        btnStealthDArmor = new javax.swing.JToggleButton();
        cmbArmorType = new javax.swing.JComboBox<String>();
        txtArmorName = new javax.swing.JTextField();
        lblArmorName = new javax.swing.JLabel();
        lblArmorCost = new javax.swing.JLabel();
        txtArmorCost = new javax.swing.JTextField();
        lblArmorWeight = new javax.swing.JLabel();
        txtArmorWeight = new javax.swing.JTextField();
        lblArmorIsEquiped = new javax.swing.JLabel();
        btnArmorIsEquiped = new javax.swing.JToggleButton();
        jpWeapon = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWeapon = new javax.swing.JTable();
        tbWeapon = new javax.swing.JToolBar();
        btnNewWpn = new javax.swing.JButton();
        btnUpdateWpn = new javax.swing.JButton();
        btnDeleteWpn = new javax.swing.JButton();
        btnSaveWpn = new javax.swing.JButton();
        btnCancelWpn = new javax.swing.JButton();
        btnRelWeapon = new javax.swing.JButton();
        lblWpnName = new javax.swing.JLabel();
        txtWpnName = new javax.swing.JTextField();
        lblWpnCost = new javax.swing.JLabel();
        txtWpnCost = new javax.swing.JTextField();
        lblWpnType = new javax.swing.JLabel();
        cmbWpnType = new javax.swing.JComboBox<String>();
        lblWpnRange = new javax.swing.JLabel();
        txtWpnMaxRange = new javax.swing.JTextField();
        txtWpnMinRange = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkWpnHeavy = new javax.swing.JCheckBox();
        chkWpnLoading = new javax.swing.JCheckBox();
        chkWpnThrown = new javax.swing.JCheckBox();
        chkWpnTwoHanded = new javax.swing.JCheckBox();
        chkWpnAmmunition = new javax.swing.JCheckBox();
        chkWpnFinesse = new javax.swing.JCheckBox();
        lblWpnAttack = new javax.swing.JLabel();
        txtWpnAttack = new javax.swing.JTextField();
        lblWpnTHAttack = new javax.swing.JLabel();
        txtWpnTHAttack = new javax.swing.JTextField();
        lblWpnWeight = new javax.swing.JLabel();
        txtWpnWeight = new javax.swing.JTextField();
        lblWpnIsEquiped = new javax.swing.JLabel();
        btnWpnIsEquiped = new javax.swing.JToggleButton();
        jpMonster = new javax.swing.JPanel();
        jpSpell = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnUpdate = new javax.swing.JMenuItem();
        mnRegister = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vault");
        setName("jfVault"); // NOI18N
        setResizable(false);

        jpAdventureGear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAdventureGearMouseClicked(evt);
            }
        });
        jpAdventureGear.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpAdventureGearComponentShown(evt);
            }
        });

        lblDescriptionGear.setText("Description :");

        lblTypeGear.setText("Gear Type :");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        tbAdventureGear.setRollover(true);

        btnNew.setText("New");
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        tbAdventureGear.add(btnNew);

        btnUpdate.setText("Update");
        btnUpdate.setFocusable(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        tbAdventureGear.add(btnUpdate);

        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        tbAdventureGear.add(btnDelete);

        btnSave.setText("Save");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        tbAdventureGear.add(btnSave);

        btnCancel.setText("Cancel");
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        tbAdventureGear.add(btnCancel);

        btnAdvRel.setText("Relatorio");
        btnAdvRel.setFocusable(false);
        btnAdvRel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdvRel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdvRel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdvRelMouseClicked(evt);
            }
        });
        tbAdventureGear.add(btnAdvRel);

        tblGear.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Cost", "Weight", "Gear Type", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGearMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGear);

        cmbGearType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Tools", "Mount and Vehicles", "Trade Goods", "Food Drink and Lodging" }));
        cmbGearType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGearTypeActionPerformed(evt);
            }
        });

        lblGearName.setText("Name :");

        txtGearName.setToolTipText("");

        lblGearCost.setText("Cost :");
        lblGearCost.setToolTipText("");

        txtGearCost.setToolTipText("cost must be in copper pieces");

        lblGearWeight.setText("Weight :");

        javax.swing.GroupLayout jpAdventureGearLayout = new javax.swing.GroupLayout(jpAdventureGear);
        jpAdventureGear.setLayout(jpAdventureGearLayout);
        jpAdventureGearLayout.setHorizontalGroup(
            jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdventureGearLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGearType, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypeGear)
                    .addGroup(jpAdventureGearLayout.createSequentialGroup()
                        .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGearName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGearName)
                            .addComponent(lblGearWeight)
                            .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtGearWeight, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescriptionGear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGearCost)
                            .addComponent(txtGearCost, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tbAdventureGear, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpAdventureGearLayout.setVerticalGroup(
            jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdventureGearLayout.createSequentialGroup()
                .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAdventureGearLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(jpAdventureGearLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGearName)
                            .addComponent(lblGearCost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAdventureGearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGearName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGearCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGearWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGearWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDescriptionGear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTypeGear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGearType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(tbAdventureGear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtVault.addTab("Adventure Gear", jpAdventureGear);

        jpArmor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpArmorComponentShown(evt);
            }
        });

        lblTypeArmor.setText("Armor Type :");

        lblACBonus.setText("AC Bonus Base :");

        lblModifierArmor.setText("Modifier :");

        lblStealthDArmor.setText("Stealth Disadvantage :");

        lblStrenghtRArmor.setText("Strenght Requirement :");

        tbArmor.setRollover(true);

        btnNewArmor.setText("New");
        btnNewArmor.setFocusable(false);
        btnNewArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNewArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnNewArmor);

        btnUpdateArmor.setText("Update");
        btnUpdateArmor.setFocusable(false);
        btnUpdateArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnUpdateArmor);

        btnDeleteArmor.setText("Delete");
        btnDeleteArmor.setFocusable(false);
        btnDeleteArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnDeleteArmor);

        btnSaveArmor.setText("Save");
        btnSaveArmor.setFocusable(false);
        btnSaveArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnSaveArmor);

        btnCancelArmor.setText("Cancel");
        btnCancelArmor.setFocusable(false);
        btnCancelArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnCancelArmor);

        btnRelArmor.setText("Relatorio");
        btnRelArmor.setFocusable(false);
        btnRelArmor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelArmor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRelArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelArmorMouseClicked(evt);
            }
        });
        tbArmor.add(btnRelArmor);

        tblArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Cost", "Weight", "Equiped", "Type", "AC Bonus", "Modifier", "Strength Req", "Stealth Disadv"
            }
        ));
        tblArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblArmor);

        cmbModifier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Modifier", "Dex Modifier", "Dex Modifier (max 2)", " " }));

        btnStealthDArmor.setText("False");
        btnStealthDArmor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStealthDArmorActionPerformed(evt);
            }
        });

        cmbArmorType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Light Armor", "Medium Armor", "Heavy Armor", "Shield" }));

        txtArmorName.setToolTipText("");

        lblArmorName.setText("Name :");

        lblArmorCost.setText("Cost :");
        lblArmorCost.setToolTipText("");

        txtArmorCost.setToolTipText("cost must be in copper pieces");

        lblArmorWeight.setText("Weight :");
        lblArmorWeight.setToolTipText("");

        txtArmorWeight.setToolTipText("cost must be in copper pieces");

        lblArmorIsEquiped.setText("Is Equiped:");

        btnArmorIsEquiped.setText("False");
        btnArmorIsEquiped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmorIsEquipedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpArmorLayout = new javax.swing.GroupLayout(jpArmor);
        jpArmor.setLayout(jpArmorLayout);
        jpArmorLayout.setHorizontalGroup(
            jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArmorLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArmorLayout.createSequentialGroup()
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblModifierArmor)
                            .addComponent(lblTypeArmor)
                            .addComponent(cmbModifier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbArmorType, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtACBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblACBonus)
                            .addComponent(lblStealthDArmor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStealthDArmor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblStrenghtRArmor)
                    .addComponent(txtStrenghtRArmor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpArmorLayout.createSequentialGroup()
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArmorName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArmorName))
                        .addGap(18, 18, 18)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArmorCost)
                            .addComponent(txtArmorCost, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpArmorLayout.createSequentialGroup()
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArmorWeight)
                            .addComponent(txtArmorWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblArmorIsEquiped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnArmorIsEquiped, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tbArmor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpArmorLayout.setVerticalGroup(
            jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpArmorLayout.createSequentialGroup()
                .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpArmorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(jpArmorLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArmorName)
                            .addComponent(lblArmorCost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArmorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArmorCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpArmorLayout.createSequentialGroup()
                                .addComponent(lblArmorWeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtArmorWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpArmorLayout.createSequentialGroup()
                                .addComponent(lblArmorIsEquiped)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnArmorIsEquiped)))
                        .addGap(4, 4, 4)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTypeArmor)
                            .addComponent(lblACBonus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtACBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbArmorType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModifierArmor)
                            .addComponent(lblStealthDArmor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpArmorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStealthDArmor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStrenghtRArmor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStrenghtRArmor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbArmor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtVault.addTab("Armor", jpArmor);

        jpWeapon.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpWeaponComponentShown(evt);
            }
        });

        tblWeapon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblWeapon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWeaponMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblWeapon);

        tbWeapon.setRollover(true);

        btnNewWpn.setText("New");
        btnNewWpn.setFocusable(false);
        btnNewWpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewWpn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNewWpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewWpnMouseClicked(evt);
            }
        });
        tbWeapon.add(btnNewWpn);

        btnUpdateWpn.setText("Update");
        btnUpdateWpn.setEnabled(false);
        btnUpdateWpn.setFocusable(false);
        btnUpdateWpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateWpn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateWpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateWpnMouseClicked(evt);
            }
        });
        tbWeapon.add(btnUpdateWpn);

        btnDeleteWpn.setText("Delete");
        btnDeleteWpn.setEnabled(false);
        btnDeleteWpn.setFocusable(false);
        btnDeleteWpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteWpn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteWpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteWpnMouseClicked(evt);
            }
        });
        tbWeapon.add(btnDeleteWpn);

        btnSaveWpn.setText("Save");
        btnSaveWpn.setEnabled(false);
        btnSaveWpn.setFocusable(false);
        btnSaveWpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveWpn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveWpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveWpnMouseClicked(evt);
            }
        });
        tbWeapon.add(btnSaveWpn);

        btnCancelWpn.setText("Cancel");
        btnCancelWpn.setEnabled(false);
        btnCancelWpn.setFocusable(false);
        btnCancelWpn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelWpn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelWpn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelWpnMouseClicked(evt);
            }
        });
        tbWeapon.add(btnCancelWpn);

        btnRelWeapon.setText("Relatorio");
        btnRelWeapon.setFocusable(false);
        btnRelWeapon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelWeapon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRelWeapon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRelWeaponMouseClicked(evt);
            }
        });
        tbWeapon.add(btnRelWeapon);

        lblWpnName.setText("Name :");

        lblWpnCost.setText("Cost :");

        lblWpnType.setText("Weapon Type :");

        cmbWpnType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple Melee", "Simple Ranged", "Martial Melee", "Martial Ranged" }));
        cmbWpnType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbWpnTypeItemStateChanged(evt);
            }
        });
        cmbWpnType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbWpnTypeActionPerformed(evt);
            }
        });

        lblWpnRange.setText("Range :");

        jLabel1.setText("-");

        chkWpnHeavy.setText("Heavy");

        chkWpnLoading.setText("Loading");

        chkWpnThrown.setText("Thrown");

        chkWpnTwoHanded.setText("Two Handed");
        chkWpnTwoHanded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWpnTwoHandedActionPerformed(evt);
            }
        });

        chkWpnAmmunition.setText("Ammunition");

        chkWpnFinesse.setText("Finesse");

        lblWpnAttack.setText("Attack Damage");

        lblWpnTHAttack.setText("Two Handed Attack Damage");

        lblWpnWeight.setText("Weight :");
        lblWpnWeight.setToolTipText("");

        txtWpnWeight.setToolTipText("cost must be in copper pieces");

        lblWpnIsEquiped.setText("Is Equiped:");

        btnWpnIsEquiped.setText("False");
        btnWpnIsEquiped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWpnIsEquipedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpWeaponLayout = new javax.swing.GroupLayout(jpWeapon);
        jpWeapon.setLayout(jpWeaponLayout);
        jpWeaponLayout.setHorizontalGroup(
            jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpWeaponLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWpnAttack)
                    .addComponent(lblWpnTHAttack)
                    .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtWpnTHAttack, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtWpnAttack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpWeaponLayout.createSequentialGroup()
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbWpnType, 0, 142, Short.MAX_VALUE)
                            .addComponent(lblWpnType, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtWpnMinRange)
                            .addComponent(lblWpnRange))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWpnMaxRange, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jpWeaponLayout.createSequentialGroup()
                            .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblWpnWeight)
                                .addComponent(txtWpnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblWpnIsEquiped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnWpnIsEquiped, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpWeaponLayout.createSequentialGroup()
                            .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkWpnTwoHanded)
                                .addComponent(chkWpnHeavy))
                            .addGap(18, 18, 18)
                            .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkWpnLoading)
                                .addComponent(chkWpnAmmunition))
                            .addGap(18, 18, 18)
                            .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkWpnThrown)
                                .addComponent(chkWpnFinesse))))
                    .addGroup(jpWeaponLayout.createSequentialGroup()
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWpnName)
                            .addComponent(txtWpnName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWpnCost, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWpnCost))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpWeaponLayout.setVerticalGroup(
            jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpWeaponLayout.createSequentialGroup()
                .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpWeaponLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(jpWeaponLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWpnName)
                            .addComponent(lblWpnCost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWpnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWpnCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpWeaponLayout.createSequentialGroup()
                                .addComponent(lblWpnWeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtWpnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpWeaponLayout.createSequentialGroup()
                                .addComponent(lblWpnIsEquiped)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnWpnIsEquiped)))
                        .addGap(9, 9, 9)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWpnType)
                            .addComponent(lblWpnRange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbWpnType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWpnMaxRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWpnMinRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkWpnHeavy)
                            .addComponent(chkWpnLoading)
                            .addComponent(chkWpnThrown))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkWpnTwoHanded)
                            .addComponent(chkWpnAmmunition)
                            .addComponent(chkWpnFinesse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblWpnAttack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWpnAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblWpnTHAttack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWpnTHAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jtVault.addTab("Weapon", jpWeapon);

        javax.swing.GroupLayout jpMonsterLayout = new javax.swing.GroupLayout(jpMonster);
        jpMonster.setLayout(jpMonsterLayout);
        jpMonsterLayout.setHorizontalGroup(
            jpMonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        jpMonsterLayout.setVerticalGroup(
            jpMonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jtVault.addTab("Monster", jpMonster);

        javax.swing.GroupLayout jpSpellLayout = new javax.swing.GroupLayout(jpSpell);
        jpSpell.setLayout(jpSpellLayout);
        jpSpellLayout.setHorizontalGroup(
            jpSpellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        jpSpellLayout.setVerticalGroup(
            jpSpellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jtVault.addTab("Spell", jpSpell);

        javax.swing.GroupLayout jpVaultLayout = new javax.swing.GroupLayout(jpVault);
        jpVault.setLayout(jpVaultLayout);
        jpVaultLayout.setHorizontalGroup(
            jpVaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(jpVaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpVaultLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jtVault)
                    .addGap(2, 2, 2)))
        );
        jpVaultLayout.setVerticalGroup(
            jpVaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(jpVaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpVaultLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jtVault)
                    .addContainerGap()))
        );

        jMenu1.setText("Options");

        mnUpdate.setText("Update Account");
        mnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUpdateActionPerformed(evt);
            }
        });
        jMenu1.add(mnUpdate);

        mnRegister.setText("Register Account");
        mnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegisterActionPerformed(evt);
            }
        });
        jMenu1.add(mnRegister);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpVault, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpVault, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpWeaponComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpWeaponComponentShown
        limpaCamposWeapon();
        habilitaDesabilitaCamposWeapon(false);

        btnNewWpn.setEnabled(true);
        btnUpdateWpn.setEnabled(false);
        btnDeleteWpn.setEnabled(false);
        btnSaveWpn.setEnabled(false);
        btnCancelWpn.setEnabled(false);

        //reload table
        try {
            weaponList = weaponC.getWeaponList();
            fillTable(weaponList,tblWeapon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jpWeaponComponentShown

    private void btnWpnIsEquipedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWpnIsEquipedMouseClicked
        if(btnWpnIsEquiped.isSelected()){
            btnWpnIsEquiped.setText("True");
        }else{
            btnWpnIsEquiped.setText("False");
        }
    }//GEN-LAST:event_btnWpnIsEquipedMouseClicked

    private void chkWpnTwoHandedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWpnTwoHandedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkWpnTwoHandedActionPerformed

    private void cmbWpnTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWpnTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbWpnTypeActionPerformed

    private void cmbWpnTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbWpnTypeItemStateChanged
        // TODO add your handling code here:
        if(cmbWpnType.getSelectedItem().toString().contains("Melee")){
            txtWpnMaxRange.setEnabled(false);
        }else{
            txtWpnMaxRange.setEnabled(true);
        }
    }//GEN-LAST:event_cmbWpnTypeItemStateChanged

    private void btnCancelWpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelWpnMouseClicked
        if (btnCancelWpn.isEnabled()) {
            limpaCamposWeapon();
            habilitaDesabilitaCamposWeapon(true);

            btnNewWpn.setEnabled(false);
            btnUpdateWpn.setEnabled(false);
            btnDeleteWpn.setEnabled(false);
            btnCancelWpn.setEnabled(true);
            btnSaveWpn.setEnabled(true);
        }
    }//GEN-LAST:event_btnCancelWpnMouseClicked

    private void btnSaveWpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveWpnMouseClicked
        if (btnSaveWpn.isEnabled()) {
            String weaponName, weaponWeight, weaponType, normalAtk, twoHandedAtk;
            int weaponCost, minRange, maxRange = 0;
            boolean isEquiped, heavy, loading, thrown, twoHanded, ammunition, finesse;

            weaponName = txtWpnName.getText();
            weaponWeight = txtWpnWeight.getText();
            weaponType = (String)cmbWpnType.getSelectedItem();
            normalAtk = txtWpnAttack.getText();
            twoHandedAtk = txtWpnTHAttack.getText();
            weaponCost = Integer.parseInt(txtWpnCost.getText());
            minRange = Integer.parseInt(txtWpnMinRange.getText());
            if (txtWpnMaxRange.isEnabled()) maxRange = Integer.parseInt(txtWpnMaxRange.getText());
            isEquiped = btnWpnIsEquiped.isSelected();
            heavy = chkWpnHeavy.isSelected();
            loading = chkWpnLoading.isSelected();
            thrown = chkWpnThrown.isSelected();
            twoHanded = chkWpnTwoHanded.isSelected();
            ammunition = chkWpnAmmunition.isSelected();
            finesse = chkWpnFinesse.isSelected();
            weapon = new Weapon(weaponType, heavy, loading, minRange, maxRange,
                thrown, twoHanded, ammunition, finesse, normalAtk, twoHandedAtk, isEquiped,
                weaponName, weaponCost, weaponWeight);

            if (weaponC.insert(weapon) == 1) {
                System.out.println("weapon inserted!");
            }
            else {
                System.out.println("error");
            }

            limpaCamposWeapon();
            habilitaDesabilitaCamposWeapon(false);

            btnNewWpn.setEnabled(true);
            btnUpdateWpn.setEnabled(false);
            btnDeleteWpn.setEnabled(false);
            btnSaveWpn.setEnabled(false);
            btnCancelWpn.setEnabled(false);

            //reload table
            try {
                weaponList = weaponC.getWeaponList();
                fillTable(weaponList,tblWeapon);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveWpnMouseClicked

    private void btnDeleteWpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteWpnMouseClicked
        if (btnDeleteWpn.isEnabled()) {
            weaponC.remove(weapon);
            limpaCamposWeapon();
            habilitaDesabilitaCamposWeapon(false);

            btnNewWpn.setEnabled(true);
            btnUpdateWpn.setEnabled(false);
            btnDeleteWpn.setEnabled(false);
            btnCancelWpn.setEnabled(false);
            btnSaveWpn.setEnabled(false);

            //reload table
            try {
                weaponList = weaponC.getWeaponList();
                fillTable(weaponList,tblWeapon);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteWpnMouseClicked

    private void btnUpdateWpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateWpnMouseClicked
        if (btnUpdateWpn.isEnabled()) {
            weapon = new Weapon(weapon.getIdWeapon(),
                cmbWpnType.getSelectedItem().toString(),
                chkWpnHeavy.isSelected(),
                chkWpnLoading.isSelected(),
                Integer.parseInt(txtWpnMinRange.getText()),
                Integer.parseInt(txtWpnMaxRange.getText()),
                chkWpnThrown.isSelected(),
                chkWpnTwoHanded.isSelected(),
                chkWpnAmmunition.isSelected(),
                chkWpnFinesse.isSelected(),
                txtWpnAttack.getText(),
                txtWpnTHAttack.getText(),
                btnWpnIsEquiped.isSelected(),
                txtWpnName.getText(),
                Integer.parseInt(txtWpnCost.getText()),
                txtWpnWeight.getText());

            weaponC.update(weapon);
            limpaCamposWeapon();
            habilitaDesabilitaCamposWeapon(false);

            btnNewWpn.setEnabled(true);
            btnUpdateWpn.setEnabled(false);
            btnDeleteWpn.setEnabled(false);
            btnSaveWpn.setEnabled(false);
            btnCancelWpn.setEnabled(false);

            //reload table
            try {
                weaponList = weaponC.getWeaponList();
                fillTable(weaponList,tblWeapon);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateWpnMouseClicked

    private void btnNewWpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewWpnMouseClicked
        if (btnNewWpn.isEnabled()) {
            limpaCamposWeapon();
            habilitaDesabilitaCamposWeapon(true);

            btnNewWpn.setEnabled(false);
            btnUpdateWpn.setEnabled(false);
            btnDeleteWpn.setEnabled(false);
            btnSaveWpn.setEnabled(true);
            btnCancelWpn.setEnabled(true);
        }
    }//GEN-LAST:event_btnNewWpnMouseClicked

    private void tblWeaponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWeaponMouseClicked
        habilitaDesabilitaCamposWeapon(true);

        btnNewWpn.setEnabled(false);
        btnUpdateWpn.setEnabled(true);
        btnDeleteWpn.setEnabled(true);
        btnCancelWpn.setEnabled(true);
        btnSaveWpn.setEnabled(false);

        int row = tblWeapon.getSelectedRow();
        weapon = new Weapon(((Long) tblWeapon.getValueAt(row,0)).intValue(),tblWeapon.getValueAt(row,5).toString(),
            (boolean)tblWeapon.getValueAt(row,6), (boolean)tblWeapon.getValueAt(row,7),
            Integer.parseInt(tblWeapon.getValueAt(row,8).toString()),
            Integer.parseInt(tblWeapon.getValueAt(row,9).toString()),
            (boolean)tblWeapon.getValueAt(row,10), (boolean)tblWeapon.getValueAt(row,11),
            (boolean)tblWeapon.getValueAt(row,12), (boolean)tblWeapon.getValueAt(row,13),
            tblWeapon.getValueAt(row,14).toString(), tblWeapon.getValueAt(row,15).toString(),
            (boolean)tblWeapon.getValueAt(row,4), tblWeapon.getValueAt(row,1).toString(),
            Integer.parseInt(tblWeapon.getValueAt(row,2).toString()),
            tblWeapon.getValueAt(row,3).toString());

        preencheCamposWeapon(weapon);
    }//GEN-LAST:event_tblWeaponMouseClicked

    private void jpArmorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpArmorComponentShown
        limpaCamposArmor();
        habilitaDesabilitaCamposArmor(false);

        btnNewArmor.setEnabled(true);
        btnUpdateArmor.setEnabled(false);
        btnDeleteArmor.setEnabled(false);
        btnCancelArmor.setEnabled(false);
        btnSaveArmor.setEnabled(false);

        //reload table
        try {
            armorList = armorC.getArmorList();
            fillTable(armorList,tblArmor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jpArmorComponentShown

    private void btnArmorIsEquipedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmorIsEquipedActionPerformed
        if(btnArmorIsEquiped.isSelected()){
            btnArmorIsEquiped.setText("True");
        }else{
            btnArmorIsEquiped.setText("False");
        }
    }//GEN-LAST:event_btnArmorIsEquipedActionPerformed

    private void btnStealthDArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStealthDArmorActionPerformed
        // TODO add your handling code here:
        if(btnStealthDArmor.isSelected()){
            btnStealthDArmor.setText("True");
        }else{
            btnStealthDArmor.setText("False");
        }
    }//GEN-LAST:event_btnStealthDArmorActionPerformed

    private void tblArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmorMouseClicked
        habilitaDesabilitaCamposArmor(true);

        btnNewArmor.setEnabled(false);
        btnUpdateArmor.setEnabled(true);
        btnDeleteArmor.setEnabled(true);
        btnCancelArmor.setEnabled(true);
        btnSaveArmor.setEnabled(false);

        int row = tblArmor.getSelectedRow();
        armor = new Armor(((Long) tblArmor.getValueAt(row,0)).intValue(),tblArmor.getValueAt(row,5).toString(),
            Integer.parseInt(tblArmor.getValueAt(row,6).toString()),
            Integer.parseInt(tblArmor.getValueAt(row,7).toString()),
            Integer.parseInt(tblArmor.getValueAt(row,8).toString()), (boolean)tblArmor.getValueAt(row,9),
            (boolean)tblArmor.getValueAt(row,4), tblArmor.getValueAt(row,1).toString(),
            Integer.parseInt(tblArmor.getValueAt(row,2).toString()), tblArmor.getValueAt(row,3).toString());

        preencheCamposArmor(armor);
    }//GEN-LAST:event_tblArmorMouseClicked

    private void btnCancelArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelArmorMouseClicked
        if (btnCancelArmor.isEnabled()) {
            limpaCamposArmor();
            habilitaDesabilitaCamposArmor(true);

            btnNewArmor.setEnabled(false);
            btnUpdateArmor.setEnabled(false);
            btnDeleteArmor.setEnabled(false);
            btnCancelArmor.setEnabled(true);
            btnSaveArmor.setEnabled(true);
        }
    }//GEN-LAST:event_btnCancelArmorMouseClicked

    private void btnSaveArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveArmorMouseClicked
        if (btnSaveArmor.isEnabled()) {
            //Faz o insert
            String armorName,armorWeight, armorType;
            int baseACBonus, modifier, strengthReq, armorCost;
            boolean isEquiped, stealthDArmor;

            armorName = txtArmorName.getText();
            armorWeight = txtArmorWeight.getText();
            armorCost = Integer.parseInt(txtArmorCost.getText());
            armorType = (String)cmbArmorType.getSelectedItem();
            baseACBonus = Integer.parseInt(txtACBonus.getText());
            modifier = cmbModifier.getSelectedIndex();
            strengthReq = Integer.parseInt(txtStrenghtRArmor.getText());
            isEquiped = btnArmorIsEquiped.isSelected();
            stealthDArmor = btnStealthDArmor.isEnabled();
            armor = new Armor(armorType, baseACBonus, modifier,
                strengthReq, stealthDArmor, isEquiped, armorName,
                armorCost, armorWeight);

            if (armorC.insert(armor) == 1) {
                System.out.println("armor inserted!");
            }
            else {
                System.out.println("error");
            }

            limpaCamposArmor();
            habilitaDesabilitaCamposArmor(false);

            btnNewArmor.setEnabled(true);
            btnUpdateArmor.setEnabled(false);
            btnDeleteArmor.setEnabled(false);
            btnCancelArmor.setEnabled(false);
            btnSaveArmor.setEnabled(false);

            //reload table
            try {
                armorList = armorC.getArmorList();
                fillTable(armorList,tblArmor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveArmorMouseClicked

    private void btnDeleteArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteArmorMouseClicked
        if (btnDeleteArmor.isEnabled()) {
            armorC.remove(armor);
            limpaCamposArmor();
            habilitaDesabilitaCamposArmor(false);

            btnNewArmor.setEnabled(true);
            btnUpdateArmor.setEnabled(false);
            btnDeleteArmor.setEnabled(false);
            btnCancelArmor.setEnabled(false);
            btnSaveArmor.setEnabled(false);

            //reload table
            try {
                armorList = armorC.getArmorList();
                fillTable(armorList,tblArmor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteArmorMouseClicked

    private void btnUpdateArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateArmorMouseClicked
        if (btnUpdateArmor.isEnabled()) {
            armor = new Armor(armor.getIdArmor(),
                cmbArmorType.getSelectedItem().toString(),
                Integer.parseInt(txtACBonus.getText()),
                cmbModifier.getSelectedIndex(),
                Integer.parseInt(txtStrenghtRArmor.getText()),
                btnStealthDArmor.isSelected(),
                btnArmorIsEquiped.isSelected(),
                txtArmorName.getText(),
                Integer.parseInt(txtArmorCost.getText()),
                txtArmorWeight.getText());

            armorC.update(armor);
            limpaCamposArmor();
            habilitaDesabilitaCamposArmor(false);

            btnNewArmor.setEnabled(true);
            btnUpdateArmor.setEnabled(false);
            btnDeleteArmor.setEnabled(false);
            btnCancelArmor.setEnabled(false);
            btnSaveArmor.setEnabled(false);

            //reload table
            try {
                armorList = armorC.getArmorList();
                fillTable(armorList,tblArmor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateArmorMouseClicked

    private void btnNewArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewArmorMouseClicked
        if (btnNewArmor.isEnabled()) {
            limpaCamposArmor();
            habilitaDesabilitaCamposArmor(true);

            btnNewArmor.setEnabled(false);
            btnUpdateArmor.setEnabled(false);
            btnDeleteArmor.setEnabled(false);
            btnCancelArmor.setEnabled(true);
            btnSaveArmor.setEnabled(true);
        }
    }//GEN-LAST:event_btnNewArmorMouseClicked

    private void jpAdventureGearComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpAdventureGearComponentShown
        clearFields();
        habilitaDesabilitaCamposGear(false);

        //Habilitando a barra de ferramentas
        btnNew.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);

        //reload table
        try {
            advGList = advGController.getAdventureGearList();
            fillTable(advGList,tblGear);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jpAdventureGearComponentShown

    private void jpAdventureGearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAdventureGearMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jpAdventureGearMouseClicked

    private void cmbGearTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGearTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGearTypeActionPerformed

    private void tblGearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGearMouseClicked
        habilitaDesabilitaCamposGear(true);

        btnNew.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnCancel.setEnabled(true);
        btnSave.setEnabled(false);

        int row = tblGear.getSelectedRow();
        advGear = new AdventureGear(tblGear.getValueAt(row,4).toString(),
            tblGear.getValueAt(row,5).toString(), tblGear.getValueAt(row,1).toString(),
            Integer.parseInt(tblGear.getValueAt(row,2).toString()),
            tblGear.getValueAt(row,3).toString(), ((Long) tblGear.getValueAt(row,0)).intValue());

        //advGear.setId(((Long) tblGear.getValueAt(row,0)).intValue());
        //advGear.setName(tblGear.getValueAt(row,1).toString());
        //advGear.setCost(Integer.parseInt(tblGear.getValueAt(row,2).toString()));
        //advGear.setGear_type(tblGear.getValueAt(row,5).toString());
        //advGear.setWeight(tblGear.getValueAt(row,3).toString());
        //advGear.setDescription(tblGear.getValueAt(row,4).toString());

        fillFields(advGear);
    }//GEN-LAST:event_tblGearMouseClicked

    private void btnAdvRelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdvRelMouseClicked
        // TODO add your handling code here:
        if(btnAdvRel.isEnabled()){
            frmRelAdv relAdv = new frmRelAdv();
            relAdv.setVisible(true);
        }
    }//GEN-LAST:event_btnAdvRelMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        if (btnCancel.isEnabled()) {
            clearFields();
            habilitaDesabilitaCamposGear(true);
            //Habilitando a barra de ferramentas
            btnNew.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCancel.setEnabled(true);
            btnSave.setEnabled(true);
        }
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (btnSave.isEnabled()) {
            advGear = new AdventureGear(txtDescription.getText(),
                cmbGearType.getSelectedItem().toString(), txtGearName.getText(),
                Integer.parseInt(txtGearCost.getText()), txtGearWeight.getText());

            //populando o obj
            //advGear.setName(txtGearName.getText());
            //advGear.setCost(Integer.parseInt(txtGearCost.getText()));
            //advGear.setDescription(txtDescription.getText());
            //advGear.setGear_type(cmbGearType.getSelectedItem().toString());
            //advGear.setWeight(txtGearWeight.getText());

            advGController.insert(advGear);

            clearFields();
            //desabilitando campos
            habilitaDesabilitaCamposGear(false);

            //gerenciando os botoes
            btnNew.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCancel.setEnabled(false);
            btnSave.setEnabled(false);

            try {
                advGList = advGController.getAdventureGearList();
                fillTable(advGList,tblGear);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        if (btnDelete.isEnabled()) {
            advGController.remove(advGear);
            clearFields();
            habilitaDesabilitaCamposGear(false);

            btnNew.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCancel.setEnabled(false);
            btnSave.setEnabled(false);

            //reload table
            try {
                advGList = advGController.getAdventureGearList();
                fillTable(advGList,tblGear);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        if (btnUpdate.isEnabled()) {
            advGear = new AdventureGear(
                txtDescription.getText(),
                cmbGearType.getSelectedItem().toString(),
                txtGearName.getText(),
                Integer.parseInt(txtGearCost.getText()),
                txtGearWeight.getText(),
                advGear.getId());

            advGController.update(advGear);
            clearFields();
            habilitaDesabilitaCamposGear(false);

            btnNew.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCancel.setEnabled(false);
            btnSave.setEnabled(false);

            try {
                advGList = advGController.getAdventureGearList();
                fillTable(advGList,tblGear);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        if (btnNew.isEnabled()) {
            clearFields();
            habilitaDesabilitaCamposGear(true);

            btnNew.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnCancel.setEnabled(true);
            btnSave.setEnabled(true);

            //advGear.setId(-1);
        }
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnRelArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelArmorMouseClicked
        // TODO add your handling code here:
        if(btnRelArmor.isEnabled()){
            frmRelArmor relArmor = new frmRelArmor();
            relArmor.setVisible(true);
        }
    }//GEN-LAST:event_btnRelArmorMouseClicked

    private void btnRelWeaponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelWeaponMouseClicked
        // TODO add your handling code here:
        if(btnRelWeapon.isEnabled()){
            frmRelWpn relWpn = new frmRelWpn();
            relWpn.setVisible(true);
        }
    }//GEN-LAST:event_btnRelWeaponMouseClicked

    private void mnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUpdateActionPerformed
        FrmRegister frmReg = new FrmRegister(access);
        frmReg.setVisible(true);
    }//GEN-LAST:event_mnUpdateActionPerformed

    private void mnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegisterActionPerformed
        FrmRegister frmReg = new FrmRegister(access);
        frmReg.setVisible(true);
    }//GEN-LAST:event_mnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(frmVault.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVault.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVault.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVault.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVault().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdvRel;
    private javax.swing.JToggleButton btnArmorIsEquiped;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelArmor;
    private javax.swing.JButton btnCancelWpn;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteArmor;
    private javax.swing.JButton btnDeleteWpn;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNewArmor;
    private javax.swing.JButton btnNewWpn;
    private javax.swing.JButton btnRelArmor;
    private javax.swing.JButton btnRelWeapon;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveArmor;
    private javax.swing.JButton btnSaveWpn;
    private javax.swing.JToggleButton btnStealthDArmor;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateArmor;
    private javax.swing.JButton btnUpdateWpn;
    private javax.swing.JToggleButton btnWpnIsEquiped;
    private javax.swing.JCheckBox chkWpnAmmunition;
    private javax.swing.JCheckBox chkWpnFinesse;
    private javax.swing.JCheckBox chkWpnHeavy;
    private javax.swing.JCheckBox chkWpnLoading;
    private javax.swing.JCheckBox chkWpnThrown;
    private javax.swing.JCheckBox chkWpnTwoHanded;
    private javax.swing.JComboBox<String> cmbArmorType;
    private javax.swing.JComboBox<String> cmbGearType;
    private javax.swing.JComboBox<String> cmbModifier;
    private javax.swing.JComboBox<String> cmbWpnType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpAdventureGear;
    private javax.swing.JPanel jpArmor;
    private javax.swing.JPanel jpMonster;
    private javax.swing.JPanel jpSpell;
    private javax.swing.JPanel jpVault;
    private javax.swing.JPanel jpWeapon;
    private javax.swing.JTabbedPane jtVault;
    private javax.swing.JLabel lblACBonus;
    private javax.swing.JLabel lblArmorCost;
    private javax.swing.JLabel lblArmorIsEquiped;
    private javax.swing.JLabel lblArmorName;
    private javax.swing.JLabel lblArmorWeight;
    private javax.swing.JLabel lblDescriptionGear;
    private javax.swing.JLabel lblGearCost;
    private javax.swing.JLabel lblGearName;
    private javax.swing.JLabel lblGearWeight;
    private javax.swing.JLabel lblModifierArmor;
    private javax.swing.JLabel lblStealthDArmor;
    private javax.swing.JLabel lblStrenghtRArmor;
    private javax.swing.JLabel lblTypeArmor;
    private javax.swing.JLabel lblTypeGear;
    private javax.swing.JLabel lblWpnAttack;
    private javax.swing.JLabel lblWpnCost;
    private javax.swing.JLabel lblWpnIsEquiped;
    private javax.swing.JLabel lblWpnName;
    private javax.swing.JLabel lblWpnRange;
    private javax.swing.JLabel lblWpnTHAttack;
    private javax.swing.JLabel lblWpnType;
    private javax.swing.JLabel lblWpnWeight;
    private javax.swing.JMenuItem mnRegister;
    private javax.swing.JMenuItem mnUpdate;
    private javax.swing.JToolBar tbAdventureGear;
    private javax.swing.JToolBar tbArmor;
    private javax.swing.JToolBar tbWeapon;
    private javax.swing.JTable tblArmor;
    private javax.swing.JTable tblGear;
    private javax.swing.JTable tblWeapon;
    private javax.swing.JTextField txtACBonus;
    private javax.swing.JTextField txtArmorCost;
    private javax.swing.JTextField txtArmorName;
    private javax.swing.JTextField txtArmorWeight;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtGearCost;
    private javax.swing.JTextField txtGearName;
    private javax.swing.JTextField txtGearWeight;
    private javax.swing.JTextField txtStrenghtRArmor;
    private javax.swing.JTextField txtWpnAttack;
    private javax.swing.JTextField txtWpnCost;
    private javax.swing.JTextField txtWpnMaxRange;
    private javax.swing.JTextField txtWpnMinRange;
    private javax.swing.JTextField txtWpnName;
    private javax.swing.JTextField txtWpnTHAttack;
    private javax.swing.JTextField txtWpnWeight;
    // End of variables declaration//GEN-END:variables
}
