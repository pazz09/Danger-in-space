package main;

import javax.swing.JFrame;

import estado.GameEstado;
import graficos.recursos;
import movimiento.teclado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable{
	
	public static final int WIDTH = 800, HEIGHT = 600;
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVERAGEFPS = FPS;
	
	private GameEstado gameEstado;
	private teclado input;
	
	

	public Window()
	{
		setTitle("Danger in space");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		canvas = new Canvas();
		input = new teclado();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		
		
		add(canvas);
		canvas.addKeyListener(input);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Window().start();
		
	}
	
	
	private void actualizar()
	{
		input.actualizar();
		gameEstado.actualizar();
	}
	
	private void dibujar()
	{
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		gameEstado.dibujar(g);
		
		g.drawString(""+AVERAGEFPS,10,20);
		
		g.dispose();
		bs.show();
	}



	private void init()
	{
		recursos.init();
		gameEstado = new GameEstado();
	}

	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		
		init();
		
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			
			if(delta >= 1) {
				
				actualizar();
				dibujar();
				delta --;
				frames ++;
				
			}
			
			if(time >= 1000000000) {
				
				AVERAGEFPS = frames;
				frames = 0;
				time = 0;
			}
		}
		
		stop();
		
	}
	
	private void start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	private void stop() {
		
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
