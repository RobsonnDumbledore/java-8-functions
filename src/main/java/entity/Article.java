package entity;

import lombok.Getter;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Article {
  private Long id;
  private String tag;
  private String title;
  private Author author;
  private LocalDate published;
}
