/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brian-kamau
 */
public class mainModelTest {
    
    public mainModelTest() {
    }
    
    @Test
    public void testDBConnection(){
        System.out.println("Database Connection Tests");
        Base instance = new mainModelimpl();
        boolean expResult = true;
        boolean result = instance.dbConnect();
        assertEquals(expResult,result);
        
        
    }   
    public class mainModelimpl extends Base{
        
    }
}
