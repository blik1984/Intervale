
import java.util.*;

public class Library {
	
	private ArrayList<Book> library = new ArrayList<Book>();
	private HashMap<String, ArrayList<Integer>> bookNames = new HashMap<String, ArrayList<Integer>>();
	private HashMap<String, ArrayList<Integer>> authors = new HashMap<String, ArrayList<Integer>>();
	private HashMap<String, ArrayList<Integer>> publishingHouses = new HashMap<String, ArrayList<Integer>>();
	private HashMap<Integer, ArrayList<Integer>> publishingYears = new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<String, ArrayList<Integer>> kinds = new HashMap<String, ArrayList<Integer>>();
	private HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();

	public Library () {
	}

	public ArrayList<Book> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Book> library) {
		this.library.clear();
		for(int i = 0; i<library.size(); i++) {
			Book book = library.get(i);
			this.library.add(book);
		}
	}
	
	public int getSize() {
		return library.size();
	}
	
	public Book getBook(int Id) {
		int index = this.indices.get(Id);
		return library.get(index);
	}
	
	public void addBook(Book book) {
		final int flag = LibraryLogic.checkDuplicateBook(book, library);
		final String message = "Данная книга уже есть в каталоге";
		if (flag == 0) {
			this.library.add(book);
			LibraryLogic.addName(book, bookNames);
			LibraryLogic.addAuthor(book, authors);
			LibraryLogic.addPublishingHouse(book, publishingHouses);
			LibraryLogic.addPublishingYear(book, publishingYears);
			LibraryLogic.addKind(book, kinds);
			this.indices = LibraryLogic.refreshIndices(library);
		} else {
			LibraryView.messageToUser(message);
		}
	}
	
	public void delBook(int Id) {
		int index = this.indices.get(Id);
		Book book = this.library.get(index);
		LibraryLogic.delName(book, bookNames);
		LibraryLogic.delAuthor(book, authors);
		LibraryLogic.delPublishingHouse(book, publishingHouses);
		LibraryLogic.delPublishingYear(book, publishingYears);
		LibraryLogic.delKind(book, kinds);
		LibraryLogic.delIndex(book, indices);
		this.library.remove(index);
	}
	
	
	
	public HashMap<String, ArrayList<Integer>> getBookNames() {
		return bookNames;
	}

	void setBookNames(HashMap<String, ArrayList<Integer>> bookNames) {
		this.bookNames = bookNames;
	}

	public HashMap<String, ArrayList<Integer>> getAuthors() {
		return authors;
	}

	void setAuthors(HashMap<String, ArrayList<Integer>> authors) {
		this.authors = authors;
	}

	public HashMap<String, ArrayList<Integer>> getPublishingHouses() {
		return publishingHouses;
	}

	void setPublishingHouses(HashMap<String, ArrayList<Integer>> publishingHouses) {
		this.publishingHouses = publishingHouses;
	}

	public HashMap<Integer, ArrayList<Integer>> getPublishingYears() {
		return publishingYears;
	}

	void setPublishingYears(HashMap<Integer, ArrayList<Integer>> publishingYears) {
		this.publishingYears = publishingYears;
	}

	public HashMap<String, ArrayList<Integer>> getKinds() {
		return kinds;
	}

	void setKinds(HashMap<String, ArrayList<Integer>> kinds) {
		this.kinds = kinds;
	}

	public HashMap<Integer, Integer> getIndices() {
		return indices;
	}

	void setIndices(HashMap<Integer, Integer> indices) {
		this.indices = indices;
	}

	@Override
	public String toString() {
		return "Library [bookNames=" + bookNames + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		return true;
	}
}
