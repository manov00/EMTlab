package emt.lab2backend.model.DTO;

import emt.lab2backend.model.ENUM.Category;
import lombok.Data;

@Data
public class BookDTO {

        private String name;
        private Category category;
        private Long author;
        private Integer availableCopies;

        public BookDTO() {
        }

        public BookDTO(String name, Category category, Long author, Integer availableCopies) {
            this.name = name;
            this.category = category;
            this.author = author;
            this.availableCopies = availableCopies;
        }

}
