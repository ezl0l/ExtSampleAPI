package ru.ecole39.ext.api.models.responses;

import ru.ecole39.ext.api.utils.Gsonable;

public final class DiaryDay implements Gsonable {
    public String date;
    public String homework;
    public String note;
    public Subject subject;
    public Teacher teacher;
    public String theme;
}
