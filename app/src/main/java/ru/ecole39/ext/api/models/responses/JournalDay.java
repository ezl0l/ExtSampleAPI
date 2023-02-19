package ru.ecole39.ext.api.models.responses;

import ru.ecole39.ext.api.utils.Gsonable;

public final class JournalDay implements Gsonable {
    public String comment;
    public String date;
    public String note;
    public Subject subject;
    public Double weight;
}
