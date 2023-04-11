package kr.co.kosmo.mvc.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.AdminDaoInter;


@RestController
public class IdCheckController{
    @Autowired
    private AdminDaoInter adminDaoInter;

    @GetMapping(value = "/idcheck")
    public int idCheck(@RequestParam String maid) {
        int cnt = adminDaoInter.idcheck(maid);
        return cnt;
    }
}