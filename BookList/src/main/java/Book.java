class Book {
    private String name;
    private int pageCount;
    private String author;
    private String publicationDate;

    public Book(String name, int pageCount, String author, String publicationDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }
}