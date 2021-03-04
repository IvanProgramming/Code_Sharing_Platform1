package platform.service;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.model.CodePiece;
import platform.model.CodePieceOutput;
import platform.model.CodePieceRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CodePieceService {

    @Autowired
    private CodePieceRepository codePieceRepository;

    public boolean view(CodePiece c) {
        boolean timeCondition = LocalDateTime.now().isBefore(c.date.plusSeconds(c.availableTime)) == c.timeRestriction;
        boolean viewsCondition = c.allowedViews > 0 == c.viewsRestriction;
        if (c.viewsRestriction && viewsCondition) {
            c.allowedViews--;
            this.update(c);
        }
        return viewsCondition && timeCondition;

    }

    public CodePiece get(String UUID) {
        Optional<CodePiece> optCodePiece = Optional.ofNullable(codePieceRepository.getCodePieceByUUIDEquals(UUID));
        if (optCodePiece.isPresent()) {
            CodePiece codePiece = optCodePiece.get();
            if (view(codePiece)) {
                return codePiece;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void update(CodePiece c) {
        codePieceRepository.save(c);
    }

    public int size() {
        return (int) codePieceRepository.count();
    }


    public List<CodePieceOutput> latest() {
        List<CodePiece> codePieces = codePieceRepository.findFirst10ByTimeRestrictionIsFalseAndViewsRestrictionIsFalseOrderByIdDesc();
        ArrayList<CodePieceOutput> rslt = new ArrayList<CodePieceOutput>();
        for (int i = 0; i < codePieces.size(); i++) {
            rslt.add(codePieces.get(i).getOutput());
        }
        return rslt.subList(0, rslt.size());
    }
}

