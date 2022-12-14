package com.service.sleepapneaiotserver.web.controller.api;


import com.service.sleepapneaiotserver.domain.infos.Infos;
import com.service.sleepapneaiotserver.domain.infos.InfosRepository;
import com.service.sleepapneaiotserver.domain.user.User;
import com.service.sleepapneaiotserver.domain.user.UserRepository;
import com.service.sleepapneaiotserver.web.dto.InfosRequestDto;
import com.service.sleepapneaiotserver.web.dto.ResponseDto;
import com.service.sleepapneaiotserver.web.service.InfosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class InfosApiController {


   private final InfosService infosService;

    // 아두이노로부터 값받고 저장.
    @PostMapping("/api/v1/info")
    public int save(@RequestBody InfosRequestDto infosRequestDto){
        return infosService.저장하기(infosRequestDto);
    }
    @GetMapping("/api/v1/infoSave")
    public int infoSave(@RequestParam("count") int count, @RequestParam("username") String username){
        InfosRequestDto infosRequestDto = new InfosRequestDto(count, username);
        return infosService.저장하기(infosRequestDto);
    }

    @GetMapping("/api/v1/info")
    public List<Infos> findall(@RequestParam("username") String username){
        return infosService.모두찾기(username);
    }

}
