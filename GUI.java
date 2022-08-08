package TestOfJar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8767938334616187038L;

	public GUI() {
		JFrame frame = new JFrame("Test of jar");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 380);
		frame.setResizable(true);

		URL urlPicture = getClass().getClassLoader().getResource("images/pudgejar.png");
		URL urlText = getClass().getClassLoader().getResource("text/inside.txt");
		System.out.println("urlPicture= " + urlPicture.getPath());
		System.out.println("urltext= " + urlText.getPath());
		ImageIcon image1 = new ImageIcon("images/pudgefolder.png");
		File file = new File("images/pudgefolder.png");
		File file2 = new File("text/1.txt");

		String textLabel2 = "";
		String textLabel1 = "";

		Scanner scanner = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(urlText.getPath()))) {
			String temp = "";
			while ((temp = reader.readLine()) != null) {

				textLabel1 += temp;

			}
		} catch (IOException e) {

			e.printStackTrace();
			textLabel1 = "textfile not found inside jar!";
		}

		try {
			scanner = new Scanner(new BufferedReader(new FileReader("text/1.txt")));

			while (scanner.hasNext()) {

				textLabel2 += scanner.nextLine();

			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
			textLabel2 = "textfile '1.txt' not found at /text/*.*";
		}

		ImageIcon image2 = new ImageIcon(urlPicture);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		JLabel label1 = new JLabel();

		label1.setText(textLabel1);
		label1.setBounds(10, 10, 600, 20);

		JLabel label2 = new JLabel(textLabel2);
		label2.setBounds(10, 40, 600, 20);
		JLabel label3 = new JLabel(image1);
		label3.setBounds(10, 70, 100, 130);

		JLabel label4 = new JLabel(image2);
		label4.setBounds(120, 70, 100, 130);
		JLabel labelPath = null;
		JLabel labelPath2 = null;
		JLabel labelPathURL = new JLabel(urlPicture.getPath().toLowerCase(getLocale()));
		;
		JLabel labelPathURL2 = new JLabel(urlText.getPath().toLowerCase());
		;
		try {
			labelPath = new JLabel(file.getCanonicalPath());
			labelPath2 = new JLabel(file2.getCanonicalPath());

		} catch (IOException e) {

			e.printStackTrace();
		}
		labelPath.setBounds(10, 220, 700, 20);
		labelPath2.setBounds(10, 240, 700, 20);
		labelPathURL.setBounds(10, 280, 700, 20);
		labelPathURL2.setBounds(10, 300, 700, 20);

		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(labelPath);
		panel.add(labelPath2);
		panel.add(labelPathURL2);
		panel.add(labelPathURL);
		frame.add(panel);

		frame.setVisible(true);
		scanner.close();

	}

}
