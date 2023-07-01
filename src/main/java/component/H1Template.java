package component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class H1Template {
     private String locale;
     private String pageId;
     private Tags template;

     /**
      * H1 data, currently only include h1 content.
      */
     @AllArgsConstructor
     @ToString
     public static class Tags {
         private String content;
     }
 }
