public class Lesson {
    private String lessonTitle;
    private String lessonContent;

    Lesson(String lessonTitle, String lessonContent) {
        this.setLessonTitle(lessonTitle);
        this.setLessonContent(lessonContent);
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }
}
