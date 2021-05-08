/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.empolyee;

import electricitysystem.Adminstrated.Admistrated;
import electricitysystem.customer.Customer;
import java.util.List;

/**
 *
 * @author unique
 */
public interface EmpolyeeDuo {

    public int insert(Empolyee emp);

    public int delete(int empId);

    public List<Empolyee> getAllEmp();

    public Empolyee getEmp(String email,String password);
    
    public Admistrated getAdmin(String email,String password);
    
    public int insertAdmin(Admistrated admin);

}
