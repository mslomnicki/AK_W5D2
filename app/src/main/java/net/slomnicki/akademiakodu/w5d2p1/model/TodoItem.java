package net.slomnicki.akademiakodu.w5d2p1.model;

public class TodoItem {
    private String title;
    private boolean done;
    private String note;

    public TodoItem(String title, boolean done, String note) {
        this.title = title;
        this.done = done;
        this.note = note;
    }

    public TodoItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
