package com.examples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Graphica extends JFrame{
	private JTextArea textArea;
	private JTextArea console;
	private static Graphica _self;
	private static final String filePath = "C:\\Users\\edbarchies\\git\\JavaWS\\Examples\\settings.xml";
	
	public Graphica(JTextArea textArea) {
		this.textArea = textArea;	
		_self = this;
	}
	
	public Graphica() {
		_self = this;
	}
	
	public void write(int b) throws IOException {

		textArea.append(String.valueOf((char)b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.update(textArea.getGraphics());
        
	}
	public static void Init() {
		_self = new Graphica(new JTextArea());
		_self.textArea.setBounds(_self.getWidth(),_self.getHeight(),_self.getWidth(), _self.getHeight()/2);
		_self.textArea.setLineWrap(true);
		_self.textArea.setEditable(true);
		_self.textArea.setText(ByteStream.readFile(filePath));
		
		_self.textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		_self.textArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK	), "Save");
		_self.textArea.getActionMap().put("Save",new Action() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saving to file");
				Thread t = new Thread(ByteStream.readFile(filePath));
				t.run();
				Thread parent = Thread.currentThread();
				try {
					parent.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ByteStream.writeFile(_self.textArea.getText(), filePath);
				System.out.println("Saved");
			}
			
			@Override
			public void setEnabled(boolean b) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void putValue(String key, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
		});
		_self.add(_self.textArea);
		_self.setSize(600, 600);

		_self.addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				if(e.getNewState() ==(WindowEvent.WINDOW_CLOSED)) {
					System.exit(0);
				}else if(e.getNewState() == (WindowEvent.WINDOW_CLOSING)) {
					System.exit(0);
				}
				
			}
			
		});
		JPanel bottom = new JPanel();
		
		bottom.setBounds(0,_self.getHeight()/6*5,_self.getWidth()/6, _self.getHeight()/6);
		_self.console = new JTextArea(" -- | -- ");
		bottom.setBackground(Color.black);
		_self.console.setBackground(Color.black);
		_self.console.setForeground(Color.white);
		_self.console.setFont(new Font("Helvetica", Font.PLAIN, 16));
		bottom.add(_self.console, BorderLayout.EAST);
		_self.add(bottom,BorderLayout.SOUTH);
		_self.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Window Closing");
				
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("To Icon");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("To Screen");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	public static void main(String[] args)  {
		
		Init();
		_self.setVisible(true);
		System.out.println(_self.getWindowListeners().length);
		
		for(KeyStroke k : _self.textArea.getInputMap().allKeys()) {
			System.out.println(k.toString());
			if(k.toString().equalsIgnoreCase("ctrl pressed s")) {
				System.out.println(k.getKeyChar());
			}
		}
		Monitor m = new Graphica.Monitor();
		
	}
	private static class Monitor extends Thread{
		
		public Monitor() {
			try {
				monitor();
			} catch (InterruptedException e) {
				System.out.println("The monitor was closed");
			}
		}
		

		public void monitor() throws InterruptedException {
			run();
			while(true) {
				this.sleep(1000);
				
				_self.console.setText((_self.getWidth() + " | " + _self.getHeight()));
			}
		}
	}
}
