package com.example.samuraitravel.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewEditForm {
	@NotNull
    private Integer id;
	@NotNull(message = "評価を入力してください。")
	private Integer evaluation;
	
	@NotBlank(message = "コメントを入力してください。")
	private String comments;
}
