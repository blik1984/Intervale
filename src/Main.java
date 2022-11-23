/*
 * В классе Storage нужно прописать реальную папку, куда будет сохраняться библиотека
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Book book1 = new Book("Рога и копыта", "Остап Бендер", "АСТ", 1666, 113, 14.5, "книга");
		Book book2 = new Book("Философия", "Иван Бендер", "Ширпотрёппечать", 2023, 99, 100, "журнал");
		Book book3 = new Book("Методы приготовления шиншилл", "Дроздов", "Живой мир", 2000, 543, 68.9, "газета");
		Book book4 = new Book("Рога", "Остап", "Знания", 2021, 56, 51.9, "книга");
		Book book5 = new Book("копыта", "Бендер", "АСТ", 2000, 113, 5, "книга");
		Book book6 = new Book("И", "Остап Бендер", "Знания", 1997, 236, 777, "фолиант");
		Book book7 = new Book("Энтомология", "Шванвич", "АСТ", 1948, 300, 450, "газета");
		Book book8 = new Book("Энтомология", "Шванвич", "Знания", 1908, 300, 450, "газета");

		Library library = new Library();
		
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);
		library.addBook(book6);
		library.addBook(book7);


		
		/*
		 * Выводим начальную библиотеку
		 */
		System.out.println("Начальная библиотека");
		ArrayList<Book>BookLib1 = library.getLibrary();
		System.out.println(BookLib1);
		
		/*
		 * Проверили наличие каталогов
		 */
		System.out.println("\nСозданы каталоги");
		System.out.println("Названия изданий: " + library.getBookNames());
		System.out.println("Авторы: " + library.getAuthors());
		System.out.println("Издательства: " + library.getPublishingHouses());
		System.out.println("Годы издания: " + library.getPublishingYears());
		System.out.println("Виды публикаций: " + library.getKinds());
		System.out.println("Ключ - Id, значение - индекс хранения: " + library.getIndices());

		/*
		 * записали и прочитали библиотеку из файла
		 */
		System.out.println("\nБиблиотека после записи в файл и обратного чтения");
		ArrayList<Book> bookLib = new ArrayList<Book>(library.getLibrary());
		Storage.setLiba(bookLib);
		ArrayList<Book>newBookLib = Storage.readLiba();
		library.setLibrary(newBookLib);
		System.out.println(library.getLibrary());
		
		/*
		 * добавили ещё одну книгу проверили что запись и чтение из файла работает.
		 */
		System.out.println("\nДобавим издание в каталог");
		library.addBook(book8);
		System.out.println(library.getLibrary());
		
		/*
		 * Проверили обновление каталогов
		 */
		System.out.println("\nКаталоги после добавления издания");
		System.out.println("\nНазвания изданий: " + library.getBookNames());
		System.out.println("Авторы: " + library.getAuthors());
		System.out.println("Издательства: " + library.getPublishingHouses());
		System.out.println("Годы издания: " + library.getPublishingYears());
		System.out.println("Виды публикаций: " + library.getKinds());
		System.out.println("Ключ - Id, значение - индекс хранения: " + library.getIndices());

		
		/*
		 * Изменяем внигу(по Id), сохраняем, проверяем обновление каталогов
		 */
		System.out.println("\nИзменяем автора книги с Id 5");
		String newAuthor = "Колодий П.В.";
		Book change = library.getBook(5);
		LibraryLogic.changeAuthor(library, change, newAuthor);
		System.out.println("\nБыло: " + change);
		System.out.println("\nСтало: " + library.getBook(5));
		System.out.println("\nБиблиотека после изменения одной из книг");
		System.out.println(library.getLibrary());
		System.out.println("\nКаталоги после изменения одной из книг");
		System.out.println("\nНазвания изданий: " + library.getBookNames());
		System.out.println("Авторы: " + library.getAuthors());
		System.out.println("Издательства: " + library.getPublishingHouses());
		System.out.println("Годы издания: " + library.getPublishingYears());
		System.out.println("Виды публикаций: " + library.getKinds());
		System.out.println("Ключ - Id, значение - индекс хранения: " + library.getIndices());

		
		/*
		 * запуск поиска по библиотеке
		 */
		LibraryLogic.choiseAction(library);
	}
}
