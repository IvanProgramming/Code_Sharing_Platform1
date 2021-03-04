package platform.model;

import platform.model.CodePiece;

public class FormInputCode {
    public String code;
    public long allowedViews;
    public long availableTime;
    public FormInputCode() {}
    public CodePiece toCodePiece() {
        return new CodePiece(this.code, availableTime, allowedViews);
    }
}
