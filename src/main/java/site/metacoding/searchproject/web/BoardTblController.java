package site.metacoding.searchproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.searchproject.domain.BoardTbl;
import site.metacoding.searchproject.domain.BoardTblRepository;

@RequiredArgsConstructor
@Controller
public class BoardTblController {

    private final BoardTblRepository boardTblRepository;

    // 메인 페이지
    @GetMapping({ "/" })
    public String home(Model model) {

        model.addAttribute("posts", boardTblRepository.findAll());

        return "/post/list";
    }

    // 검색
    @GetMapping("/search")
    public String search(@RequestBody String keyword, Model model) {

        List<BoardTbl> posts = boardTblRepository.mSearch(keyword);
        System.out.println(posts); // 잘 나온다

        return "redirect:/post/list";
    }

}
