package com.aditya.chat.dto; import jakarta.validation.constraints.*; public record MessageRequest(@NotBlank @Size(max=100) String chatId,@NotBlank @Size(max=4000) String content){}
