
import java.util.*;

public class LibraryLogic {

	/*
	 * метод возвращает 0, если вниги ещё нет в библиотеке, 1 - если книга есть в библиотеке
	 */
	public static int checkDuplicateBook (Book book, List<Book> lib) {							
		
		int flag = 0;
		
		for (int i = 0; i<lib.size(); i++) {
			Book book2 = (Book)lib.get(i);
			if (book2.equals(book)){
				flag = 1;
				return flag;
			}
		}
		return flag;
	}
	
	/*
	 * метод реализует запуск различных действий с библиотекой
	 */
	public static void choiseAction(Library lib) {									
		int mov = reqestToUser();
		if (mov ==1) {
			ArrayList<Book> autLib = searchAuthor(lib);
			System.out.println (autLib);
		} else if (mov == 2) {
			ArrayList<Book> pubHouseLib = searchPubHouse(lib);
			System.out.println(pubHouseLib);
		}else if (mov == 3) {
			ArrayList<Book> pubYearLib = searchPubYear(lib);
			System.out.println(pubYearLib);
		} 
	}
	
	/*
	 * метод запрашивает у пользоветеля вид действия
	 */
	 static int reqestToUser() {													
		LibraryView.messageToUser("\nДоступные критерии поиска: \n1)Вывести список книг заданного авора "
				+ "\n2)Вывести список книг, выпущенных заданным издательством \n3)Вывести список книг, выпущенных в определённом году");
		boolean flag = false;
		int mov = 0;
		while (flag == false) {
			mov = LibraryView.requestToUser();
			if (mov == 1 || mov == 2 || mov == 3) {
				flag = true;
			} else {
				LibraryView.messageToUser("Данный вариант действий невозможен");
			}
		}
		return mov;
	}
	
	/*
	 * Метод поиска изданий по автору
	 */
	static ArrayList<Book> searchAuthor (Library lib){					
		
		HashMap<String, ArrayList<Integer>>authors = lib.getAuthors();
		final String s1 = "В библиотеке есть издания следующих авторов: ";
		final String s2 = "Введите номер автора в списке";
		String author = new String();
		author = LibraryView.getArgumentToSearch (authors, s1,s2);
		
		ArrayList<Book> ret = new ArrayList<Book>();
		ArrayList<Integer> listIdBook = authors.get(author);
		for (int i = 0; i<listIdBook.size(); i++) {
			int k = listIdBook.get(i);
			ret.add(lib.getBook(k));
		}
		return ret;
	}
	
		/*
		 * Метод поиска изданий по издательству
		 */
	static ArrayList<Book> searchPubHouse (Library lib){
		
		HashMap<String, ArrayList<Integer>>publishingHouses = lib.getPublishingHouses();
		final String s1 = "В библиотеке есть издания следующих издательств: ";
		final String s2 = "Введите номер издательства в списке";
		String pubHouse = LibraryView.getArgumentToSearch (publishingHouses, s1,s2);
		ArrayList<Book> ret = new ArrayList<Book>();
		ArrayList<Integer> listIdBook = publishingHouses.get(pubHouse);
		for (int i = 0; i<listIdBook.size(); i++) {
			int k = listIdBook.get(i);
			ret.add(lib.getBook(k));
		}
		return ret;
	}
	
	/*
	 * Метод поиска изданий по году издания
	 */
	static ArrayList<Book> searchPubYear (Library lib){
	
		HashMap<Integer, ArrayList<Integer>>publishingYears = lib.getPublishingYears();
		final String s1 = "В библиотеке есть издания следующих годов: ";
		final String s2 = "Введите позицию года издания в списке";
		int pubYears = LibraryView.getIntArgumentToSearch(publishingYears, s1,s2);
		ArrayList<Book> ret = new ArrayList<Book>();
		ArrayList<Integer> listIdBook = publishingYears.get(pubYears);
		for (int i = 0; i<listIdBook.size(); i++) {
			int k = listIdBook.get(i);
			ret.add(lib.getBook(k));
		}
		return ret;
	}
	
