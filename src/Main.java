
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Book book1 = new Book("���� � ������", "����� ������", "���", 1666, 113, 14.5, "�����");
		Book book2 = new Book("���������", "���� ������", "��������������", 2023, 99, 100, "������");
		Book book3 = new Book("������ ������������� �������", "�������", "����� ���", 2000, 543, 68.9, "������");
		Book book4 = new Book("����", "�����", "������", 2021, 56, 51.9, "�����");
		Book book5 = new Book("������", "������", "���", 2000, 113, 5, "�����");
		Book book6 = new Book("�", "����� ������", "������", 1997, 236, 777, "�������");
		Book book7 = new Book("�����������", "�������", "���", 1948, 300, 450, "������");
		Book book8 = new Book("�����������", "�������", "������", 1908, 300, 450, "������");

		Library library = new Library();
		
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);
		library.addBook(book6);
		library.addBook(book7);


		
		/*
		 * ������� ��������� ����������
		 */
		System.out.println("��������� ����������");
		ArrayList<Book>BookLib1 = library.getLibrary();
		System.out.println(BookLib1);
		
		/*
		 * ��������� ������� ���������
		 */
		System.out.println("\n������� ��������");
		System.out.println("�������� �������: " + library.getBookNames());
		System.out.println("������: " + library.getAuthors());
		System.out.println("������������: " + library.getPublishingHouses());
		System.out.println("���� �������: " + library.getPublishingYears());
		System.out.println("���� ����������: " + library.getKinds());
		System.out.println("���� - Id, �������� - ������ ��������: " + library.getIndices());

		/*
		 * �������� � ��������� ���������� �� �����
		 */
		System.out.println("\n���������� ����� ������ � ���� � ��������� ������");
		ArrayList<Book> bookLib = new ArrayList<Book>(library.getLibrary());
		Storage.setLiba(bookLib);
		ArrayList<Book>newBookLib = Storage.readLiba();
		library.setLibrary(newBookLib);
		System.out.println(library.getLibrary());
		
		/*
		 * �������� ��� ���� ����� ��������� ��� ������ � ������ �� ����� ��������.
		 */
		System.out.println("\n������� ������� � �������");
		library.addBook(book8);
		System.out.println(library.getLibrary());
		
		/*
		 * ��������� ���������� ���������
		 */
		System.out.println("\n�������� ����� ���������� �������");
		System.out.println("\n�������� �������: " + library.getBookNames());
		System.out.println("������: " + library.getAuthors());
		System.out.println("������������: " + library.getPublishingHouses());
		System.out.println("���� �������: " + library.getPublishingYears());
		System.out.println("���� ����������: " + library.getKinds());
		System.out.println("���� - Id, �������� - ������ ��������: " + library.getIndices());

		
		/*
		 * �������� �����(�� Id), ���������, ��������� ���������� ���������
		 */
		System.out.println("\n�������� ������ ����� � Id 5");
		String newAuthor = "������� �.�.";
		Book change = library.getBook(5);
		LibraryLogic.changeAuthor(library, change, newAuthor);
		System.out.println("\n����: " + change);
		System.out.println("\n�����: " + library.getBook(5));
		System.out.println("\n���������� ����� ��������� ����� �� ����");
		System.out.println(library.getLibrary());
		System.out.println("\n�������� ����� ��������� ����� �� ����");
		System.out.println("\n�������� �������: " + library.getBookNames());
		System.out.println("������: " + library.getAuthors());
		System.out.println("������������: " + library.getPublishingHouses());
		System.out.println("���� �������: " + library.getPublishingYears());
		System.out.println("���� ����������: " + library.getKinds());
		System.out.println("���� - Id, �������� - ������ ��������: " + library.getIndices());

		
		/*
		 * ������ ������ �� ����������
		 */
		LibraryLogic.choiseAction(library);
	}
}
