package se1ex12.src;

/*
 * University of Aizu [Introduction to Software Engineering] Exercise material
 *
 * Class: ProcurementControl
 *
 * Date: 2018/07/24
 *
 * author: s1240234 Yuta Nemoto
 *
 */
/*
 *
 * Complete the implementation of this class "ProcurementControl"
 *
 */
import java.sql.SQLException;
import java.util.Date;

public class ProcurementControl {
    // Declare necessary variables
    private Procurement procurement;
    private DBAccess dbAccess;

    public ProcurementControl() throws ClassNotFoundException, SQLException {
	// Initialization of DBAccess
	dbAccess = new DBAccess();
    }

    public ProcurementStaff getStaff(String staffCode){
	ProcurementStaff procStaff = new ProcurementStaff(staffCode, this.dbAccess);
	boolean status = procStaff.checkStaff();
	if(status) return procStaff;
	else return null;
    }

    public Material getMaterial(String materialCode){
	Material material = new Material(materialCode, this.dbAccess);
	boolean status = material.checkMaterial();
	if(status) return material;
	else return null;
    }

    /*
    public Procurement getProcurement(String procurementId){

    }
    */

    public boolean recordProcurement(String procurementId, String staffCode, String materialCode, int amount, Date requestedDate){
	this.procurement = new Procurement(procurementId, staffCode, materialCode, amount, requestedDate, this.dbAccess);
	boolean status = this.procurement.addProcurement();
	return status;
    }

    /*
    public boolean recordDelivery(String procurementId, Date deliveryDate){

    }
    */
}
