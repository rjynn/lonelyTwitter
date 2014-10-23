package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:

    
    //assuring that second activity actually getting the text
    public void testSendText(){
    	//define intent put text in it and send it
    	Intent intent =  new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send text"); //this is how you send something to that key
    	
    	
    	setActivityIntent(intent); //need to set the intent of the activity before getting activity
    	
    	
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "testing send text");	
    }
    
    //check that the text is actually displayed in the textview in that activity
    public void testDisplayText(){
    	Intent intent =  new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing display"); 
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);	
    	assertEquals("testing display", tv.getText());
    }
    
    public void testDoubleText(){
    	//testing if the double is set correctly and that it is good
    	Intent intent =  new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Bye"); 
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE); //sending mode as 3 other ones were normal default mode
    
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "ByeBye"); //doubles the text put into the activity and displays it. this is only checking the text..can do like before
    	//and check the actualy textview but just do this for now. should do both.
    }
    
    public void testReverseText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "hello");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "olleh");
    }
    
    public void testDefaultText(){
    	Intent intent = new Intent();
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "default text");
    	
    }
    
    public void testTextViewVisible(){
    	Intent intent = new Intent();
    	setActivityIntent(intent);
    	IntentReaderActivity ira = getActivity();
    	View view = (View) ira.getWindow().getDecorView();
    	TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);	
    	ViewAsserts.assertOnScreen(view, tv);
    
    
    }
    
    
}
