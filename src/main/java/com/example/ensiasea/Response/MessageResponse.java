package com.example.ensiasea.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {
	private Boolean success;
	private String message;
}
