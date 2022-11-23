import java.io.*;
import java.util.*;

public class Storage {
	
	/*
	 * ћетод сохран¤ет библиотеку в файл
	 * —начала делал запись в файл через превод объектов в строковый вид,
	 * потом наткнулс¤ на другой способ попроще, загрузку этим способом не делал.
	 * ћетод ни где не используетс¤.
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
	 * ћетод сохран¤ет библиотеку в файл (сериализаци¤)
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
	 * ћетод загружает библиотеку из файла (сериализаци¤)
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
		} catch (ClassNotFoundException c) {System.out.println("Ѕиблиотека не найдена");
			c.printStackTrace();
			return liba;
		}
		return liba;
	}
}
