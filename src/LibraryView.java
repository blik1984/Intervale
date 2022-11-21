
import java.util.*;

public class LibraryView {

	/*
	 * ��� ������ ��������� ������������
	 */
public static void messageToUser(String message){
		
		System.out.println(message);
	}

/*
 * ����� �������� �� ������������ ��� ��������
 */
	public static int requestToUser () {									
		final String s1 = "\n�������� ����������� ��������";
		final String s2 = "������ ������� �������� ����������";
		int flag = 0;
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		messageToUser(s1);
		while (!s.hasNextInt()) {
			@SuppressWarnings("unused")
			String trash = s.nextLine();
			messageToUser(s2);
			messageToUser(s1);
		}
		flag = s.nextInt();
		return flag;
	}
	
	/*
	 * �������� ��������� �������� ��� ������
	 * �������� ��������� �����, �� � ���(
	 */
	static String getArgumentToSearch (HashMap<String, ArrayList<Integer>> argumentList, String s1, String s2) {		
		
		Set<String> setList = argumentList.keySet();
		ArrayList<String> list = new ArrayList<String>();
		String argument = new String();
		messageToUser(s1);
		int i = 1;
		for(String s3 : setList) {
			System.out.println(i + " - " + s3);
			i++;
			list.add(s3);
		}
		messageToUser(s2);
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		int num = s.nextInt();
		argument = list.get(num-1);
		return argument;
	}
	
	/*
	 * �������� �������� �������� ��� ������
	 * �������� ��������� �����, �� � ���(
	 */
	static int getIntArgumentToSearch (HashMap<Integer, ArrayList<Integer>> argumentList, String s1, String s2) {		
		
		Set<Integer> setList = argumentList.keySet();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int argument = 0;
		messageToUser(s1);
		int i = 1;
		for(Integer s3 : setList) {
			System.out.println(i + " - " + s3);
			i++;
			list.add(s3);
		}
		messageToUser(s2);
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		while(!s.hasNextInt()) {
			messageToUser("������� �� �����");
			messageToUser("������� ����� ������������ ��������");
			s = new Scanner (System.in);
			}	
		int num = s.nextInt();
		if (num > list.size()|num<=0) {
			getIntArgumentToSearch(argumentList, s1, s2);
			} else {
				argument = list.get(num-1);
			}
		return argument;
	}
	
	public static String requestPubHouse (HashSet<String> list) {
		
		String pubHouse = null;
		//String trash = null;
		messageToUser("� ���������� ���� ����� ��������� �����������: ");
		System.out.println(list);
		messageToUser("�������� ����������� ������������");
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		pubHouse = s.nextLine();
		pubHouse = pubHouse.toUpperCase();
		while(!list.contains(pubHouse)) {
			messageToUser("����� ���������� ������������ ����������� � ����������");
			messageToUser("� ���������� ���� ����� ��������� �����������: ");
			System.out.println(list);
			s = new Scanner (System.in);
			pubHouse = s.nextLine();
			pubHouse = pubHouse.toUpperCase();
		}
	return pubHouse;
	}
	
	public static int requestYear (TreeSet<Integer> list) {
		messageToUser("� ���������� ���� ����� �������� � ��������� ����: ");
		System.out.println(list);
		messageToUser("�������� ����������� ���");
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		while(!s.hasNextInt()) {
			messageToUser("������� �� �����");
			messageToUser("�������� ����������� ���");
			@SuppressWarnings("unused")
			String trash = s.nextLine();
		}
		int pubYear = s.nextInt();
		return pubYear;
	}
}
