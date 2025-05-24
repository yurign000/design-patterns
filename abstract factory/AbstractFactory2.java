interface Book{
    String log();
}
interface Movie{
    String log();
}
class BookStore1 implements Book{
    public String log(){
        return "book of store 1";
    }
}
class MovieStore1 implements Movie{
    public String log(){
        return "movie of store 1";
    }
}
class BookStore2 implements Book{
    public String log(){
        return "book of store 2";
    }
}
class MovieStore2 implements Movie{
    public String log(){
        return "movie of store 2";
    }
}

interface StoreFactory{
    Book createBook();
    Movie createMovie();
}
class Store1Factory implements StoreFactory{
    public Book createBook(){
        return new BookStore1();
    }
    public Movie createMovie(){
        return new MovieStore1();
    }
}
class Store2Factory implements StoreFactory{
    public Book createBook(){
        return new BookStore2();
    }
    public Movie createMovie(){
        return new MovieStore2();
    }
}

class Purchase{
    private Book book;
    private Movie movie;

    public Purchase(Book book){
        this.book = book;
    }
    public Purchase(Movie movie){
        this.movie = movie;
    }
    public Book getBook(){
        return book;
    }
    public Movie getMovie(){
        return movie;
    }
}
class Kart{
    private Purchase purchases[];
    
    public Kart(Purchase ...purchases){
        this.purchases = purchases;
    }
    public Purchase[] getPurchases(){
        return purchases;
    }
    
    @Override
    public String toString(){
        String str = "";
        
        for(Purchase p : purchases){
            if(p.getBook() != null){
                str += p.getBook().log() + " | ";
            }
            if(p.getMovie() != null){
                str += p.getMovie().log() + "\n";
            }
        }
        str += "\n";
        return str;
    }
}

public class AbstractFactory2{
    public static void main(String[] args) {
        StoreFactory store1 = new Store1Factory();
        StoreFactory store2 = new Store2Factory();

        Purchase p1 = new Purchase(store1.createBook());
        Purchase p2 = new Purchase(store1.createMovie());
        Purchase p3 = new Purchase(store2.createMovie());

        Kart k1 = new Kart(p1,p2,p3);

        System.out.println(k1);
    }
}
