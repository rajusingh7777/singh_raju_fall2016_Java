/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Lab.getValue())) {
            organization = new LabOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Donor_Reception.getValue())){
            organization = new DonorReceptionOrganization();
            organizationList.add(organization);       
        } else if (type.getValue().equals(Type.Donor_Nurse.getValue())){
            organization = new DonorNurseOrganization();
            organizationList.add(organization);  
        }else if (type.getValue().equals(Type.Lab_TestingReporting.getValue())){
            organization = new LabTestingReportingOrganization();
            organizationList.add(organization);  
        }return organization;
    }

}
