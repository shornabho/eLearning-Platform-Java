public class Lesson {
    private long lessonId;
    private String lessonTitle;
    private String lessonContent;

    private static long lastLessonId;

    Lesson(String lessonTitle, String lessonContent) {
        this.setLessonId(getLastLessonId());
        this.setLastLessonId(getLastLessonId() + 1);
        this.setLessonTitle(lessonTitle);
        this.setLessonContent(lessonContent);
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

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public long getLastLessonId() {
        return Lesson.lastLessonId;
    }

    private void setLastLessonId(long lastLessonId) {
        Lesson.lastLessonId = lastLessonId;
    }
}
