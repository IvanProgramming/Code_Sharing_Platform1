package platform.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "code_piece")
public class CodePiece {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(length = 36, unique = true)
    public String UUID;

    @Column(length = 16384 * 32)
    public String code;

    public LocalDateTime date;

    public long availableTime;
    public long allowedViews;
    public boolean viewsRestriction;
    public boolean timeRestriction;

    public CodePiece() {}

    public CodePiece(String code, long availableTime, long allowedViews) {
        this.code = code;
        this.availableTime = availableTime;
        this.allowedViews = allowedViews;
        this.date = LocalDateTime.now();
        this.viewsRestriction = allowedViews > 0;
        this.timeRestriction = availableTime > 0;
        this.UUID = java.util.UUID.randomUUID().toString();
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }

    public String getCode() {
        return code;
    }

    public long getAvailableTime() {
        return availableTime;
    }

    public long getAllowedViews() {
        return allowedViews;
    }

    public CodePieceOutput getOutput() {
        return new CodePieceOutput(code, getDate(), availableTime, allowedViews, date);
    }
}
