package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import platform.model.CodePiece;
import platform.service.CodePieceService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class CodePieceController {
    @Autowired
    private CodePieceService codePieceService;

    @GetMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value = "/code/new")
    public String showForm(Model model) {
        return "add";
    }

    @GetMapping(value = "/code/{UUID}")
    public ModelAndView showCode(HttpServletResponse response, @PathVariable String UUID) {
        Map<String, Object> params = new HashMap<String, Object>();
        Optional<CodePiece> optionalCodePiece = Optional.ofNullable(codePieceService.get(UUID));

        if (optionalCodePiece.isPresent()) {
            params.put("snippet", optionalCodePiece.get().getOutput());
            return new ModelAndView("view", params);
        } else {
            response.setStatus(404);
            return null;
        }

    }

    @GetMapping(value = "/code/latest")
    public ModelAndView showRecent() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("recent", codePieceService.latest());
        return new ModelAndView("recent", params);
    }
}
