/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.transction;

import java.util.List;

/**
 *
 * @author unique
 */
public interface TransctionDuo {

    public int insert(Transction transction);

    public List<Transction> getAllTransction();

    public int Update(int transctionid);

}
