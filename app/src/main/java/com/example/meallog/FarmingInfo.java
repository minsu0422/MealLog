package com.example.meallog;


/**
 * 농업 정보를 나타내는 클래스입니다.
 */
public class FarmingInfo {
    private String title;   // 농업 정보의 제목
    private String content; // 농업 정보의 내용

    // Getters and setters
    /**
     * 농업 정보의 제목을 반환합니다.
     * @return 농업 정보의 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * 농업 정보의 제목을 설정합니다.
     * @param title 농업 정보의 제목
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 농업 정보의 내용을 반환합니다.
     * @return 농업 정보의 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 농업 정보의 내용을 설정합니다.
     * @param content 농업 정보의 내용
     */
    public void setContent(String content) {
        this.content = content;
    }
}

