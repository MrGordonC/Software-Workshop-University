package predictiveGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Gordon Chan
 * @author gxc378
 * @version 22-02-2016
 * 
 * PredictiveView implements the observer class, and contains a constructor for the GUI for the predictive text
 * entry implementation of TreeDictionary. It contains a method to display the words that are stored in the model, and
 * an inner class that implements the action listener. It also contains an update method for outputting text onto the 
 * screen of the interface.
 */
public class PredictiveView extends JFrame implements Observer{
	private static final long serialVersionUID = 7287051317610525613L;
	private PredictiveModel model;
	public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int NUMBER_OF_CHAR = 200;

    private JTextArea textField;
    private JButton[] buttons;
	private StringBuffer current;

	/**
	 * Constructor for GUI PredictiveView. It requires one argument, the model for which it will take components
	 * and output them onto the screen. It is comprised of a panel that contains a textPanel and a gridlayout in which
	 * all the buttons are located. All buttons have Action Listeners.
	 * @param model for the observed object as PredictiveModel.
	 */
	public PredictiveView(PredictiveModel model){
    	super("PredictiveGUI");
    	this.model = model;
    	model.addObserver(this);
    	setSize(WIDTH, HEIGHT);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.current = new StringBuffer();

    	setLayout(new GridLayout(2,1));
    	JTextArea textPanel = new JTextArea();
	        
    	textPanel.setLayout(new BorderLayout());

    	textField = new JTextArea(10,10);
    	Font font = new Font("Courier", Font.BOLD,24);
    	
    	textField.setFont(font);
    	textField.setLineWrap(true);

	    buttons = new JButton[12];
	    
	    textPanel.add(textField, BorderLayout.CENTER);
	    add(textPanel);

	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(4,3));
	    buttonPanel.setBackground(Color.WHITE);
	    
	    ButtonListener bL = new ButtonListener();
	    
	    buttons[0]  = new JButton("1");
	    buttons[1]  = new JButton("ABC 2");
	    buttons[2]  = new JButton("DEF 3");
		buttons[3]  = new JButton("GHI 4");
		buttons[4]  = new JButton("JKL 5");
		buttons[5]  = new JButton("MNO 6");
		buttons[6]  = new JButton("PQRS 7");
		buttons[7]  = new JButton("TUV 8");
		buttons[8]  = new JButton("WXYZ 9");
		buttons[9] = new JButton("*");
		buttons[10]  = new JButton("0");
		buttons[11] = new JButton("#");
		for(int b = 0; b < buttons.length; b++){
			buttons[b].addActionListener(bL);
			buttonPanel.add(buttons[b]);
		}
		
		add(buttonPanel);
		
	}
	/**
	 * Accessor method for PredictiveModel model;
	 * @return
	 */
	public PredictiveModel getModel(){
		return this.model;
	}
	/**
	 * Update method for this class. When called, it sets the text on the GUI to the words currently stored in the model.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		textField.setText(model.display(model.getText()));
	}
	/**
	 * Gordon Chan		
	 * @author gxc378
	 * @version 22-02-16
	 */
	private class ButtonListener implements ActionListener{
		/**
		 * This inner class acts as an ActionListener for the buttons of the PredictiveView.
		 * Depending on what button is pressed, a number of actions may take place. The buttons that correspond to
		 * letters and numbers will add a number to the signature and display the currently selected corresponding
		 * signature. Pressing * will cycle through the words that correspond to the current signature,
		 * pressing 0 will confirm the currently selected word and allow input for the next word. # will clear the
		 * current text displayed onscreen and reset the GUI to its default appearance, ready for more input.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

	        if(actionCommand.equals("1")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(1);
        		model.remove();
	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
		        	model.addWord(model.getPrefix());
	        	} catch(Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	    	} else if(actionCommand.equals("ABC 2")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(2);
        		model.remove();

	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("DEF 3")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(3);
        		model.remove();

	        	try {
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        		
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("GHI 4")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(4);
        		model.remove();

	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("JKL 5")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(5);
        		model.remove();

	        	try {
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("MNO 6")){
	        	//model.setCurrent(model.getCurrent().append(1));
	        	current.append(6);
        		model.remove();

	        	try {
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        		
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("PQRS 7")){
	        	//model.setCurrent(model.getCurrent().append(7));
	        	current.append(7);
        		model.remove();

	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("TUV 8")){
	        	//model.setCurrent(model.getCurrent().append(8));
	        	current.append(8);
        		model.remove();

	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("WXYZ 9")){
	        	//model.setCurrent(model.getCurrent().append(9));
	        	current.append(9);
        		model.remove();

	        	try{
	        		//model.sig2Words(model.getCurrent().toString());
	        		sig2Words(current.toString());
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        		
	        	} catch (Exception exception){
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	} 
	        } else if(actionCommand.equals("0")){
        		model.remove();
	        	try{
	        		model.setPrefix(model.getPool().get(model.getPoolCounter()));
	        		model.addWord(model.getPrefix());
	        		model.incrementCounter();
	        	} catch(Exception error){
	        		
	        	} finally {
	        		model.setPool(null);
	        		model.setPoolCounter(0);
		        	model.setPrefix("");
		        	//model.setCurrent(new StringBuffer());;
		        	current.delete(0, current.length());
	        	}
	        } else if(actionCommand.equals("*")){
	        	model.setPoolCounter(model.getPoolCounter() + 1 );
	        	if(model.getPoolCounter() < model.getPool().size()){
	        		model.remove();
	        		model.addWord(model.getPool().get(model.getPoolCounter()));

	        	} else {
	        		model.setPoolCounter(0);
	        		model.remove();
		        	model.addWord(model.getPool().get(model.getPoolCounter()));
	        	}

	        } else if(actionCommand.equals("#")){
	        	model.setCurrent(new StringBuffer());;
	        	//current.delete(0, current.length());
	        	model.setCounter(0);
	        	model.setPoolCounter(0);
	        	model.setText(new ArrayList<String>());
	        	model.setPrefix("");

	        }
			
		}	
		
	}
	/**
	 * Helper method that calls the signatureToWords on a String, converts the output TreeSet to an ArrayList,
	 * before setting the instance variable pool in the model to this ArrayList.
	 * @param signature for the signature to be converted into a set of words as an String.
	 */
	public void sig2Words(String signature){
		ArrayList<String> s = new ArrayList<String>();
		TreeSet<String> match = model.getTD().signatureToWords(signature);
		s.addAll(match);
		model.setPool(s);
	}
	/**
	 * display formats an ArrayList<String> of words into a format that can be displayed by onscreen //consider moving to model class.
	 * @param words for the set to be converted into a String as ArrayList<String>
	 * @return all words in the set as a sentence in a String.
	 */
	public String display(ArrayList<String> words){
		String r = "";
		for(int i = 0; i < words.size(); i++){
			r = r + words.get(i) + " ";
		} return r;
	}

}
