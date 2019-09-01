package calculator;

import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Calculator extends Frame implements ActionListener {
	
	String field;
	MenuBar bar=new MenuBar();
	Panel p0=new Panel(new FlowLayout());
	TextField input=new TextField(20);
	HashMap<String,String> h=new HashMap<String,String>();
	Button b1=new Button("1");
	Button b2=new Button("2");
	Button b3=new Button("3");
	Button bp=new Button("+");
	Button b4=new Button("4");
	Button b5=new Button("5");
	Button b6=new Button("6");
	Button bs=new Button("-");
	Button b7=new Button("7");
	Button b8=new Button("8");
	Button b9=new Button("9");
	Button bd=new Button("/");
	Button be=new Button("=");
	Button b0=new Button("0");
	Button bc=new Button("C");
	Button bm=new Button("*");
	Button bb=new Button("<");
	Button bh=new Button("H");
	Button bdot=new Button(".");
	Button bpi=new Button("P");
	
	
	
	
	Calculator()
	{
		setTitle("CALCULATOR");
		setLayout(new BorderLayout());
		
		setMenuBar(bar);
		Menu info=new Menu("Features");
		// Menu credits=new Menu("Credits");
		MenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11;
		info.add(i1=new MenuItem("Purely AWT Based"));
		info.add(i2=new MenuItem("Follows DMAS"));
		info.add(i3=new MenuItem("Keyboard supported"));
		info.add(i7=new MenuItem("BackSpace provided"));
		info.add(i8=new MenuItem("History of Calculations available"));
		info.add(i9=new MenuItem("Operates on Float Numbers"));
		info.add(i10=new MenuItem("Direct Pi constant support"));
		info.add(i8=new MenuItem("Clean and Simple Interface"));
		
		bar.add(info);
		// bar.add(credits);
		
		p0.setFont(new Font("SansSerif",Font.PLAIN,30));
		p0.add(input);
		add(p0,BorderLayout.NORTH);
		
		Panel p1=new Panel(new GridLayout(5,4,2,2));
		p1.setFont(new Font("SansSerif",Font.BOLD,65));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(bp);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(bs);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(bd);
		p1.add(be);
		p1.add(b0);
		p1.add(bdot);
		p1.add(bm);
		p1.add(bpi);
		p1.add(bc);
		p1.add(bh);
		p1.add(bb);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bp.addActionListener(this);
		bs.addActionListener(this);
		bm.addActionListener(this);
		bd.addActionListener(this);
		be.addActionListener(this);
		bc.addActionListener(this);
		bb.addActionListener(this);
		bh.addActionListener(this);
		bdot.addActionListener(this);
		bpi.addActionListener(this);
		add(p1,BorderLayout.CENTER);
		
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
     }
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("C"))
		{
			input.setText("");
		}
		else if(ae.getActionCommand().equals("="))
		{
			Compute calc=new Compute(input.getText());
			input.setText(calc.answer);
			h.put(calc.s,calc.answer);
			
		}
		else if(ae.getActionCommand().equals("P"))
		{
		  input.setText(input.getText()+"22/7");
		}
		else if(ae.getActionCommand().equals("<"))
		{
			field=input.getText().substring(0,input.getText().length()-1);
			input.setText(field);
		}
		else if(ae.getActionCommand().equals("H"))
		{
			
			String display=new String("");
			Set<Map.Entry<String, String>> set=h.entrySet();
			for(Map.Entry<String, String> hh:set)
			{
				display=hh.getKey()+"="+hh.getValue();
				input.setText(display);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
				}
			}
		}
		else
		{
		input.setText(input.getText()+ae.getActionCommand());
		}
	}
	
	public void paint(Graphics g)
	{
		
   }
 

public static void main(String[] args) {
    Calculator c=new Calculator();
	c.setSize(400, 600);
	c.setVisible(true);	
	

}
}

		

