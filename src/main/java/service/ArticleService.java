package service;

import entity.Article;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.function.BiFunction;

public class ArticleService {

  public BiFunction<String, List<Article>, List<Article>> byAuthor =
          (name, articles) -> articles.stream()
                  .filter(a -> a.getAuthor().getName().contains(name))
                  .collect(Collectors.toList());

  public BiFunction<String, List<Article>, List<Article>> byTag =
          (tag, articles) -> articles.stream()
                  .filter(a -> a.getTag().equals(tag))
                  .collect(Collectors.toList());

  public BiFunction<String, List<Article>, List<Article>> byTitle =
          (title, articles) -> articles.stream()
                  .filter(a -> a.getTitle().equals(title))
                  .collect(Collectors.toList());

  public Function<List<Article>, List<Article>> sortByDate =
          articles -> articles.stream()
                  .sorted((x, y) -> y.getPublished().compareTo(x.getPublished()))
                  .collect(Collectors.toList());


  public Function<List<Article>, Optional<Article>> first = a -> a.stream().findFirst();

  public Function<List<Article>, Optional<Article>> newest = first.compose(sortByDate);

  public BiFunction<String, List<Article>, Optional<Article>> newestByTag = byTag.andThen(newest);

  public BiFunction<String, List<Article>, Optional<Article>> newestByTitle = byTitle.andThen(newest);

  public BiFunction<String, List<Article>, Optional<Article>> newestByAuthor = byAuthor.andThen(newest);

  public BiFunction<String, List<Article>, List<Article>> byAuthorSorted = byAuthor.andThen(sortByDate);

}