	/*
	 * Создаём каталог по наименованиям
	 * Ключ - название издания, значение - список ID всех изданий с таким названием
	 */
	 static HashMap<String, ArrayList<Integer>> addName (Book book, HashMap<String, ArrayList<Integer>> map) {
	
		String bookName = book.getBookName();
		ArrayList<Integer> list = new ArrayList<>();
	
		if (map.containsKey(bookName)){
			list = map.get(book.getBookName());
			list.add(book.getId());
			map.put(bookName, list);
			return map;
		} else {
			list.add(book.getId());
			map.put(bookName, list);
			return map;
		}
	}
	
	/*
	 * Создаём каталог по авторам
	 * Ключ - имя автора, значение - список ID всех книг этого автора
	 */
	 static HashMap<String, ArrayList<Integer>> addAuthor (Book book, HashMap<String, ArrayList<Integer>> map) {
		
		String author = book.getAuthor();
		ArrayList<Integer> list = new ArrayList<>();
		
		if (map.containsKey(author)){
			list = map.get(book.getAuthor());
			list.add(book.getId());
			map.put(author, list);
			return map;
		} else {
			list.add(book.getId());
			map.put(author, list);
			return map;
		}
	}
	
	/*
	 * Создаём каталог по издательствам
	 * Ключ - издательство, значение - список ID всех книг этого издательства
	 */
	 static HashMap<String, ArrayList<Integer>> addPublishingHouse (Book book, HashMap<String, ArrayList<Integer>> map) {
		
		String publishingHouse = book.getPublishingHouse();
		ArrayList<Integer> list = new ArrayList<>();
		
		if (map.containsKey(publishingHouse)){
			list = map.get(book.getPublishingHouse());
			list.add(book.getId());
			map.put(publishingHouse, list);
			return map;
		} else {
			list.add(book.getId());
			map.put(publishingHouse, list);
			return map;
		}
	}
		/*
		 * Создаём каталог по годам издания
		 * Ключ - год издания, значение - список ID всех книг этого года
		 */
	 static HashMap<Integer, ArrayList<Integer>> addPublishingYear (Book book, HashMap<Integer, ArrayList<Integer>> map) {
		
		Integer publishingYear = book.getPublishingYear();
		ArrayList<Integer> list = new ArrayList<>();
		
		if (map.containsKey(publishingYear)){
			list = map.get(book.getPublishingYear());
			list.add(book.getId());
			map.put(publishingYear, list);
			return map;
		} else {
			list.add(book.getId());
			map.put(publishingYear, list);
			return map;
		}
	}
	
	/*
	 * Создаём каталог по видам изданий
	 * Ключ - вид издания, значение - список ID всех изданий этого вида
	 */
	 static HashMap<String, ArrayList<Integer>> addKind (Book book, HashMap<String, ArrayList<Integer>> kinds) {
	
		String kind = book.getKind();
		ArrayList<Integer> list = new ArrayList<>();
	
		if (kinds.containsKey(kind)){
			list = kinds.get(book.getKind());
			list.add(book.getId());
			kinds.put(kind, list);
			return kinds;
		} else {
			list.add(book.getId());
			kinds.put(kind, list);
			return kinds;
		}
	}
	
	/*
	 * Создаём каталог в какой ячейке лежит издание с определённым Id
	 * Ключ - Id, значение - индекс в массиве
	 */
	
	static HashMap <Integer, Integer> refreshIndices (ArrayList<Book> lib){
		
		HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
		for (int i = 0; i < lib.size(); i++) {
			Book book = lib.get(i);
			int value = book.getId();
			indices.put(value, i);
		}
		return indices;
	}
	
	/*
	 * Обновляем каталог названий
	 */
	static HashMap <String, ArrayList<Integer>> refreshBookNames (ArrayList<Book> lib){
	
		HashMap<String, ArrayList<Integer>> bookNames = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String name = lib.get(0).getBookName();
		int Id = lib.get(0).getId();
		list.add(Id);
		bookNames.put(name, list);
		for (int i = 1; i<lib.size(); i++) {
			String name2 = lib.get(i).getBookName();
			int Id2 = lib.get(i).getId();
			if (bookNames.containsKey(name2)){
				list = bookNames.get(name2);
				list.add(Id2);
				bookNames.put(name2, list);
			} else {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(Id2);
				bookNames.put(name2, list2);
			}
		}
		return bookNames;
	}
	
