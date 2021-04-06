package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Game;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.GameServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Slf4j
@Controller("gameController")
public class GameController {
    @Resource
    private GameServiceImp gameServiceImp;

    @RequestMapping("/admin/game/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/game/list";
    }

    @RequestMapping("/admin/game/getAllGames")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllGames() {
        return new PageVo<Game>().toPageDTO(gameServiceImp.getAllGames());
    }

    @RequestMapping(value = "/admin/game/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Game game) {
        gameServiceImp.addGame(game);
        return "success";
    }


    @RequestMapping(value = "/admin/game/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Game game) {
        gameServiceImp.setGame(game);
        return "success";
    }

    @RequestMapping(value = "/admin/game/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        gameServiceImp.deleteGame(id);
        return "true";
    }
}
