package kz.dar.academy.object;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Mail {
    private String content;
    private Integer id;

    public Mail(Integer id, String second) {
        this.content = second;
        this.id = id;
    }
}
