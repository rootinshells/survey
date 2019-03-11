package com.hellokoding.springboot.repository;

public enum Error {
    FILE_EXTENSION_ERROR(0, "File extension is not correct."),
    FILE_CONTAINS_SPECIAL_CHARS(1, "File contains special characters."),
    FILE_SUCCESSFULLY_PARSED(2, "File successfully parsed!"),
    DATA_SAVE_ERROR(3, "Error occured to save data!"),
    DATA_SAVED_SUCCSS(4, "Successfully saved to database!");

    private final int code;
    private String description;

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + this.description;
    }
}
