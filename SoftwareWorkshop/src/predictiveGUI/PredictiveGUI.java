package predictiveGUI;
/**
 * Gordon Chan	
 * @author gxc378
 * @version 22-02-2016
 * PredictiveGUI contains the main method for the GUI that instantiates a PredctiveModel, passes that model as an argument to
 * PredictiveView, and displays that view.
 */
public class PredictiveGUI{
	
	public static void main(String[]args){
		PredictiveModel model = new PredictiveModel("/usr/share/dict/words");
		PredictiveView instance = new PredictiveView(model);
		instance.setVisible(true);
		
	}
	
}
