package platform.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.model.CodePieceOutput;
import platform.model.FormInputCode;
import platform.model.CodePiece;
import platform.service.CodePieceService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class CodePieceRestController {

    @Autowired
    private CodePieceService codePieceService;

    @PostMapping(value = "/api/code/new")
    public HashMap<String, String> addCode(HttpServletResponse response, @RequestBody FormInputCode inputCode) {
        response.addHeader("Content-type", "application/json");
        CodePiece codePiece = inputCode.toCodePiece();
        codePieceService.update(codePiece);
        HashMap<String, String> result = new HashMap<>();
        result.put("id", codePiece.UUID);
        return result;
    }

    @GetMapping(value = "/api/code/{UUID}")
    public CodePieceOutput getCode(HttpServletResponse response, @PathVariable String UUID) {
        response.addHeader("Content-type", "application/json");
        Optional<CodePiece> optionalCodePiece = Optional.ofNullable(codePieceService.get(UUID));
        if (optionalCodePiece.isPresent()) {
            return optionalCodePiece.get().getOutput();
        } else {
            response.setStatus(404);
            return null;
        }
    }

    @GetMapping(value = "/api/code/latest")
    public List<CodePieceOutput> getLatest(HttpServletResponse response) {
        response.addHeader("Content-type", "application/json");
        return codePieceService.latest();
    }
}
