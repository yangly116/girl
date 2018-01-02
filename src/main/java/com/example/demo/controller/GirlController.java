package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "add/girl")
    public Result<Girl> GirlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result<Girl> result = new Result<>();
        if(bindingResult.hasErrors()){
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
        }else{
            result.setCode(0);
            result.setMsg("操作成功");
            result.setData(girlRepository.save(girl));
        }
        return result;
    }
    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl grilFindOne(@PathVariable Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     * @param girl
     * @return
     */
    @PutMapping(value = "/update/girls")
    public Girl girlUpdate(Girl girl){
        System.out.println("girl:"+girl.toString());
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "delete/girls/{id}")
    public void girlDelete(@PathVariable Integer id){
        girlRepository.delete(id);
    }
    //根据年龄查询一个女生列表
    @GetMapping(value = "find/girls/{age}")
    public List<Girl> findGirlByAge(@PathVariable Integer age){
        return girlRepository.findByAge(age);
    }
    @PostMapping(value = "add/girls/two")
    public void addGirlTwo(){
        girlService.insertGirl();
    }
    @GetMapping("testException")
    public void testException() throws Exception {
        girlService.tsetException();
    }
    @GetMapping("testSysException")
    public void testSysException() throws Exception {
        girlService.tsetSysException(null);
    }
}
