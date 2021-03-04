package platform.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodePieceOutput {

    public String code;
    public String date;
    public long time;
    public long views;

    public CodePieceOutput(String code, String date, long time, long views, LocalDateTime startDate) {
        this.code = code;
        this.date = date;
        this.views = views;
        if (time > 0) {
            Duration d1 = Duration.between(LocalDateTime.now(), startDate.plusSeconds(time));
            this.time = d1.getSeconds() + 1;
        } else {
            this.time = time;
        }

    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public long getTime() {
        return time;
    }

    public long getViews() {
        return views;
    }
}
