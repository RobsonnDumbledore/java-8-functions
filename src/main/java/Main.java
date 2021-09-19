
import entity.Author;
import entity.Article;
import java.util.List;
import java.time.LocalDate;
import service.ArticleService;

public class Main {
    public static void main(String[] args) {


        Author author01 = new Author(1l, "BAELDUNG");
        Author author02 = new Author(2l, "R.MARTÍN");
        Author author03 = new Author(3l, "PAULO SILVEIRA");
        Author author04 = new Author(4l, "LEONARDO MOURA");

        Article article01 = new Article(1l, "JAVA", "lombok in java", author01,
                LocalDate.of(2020, 1, 1));
        Article article02 = new Article(2l, "CSS", "css grid vs css flexbox",
                author03, LocalDate.of(2021, 5, 8));
        Article article09 = new Article(2l, "CSS", "css grid vs css flexbox",
                author03, LocalDate.of(2021, 1, 1));
        Article article03 = new Article(3l, "PYTHON", "code game in python",
                author04, LocalDate.of(2019, 4, 7));
        Article article04 = new Article(4l, "JAVA", "spring data jpa",
                author02, LocalDate.of(2020, 6, 15));
        Article article05 = new Article(5l, "JAVASCRIPT", "es6",
                author04, LocalDate.of(2021, 2, 26));
        Article article06 = new Article(1l, "JAVA", "spring data mongodb",
                author01, LocalDate.of(2021, 9, 1));

        List<Article> articles = List.of(article01, article02, article03, article04, article05, article06, article09);
        ArticleService service = new ArticleService();

        System.out.println(service.newest.apply(articles).get().getTitle());
        service.byTag.apply("JAVA", articles).forEach(a -> System.out.println(a.getTitle()));
        service.byAuthorSorted.apply("LEONARDO MOURA", articles).forEach(a -> System.out.println(a.getTitle()));
        service.byAuthor.apply("BAELDUNG", articles).forEach(a -> System.out.println(a.getAuthor().getName()));
        System.out.println(service.newestByTitle.apply("css grid vs css flexbox", articles).get().getPublished().toString());

    }
}
