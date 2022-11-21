import java.io.*;
import java.util.*;

public class Storage {
	
	/*
	 * ����� ��������� ���������� � ����
	 * ������� ����� ������ � ���� ����� ������ �������� � ��������� ���,
	 * ����� ��������� �� ������ ������ �������, �������� ���� �������� �� �����.
	 * ����� �� ��� �� ������������.
	 */
	public static void setLib (ArrayList<Book> lib) {
	
		ArrayList<String> bookLib = new ArrayList<String>();
		
		for (int i = 0; i < lib.size(); i++) {
			Book book = lib.get(i);
			String b = book.toString();
			bookLib.add(b);
		}
	try{
		FileWriter writer = new FileWriter("Libibi.txt");
		for (String line : bookLib)
		writer.write (line);
		writer.flush();
		writer.close();
		}catch(IOException ex ) {ex.printStackTrace();}
	}
		
	/*
	 * ����� ��������� ���������� � ���� (������������)
	 */
	public static void setLiba (ArrayList<Book> liba) {
		try {	
			FileOutputStream outputFile = new FileOutputStream ("c:/Users/HomePC/eclipse-workspace/Intervale/liba.ser");
			ObjectOutputStream out = new ObjectOutputStream (outputFile);
			out.writeObject(liba);
			out.close();
			outputFile.close();
			}catch(IOException i) { i.printStackTrace();
		}
	}
	
	/*
	 * ����� ��������� ���������� �� ����� (������������)
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Book> readLiba (){
		
		ArrayList<Book> liba = null;
	try {
		FileInputStream inputFile = new FileInputStream("c:/Users/HomePC/eclipse-workspace/Intervale/liba.ser");
		ObjectInputStream inputObject = new ObjectInputStream (inputFile);
		liba = (ArrayList<Book>)inputObject.readObject();
		inputObject.close();
		inputFile.close();
		} catch (IOException i) {i.printStackTrace();
        return liba;
		} catch (ClassNotFoundException c) {System.out.println("���������� �� �������");
			c.printStackTrace();
			return liba;
		}
		return liba;
	}
}
