package com.aditya.chat.dto; import jakarta.validation.constraints.*; public record RegisterRequest(@NotBlank @Size(min=3,max=30) String username,@NotBlank @Size(min=6,max=100) String password){}
