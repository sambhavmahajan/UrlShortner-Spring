package com.github.sambhavmahajan.urlshortner;

import com.github.sambhavmahajan.urlshortner.entities.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
    private final UrlService urlService;
    public MainController(UrlService service) {
        this.urlService =  service;
    }
    @GetMapping
    public String mainPage(Model model) {
        UrlDto dto = new UrlDto();
        model.addAttribute("urlDto", dto);
        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute UrlDto urlDto, Model model) {
        Url url = new Url(urlDto.url);
        urlService.save(url);
        UrlDto dto = new UrlDto();
        dto.url = "/s/" + url.getLnk();
        model.addAttribute("urlDto", dto);
        return "index";
    }
    @GetMapping("/s/{lnk}")
    public String gotoUrl(@PathVariable String lnk, Model model) {
        Optional<Url> url = urlService.findByLnk(lnk);
        if(url.isEmpty()) {
            return "redirect:/";
        }
        return "redirect:" + url.get().getUrlToRedirect();
    }
}