	/*
	 * Обновляем каталог авторов
	 */
	static HashMap <String, ArrayList<Integer>> refreshBookAuthors (ArrayList<Book> lib){
		
		HashMap<String, ArrayList<Integer>> bookAuthors = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String author = lib.get(0).getAuthor();
		int Id = lib.get(0).getId();
		list.add(Id);
		bookAuthors.put(author, list);
		for (int i = 1; i<lib.size(); i++) {
			String author2 = lib.get(i).getAuthor();
			int Id2 = lib.get(i).getId();
			if (bookAuthors.containsKey(author2)){
				list = bookAuthors.get(author2);
				list.add(Id2);
				bookAuthors.put(author2, list);
			} else {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(Id2);
				bookAuthors.put(author2, list2);
			}
		}
		return bookAuthors;
	}
	
	/*
	 * Обновляем каталог издательств
	 */
	static HashMap <String, ArrayList<Integer>> refreshPublishingHouses (ArrayList<Book> lib){
		
		HashMap<String, ArrayList<Integer>> publishingHouses = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String pubHouse = lib.get(0).getPublishingHouse();
		int Id = lib.get(0).getId();
		list.add(Id);
		publishingHouses.put(pubHouse, list);
		for (int i = 1; i<lib.size(); i++) {
			String pubHouse2 = lib.get(i).getPublishingHouse();
			int Id2 = lib.get(i).getId();
			if (publishingHouses.containsKey(pubHouse2)){
				list = publishingHouses.get(pubHouse2);
				list.add(Id2);
				publishingHouses.put(pubHouse2, list);
			} else {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(Id2);
				publishingHouses.put(pubHouse2, list2);
			}
		}
		return publishingHouses;
	}
	
	/*
	 * Обновляем каталог годов издания
	 */
	static HashMap <Integer, ArrayList<Integer>> refreshPublishingYears (ArrayList<Book> lib){
		
		HashMap<Integer, ArrayList<Integer>> publishingYears = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int pubYear = lib.get(0).getPublishingYear();
		int Id = lib.get(0).getId();
		list.add(Id);
		publishingYears.put(pubYear, list);
		for (int i = 1; i<lib.size(); i++) {
			int pubYear2 = lib.get(i).getPublishingYear();
			int Id2 = lib.get(i).getId();
			if (publishingYears.containsKey(pubYear2)){
				list = publishingYears.get(pubYear2);
				list.add(Id2);
				publishingYears.put(pubYear2, list);
			} else {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(Id2);
				publishingYears.put(pubYear2, list2);
			}
		}
		return publishingYears;
	}
	
	/*
	 * Обновляем каталог видов изданий
	 */
	static HashMap <String, ArrayList<Integer>> refreshKinds (ArrayList<Book> lib){
		
		HashMap<String, ArrayList<Integer>> kinds = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String kind = lib.get(0).getKind();
		int Id = lib.get(0).getId();
		list.add(Id);
		kinds.put(kind, list);
		for (int i = 1; i<lib.size(); i++) {
			String kind2 = lib.get(i).getKind();
			int Id2 = lib.get(i).getId();
			if (kinds.containsKey(kind2)){
				list = kinds.get(kind2);
				list.add(Id2);
				kinds.put(kind2, list);
			} else {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				list2.add(Id2);
				kinds.put(kind2, list2);
			}
		}
		return kinds;
	}
	
	/*
	 * Метод удаляет издание с определённым наименованием из каталога
	 * Если для данного наименования не осталось изданий, то удаляется само наименование.
	 */
	 static void delName (Book book, HashMap<String, ArrayList<Integer>> map) {
	
		String bookName = book.getBookName();			//название издания
		int Id = book.getId();
		if (map.containsKey(bookName)){
			ArrayList<Integer> listId = map.get(bookName);	//список ID 
			listId.remove(listId.indexOf(Id));
			if (listId.size() <=0) {
				map.remove(bookName);
				return;
			}
			map.put(bookName, listId);
		} else {
			LibraryView.messageToUser("Авария, наименование отсутствует в каталоге");
		}
	}
	
