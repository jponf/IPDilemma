package cat.udl.ipdilemma.ui;

import cat.udl.ipdilemma.CooperateAlwaysStrategy;
import cat.udl.ipdilemma.DefectAlwaysStrategy;
import cat.udl.ipdilemma.MajorityRuleStrategy;
import cat.udl.ipdilemma.MoreUsedStrategy;
import cat.udl.ipdilemma.RandomStrategy;
import cat.udl.ipdilemma.Register;
import cat.udl.ipdilemma.exceptions.CurrentlyExistingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IPDilemma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Initialize register
        initializeRegister();
		
		new ConsoleUI().run();
    }
    
    
    public static void initializeRegister() {
        try {
            Register reg = Register.getRegister();
                    
            reg.addStrategy("Cooperate Always", new CooperateAlwaysStrategy());
            reg.addStrategy("Defect Always", new DefectAlwaysStrategy());
            reg.addStrategy("Random", new RandomStrategy());
            reg.addStrategy("More Used", new MoreUsedStrategy());
            reg.addStrategy("Majority Rule", new MajorityRuleStrategy());
        } catch (CurrentlyExistingException ex) {
            Logger.getLogger(IPDilemma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
