/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmash.inventario;

import jmash.AcquistoIngredienti;
import java.awt.Cursor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jmash.Hop;
import jmash.Main;
import jmash.Malt;
import jmash.RecipeData;
import jmash.Utils;
import jmash.Yeast;
import jmash.inventario.model.RecipesModel;
import jmash.report.PrintRecipe;
import jmash.utils.BrewplusEnvironment;
import jmash.utils.Constants;
import jmash.utils.Utility;
import org.jdom.Document;
import org.jdom.Element;

/**
 *
 * @author a.cerella
 */
public class FrmSelezioneRicette extends javax.swing.JInternalFrame {
    
    private AcquistoIngredienti inventario = null;
    private final JFileChooser recipeChooser = new JFileChooser((String)Main.getFromCache("recipe.dir", bpenv.getFolderName(Constants.DIR_RECIPE)));
    /**
     * Creates new form FrmSelezioneRicette
     */
    public FrmSelezioneRicette() {
        initComponents();
        inizializza();
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblElencoRicette = new javax.swing.JTable();
        mTabIngredienti = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblFermentabili = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblLuppoli = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblLieviti = new javax.swing.JTable();
        btnAddRicetta = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnVerifica = new javax.swing.JButton();
        btnStampaFabbisogno = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verifica Ingredienti");
        setMaximumSize(new java.awt.Dimension(988, 574));
        setMinimumSize(new java.awt.Dimension(988, 574));
        setPreferredSize(new java.awt.Dimension(988, 574));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(164, 67));
        jPanel1.setMinimumSize(new java.awt.Dimension(164, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(164, 67));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/filesave_delete.png"))); // NOI18N
        btnClose.setToolTipText("Chiudi");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/filesave.png"))); // NOI18N
        btnSave.setToolTipText("Salva");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, 170, 70));

        tblElencoRicette.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Style", "Volume", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblElencoRicette);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 850, 130));

        tblFermentabili.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Forma", "EBC", "Necessario (gr)", "Disponibile (gr)", "Mancanti (gr)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblFermentabili);

        mTabIngredienti.addTab("tab1", jScrollPane6);

        tblLuppoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Forma", "A.A.", "Necessario (gr)", "Disponibile (gr)", "Mancanti (gr)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblLuppoli);

        mTabIngredienti.addTab("tab2", jScrollPane7);

        tblLieviti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codice", "Nome", "Necessario (gr)", "Disponibile (gr)", "Mancanti (gr)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblLieviti);

        mTabIngredienti.addTab("tab3", jScrollPane8);

        getContentPane().add(mTabIngredienti, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 930, 290));

        btnAddRicetta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/edit_add.png"))); // NOI18N
        btnAddRicetta.setToolTipText("Aggiungi Ricetta");
        btnAddRicetta.setMaximumSize(new java.awt.Dimension(60, 40));
        btnAddRicetta.setMinimumSize(new java.awt.Dimension(60, 40));
        btnAddRicetta.setPreferredSize(new java.awt.Dimension(60, 40));
        btnAddRicetta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRicettaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddRicetta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/edit_remove.png"))); // NOI18N
        btnRemove.setToolTipText("Rimuovi Ricetta");
        btnRemove.setMaximumSize(new java.awt.Dimension(60, 40));
        btnRemove.setMinimumSize(new java.awt.Dimension(60, 40));
        btnRemove.setPreferredSize(new java.awt.Dimension(60, 40));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(164, 67));
        jPanel2.setRequestFocusEnabled(false);

        btnVerifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/chkinventario.png"))); // NOI18N
        btnVerifica.setToolTipText("Verifica Disponibiltà");
        btnVerifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaActionPerformed(evt);
            }
        });

        btnStampaFabbisogno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jmash/images/doc.png"))); // NOI18N
        btnStampaFabbisogno.setToolTipText("Stampa Fabbisogno");
        btnStampaFabbisogno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStampaFabbisognoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerifica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStampaFabbisogno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStampaFabbisogno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRicettaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRicettaActionPerformed
        RecipeData recipe = new RecipeData(); 
        recipeChooser.setAcceptAllFileFilterUsed(false);
        FileFilter filtro1 = new FileNameExtensionFilter("BrewPlus, HobbyBrew (*.xml)", "xml");
        recipeChooser.addChoosableFileFilter(filtro1);
      
        if (recipeChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if ("XML".equalsIgnoreCase(Utility.getSelectedFileExtension(recipeChooser.getSelectedFile()))) {
                try { 
                    recipeChooser.setCurrentDirectory(recipeChooser.getSelectedFile());
                    recipe.read(Utils.readFileAsXml(recipeChooser.getSelectedFile().toString()));
                    if (recipe.getMalts() == null)
                        throw new Exception();    
                    addDatiRicetta(recipe);
                    btnStampaFabbisogno.setEnabled(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "La Ricetta selezionata non è compatibile oppure non contiene malti. ", "Ricetta scartata", JOptionPane.ERROR_MESSAGE); 
                }
            } else {
                JOptionPane.showMessageDialog(this, "In formato del file non è quello atteso.", "Ricetta scartata", JOptionPane.ERROR_MESSAGE); 
            }    
        }
    }//GEN-LAST:event_btnAddRicettaActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (tblElencoRicette.getSelectedRow() > -1) {
            Integer idRicettaSelezionata = (Integer)tblElencoRicette.getModel().getValueAt(tblElencoRicette.getSelectedRow(), 0); 
            RecipeData recipe = listaRicette.get(idRicettaSelezionata);
            ((DefaultTableModel)(tblElencoRicette.getModel())).removeRow(tblElencoRicette.getSelectedRow());
            subFermentabili(recipe.getMalts());
            subLuppoli(recipe.getHops());
            subLieviti(recipe.getYeasts());
            btnStampaFabbisogno.setEnabled(false);
            if (listaRicette.isEmpty()) {
                btnVerifica.setEnabled(false);  
            }
        } else if (tblElencoRicette.getModel().getRowCount() > 0)
            JOptionPane.showMessageDialog(this, "Seleziona la Ricetta da togliere.", "Elimina Ricetta", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        isVisible = false;
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaActionPerformed
        inventario = caricaDisponibilitaMagazzino();
        ScalaDisponibilitaFermentabili(inventario.getMalti());
        ScalaDisponibilitaLuppoli(inventario.getLuppoli());
        ScalaDisponibilitaLieviti(inventario.getLieviti());
        btnStampaFabbisogno.setEnabled(true);
    }//GEN-LAST:event_btnVerificaActionPerformed

    private void btnStampaFabbisognoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStampaFabbisognoActionPerformed
        DefaultTableModel modelRicette = (DefaultTableModel) tblElencoRicette.getModel();
        DefaultTableModel modelMalts = (DefaultTableModel) tblFermentabili.getModel();
        DefaultTableModel modelLuppoli = (DefaultTableModel) tblLuppoli.getModel();
        DefaultTableModel modelLieviti = (DefaultTableModel) tblLieviti.getModel();
        List<RecipesModel> summaries = new ArrayList<>();
        List<RecipeData> ricette = new ArrayList<>();
        List<Malt> malts = new ArrayList<>();
        List<Hop> hops = new ArrayList<>();
        List<Yeast> yeasts = new ArrayList<>();
        
        RecipesModel summary = new RecipesModel();
        try {  
            //Estrazione ricette
             for (int ii = 0; ii < modelRicette.getRowCount(); ii++) {
                 RecipeData ricetta = new RecipeData();
                 ricetta.setNome((String)modelRicette.getValueAt(ii, 1));
                 ricetta.setCodiceStile((String)modelRicette.getValueAt(ii, 2));
                 ricetta.setVolumeFin((Double)modelRicette.getValueAt(ii, 3));
                 ricetta.setNote((String)modelRicette.getValueAt(ii, 4));
                 ricette.add(ricetta);
             }
             summary.setRicette(ricette);
             //Estrazione Fermentabili
             for (int ii = 0; ii < modelMalts.getRowCount(); ii++) {
                  if ((Double)modelMalts.getValueAt(ii, COL_FABB_FERMENTABILI) > 0) {
                    Malt malt = new Malt();
                    malt.setNome((String)modelMalts.getValueAt(ii, 0));
                    malt.setForma((String)modelMalts.getValueAt(ii, 1));
                    malt.setEbc((Double)modelMalts.getValueAt(ii, 2));
                    malt.setGrammi((Double)modelMalts.getValueAt(ii, COL_FABB_FERMENTABILI));
                    malts.add(malt);
                  }
             } 
             summary.setMalts(malts);
             //Estrazione Luppoli
             for (int ii = 0; ii < modelLuppoli.getRowCount(); ii++) {
                  if ((Double)modelLuppoli.getValueAt(ii, COL_FABB_LUPPOLI) > 0) {
                    Hop hop = new Hop();
                    hop.setNome((String)modelLuppoli.getValueAt(ii, 0));
                    hop.setForma((String)modelLuppoli.getValueAt(ii, 1));
                    hop.setAlfaAcidi((Double)modelLuppoli.getValueAt(ii, 2));
                    hop.setGrammi((Double)modelLuppoli.getValueAt(ii, COL_FABB_LUPPOLI));
                    hops.add(hop);
                  }
             } 
             summary.setHops(hops);
             //Estrazione Lieviti
             for (int ii = 0; ii < modelLieviti.getRowCount(); ii++) {
                  if ((Double)modelLieviti.getValueAt(ii, COL_FABB_LIEVITI) > 0) {
                    Yeast yeast = new Yeast();
                    yeast.setCodice((String)modelLieviti.getValueAt(ii, 0));
                    yeast.setNome((String)modelLieviti.getValueAt(ii, 1));
                    yeast.setQuantita(modelLieviti.getValueAt(ii, COL_FABB_LIEVITI) + "");
                    yeasts.add(yeast);
                  }
             } 
             summary.setYeasts(yeasts);
             summaries.add(summary);
            PrintRecipe.fabbisogno( Utils.getVersion(), summaries);

        } catch (Exception ex) {
                Utils.showException(ex, "", this);
        }
    }//GEN-LAST:event_btnStampaFabbisognoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         JOptionPane.showMessageDialog(this, "La funzionalità non è al momento disponibile ", "Salvataggio ricette", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRicetta;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStampaFabbisogno;
    private javax.swing.JButton btnVerifica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane mTabIngredienti;
    private javax.swing.JTable tblElencoRicette;
    private javax.swing.JTable tblFermentabili;
    private javax.swing.JTable tblLieviti;
    private javax.swing.JTable tblLuppoli;
    // End of variables declaration//GEN-END:variables
    
    public static boolean isVisible = false; 
    private static final Map<Integer, RecipeData> listaRicette = new HashMap<>();
    private static Integer idRicetta = 0;
    private static final Integer COL_QUANT_FERMENTABILI = 3;
    private static final Integer COL_FABB_FERMENTABILI = 5;
    private static final Integer COL_QUANT_LUPPOLI = 3;
    private static final Integer COL_FABB_LUPPOLI = 5;
    private static final Integer COL_QUANT_LIEVITI = 2;
    private static final Integer COL_FABB_LIEVITI = 4;
    private static final BrewplusEnvironment bpenv = BrewplusEnvironment.getIstance();
    
    private void inizializza() {
        mTabIngredienti.setTitleAt(0, "Malti e Fermentabili");
        mTabIngredienti.setTitleAt(1, "Luppoli e Spezie");
        mTabIngredienti.setTitleAt(2, "Lieviti");
        tblElencoRicette.removeColumn(tblElencoRicette.getColumnModel().getColumn(0));
        btnVerifica.setEnabled(false);
        btnVerifica.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnStampaFabbisogno.setEnabled(false);
        btnStampaFabbisogno.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddRicetta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        isVisible = true;
    }
    
    private void addDatiRicetta(RecipeData recipe) {
        addRicetta(recipe);
        addFermentabili(recipe.getMalts());
        addLuppoli(recipe.getHops());
        addLieviti(recipe.getYeasts());
        
    }
    
    private void addRicetta(RecipeData recipe) {
        DefaultTableModel model = (DefaultTableModel) tblElencoRicette.getModel();
        model.addRow(new Object[]{idRicetta,recipe.getNome(), recipe.getCodiceStile(), recipe.getVolumeFin(), recipe.getNote()});
        listaRicette.put(idRicetta++, recipe);
        btnVerifica.setEnabled(true);
    }
    
    private void addFermentabili(List<Malt> malti) {
        DefaultTableModel model = (DefaultTableModel) tblFermentabili.getModel();
        Boolean esiste;
        for (Malt malto : malti) {
            esiste = false;
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                if (malto.getNome().equalsIgnoreCase((String)model.getValueAt(ii, 0)) && malto.getForma().equalsIgnoreCase((String)model.getValueAt(ii, 1))) {
                    model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_FERMENTABILI) + malto.getGrammi(), ii, COL_QUANT_FERMENTABILI);
                    esiste = !esiste;
                    break;
                }
            }
            if (!esiste) model.addRow(new Object[]{malto.getNome(), malto.getForma(), malto.getEbc() ,malto.getGrammi()});   
        }
    }
    
     private void subFermentabili(List<Malt> malti) {
        DefaultTableModel model = (DefaultTableModel) tblFermentabili.getModel();
        for (Malt malto : malti) {
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                if (malto.getNome().equalsIgnoreCase((String)model.getValueAt(ii, 0))&& malto.getForma().equalsIgnoreCase((String)model.getValueAt(ii, 1))) {
                    if ((Double)model.getValueAt(ii, COL_QUANT_FERMENTABILI) - malto.getGrammi() > 0)
                        model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_FERMENTABILI) - malto.getGrammi(), ii, COL_QUANT_FERMENTABILI);
                    else 
                        model.removeRow(ii);
                    break;
                }
            }
        }
    }
    
    private void addLuppoli(List<Hop> luppoli) {
        DefaultTableModel model = (DefaultTableModel) tblLuppoli.getModel();
        Boolean esiste;
        for (Hop luppolo : luppoli) {
            esiste = false;
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                if (luppolo.getNome().equalsIgnoreCase((String)model.getValueAt(ii, 0)) && luppolo.getForma().equalsIgnoreCase((String)model.getValueAt(ii, 1))) {
                    model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_LUPPOLI) + luppolo.getGrammi(), ii, COL_QUANT_LUPPOLI);
                    esiste = !esiste;
                    break;
                }
            }
            if (!esiste) model.addRow(new Object[]{luppolo.getNome(), luppolo.getForma(), luppolo.getAlfaAcidi(), luppolo.getGrammi()});   
        }
    }
    
     private void subLuppoli(List<Hop> luppoli) {
        DefaultTableModel model = (DefaultTableModel) tblLuppoli.getModel();
        for (Hop luppolo : luppoli) {
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                 if (luppolo.getNome().equalsIgnoreCase((String)model.getValueAt(ii, 0)) && luppolo.getForma().equalsIgnoreCase((String)model.getValueAt(ii, 1))) {
                    if (((Double)model.getValueAt(ii, COL_QUANT_LUPPOLI) - luppolo.getGrammi()) > 0)
                        model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_LUPPOLI) - luppolo.getGrammi(), ii, COL_QUANT_LUPPOLI);
                    else
                        model.removeRow(ii);
                    break;
                }
            }
        }
    }
     
    private void addLieviti(List<Yeast> lieviti) {
        DefaultTableModel model = (DefaultTableModel) tblLieviti.getModel();
        Boolean esiste;
        for (Yeast lievito : lieviti) {
            esiste = false;
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                if (lievito.getCodice().equalsIgnoreCase((String)model.getValueAt(ii, 0))) {
                    model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_LIEVITI) + Double.parseDouble( (lievito.getQuantita() != null && !"".equalsIgnoreCase(lievito.getQuantita())) ? lievito.getQuantita() : "0.0"), ii, COL_QUANT_LIEVITI);
                    esiste = !esiste;
                    break;
                }
            }
            if (!esiste) model.addRow(new Object[]{lievito.getCodice(), lievito.getNome(),Double.parseDouble( (lievito.getQuantita() != null && !"".equalsIgnoreCase(lievito.getQuantita())) ? lievito.getQuantita() : "0.0")});   
        }
    }
    
     private void subLieviti(List<Yeast> lieviti) {
        DefaultTableModel model = (DefaultTableModel) tblLieviti.getModel();
        for (Yeast lievito : lieviti) {
            for (int ii = 0; ii < model.getRowCount(); ii++) {
                if (lievito.getCodice().equalsIgnoreCase((String)model.getValueAt(ii, 0))) {
                    if ((Double)model.getValueAt(ii, COL_QUANT_LIEVITI) - Double.parseDouble(lievito.getQuantita()) > 0)
                        model.setValueAt((Double)model.getValueAt(ii, COL_QUANT_LIEVITI) - Double.parseDouble(lievito.getQuantita()), ii, COL_QUANT_LIEVITI);
                    else
                        model.removeRow(ii);
                    break;
                }
            }
        }
    }
     
     public static AcquistoIngredienti caricaDisponibilitaMagazzino() {
        File file = new File(bpenv.getConfigfileName(Constants.XML_INVENTORY));
        AcquistoIngredienti acquistoIngredienti = new AcquistoIngredienti();
        if (file.exists()) {
            Document doc = Utils.readFileAsXml(file.toString());
            Element root = doc.getRootElement();
            if (root.getName().compareToIgnoreCase(new AcquistoIngredienti().getClass().getName()) == 0) {
                for (Object obj : root.getChildren()) {
                    Element elem = (Element) obj;
                    if (elem.getName().compareToIgnoreCase(new Hop().getClass().getName()) == 0) {
                            acquistoIngredienti.getLuppoli().add(Hop.fromXml(elem));
                    }
                    if (elem.getName().compareToIgnoreCase(new Malt().getClass().getName()) == 0) {
                           acquistoIngredienti.getMalti().add(Malt.fromXml(elem));
                    }
                     if (elem.getName().compareToIgnoreCase(new Yeast().getClass().getName()) == 0) {
                           acquistoIngredienti.getLieviti().add(Yeast.fromXml(elem));
                    }
                }
            }
        }
        return acquistoIngredienti;
     }
     
    private void ScalaDisponibilitaFermentabili(List<Malt> malti) {
       DefaultTableModel modelFermentabili = (DefaultTableModel) tblFermentabili.getModel();
       Boolean esiste;
       for (int ii = 0; ii < modelFermentabili.getRowCount(); ii++) {
            esiste = false;
            for (Malt malto : malti) {
                if (malto.getNome().equalsIgnoreCase((String)modelFermentabili.getValueAt(ii, 0))&& malto.getForma().equalsIgnoreCase((String)modelFermentabili.getValueAt(ii, 1))) {
                    esiste = true;
                    modelFermentabili.setValueAt(malto.getGrammi(), ii, 4); 
                    if (malto.getGrammi() - (Double)modelFermentabili.getValueAt(ii, COL_QUANT_FERMENTABILI) > 0)
                       modelFermentabili.setValueAt(0.0, ii, COL_FABB_FERMENTABILI); 
                    else 
                       modelFermentabili.setValueAt((Double)modelFermentabili.getValueAt(ii, COL_QUANT_FERMENTABILI) - malto.getGrammi(), ii, COL_FABB_FERMENTABILI);
                    break;
                }
            }
            if (!esiste) {modelFermentabili.setValueAt(0.0, ii, 4); modelFermentabili.setValueAt((Double)modelFermentabili.getValueAt(ii, COL_QUANT_FERMENTABILI), ii, COL_FABB_FERMENTABILI);}
       }
    }
    
    private void  ScalaDisponibilitaLuppoli(List<Hop> luppoli) {
        DefaultTableModel modelLuppoli = (DefaultTableModel) tblLuppoli.getModel();
        Boolean esiste;
        for (int ii = 0; ii < modelLuppoli.getRowCount(); ii++) {
            esiste = false;
            for (Hop luppolo : luppoli) {
                if (luppolo.getNome().equalsIgnoreCase((String)modelLuppoli.getValueAt(ii, 0))&& luppolo.getForma().equalsIgnoreCase((String)modelLuppoli.getValueAt(ii, 1))) {
                    esiste = true;
                    modelLuppoli.setValueAt(luppolo.getGrammi(), ii, 4);
                    if (luppolo.getGrammi() - (Double)modelLuppoli.getValueAt(ii, COL_QUANT_LUPPOLI) > 0)
                       modelLuppoli.setValueAt(0.0, ii, COL_FABB_LUPPOLI); 
                    else 
                       modelLuppoli.setValueAt((Double)modelLuppoli.getValueAt(ii, COL_QUANT_LUPPOLI) - luppolo.getGrammi(), ii, COL_FABB_LUPPOLI);
                    break;
                }
            }
            if (!esiste)  {modelLuppoli.setValueAt(0.0, ii, 4); modelLuppoli.setValueAt((Double)modelLuppoli.getValueAt(ii, COL_QUANT_LUPPOLI), ii, COL_FABB_LUPPOLI);}
        }
    }
    
    private void ScalaDisponibilitaLieviti(List<Yeast> lieviti) {
        DefaultTableModel modelLieviti = (DefaultTableModel) tblLieviti.getModel();
        Boolean esiste;
        for (int ii = 0; ii < modelLieviti.getRowCount(); ii++) {
            esiste = false;
            for (Yeast lievito : lieviti) {
                if (lievito.getCodice().equalsIgnoreCase((String)modelLieviti.getValueAt(ii, 0))) {
                    esiste = true;
                    modelLieviti.setValueAt(Double.parseDouble(lievito.getQuantita()), ii, 3);
                    if (Double.parseDouble(lievito.getQuantita()) - (Double)modelLieviti.getValueAt(ii, COL_QUANT_LIEVITI) > 0)
                       modelLieviti.setValueAt(0.0, ii, COL_FABB_LIEVITI); 
                    else 
                       modelLieviti.setValueAt((Double)modelLieviti.getValueAt(ii, COL_QUANT_LIEVITI) - Double.parseDouble(lievito.getQuantita()), ii, COL_FABB_LIEVITI);
                    break;
                }
            }
            if (!esiste) {modelLieviti.setValueAt(0.0, ii, 3); modelLieviti.setValueAt((Double)modelLieviti.getValueAt(ii, COL_QUANT_LIEVITI), ii, COL_FABB_LIEVITI);}
        }
    }
}