	/*
	 * Метод удаляет издание определённого автора  из каталога 
	 * Если для данного автора не осталось изданий, то удаляется сам автор.
	 */
	 static void delAuthor (Book book, HashMap<String, ArrayList<Integer>> map) {
	
		String bookAuthor = book.getAuthor();
		System.out.println("\n" + bookAuthor);
		int Id = book.getId();
		if (map.containsKey(bookAuthor)){
			ArrayList<Integer> listId = map.get(bookAuthor);	
			listId.remove(listId.indexOf(Id));
			if (listId.size() <=0) {
				map.remove(bookAuthor);
				return;
			}
			map.put(bookAuthor, listId);
		} else {
			LibraryView.messageToUser("Авария, автор отсутствует в каталоге");
		}
	}
	 
	 static void delPublishingYear (Book book, HashMap<Integer, ArrayList<Integer>> map) {
		
		Integer bookPublishingYear = book.getPublishingYear();			
		int Id = book.getId();
		if (map.containsKey(bookPublishingYear)){
			ArrayList<Integer> listId = map.get(bookPublishingYear);	
			listId.remove(listId.indexOf(Id));
			if (listId.size() <=0) {
				map.remove(bookPublishingYear);
				return;
			}
			map.put(bookPublishingYear, listId);
		} else {
			LibraryView.messageToUser("Авария, год издания отсутствует в каталоге");
		}
	}
	 static void delPublishingHouse (Book book, HashMap<String, ArrayList<Integer>> map) {
		
		String bookPublishingHouse = book.getPublishingHouse();			
		int Id = book.getId();
		if (map.containsKey(bookPublishingHouse)){
			ArrayList<Integer> listId = map.get(bookPublishingHouse);	
			listId.remove(listId.indexOf(Id));
			if (listId.size() <=0) {
				map.remove(bookPublishingHouse);
				return;
			}
			map.put(bookPublishingHouse, listId);
		} else {
			LibraryView.messageToUser("Авария, издательство отсутствует в каталоге");
		}
	}
	
	 static void delKind (Book book, HashMap<String, ArrayList<Integer>> map) {
		
		String bookKind = book.getKind();			
		int Id = book.getId();
		if (map.containsKey(bookKind)){
			ArrayList<Integer> listId = map.get(bookKind);	
			listId.remove(listId.indexOf(Id));
			if (listId.size() <=0) {
				map.remove(bookKind);
				return;
			}
			map.put(bookKind, listId);
		} else {
			LibraryView.messageToUser("Авария, вид издания отсутствует в каталоге");
		}
	}
	 static void  delIndex(Book book, HashMap<Integer, Integer>indices) {
		
		Integer Id = book.getId();
		indices.remove(Id);
	}
	
	 /*
	  * метод изменяет автора книги и запускает обновление каталога авторов
	  */
	 static void changeAuthor (Library lib, Book book, String newAuthor) {
	
		book.setAuthor(newAuthor);
		HashMap<String, ArrayList<Integer>> authors = refreshBookAuthors(lib.getLibrary());
		lib.setAuthors(authors);
	 }
	 
	 /*
	  * метод изменяет название книги и запускает обновление каталога названий
	  */
	 static void changeBookName (Library lib, Book book, String newName) {
	
		book.setBookName(newName);
		HashMap<String, ArrayList<Integer>> bookNames = refreshBookNames(lib.getLibrary());
		lib.setBookNames(bookNames);
	 }
	 
	 /*
	  * метод изменяет издательство книги и запускает обновление каталога издательств
	  */
	 static void changePublishingHouse (Library lib, Book book, String newHouse) {
	
		book.setPublishingHouse(newHouse);
		HashMap<String, ArrayList<Integer>> publishingHouses = refreshPublishingHouses(lib.getLibrary());
		lib.setPublishingHouses(publishingHouses);
	 }
	 
	 /*
	  * метод изменяет год издания книги и запускает обновление каталога годов издания
	  */
	 static void changePublishingYear (Library lib, Book book, int newYear) {
	
		book.setPublishingYear(newYear);
		HashMap<Integer, ArrayList<Integer>> publishingYears = refreshPublishingYears(lib.getLibrary());
		lib.setPublishingYears(publishingYears);
	 }
	 
	 /*
	  * метод изменяет вид издания  и запускает обновление каталога видов изданий
	  */
	 static void changeKinds (Library lib, Book book, String newKind) {
	
		book.setKind(newKind);
		HashMap<String, ArrayList<Integer>> kinds = refreshKinds(lib.getLibrary());
		lib.setKinds(kinds);
	 }
}

