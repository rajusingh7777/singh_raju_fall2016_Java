/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author rajusingh
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessorContainer;
    EcoSystem system;

    public SystemAdminWorkAreaJPanel(JPanel userProcessorContainer, EcoSystem system) {
        initComponents();
        this.userProcessorContainer = userProcessorContainer;
        this.system = system;
        populateTree();

    }

    public void populateTree() {
        DefaultTreeModel dTM = (DefaultTreeModel) jTree.getModel();
        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;

        Network network;
        Enterprise enterprise; //null is not there in lab ie it is not initilized
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) dTM.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode organizationNode;
        DefaultMutableTreeNode enterpriseNode; //null is not there in lab ie it is not initilized

        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        dTM.reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        viewSelectedNodeLabel = new javax.swing.JLabel();
        manageNetworkBtn = new javax.swing.JButton();
        manageEnterpriseBtn1 = new javax.swing.JButton();
        manageEnterpriseAdminBtn2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane.setLeftComponent(jPanel1);

        jLabel1.setText("Selected Node:");

        viewSelectedNodeLabel.setText("<ViewSelectedNode>");

        manageNetworkBtn.setText("Manage Network");
        manageNetworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkBtnActionPerformed(evt);
            }
        });

        manageEnterpriseBtn1.setText("Manage Enterprise");
        manageEnterpriseBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseBtn1ActionPerformed(evt);
            }
        });

        manageEnterpriseAdminBtn2.setText("Manage Enterprise Admin");
        manageEnterpriseAdminBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseAdminBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(manageEnterpriseBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(manageNetworkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageEnterpriseAdminBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addComponent(viewSelectedNodeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(viewSelectedNodeLabel))
                .addGap(33, 33, 33)
                .addComponent(manageNetworkBtn)
                .addGap(28, 28, 28)
                .addComponent(manageEnterpriseBtn1)
                .addGap(18, 18, 18)
                .addComponent(manageEnterpriseAdminBtn2)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageNetworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkBtnActionPerformed
        // TODO add your handling code here:
        ManageNetworkJPanel mNJP = new ManageNetworkJPanel(userProcessorContainer, system);
        userProcessorContainer.add("mNJP", mNJP);
        CardLayout layout = (CardLayout) userProcessorContainer.getLayout();
        layout.next(userProcessorContainer);
    }//GEN-LAST:event_manageNetworkBtnActionPerformed

    private void manageEnterpriseBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseBtn1ActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseJPanel mEJP = new ManageEnterpriseJPanel(userProcessorContainer, system);
        userProcessorContainer.add("mEJP", mEJP);
        CardLayout layout = (CardLayout) userProcessorContainer.getLayout();
        layout.next(userProcessorContainer);
    }//GEN-LAST:event_manageEnterpriseBtn1ActionPerformed

    private void manageEnterpriseAdminBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminBtn2ActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel mEAJP = new ManageEnterpriseAdminJPanel(userProcessorContainer, system);
        userProcessorContainer.add("mEAJP", mEAJP);
        CardLayout layout = (CardLayout) userProcessorContainer.getLayout();
        layout.next(userProcessorContainer);
    }//GEN-LAST:event_manageEnterpriseAdminBtn2ActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            viewSelectedNodeLabel.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JButton manageEnterpriseAdminBtn2;
    private javax.swing.JButton manageEnterpriseBtn1;
    private javax.swing.JButton manageNetworkBtn;
    private javax.swing.JLabel viewSelectedNodeLabel;
    // End of variables declaration//GEN-END:variables
}
