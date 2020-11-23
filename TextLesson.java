package ElearningPackage;

import java.time.Duration;

public class TextLesson implements Lesson{
    private long lessonId;
    private String lessonTitle;
    private static String lessonType = "Text";
    private String lessonContent;
    private Duration lessonDuration;

    private static long lastLessonId;

    TextLesson(String lessonTitle, String lessonContent, Duration lessonDuration) {
        this.setLessonId(getLastLessonId());
        this.setLastLessonId(getLastLessonId() + 1);
        this.setLessonTitle(lessonTitle);
        this.setLessonContent(lessonContent);
        this.setLessonDuration(lessonDuration);
    }

    public long getLessonId() {
        return lessonId;
    }

    private void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonType() { 
        return TextLesson.lessonType; 
    }

    private void setLessonType(String lessonType) { 
        TextLesson.lessonType = lessonType;
    }


    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public long getLastLessonId() {
        return TextLesson.lastLessonId;
    }

    private void setLastLessonId(long lastLessonId) {
        TextLesson.lastLessonId = lastLessonId;
    }

    public Duration getLessonDuration() { 
        return this.lessonDuration; 
    }

    private void setLessonDuration(Duration lessonDuration) { 
        this.lessonDuration = lessonDuration;
    }

    public void showLessonDetails() {
        System.out.println("\t\t--------------");
        System.out.println("\t\tLesson Id: " + getLessonId());
        System.out.println("\t\tLesson Title: " + getLessonTitle());
        System.out.println("\t\tLesson Type: " + getLessonTitle());
        System.out.println("\t\tLesson Content: " + getLessonContent());
        System.out.println("\t\tLesson Duration: " + getLessonDuration());
        System.out.println("\t\t--------------");
    }

}
