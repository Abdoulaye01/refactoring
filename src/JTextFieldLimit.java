/*
 * 
 * This is a class for limiting input in text fields
 * 
 * */


/*
 *This is a class for limiting input in text fields
 * 
 * */

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// set text field input limits
class JTextFieldLimit extends PlainDocument 
{	
  private int textInputLimit;

  
  
  JTextFieldLimit(int textInputlimit) {
    super();
    this.textInputLimit = textInputlimit;
  }// end JTextFieldLimit

  JTextFieldLimit(int textInputlimit, boolean upper) {
    super();
    this.textInputLimit = textInputlimit;
  }// end JTextFieldLimit

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= textInputLimit) 
      super.insertString(offset, str, attr);
    else
    	JOptionPane.showMessageDialog(null, "For input " + textInputLimit + " characters maximum!");
  }// end insertString
  
 
}// end class JTextFieldLimits